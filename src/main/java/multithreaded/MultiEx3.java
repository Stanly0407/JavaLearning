package multithreaded;

public class MultiEx3 {

    public static void main(String[] args) {

       System.out.println("Main thread started...");
       new MultiEx2("MultiEx2").start(); // для запуска потока MultiEx2 у него вызывается метод start(),
        // после чего начинается выполнение того кода, который определен в методе run
       System.out.println("Main thread finished...");

        // !!! Обратите внимание, что главный поток завершает работу раньше, чем порожденный им дочерний поток MultiEx2.

        // Аналогично созданию одного потока мы можем запускать сразу несколько потоков:

        System.out.println("Main thread started...");
        for(int i=1; i < 6; i++)
            new MultiEx2("MultiEx2 " + i).start();
        System.out.println("Main thread finished...");



    }
}
