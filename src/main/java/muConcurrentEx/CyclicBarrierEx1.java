package muConcurrentEx;

import java.util.concurrent.CyclicBarrier;

// В примере организуется переправа. Паром может вместить только 3 автомобиля. Количество автомобилей 9.
// Роль парома выполняет объект синхронизации FerryBarrier, которому в качестве второго параметра передается
// реализующий интерфейс Runnable класс FerryBoat. Как только 3 потока достигнут барьера
// автоматически будет запущен FerryBoat, после завершения работы которого потоки продолжают свою работу.

public class CyclicBarrierEx1 {

    private static CyclicBarrier FerryBarrier;
    private static final int FerryBoat_size = 3;

    // Переправляющий автомобили паром
    public static class FerryBoat implements Runnable {
        @Override
        public void run() {
            try {// Задержка на переправе
                System.out.println("\nЗагрузка автомобилей");
                Thread.sleep(500);
                System.out.println("Паром переправил автомобили\n");
            } catch (InterruptedException e) {}
        }
    }

    // Класс автомобиля
    public static class Car implements Runnable {

        private int carNumber;

        public Car(int carNumber) {
            this.carNumber = carNumber;
        }

        @Override
        public void run() {
            try {
                System.out.printf("К переправе подъехал автомобиль %d\n", carNumber);
                // Вызов метода await при подходе к барьеру; поток блокируется в ожидании прихода остальных потоков
                FerryBarrier.await();
                System.out.printf("Автомобиль %d продолжил движение\n", carNumber);
            } catch (Exception e) {}
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FerryBarrier = new CyclicBarrier(FerryBoat_size, new FerryBoat()); // На вход еще и запуск!

        for (int i = 1; i < 10; i++) { //10 т.к. кол-во авто 9 шт.
            new Thread(new Car(i)).start(); //заупск run в классе car
            Thread.sleep(400);
        }
    }
}
