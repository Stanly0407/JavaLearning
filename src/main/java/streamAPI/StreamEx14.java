package streamAPI;

import java.util.Arrays;
import java.util.Comparator;

public class StreamEx14 {

    // Параллельные операции над массивами
    //Рассмотрим более сложный пример.
    public static void main(String[] args) {


    Phone[] phones = new Phone[]{new Phone("iPhone 8", 54000),
            new Phone("Pixel 2", 45000),
            new Phone("Samsung Galaxy S9", 40000),
            new Phone("Nokia 9", 32000)};

     Arrays.parallelSetAll(phones, i-> {phones[i].setPrice(phones[i].getPrice()-10000);
     return phones[i];});

     for(Phone p: phones)
            System.out.printf("%s - %d \n", p.getName(), p.getPrice());
// Теперь лямбда-выражение в методе Arrays.parallelSetAll представляет блок кода.
// И так как лямбда-выражение должно возвращать объект, то нам надо явным образом использовать оператор return.
// В этом лямбда-выражении опять же функция получает индексы перебираемых элементов, и по этим индексам мы можем обратиться к элементам массива и их изменить.
// Конкретно в данном случае происходит уменьшение цены смартфонов на 10000 единиц.


        // Сортировка
        //Отсортируем массив чисел в параллельном режиме:

        int[] nums = {30, -4, 5, 29, 7, -8};
        Arrays.parallelSort(nums);
        for(int i: nums)
            System.out.println(i);
//Метод Arrays.parallelSort() в качестве параметра принимает массив и сортирует его по возрастанию

        //Если же нам надо как-то по-другому отсортировать объекты, например, по модулю числа, или у нас более сложные объекты,
        // то мы можем создать свой компаратор и передать его в качестве второго параметра в Arrays.parallelSort().
        // Например, возьмем класс Phone и создадим для него компаратор:

        Phone[] phones2 = new Phone[]{new Phone("iPhone 8", 54000),
                new Phone("Pixel 2", 45000),
                new Phone("Samsung Galaxy S9", 40000),
                new Phone("Nokia 9", 32000)};

        Arrays.parallelSort(phones2, new PhoneComparator());

        for(Phone p: phones2)
            System.out.println(p.getName());

// Метод parallelPrefix
//Метод parallelPrefix() походит для тех случаев, когда надо получить элемент массива или объект того же типа, что и элементы массива,
// который обладает некоторыми признаками.
// Например, в массиве чисел это может быть максимальное, минимальное значения и т.д. Например, найдем произведение чисел:

        int[] numbers = {1, 2, 3, 4, 5, 6};
        Arrays.parallelPrefix(numbers, (x, y) -> x * y);

        for(int i: numbers)
            System.out.println(i);
//То есть, как мы видим из консольного вывода, лямбда-выражение из Arrays.parallelPrefix, которое представляет бинарную функцию,
// получает два элемента и выполняет над ними операцию.
// Результат операции сохраняется и передается в следующий вызов бинарной функции.
    }
}
