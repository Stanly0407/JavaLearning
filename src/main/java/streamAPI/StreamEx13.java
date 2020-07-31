package streamAPI;

import java.util.Arrays;

public class StreamEx13 {

    // Параллельные операции над массивами
    //В JDK 8 к классу Arrays было добавлено ряд методов, которые позволяют в параллельном режиме совершать обработку элементов массива.
    // И хотя данные методы формально не входят в Stream API, но реализуют схожую функциональность, что и параллельные потоки:

    //parallelPrefix(): вычисляет некоторое значение для элементов массива (например, сумму элементов)

    //parallelSetAll(): устанавливает элементы массива с помощью лямбда-выражения

    //parallelSort(): сортирует массив

    //Используем метод parallelSetAll() для установки элементов массива:
    public static void main(String[] args) {

        int[] numbers = initializeArray(6);
        for(int i: numbers)
            System.out.println(i);
        // В метод Arrays.parallelSetAll передается два параметра: изменяемый массив и функция, которая устанавливает элементы массива.
        // Эта функция перебирает все элементы и в качестве параметра получает индекс текущего перебираемого элемента.
        // Выражение i -> i*10 означает, что по каждому индексу в массиве будет хранится число, равное i * 10.

    }

    public static int[] initializeArray(int size) {
        int[] values = new int[size];
        Arrays.parallelSetAll(values, i -> i*10);
        return values;
    }





}
