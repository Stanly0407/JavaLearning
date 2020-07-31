package streamAPI;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx10 {

    // Метод collect
    // Большинство операций класса Stream, которые модифицируют набор данных, возвращают этот набор в виде потока.
    // Однако бывают ситуации, когда хотелось бы получить данные не в виде потока, а в виде обычной коллекции,
    // например, ArrayList или HashSet. И для этого у класса Stream определен метод collect.

    // 1.  Первая версия метода принимает в качестве параметра функцию преобразования к коллекции:
    //<R,A> R collect(Collector<? super T,A,R> collector)
    //Параметр R представляет тип результата метода, параметр Т - тип элемента в потоке,
    // а параметр А - тип промежуточных накапливаемых данных. В итоге параметр collector представляет функцию преобразования потока в коллекцию.
    //Эта функция представляет объект Collector, который определен в пакете java.util.stream.
    // Мы можем написать свою реализацию функции, однако Java уже предоставляет ряд встроенных функций, определенных в классе Collectors:
    //toList(): преобразование к типу List
    //toSet(): преобразование к типу Set
    //toMap(): преобразование к типу Map
    //Например, преобразуем набор в потоке в список:

    public static void main(String[] args) {

        List<String> phones = new ArrayList<>();
        Collections.addAll(phones, "iPhone 8", "HTC U12", "Huawei Nexus 6P",
                "Samsung Galaxy S9", "LG G6", "Xiaomi MI6", "ASUS Zenfone 2",
                "Sony Xperia Z5", "Meizu Pro 6", "Lenovo S850");

        List<String> filteredPhones = phones.stream()
                .filter(s -> s.length() < 10)
                .collect(Collectors.toList());

        for (String s : filteredPhones) {
            System.out.println(s);
        }

        // Использование метода toSet() аналогично.

        Set<String> filteredPhones2 = phones.stream()
                .filter(s -> s.length() < 10)
                .collect(Collectors.toSet());
        for (String s : filteredPhones2) {
            System.out.println(s);
        }

        // Для применения метода toMap() надо задать ключ и значение. Например, пусть у нас есть следующая модель:

        Stream<Phone> phoneStream = Stream.of(new Phone("iPhone 8", 54000),
                new Phone("Nokia 9", 45000),
                new Phone("Samsung Galaxy S9", 40000),
                new Phone("LG G6", 32000));


        Map<String, Integer> phones3 = phoneStream
                .collect(Collectors.toMap(p -> p.getName(), t -> t.getPrice()));

        phones3.forEach((k, v) -> System.out.println(k + " " + v));

// Если нам надо создать какой-то определенный тип коллекции, например, HashSet, то мы можем использовать специальные функции,
// которые определены в классах-коллекций. Например, получим объект HashSet:

        Stream<String> phones4 = Stream.of("iPhone 8", "HTC U12", "Huawei Nexus 6P",
                "Samsung Galaxy S9", "LG G6", "Xiaomi MI6", "ASUS Zenfone 2",
                "Sony Xperia Z5", "Meizu Pro 6", "Lenovo S850");

        HashSet<String> filteredPhones4 = phones4.filter(s -> s.length() < 12).
                collect(Collectors.toCollection(HashSet::new));
        filteredPhones4.forEach(s -> System.out.println(s));
        //  Выражение HashSet::new представляет функцию создания коллекции.

        // 2.  Вторая форма метода collect имеет три параметра:
        //<R> R collect(Supplier<R> supplier, BiConsumer<R,? super T> accumulator, BiConsumer<R,R> combiner)
        //supplier: создает объект коллекции
        //accumulator: добавляет элемент в коллекцию
        //combiner: бинарная функция, которая объединяет два объекта
        System.out.println();
        //Применим эту версию метода collect:

        Stream<String> phones5 = Stream.of("iPhone 8", "HTC U12", "Huawei Nexus 6P",
                "Samsung Galaxy S9", "LG G6", "Xiaomi MI6", "ASUS Zenfone 2",
                "Sony Xperia Z5", "Meizu Pro 6", "Lenovo S850");

        ArrayList<String> filteredPhones5 = phones5.filter(s -> s.length() < 12)
                .collect(
                        () -> new ArrayList<>(), // создаем ArrayList
                        (list, item) -> list.add(item), // добавляем в список элемент
                        (list1, list2) -> list1.addAll(list2)); // добавляем в список другой список

        filteredPhones5.forEach(s -> System.out.println(s));

    }

}
