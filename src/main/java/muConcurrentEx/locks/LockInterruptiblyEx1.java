package muConcurrentEx.locks;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Основная идея примера связана с тем, чтобы в очередь (в ожидание) на получение блокировки поставить два потока,
// а в первом потоке, получившем блокировку, прервать работу одного из потоков.


public class LockInterruptiblyEx1 {
    private String resource = "Hello, World!";
    private Lock lock;

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss  ");
    final int TIME_SLEEP = 7000;

    Thread thread1;
    Thread thread2;
    Thread thread3;

    LockInterruptiblyEx1() {
        lock = new ReentrantLock();
        thread1 = new Thread(new LockClass("first", "Первый поток"));
        thread2 = new Thread(new LockClass("second", "Второй поток"));
        thread3 = new Thread(new LockClass("third", "Третий поток"));

            thread1.start();
        try { //второй и третий потоки стартуют с небольшой задержкой, чтобы надежно первый поток захватил блокировку lock,
            // в противном случае первым захватить блокировку может и второй поток, работу которого необходимо прерывать.
            Thread.sleep(400);
            thread2.start();
            thread3.start();
        } catch (InterruptedException e) {
        }

        while (thread1.isAlive() || thread2.isAlive() || thread3.isAlive()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\nЗавершение работы примера");
        System.exit(0);
    }

    void printMessage(final String msg) {
        String text = sdf.format(new Date());
        if (msg == null)
            text += resource;
        else
            text += msg;
        System.out.println(text);
    }

    class LockClass implements Runnable {
        String name;
        String text;

        public LockClass(final String name, final String text) {
            this.name = name;
            this.text = text;
        }

        //  Сначала потоки запрашивают блокировку, первый поток, пришедший первым, получает ее, а два потока остаются
        //  в ожидании освобождения/получения блокировки. После небольшой задержки первый поток прерывает работу второго потока и ждет его завершения.
        //  Далее первый поток освобождает блокировку и завершает работу.
        // Сразу же после этого третий поток получает блокировку и далее по сценарию
        @Override
        public void run() {
            try {
                printMessage("Wait (" + name + ") ...");
                lock.lockInterruptibly();
                try {
                    Thread.sleep(2000);
                    if (name.equalsIgnoreCase("first")) {
                        printMessage("Прерывание второго потока");
                        thread2.interrupt();
                        thread2.join();
                    }
                    // доступ к ресурсу
                    resource = text;
                    printMessage(null);
                    Thread.sleep(TIME_SLEEP);
                } finally {
                    // Убираем блокировку
                    lock.unlock();
                    String text = name + " : завершил работу";
                    printMessage(text);
                }
            } catch (InterruptedException e) {
                printMessage(name + " : interrupted wait");
            }
        }
    }

    public static void main(String[] args) {
        new LockInterruptiblyEx1();
    }
}
