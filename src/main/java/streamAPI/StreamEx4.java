package streamAPI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class StreamEx4 {

    // Сортировка
    //Коллекции, на основе которых нередко создаются потоки, уже имеют специальные методы для сортировки содержимого.
    // Однако класс Stream также включает возможность сортировки.
    // Такую сортировку мы можем задействовать, когда у нас идет набор промежуточных операций с потоком,
    // которые создают новые наборы данных, и нам надо эти наборы отсортировать.

    //Для простой сортировки по возрастанию применяется метод sorted():

    public static void main(String[] args) {

        List<String> phones = new ArrayList<>();
        Collections.addAll(phones, "iPhone X", "Nokia 9", "Huawei Nexus 6P",
                "Samsung Galaxy S8", "LG G6", "Xiaomi MI6",
                "ASUS Zenfone 3", "Sony Xperia Z5", "Meizu Pro 6",
                "Pixel 2");

        phones.stream()
                .filter(p -> p.length() < 12)
                .sorted() // сортировка по возрастанию
                .forEach(s -> System.out.println(s));

//данный метод подходит только для сортировки тех объектов, которые реализуют интерфейс Comparable.
//Если же у нас классы объектов не реализуют этот интерфейс или мы хотим создать какую-то свою логику сортировки,
// то мы можем использовать другую версию метода sorted(), которая в качестве параметра принимает компаратор.

// Отсортируем поток обектов Phone:

        Stream<Phone> phoneStream = Stream.of(new Phone("iPhone X", "Apple", 600),
                new Phone("Pixel 2", "Google", 500),
                new Phone("iPhone 8", "Apple", 450),
                new Phone("Nokia 9", "HMD Global", 150),
                new Phone("Galaxy S9", "Samsung", 300));

        phoneStream.sorted(new PhoneComparator())
                .forEach(p -> System.out.printf("%s (%s) - %d \n",
                        p.getName(), p.getCompany(), p.getPrice()));
// Здесь определен класс компаратора PhoneComparator, который сортирует объекты по полю name.
    }
}




