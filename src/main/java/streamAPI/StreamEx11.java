package streamAPI;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx11 {

    // Группировка
    // Чтобы сгруппировать данные по какому-нибудь признаку, нам надо использовать в связке метод collect() объекта Stream
    // и метод Collectors.groupingBy().
    // Допустим, у нас есть класс Phone. И, к примеру, у нас есть набор объектов Phone, которые мы хотим сгруппировать по компании:

    public static void main(String[] args) {

        Stream<Phone> phoneStream = Stream.of(new Phone("iPhone X", "Apple", 600),
                new Phone("Pixel 2", "Google", 500),
                new Phone("iPhone 8", "Apple", 450),
                new Phone("Galaxy S9", "Samsung", 440),
                new Phone("Galaxy S8", "Samsung", 340));

        Map<String, List<Phone>> phonesByCompany = phoneStream.collect(
                Collectors.groupingBy(Phone::getCompany));

        for (Map.Entry<String, List<Phone>> item : phonesByCompany.entrySet()) {
            //каждая пара хранится в поле Map называемом Map.Entry.
            // Map.entrySet() возвращает набор ключ-значений.

            System.out.println(item.getKey());
            for (Phone phone : item.getValue()) {
                System.out.println(phone.getName());
            }
            System.out.println();
        }

        // Метод Collectors.partitioningBy
        // Метод Collectors.partitioningBy() имеет похожее действие, только он делит элементы на группы по принципу,
        // соответствует ли элемент определенному условию. Например:

        Stream<Phone> phoneStream2 = Stream.of(new Phone("iPhone X", "Apple", 600),
                new Phone("Pixel 2", "Google", 500),
                new Phone("iPhone 8", "Apple", 450),
                new Phone("Galaxy S9", "Samsung", 440),
                new Phone("Galaxy S8", "Samsung", 340));

        Map<Boolean, List<Phone>> phonesByCompany2 = phoneStream2.collect(
                Collectors.partitioningBy(p -> p.getCompany() == "Apple"));

        for (Map.Entry<Boolean, List<Phone>> item : phonesByCompany2.entrySet()) {
            System.out.println(item.getKey());
            for (Phone phone : item.getValue()) {
                System.out.println(phone.getName());
            }
            System.out.println();
        }

        // Метод Coollectors.counting
        // Метод Collectors.counting применяется в Collectors.groupingBy() для вычисления количества элементов в каждой группе:
        Stream<Phone> phoneStream3 = Stream.of(new Phone("iPhone X", "Apple", 600),
                new Phone("Pixel 2", "Google", 500),
                new Phone("iPhone 8", "Apple", 450),
                new Phone("Galaxy S9", "Samsung", 440),
                new Phone("Galaxy S8", "Samsung", 340));

        Map<String, Long> phonesByCompany3 = phoneStream3.collect(
                Collectors.groupingBy(Phone::getCompany, Collectors.counting()));

        for (Map.Entry<String, Long> item : phonesByCompany3.entrySet()) {

            System.out.println(item.getKey() + " - " + item.getValue());
        }

// Метод Collectors.summing
//Метод Collectors.summing применяется для подсчета суммы. В зависимости от типа данных, к которым применяется метод,
// он имеет следующие формы: summingInt(), summingLong(), summingDouble().
// Применим этот метод для подсчета стоимости всех смартфонов по компаниям:

        Stream<Phone> phoneStream4 = Stream.of(new Phone("iPhone X", "Apple", 600),
                new Phone("Pixel 2", "Google", 500),
                new Phone("iPhone 8", "Apple", 450),
                new Phone("Galaxy S9", "Samsung", 440),
                new Phone("Galaxy S8", "Samsung", 340));


        Map<String, Integer> phonesByCompany4 = phoneStream4.collect(
                Collectors.groupingBy(Phone::getCompany, Collectors.summingInt(Phone::getPrice)));

        for (Map.Entry<String, Integer> item : phonesByCompany4.entrySet()) {

            System.out.println(item.getKey() + " - " + item.getValue());
        }

        // Методы maxBy и minBy
        // Методы maxBy и minBy применяются для подсчета минимального и максимального значения в каждой группе.
        // В качестве параметра эти методы принимают функцию компаратора, которая нужна для сравнения значений.
        // Например, найдем для каждой компании телефон с минимальной ценой:

        Stream<Phone> phoneStream5 = Stream.of(new Phone("iPhone X", "Apple", 600),
                new Phone("Pixel 2", "Google", 500),
                new Phone("iPhone 8", "Apple", 450),
                new Phone("Galaxy S9", "Samsung", 440),
                new Phone("Galaxy S8", "Samsung", 340));

        Map<String, Optional<Phone>> phonesByCompany5 = phoneStream5.collect(
                Collectors.groupingBy(Phone::getCompany,
                        Collectors.minBy(Comparator.comparing(Phone::getPrice))));

        for (Map.Entry<String, Optional<Phone>> item : phonesByCompany5.entrySet()) {

            System.out.println(item.getKey() + " - " + item.getValue().get().getName());
        }
        System.out.println();
        // Метод summarizing
        //Методы summarizingInt() / summarizingLong() / summarizingDouble() позволяют объединить в набор значения соответствующих типов:
        Stream<Phone> phoneStream6 = Stream.of(new Phone("iPhone X", "Apple", 600),
                new Phone("Pixel 2", "Google", 500),
                new Phone("iPhone 8", "Apple", 450),
                new Phone("Galaxy S9", "Samsung", 440),
                new Phone("Galaxy S8", "Samsung", 340));

        Map<String, IntSummaryStatistics> priceSummary = phoneStream6.collect(
                Collectors.groupingBy(Phone::getCompany,
                        Collectors.summarizingInt(Phone::getPrice)));

        for (Map.Entry<String, IntSummaryStatistics> item : priceSummary.entrySet()) {

            System.out.println(item.getKey() + " - " + item.getValue().getAverage());
        }

// Метод Collectors.summarizingInt(Phone::getPrice)) создает набор, в который помещаются цены для всех телефонов каждой из групп.
// Данный набор инкапсулируется в объекте IntSummaryStatistics. Соответственно если бы мы применяли методы summarizingLong() или summarizingDouble(),
// то соответственно бы получали объекты LongSummaryStatistics или DoubleSummaryStatistics.

//У этих объектов есть ряд методов, который позволяют выполнить различные атомарные операции над набором:
//getAverage(): возвращает среднее значение
//getCount(): возвращает количество элементов в наборе
//getMax(): возвращает максимальное значение
//getMin(): возвращает минимальное значение
//getSum(): возвращает сумму элементов
//accept(): добавляет в набор новый элемент

        // Метод mapping
        //Метод mapping позволяет дополнительно обработать данные и задать функцию отображения объектов из потока на какой-нибудь другой тип данных. Например:
        Stream<Phone> phoneStream7 = Stream.of(new Phone("iPhone X", "Apple", 600),
                new Phone("Pixel 2", "Google", 500),
                new Phone("iPhone 8", "Apple", 450),
                new Phone("Galaxy S9", "Samsung", 440),
                new Phone("Galaxy S8", "Samsung", 340));
        Map<String, List<String>> phonesByCompany7 = phoneStream7.collect(Collectors.groupingBy(Phone::getCompany,
                Collectors.mapping(Phone::getName, Collectors.toList())));

        for (Map.Entry<String, List<String>> item7 : phonesByCompany7.entrySet()) {
            System.out.println(item7.getKey());
            for (String name : item7.getValue()) {
                System.out.println(name);}
        }
        //Выражение Collectors.mapping(Phone::getName, Collectors.toList()) указывает, что в группу будут выделятся названия смартфонов,
        // причем группа будет представлять объект List.


    }
}
