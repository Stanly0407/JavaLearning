package multithreaded;

public class MultiEx7 implements Runnable {

    // Завершение и прерывание потока

    //Примеры потоков ранее представляли поток как последовательный набор операций.
    // После выполнения последней операции завершался и поток. Однако нередко имеет место и другая организация потока в виде бесконечного цикла.
    // Например, поток сервера в бесконечном цикле прослушивает определенный порт на предмет получения данных.
    // И в этом случае мы также можем предусмотреть механизм завершения потока.

    //Завершение потока
    //Распространенный способ завершения потока представляет опрос логической переменной.
    // И если она равна, например, false, то поток завершает бесконечный цикл и заканчивает свое выполнение.

    //Определим следующий класс потока:

    private boolean isActive;

    // Переменная isActive указывает на активность потока. С помощью метода disable() мы можем сбросить состояние этой переменной.

    void disable(){
        isActive = false;
    }

    MultiEx7(){
        isActive = true;
    }

    public void run(){

        System.out.printf("%s started... \n", Thread.currentThread().getName());
        int counter=1; // счетчик циклов
        while(isActive){
            System.out.println("Loop " + counter++);
            try{
                Thread.sleep(400);
            }
            catch(InterruptedException e){
                System.out.println("Thread has been interrupted");
            }
        }
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }


    public static void main(String[] args) {

        System.out.println("Main thread started...");
        MultiEx7 myThread = new MultiEx7();
        new Thread(myThread,"MyThread").start();

        try{
            Thread.sleep(1100);

            myThread.disable();

            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            System.out.println("Thread has been interrupted");
        }
        System.out.println("Main thread finished...");
    }

    //Итак, вначале запускается дочерний поток: new Thread(myThread,"MyThread").start().
    // Затем на 1100 миллисекунд останавливаем Main thread и потом вызываем метод myThread.disable(),
    // который переключает в потоке флаг isActive. И дочерний поток завершается.

    //Метод interrupt
    //Еще один способ вызова завершения или прерывания потока представляет метод interrupt().
    // Вызов этого метода устанавливает у потока статус, что он прерван.
    // Сам метод возвращает true, если поток может быть прерван, в ином случае возвращается false.

    //При этом сам вызов этого метода НЕ завершает поток, он только устанавливает статус:
    // в частности, метод isInterrupted() класса Thread будет возвращать значение true.
    // Мы можем проверить значение возвращаемое данным методом и прозвести некоторые действия. Например:


}
