package muConcurrentEx.synchronizers;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchEx1 {
    // В примере несколько всадников должны подъехать к барьеру. Как только все всадники выстроятся перед барьером,
    // будут даны команды «На старт», «Внимание», «Марш». После этого барьер опустится и начнутся скачки.
    // Объект синхронизации CountDownLatch выполняет роль счетчика количества всадников и команд.

    private static final int RIDERS_COUNT = 5;    // Количество всадников
    private static CountDownLatch LATCH;    // Объект синхронизации
    private static final int trackLength = 3000;    // Условная длина трассы

    public static class Rider implements Runnable {
        private int riderNumber; // номер всадника
        private int riderSpeed ; // скорость всадника постоянная

        public Rider(int riderNumber, int riderSpeed) {
            this.riderNumber = riderNumber;
            this.riderSpeed  = riderSpeed;
        }

        @Override
        public void run() {
            try {
                System.out.printf("Всадник %d вышел на старт\n", riderNumber);
                LATCH.countDown(); //  Уменьшаем счетчик на 1
                LATCH.await(); // Метод await блокирует поток до тех пор,пока счетчик CountDownLatch не обнулится
                Thread.sleep(trackLength / riderSpeed * 10);  // Ожидание, пока всадник не преодолеет трассу
                System.out.printf("Всадник %d финишировал\n", riderNumber);
            } catch (InterruptedException e) {
                System.out.println ("Что-то пошло не так!");
            }
        }
    }
    public static Rider createRider(final int number) {
        return new Rider(number,
                (int) (Math.random() * 10 + 5)); // случайным образом определяем скорость всадника
    }

    public static void main(String[] args) throws InterruptedException {
        LATCH = new CountDownLatch(RIDERS_COUNT + 3);// Определение объекта синхронизации (8)
        // Создание потоков всадников
        for (int i = 1; i <= RIDERS_COUNT; i++) {
            new Thread (createRider(i)).start();
            Thread.sleep(1000);
        }
        // Проверка наличия всех всадников на старте
        while (LATCH.getCount() > 3)
            Thread.sleep(100);

        Thread.sleep(1000);
        System.out.println("На старт!");
        LATCH.countDown();  // Уменьшаем счетчик на 1
        Thread.sleep(1000);
        System.out.println("Внимание!");
        LATCH.countDown(); // Уменьшаем счетчик на 1
        Thread.sleep(1000);
        System.out.println("Марш!");
        LATCH.countDown(); // Уменьшаем счетчик на 1

        // Счетчик обнулен, и все ожидающие этого события потоки разблокированы
        System.out.println("Счетчик обнулен, Всадники статовали и идут к финишу");
    }
}
