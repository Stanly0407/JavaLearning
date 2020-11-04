package muConcurrentEx.executors;


import java.util.concurrent.*;

// создается пул из 3-х потоков, реализующих интерфейс Callable в виде класса CallableDelay.
// Основная идея примера связана с проверками выполняемых потоков и отмены выполнения задачи одного из потоков.

public class FutureTaskEx {

    CallableDelay[] callable;
    FutureTask<String>[] futureTask;
    ExecutorService executor;
    private final int THREAD_COUNT = 3;

    //-----------------------------------------------------
    class CallableDelay implements Callable<String> {
        private long delay;
        private int idx;
        private int cycle;


// Конструктор класса CallableDelay в качестве параметров получает временно́й размер задержки delay и идентификатор потока.
        public CallableDelay(int delay, int idx) {
            this.delay = delay;
            this.idx = idx;
            this.cycle = idx;
        }

        @Override
        public String call() throws Exception {
// В зависимости от значения идентификатора потока в методе call() выполняется соответствующее количество циклов с заданной задержкой,
// после чего поток завершает работу. Второй поток на первом цикле прерывает выполнение 3-го потока вызовом метода cancel.
// Метод call потока возвращает текстовый объект String в виде наименования потока.
            while (cycle > 0) {
                Thread.sleep(delay);
                cycle--;
                if ((idx == 2) && (cycle > 0)){
                 futureTask[futureTask.length - 1].cancel(true);}
            }
// Идентификатор и наименование потока, выполняющего данную callable задачу
            return "" + idx + ". " + Thread.currentThread().getName();
        }
    }
//------------------------------------------------------------------------------------------------------------------

    // Метод areTasksDone() проверяет завершение выполнения всех задач/потоков вызовом методов isDone() объектов futureTask.
    // Если выполнение всех потоков завершены, то сервис executor останавливает свою работу методом shutdown().
    private boolean areTasksDone() {
        boolean isDone = true;
        for (int i = 0; i < THREAD_COUNT; i++) {
            if (!futureTask[i].isDone()) {
                isDone = false;
                break;
            }
        }
        return isDone;
    }

    //-----------------------------------------------------
    FutureTaskEx() {
        callable = new CallableDelay[THREAD_COUNT];
        futureTask = new FutureTask[THREAD_COUNT];
        // Сервис исполнения
        executor = Executors.newFixedThreadPool(THREAD_COUNT);

        for (int i = 0; i < THREAD_COUNT; i++) {
            callable[i] = new CallableDelay(1000, (i + 1));
            futureTask[i] = new FutureTask<>(callable[i]);
            executor.execute(futureTask[i]);
        }
        // Цикл работы executor'а
        while (true) {
            try {
                if (areTasksDone()) {
                    // Завершение работы executor'а
                    executor.shutdown();
                    System.out.println("\nexecutor shutdown");
                    return;
                }
                // Проверка завершения выполнения задачи 1-м потоком
                if (!futureTask[0].isDone()){
                    System.out.println("1-ый поток завершен : " + futureTask[0].get());}
                System.out.println("Ожидание завершения 2-го потока");
                String txt = futureTask[1].get(200L, TimeUnit.MILLISECONDS); //получение результата до окончания вычислений
                // или до истечения указанного интервала времени;
                // если в течение указанного времени вычисления не завершились, то вызывается исключение TimeoutException
                if (txt != null){
                    System.out.println("2-ой поток завершен : " + txt);}
                System.out.println("Проверка завершения 3-го потока");
                if (futureTask[2].isCancelled()){
                    System.out.println("3-ой поток был прерван ...");}
                else if (!futureTask[2].isDone()) {
                    txt = futureTask[2].get();
                    System.out.println("3-ий поток завершен : " + txt);
                }
                Thread.sleep(200);
            } catch (InterruptedException |
                    ExecutionException e) {
                System.err.println(e.getMessage());
            } catch (TimeoutException e) {
                // 2-ой поток вызывает TimeoutException, если задача не завершена за указанное время
                System.err.println("TimeoutException");
            }
        }
    }

    //-----------------------------------------------------
    public static void main(String[] args) {
        new FutureTaskEx();
    }
}
// Результат работы примера
// При выполнении задачи представленные информационные сообщения выводятся в консоль.
// Согласно последовательности вывода сообщений можно сказать, что при вызове метода isDone() объекта FutureTask 1-го потока
// программа перешла в режим ожидания завершения работы потока.
// После завершения выполнения 1-го потока программа перешла к проверке 2-го потока методом get() с временно́й задержкой.
// Так как за предоставленное время поток не смог завершить работу, то был вызван TimeoutException и цикл проверки повторился снова.
// Только после завершения работы 2-го потока программа перешла к проверке отмены/завершения 3-го потока.
// Метод isCancelled() подтвердил, что выполнение потока было прервано.
// Только после этого метод areTasksDone() подтвердил, что все потоки завершили выполнение и цикл проверок был прерван,
// сервис executor завершил выполнение методом shutdown().