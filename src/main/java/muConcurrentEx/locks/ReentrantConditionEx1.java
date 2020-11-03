package muConcurrentEx.locks;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantConditionEx1 {
    //Пример ReentrantCondExample демонстрирует использование объекта условия Condition с блокировкой ReentrantLock.
    // В примере описывается торговый склад, в который производитель завозит товар из списка GOODS. Товар регистрируется в коллекции goods.
    // Потребитель забирает товар со склада.

    //В конструкторе примера создаются торговый склад store и два потока: producer, consumer.

    Store store;
    SimpleDateFormat sdf ;
    final String[] GOODS = {"Молоко", "Кефир", "Ряженка", "Кофе", "Чай"};
    List<String> goods = new ArrayList<>();

    ReentrantConditionEx1() {
        store = new Store();
        sdf = new SimpleDateFormat("HH:mm:ss  ");

        Thread producer = new Thread(new Producer());
        Thread consumer = new Thread(new Consumer());
        producer.start();
        consumer.start();

        while (producer.isAlive() || consumer.isAlive()) {
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
    void printMessage(final String msg) {
        if (msg != null) {
            String text = sdf.format(new Date()) + msg;
            System.out.println(text);
        } else
            System.out.println("\tТоваров на складе:"
                    + goods.size());
    }

    // Производитель
    class Producer implements Runnable {
        public void run() {
            for (int i = 0; i < GOODS.length; i++) {
                store.put(GOODS[i]);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
            }
        }
    }

// Потребитель
    class Consumer implements Runnable {
        public void run() {
            for (int i = 0; i > GOODS.length; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                store.get();
            }
        }
    }
    //-----------------------------------------------------

    // Склад с товаром
    class Store {
        ReentrantLock lock;  // блокировка
        Condition cond;  // условие блокировки

        Store() {
            lock = new ReentrantLock();
            cond = lock.newCondition();
        }

        public void get() {
            lock.lock();
            try {
                // ожидание на пустом складе
                while (goods.size() < 1)
                    cond.await();

                printMessage("Реализация : " + goods.get(0));
                goods.remove(0);
                printMessage(null);
                // Сигнализация
                cond.signalAll();
            } catch (InterruptedException e) {
            } finally {
                lock.unlock();
            }
        }

        public void put(final String good) {
            lock.lock();
            try {
                // ожидание освобождения места
                while (goods.size() >= 3)
                    cond.await();
                goods.add(good);

                printMessage("Доставка : " + good);
                printMessage(null);
                // Сигнализация
                cond.signalAll();
            } catch (InterruptedException e) {
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        new ReentrantConditionEx1();
    }

}
