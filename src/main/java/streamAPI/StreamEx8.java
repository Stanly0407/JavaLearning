package streamAPI;

import java.util.Optional;
import java.util.stream.Stream;

public class StreamEx8 {

    // Метод reduce     - eng. 	предварительно преобразовывать
    // Метод reduce выполняет терминальные операции сведения, возвращая некоторое значение - результат операции. Он имеет следующие формы:
    // Optional<T> reduce(BinaryOperator<T> accumulator)
    // T reduce(T identity, BinaryOperator<T> accumulator)
    // U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)

    public static void main(String[] args) {

        //1. Первая форма возвращает результат в виде объекта Optional<T>. Например, вычислим произведение набора чисел:
        Stream<Integer> numbersStream = Stream.of(1,2,3,4,5,6);
        Optional<Integer> result = numbersStream.reduce((x, y)->x*y);
        // метод reduce сохраняет результат и затем опять же применяет к этому результату и следующему элементу в наборе бинарную операцию.
        System.out.println(result.get()); // 720

        // Или еще один пример - объединение слов в предложение:
        Stream<String> wordsStream = Stream.of("мама", "мыла", "раму");
        Optional<String> sentence = wordsStream.reduce((x,y)->x + " " + y);
        System.out.println(sentence.get());

        // 2. Если нам надо, чтобы первым элементом в наборе было какое-то определенное значение, то мы можем использовать вторую версию метода reduce(),
        // которая в качестве первого параметра принимает T identity.
        // Этот параметр хранит значение, с которого будет начинаться цепочка бинарных операций. Например:

        Stream<String> wordsStream2 = Stream.of("мама", "мыла", "раму");
        String sentence2 = wordsStream2.reduce("Результат:", (x,y)->x + " " + y);
        System.out.println(sentence2); // Результат: мама мыла раму

// Использование параметра identity также подходит для тех случаев, когда надо предоставить значение по умолчанию, если поток пустой и не содержит элементов.

        // 3. В предыдущих примерах тип возвращаемых объектов совпадал с типом элементов, которые входят в поток. Однако это не всегда удобно.
        // Возможно, мы захотим возвратить результат, тип которого отличается от типа объектов потока.
        // Например, пусть у нас есть  класс Phone. И мы хотим найти сумму цен тех телефонов, у которых цена меньше определенного значения.
        // Для этого используем третью версию метода reduce:

        Stream<Phone> phoneStream = Stream.of(new Phone("iPhone 6 S", 54000),
                new Phone("Lumia 950", 45000),
                new Phone("Samsung Galaxy S 6", 40000),
                new Phone("LG G 4", 32000));

        int sum = phoneStream.reduce(0,      // это начальное значение x
                (x,y)-> {
                    if(y.getPrice()<50000)
                        return x + y.getPrice();
                    else
                        return x + 0;
                },
                (x, y)->x+y);

        System.out.println(sum); // 117000

// Опять же здесь в качестве первого параметра идет значение по умолчанию - 0.
// Второй параметр производит бинарную операцию, которая получает промежуточное значение - суммарную цену текущего и предыдущего телефонов.
// Третий параметр представляет бинарную операцию, которая суммирует все промежуточные вычисления.


    }




}
