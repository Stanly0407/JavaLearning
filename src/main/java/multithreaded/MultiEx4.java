package multithreaded;

public class MultiEx4 {

    //Ожидание завершения потока
    //При запуске потоков в примерах выше Main thread завершался до дочернего потока.
    // Как правило, более распространенной ситуацией является случай, когда Main thread завершается самым последним.
    // !!!! Для этого надо применить метод join().
    // В этом случае текущий поток будет ожидать завершения потока, для которого вызван метод join:

    public static void main(String[] args) {

        System.out.println("Main thread started...");
        MultiEx2 t = new MultiEx2("MultiEx2 ");
        t.start();
        try{
            t.join();
        }
        catch(InterruptedException e){

            System.out.printf("%s has been interrupted", t.getName());
        }
        System.out.println("Main thread finished...");
    }
     // Метод join() заставляет вызвавший поток (в данном случае Main thread)
     // ожидать завершения вызываемого потока, для которого и применяется метод join (в данном случае JThread).

     // Если в программе используется несколько дочерних потоков, и надо, чтобы Main thread завершался после дочерних,
     // то для каждого дочернего потока надо вызвать метод join.

}
