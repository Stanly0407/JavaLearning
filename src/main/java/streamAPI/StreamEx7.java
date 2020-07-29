package streamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class StreamEx7 {

    // Операции сведения
    // Операции сведения представляют терминальные операции, которые возвращают некоторое значение - результат операции. В Stream API есть ряд операций сведения.


    public static void main(String[] args) {

        // 1. count
        // Метод count() возвращает количество элементов в потоке данных:

        ArrayList<String> names = new ArrayList<String>();
        names.addAll(Arrays.asList(new String[]{"Tom", "Sam", "Bob", "Alice"}));
        System.out.println(names.stream().count());  // 4

        // количество элементов с длиной не больше 3 символов
        System.out.println(names.stream().filter(n->n.length()<=3).count());  // 3

        // 2. findFirst и findAny
        //Метод findFirst() извлекает из потока первый элемент, а findAny() извлекает случайный объект из потока (нередко так же первый):

        ArrayList<String> names2 = new ArrayList<String>();
        names2.addAll(Arrays.asList(new String[]{"Tom", "Sam", "Bob", "Alice"}));

        Optional<String> first = names2.stream().findFirst();
        System.out.println(first.get());    // Tom

        Optional<String> any = names2.stream().findAny();
        System.out.println(first.get());    // Tom

        // англ Match  - совпадать
        // 3. allMatch, anyMatch, noneMatch
        //Еще одна группа операций сведения возвращает логическое значение true или false:
        //boolean allMatch(Predicate<? super T> predicate): возвращает true, если все элементы потока удовлетворяют условию в предикате
        //boolean anyMatch(Predicate<? super T> predicate): возвращает true, если хоть один элемент потока удовлетворяют условию в предикате
        //boolean noneMatch(Predicate<? super T> predicate): возвращает true, если ни один из элементов в потоке не удовлетворяет условию в предикате

        //Пример использования функций:

        ArrayList<String> names3 = new ArrayList<String>();
        names3.addAll(Arrays.asList(new String[]{"Tom", "Sam", "Bob", "Alice"}));

        // есть ли в потоке строка, длина которой больше 3
        boolean any2 = names3.stream().anyMatch(s->s.length()>3);
        System.out.println(any2);    // true

        // все ли строки имеют длину в 3 символа
        boolean all = names.stream().allMatch(s->s.length()==3);
        System.out.println(all);    // false

        // НЕТ ЛИ в потоке строки "Bill". Если нет, то true, если есть, то false
        boolean none = names.stream().noneMatch(s->s=="Bill");
        System.out.println(none);   // true

        // 4. min и max
        // Методы min() и max() возвращают соответственно минимальное и максимальное значение. Поскольку данные в потоке могут представлять различные типы,
        // в том числе сложные классы, то в качестве параметра в эти методы передается объект интерфейса Comparator, который указывает, как сравнивать объекты:
                      // Optional<T> min(Comparator<? super T> comparator)
                      // Optional<T> max(Comparator<? super T> comparator)
        //Оба метода возвращают элемент потока (минимальный или максимальный), обернутый в объект Optional.

        //Например, найдем минимальное и максимальное число в числовом потоке:

        ArrayList<Integer> numbers5 = new ArrayList<Integer>();
        numbers5.addAll(Arrays.asList(new Integer[]{1,2,3,4,5,6,7,8,9}));

        Optional<Integer> min = numbers5.stream().min(Integer::compare);
        Optional<Integer> max = numbers5.stream().max(Integer::compare);
        System.out.println(min.get());  // 1
        System.out.println(max.get());  // 9

        // Рассмотрим более сложный случай, когда нам надо сравнивать более сложные объекты:

        ArrayList<Phone> phones = new ArrayList<Phone>();
        phones.addAll(Arrays.asList(new Phone("iPhone 8", 52000),
                new Phone("Nokia 9", 35000),
                new Phone("Samsung Galaxy S9", 48000),
                new Phone("HTC U12", 36000)));

        Phone min1 = phones.stream().min(Phone::compare).get();
        Phone max1 = phones.stream().max(Phone::compare).get();
        System.out.printf("MIN Name: %s Price: %d \n", min1.getName(), min1.getPrice());
        System.out.printf("MAX Name: %s Price: %d \n", max1.getName(), max1.getPrice());
    }
}


