package muConcurrentEx.executors;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

// Основная идея данного примера – показать, как можно, используя Future, узнать статус Callable потока и получить возвращенный объект.
// В примере используется объект executor типа ExecutorService, формирующий пул из трех потоков.
// Метод submit с параметром Callable возвращает объект Future для каждого из стартуемого потоков.

public class CallableFutureEx {

    public CallableFutureEx() {
        // Определяем пул из трех потоков
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Список ассоциированных с Callable задач Future
        List<Future<String>> futures = new ArrayList<>();

        // Создание экземпляра Callable класса
        Callable<String> callable = new CallableClass();

        for (int i = 0; i < 3; i++) {
            // Стартуем, возвращаюший результат исполнения в виде объекта Future поток
            Future<String> future = executor.submit(callable);
            // Добавляем объект Future в список для отображения результат выполнения (получение наименования потока)
            futures.add(future);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss  ");
        for (Future<String> future : futures) {
            try {  // Выводим в консоль полученное значение
                String text = sdf.format(new Date()) + future.get();
                System.out.println(text);
            } catch (InterruptedException | ExecutionException e) {}
        }
        // Останавливаем пул потоков
        executor.shutdown();
    }

    //-----------------------------------------------------
    // Класс, реализующий интерфейс Callable
    class CallableClass implements Callable<String> {
        @Override
        public String call() throws Exception {
            Thread.sleep(1000);
            // наименование потока, выполняющего callable задачу
            return Thread.currentThread().getName();
        }
    }

    //-----------------------------------------------------
    public static void main(String args[]) {
        new CallableFutureEx();
    }
}
