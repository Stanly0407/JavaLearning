package muConcurrentEx.locks;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Сначала каждый поток пытается в течение определенного времени (TIME_WAIT, мс) блокировать доступ к ресурсу resource с использованием метода tryLock.
// Если блокировка получена, то текст строки resource изменяется.
// После этого в потоке выполняется некоторая задержка по времени (TIME_SLEEP, мс) и поток завершает свою работу с освобождением блокировки методом unlock.
// Если поток в течение времени TIME_WAIT не смог блокировать ресурс, то он переходит к стадии задержки и завершению работы.
//
// Оперируя временем ожидания блокировки TIME_WAIT и временем задержки TIME_SLEEP можно дать возможность
// либо каждому из потоку изменить значение resource,
// либо только одному.

public class ReentrantLockEx1 {

    String resource = "Hello, World!"; // resource используется в качестве общего ресурса, значение которого будет изменяться внутри потоков.
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss  ");

    Lock lock;

    // Константы TIME_WAIT и TIME_SLEEP используются потоками для организации определенных задержек при выполнении.
    final int TIME_WAIT = 7000;
    final int TIME_SLEEP = 5000;

    ReentrantLockEx1() { // В конструкторе  создается блокировка lock типа ReentrantLock и два потока,
        // которые будут использовать lock для блокирования доступа к текстовому ресурсу.
        lock = new ReentrantLock();
        Thread thread1;
        Thread thread2;
        thread1 = new Thread(new LockClass("first", "Первый поток"));
        thread2 = new Thread(new LockClass("second", "Второй поток"));
        thread1.start();
        thread2.start();

        printMessage(null);

        while (thread1.isAlive() || thread2.isAlive()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\nЗавершение работы примера");
        System.exit(0);
    }

    //-----------------------------------------------------
    void printMessage(final String msg) { // Метод printMessage выводит в консоль сообщения потоков с указанием времени.
        String text = sdf.format(new Date());
        if (msg == null)
            text += resource;
        else
            text += msg;
        System.out.println(text);
    }

    //-----------------------------------------------------
    class LockClass implements Runnable { // внутренний класс LockClass используется для организации двух потоков.
        String name;
        String text;

        public LockClass(String name, String text) {
            this.name = name;
            this.text = text;
        }

        @Override
        public void run() {
            boolean locked = false;
            try {
                locked = lock.tryLock(TIME_WAIT, TimeUnit.MILLISECONDS); // Получение блокировки в течение TIME_WAIT
                if (locked) {
                    resource = text;
                    printMessage(null);
                }
                Thread.sleep(TIME_SLEEP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // Убираем блокировку
                String text = name + " : завершил работу";
                if (locked)
                printMessage(text);
                lock.unlock();
            }
        }
    }

    //-----------------------------------------------------
    public static void main(String[] args) {
        new ReentrantLockEx1();
    }

}
