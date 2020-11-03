package muConcurrentEx.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//В качестве примера предположим, что у нас есть ограниченный буфер, который поддерживает put и take методы.
// Если take попытаться выполнить a в пустом буфере, поток будет блокироваться до тех пор, пока элемент не станет доступным;
// если put попытаться выполнить для полного буфера, поток будет блокироваться до тех пор, пока не станет доступным пространство.
// Мы хотели бы сохранить ожидающие put потоки и take потоки в отдельных наборах ожидания,
// чтобы мы могли использовать оптимизацию только для уведомления одного потока в то время,
// когда элементы или пробелы становятся доступными в буфере.
// Этого можно добиться с помощью двух Condition экземпляров.


//( ArrayBlockingQueue Класс предоставляет эту функциональность, поэтому нет причин для реализации этого примера класса использования.)
public class ReentrantConditionEx2 {
    final Lock lock = new ReentrantLock();
    final Condition notFull  = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    final Object[] items = new Object[100];
    int putptr, takeptr, count;

    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length)
                notFull.await();
            items[putptr] = x;
            if (++putptr == items.length) putptr = 0;
            ++count;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0)
                notEmpty.await();
            Object x = items[takeptr];
            if (++takeptr == items.length) takeptr = 0;
            --count;
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }
}
