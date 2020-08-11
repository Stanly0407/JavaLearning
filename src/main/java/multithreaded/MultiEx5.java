package multithreaded;

public class MultiEx5 implements Runnable {

    // 2. Реализация интерфейса Runnable

    // Другой способ определения потока представляет реализация интерфейса Runnable. Этот интерфейс имеет один метод run
    // В методе run() собственно определяется весь тот код, который выполняется при запуске потока.
    // После определения объекта Runnable он передается в один из конструкторов класса Thread:

    @Override
    public void run() {
        System.out.printf("%s started... \n", Thread.currentThread().getName());
        try{
            Thread.sleep(500);
        }
        catch(InterruptedException e){
            System.out.println("Thread has been interrupted");
        }
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }

    public static void main(String[] args) {

        System.out.println("Main thread started...");
        Thread myThread = new Thread(new MultiEx5(),"MultiEx5");
        myThread.start();
        System.out.println("Main thread finished...");
    }

    //Реализация интерфейса Runnable во многом аналогична переопределению класса Thread.
    // Также в методе run определяется простейший код, который усыпляет поток на 500 миллисекунд.

    //В методе main вызывается конструктор Thread, в который передается объект MultiEx5.
    // И чтобы запустить поток, вызывается метод start().
    // В итоге консоль выведет что-то наподобие следующего:



}
