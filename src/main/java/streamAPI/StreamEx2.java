package streamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamEx2 {

// В качестве источника потока мы можем использовать коллекции. В частности, в JDK 8 в интерфейс Collection,
// который реализуется всеми классами коллекций, были добавлены два метода для работы с потоками:
           //default Stream<E> stream: возвращается поток данных из коллекции
           //default Stream<E> parallelStream: возвращается параллельный поток данных из коллекции
// 1. Так, рассмотрим пример с ArrayList:

    public static void main(String[] args) {
        ArrayList<String> cities = new ArrayList<String>();
        Collections.addAll(cities, "Париж", "Лондон", "Мадрид");
        cities.stream() // получаем поток
                .filter(s->s.length()==6) // применяем фильтрацию по длине строки
                .forEach(s->System.out.println(s)); // выводим отфильтрованные строки на консоль
    // Важно, что после использования терминальных операций другие терминальные или промежуточные операции к этому же потоку не могут быть применены,
    // поток уже употреблен. Фактически жизненный цикл потока проходит следующие три стадии:
        //Создание потока
        //Применение к потоку ряда промежуточных операций
        //Применение к потоку терминальной операции и получение результата


        // 2. метод Arrays.stream(T[] array), который создает поток данных из массива:
        Stream<String> citiesStream = Arrays.stream(new String[]{"Париж", "Лондон", "Мадрид"}) ;
        citiesStream.forEach(s->System.out.println(s)); // выводим все элементы массива

        // 2.1. Для создания потоков IntStream, DoubleStream, LongStream можно использовать соответствующие перегруженные версии этого метода:

        IntStream intStream = Arrays.stream(new int[]{1,2,4,5,7});
        intStream.forEach(i->System.out.println(i));

        LongStream longStream = Arrays.stream(new long[]{100,250,400,5843787,237});
        longStream.forEach(l->System.out.println(l));

        DoubleStream doubleStream = Arrays.stream(new double[] {3.4, 6.7, 9.5, 8.2345, 121});
        doubleStream.forEach(d->System.out.println(d));

        // 3. И еще один способ создания потока представляет статический метод of(T..values) класса Stream:

        Stream<String> citiesStream2 = Stream.of("Париж", "Лондон", "Мадрид");
        citiesStream2.forEach(s->System.out.println(s));

        // можно передать массив
        String[] cities2 = {"Париж", "Лондон", "Мадрид"};
        Stream<String> citiesStream3 =Stream.of(cities2);
        citiesStream3.forEach(s->System.out.println(s));

        IntStream intStream1 = IntStream.of(1,2,4,5,7);
        intStream1.forEach(i->System.out.println(i));

        LongStream longStream1 = LongStream.of(100,250,400,5843787,237);
        longStream1.forEach(l->System.out.println(l));

        DoubleStream doubleStream1 = DoubleStream.of(3.4, 6.7, 9.5, 8.2345, 121);
        doubleStream1.forEach(d->System.out.println(d));

    }

}
