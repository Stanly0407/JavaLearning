package muConcurrentEx;

import java.util.concurrent.Semaphore;

// у нас есть 5 философов, которым нужно пообедать. При этом у нас есть один стол, и одновременно находиться за ним могут не более двух человек.
// задача — накормить всех философов. Никто из них не должен остаться голодным, и при этом они не должны «заблокировать» друг друга при попытке сесть за стол
// (мы должны избежать deadlock).

public class SemaphEx extends Thread { // Philosopher

    private Semaphore sem;
    private boolean full = false; // поел ли философ
    private String name;

    SemaphEx(Semaphore sem, String name) {
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
                sem.release();
                sleep(300); // философ ушел, освободив место другим
            }
        }
        catch(InterruptedException e) {
            System.out.println ("Что-то пошло не так!");
        }
    }
    public static void main(String[] args) {

        Semaphore sem = new Semaphore(2);
        new SemaphEx(sem,"Сократ").start();
        new SemaphEx(sem,"Платон").start();
        new SemaphEx(sem,"Аристотель").start();
        new SemaphEx(sem,"Фалес").start();
        new SemaphEx(sem,"Пифагор").start();
    }
}
