package multithreaded;

public class MultiEx2 extends Thread {

    //Создание и выполнение потоков

    //Для создания нового потока мы можем создать новый класс, либо наследуя его от класса Thread, либо реализуя в классе интерфейс Runnable.

    // 1. Наследование от класса Thread
    //Создадим свой класс на основе Thread:

    MultiEx2(String name){
        super(name);
    }
    // Предполагается, что в конструктор класса передается имя потока, которое затем передается в конструктор базового класса.
    // В конструктор своего класса потока мы можем передать различные данные, но главное, чтобы в нем вызывался конструктор базового класса Thread,
    // в который передается имя потока.


    //И также в MultiEx2 переопределяется метод run(), код которого собственно и будет представлять весь тот код, который выполняется в потоке.
    public void run(){

        System.out.printf("%s started... \n", Thread.currentThread().getName());
        try{
            Thread.sleep(500);
        }
        catch(InterruptedException e){
            System.out.println("Thread has been interrupted");
        }
        System.out.printf("%s fiished... \n", Thread.currentThread().getName());
    }
// Далее см. класс MultiEx3

}
