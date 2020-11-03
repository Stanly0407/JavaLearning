package muConcurrentEx.synchronizers;

import java.util.concurrent.Semaphore;

// у нас есть 5 философов, которым нужно пообедать. При этом у нас есть один стол, и одновременно находиться за ним могут не более двух человек.
// задача — накормить всех философов. Никто из них не должен остаться голодным, и при этом они не должны «заблокировать» друг друга при попытке сесть за стол
// (мы должны избежать deadlock).

public class SemaphEx1 extends Thread { // Philosopher

    private Semaphore sem;
    private boolean full = false; // поел ли философ
    private String name;

    SemaphEx1(Semaphore sem, String name) {
        this.sem=sem;
        this.name=name;
    }

    public void run(){
        try{
            if (!full) { // если философ еще не ел
                // Запрашиваем у семафора разрешение на выполнение
                sem.acquire(); //запрашивает разрешение на доступ к ресурсу у семафора. Если счетчик > 0, разрешение предоставляется, а счетчик уменьшается на 1.
                System.out.println (name + " садится за стол");
                sleep(300); // философ ест
                full = true;
                System.out.println (name + " поел! Он выходит из-за стола");
                sem.release(); // Метод release() «освобождает» выданное ранее разрешение и возвращает его в счетчик (увеличивает счетчик разрешений семафора на 1).
                sleep(300); // философ ушел, освободив место другим
            }
        }
        catch(InterruptedException e) {
            System.out.println ("Что-то пошло не так!");
        }
    }
    public static void main(String[] args) {

        Semaphore sem = new Semaphore(2, true); //параметр справедливости fair: усли true, то разрешения будут предоставляться
        // ожидающим потокам исполнения в том порядке, в каком они его запрашивали.
        new SemaphEx1(sem,"Сократ").start();
        new SemaphEx1(sem,"Платон").start();
        new SemaphEx1(sem,"Аристотель").start();
        new SemaphEx1(sem,"Фалес").start();
        new SemaphEx1(sem,"Пифагор").start();
    }
}
