package streamAPI;

import java.util.stream.Stream;

public class StreamEx3 {

    // 1. Фильтрация, перебор элементов и отображение

    // Перебор элементов. Метод forEach
    //Для перебора элементов потока применяется метод forEach(), который представляет терминальную операцию.
    // В качестве параметра он принимает объект Consumer<? super String>, который представляет действие, выполняемое для каждого элемента набора. Например:
    public static void main(String[] args) {
        Stream<String> citiesStream = Stream.of("Париж", "Лондон", "Мадрид","Берлин", "Брюссель");
        citiesStream.forEach(s->System.out.println(s));

     //   Кстати мы можем сократить в данном случае применение метода forEach следующим образом:

        Stream<String> citiesStream2 = Stream.of("Париж", "Лондон", "Мадрид","Берлин", "Брюссель");
        citiesStream2.forEach(System.out::println);
      // Фактически здесь переадается ссылка на статический метод, который выводит строку на консоль.

     // 2. Фильтрация. Метод filter
    //Для фильтрации элементов в потоке применяется метод filter(), который представляет промежуточную операцию.
    // Он принимает в качестве параметра некоторое условие в виде объекта Predicate<T> и возвращает новый поток из элементов, которые удовлетворяют этому условию:
        Stream<String> citiesStream3 = Stream.of("Париж", "Лондон", "Мадрид","Берлин", "Брюссель");
        citiesStream3.filter(s->s.length()==6).forEach(s->System.out.println(s));

// Рассмотрим еще один пример фильтрации с более сложными данными. Допустим, у нас есть следующий класс Phone:
// Отфильтруем набор телефонов по цене:

        Stream<Phone> phoneStream = Stream.of(new Phone("iPhone 6 S", 54000), new Phone("Lumia 950", 45000),
                new Phone("Samsung Galaxy S 6", 40000));

        phoneStream.filter(p->p.getPrice()<50000).forEach(p->System.out.println(p.getName()));

        // 3. Отображение. Метод map
        // Отображение или маппинг позволяет задать функцию преобразования одного объекта в другой, то есть получить из элемента одного типа элемент другого типа.
        // Для отображения используется метод map, который имеет следующее определение:
        // <R> Stream<R> map(Function<? super T, ? extends R> mapper)
        //Передаваемая в метод map функция задает преобразование от объектов типа T к типу R.
        // И в результате возвращается новый поток с преобразованными объектами.
        //
        //Возьмем вышеопределенный класс телефонов и выполним преобразование от типа Phone к типу String:

        Stream<Phone> phoneStream2 = Stream.of(new Phone("iPhone 6 S", 54000), new Phone("Lumia 950", 45000),
                new Phone("Samsung Galaxy S 6", 40000));

        phoneStream2
                .map(p-> p.getName()) // помещаем в поток только названия телефонов
                .forEach(s->System.out.println(s));

         // Еще проведем преобразования:

        Stream<Phone> phoneStream3 = Stream.of(new Phone("iPhone 6 S", 54000), new Phone("Lumia 950", 45000),
                new Phone("Samsung Galaxy S 6", 40000));
        phoneStream3
                .map(p-> "название: " + p.getName() + " цена: " + p.getPrice())
                .forEach(s->System.out.println(s));

// Для преобразования объектов в типы Integer, Long, Double определены специальные методы mapToInt(), mapToLong() и mapToDouble() соответственно.

        // 4. Плоское отображение. Метод flatMap
        //Плоское отображение выполняется тогда, когда из одного элемента нужно получить несколько. Данную операцию выполняет метод flatMap:
        //<R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)
        //Например, в примере выше мы выводим название телефона и его цену. Но что, если мы хотим установить для каждого телефона цену со скидкой и цену без скидки.
        // То есть из одного объекта Phone нам надо получить два объекта с информацией, например, в виде строки. Для этого применим flatMap:

        Stream<Phone> phoneStream4 = Stream.of(new Phone("iPhone 6 S", 54000), new Phone("Lumia 950", 45000),
                new Phone("Samsung Galaxy S 6", 40000));

        phoneStream4
                .flatMap(p->Stream.of(
                        String.format("название: %s  цена без скидки: %d", p.getName(), p.getPrice()),
                        String.format("название: %s  цена со скидкой: %d", p.getName(), p.getPrice() - (int)(p.getPrice()*0.1))
                ))
                .forEach(s->System.out.println(s));


    }




}
