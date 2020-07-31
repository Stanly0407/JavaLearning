package streamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

public class StreamEx9 {

    // Тип Optional

// Ряд операций сведения, такие как min, max, reduce, возвращают объект Optional<T>.
// Этот объект фактически обертывает результат операции. После выполнения операции с помощью метода get() объекта Optional мы можем получить его значение:

    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9));
        Optional<Integer> min1 = numbers.stream().min(Integer::compare);
        System.out.println(min1.get());  // 1

// 1. Но что, если поток не содержит вообще никаких данных:
// список numbers пустой
//ArrayList<Integer> numbers = new ArrayList<Integer>();
//Optional<Integer> min = numbers.stream().min(Integer::compare);
//System.out.println(min.get());  // java.util.NoSuchElementException

//В этом случае программа выдаст исключение java.util.NoSuchElementException. Что мы можем сделать, чтобы избежать выброса исключения?
// Для этого класс Optional предоставляет ряд методов.
//Самой простой способ избежать подобной ситуации - это предварительная проверка наличия значения в Optional с помощью метода isPresent().
// Он возврашает true, если значение присутствует в Optional, и false, если значение отсутствует:

        ArrayList<Integer> numbers2 = new ArrayList<>();
        Optional<Integer> min2 = numbers2.stream().min(Integer::compare);
        if(min2.isPresent()){
            System.out.println(min2.get());
        }

// 2. orElse
//Метод orElse() позволяет определить альтернативное значение, которое будет возвращаться, если Optional не получит из потока какого-нибудь значения:

// пустой список
        ArrayList<Integer> numbers3 = new ArrayList<>();
        Optional<Integer> min = numbers3.stream().min(Integer::compare);
        System.out.println(min.orElse(-1)); // -1

// непустой список
        numbers3.addAll(Arrays.asList(4,5,6,7,8,9));
        min = numbers3.stream().min(Integer::compare);
        System.out.println(min.orElse(-1)); // 4

// 3. orElseGet
//Метод orElseGet() позволяет задать функцию, которая будет возвращать значение по умолчанию:

        ArrayList<Integer> numbers4 = new ArrayList<>();
        Optional<Integer> min4 = numbers4.stream().min(Integer::compare);
        Random rnd = new Random();
        System.out.println(min4.orElseGet(()->rnd.nextInt(100)));
//В данном случае возвращаемое значение генерируется с помощью метода nextInt класса Random, который возвращает случайное число.

// 4. orElseThrow
//Еще один метод - orElseThrow позволяет сгенерировать исключение, если Optional не содержит значения:

        //ArrayList<Integer> numbers5 = new ArrayList<Integer>();
        //Optional<Integer> min5 = numbers5.stream().min(Integer::compare);
// генерация исключения IllegalStateException
        //System.out.println(min5.orElseThrow(IllegalStateException::new));

// 5. Обработка полученного значения
//Метод ifPresent() определяет действия со значением в Optional, если значение имеется:

        ArrayList<Integer> numbers6 = new ArrayList<>();
        numbers6.addAll(Arrays.asList(4,5,6,7,8,9));
        Optional<Integer> min6 = numbers6.stream().min(Integer::compare);
        min6.ifPresent(v->System.out.println(v)); // 4

// В метод ifPresent передается функция, которая принимает один параметр - значение из Optional.
// В данном случае полученное минимальное число выводится на консоль. Но если бы массив numbers был бы пустым,
// и соответственно Optional не сдержало бы никакого значения, то никакой ошибки бы не было.

// 6. Метод ifPresentOrElse() позволяет определить альтернативную логику на случай, если значение в Optional отсутствует:
        ArrayList<Integer> numbers7 = new ArrayList<>();
        Optional<Integer> min7 = numbers7.stream().min(Integer::compare);
        min7.ifPresentOrElse(
                v -> System.out.println(v),
                () -> System.out.println("Value not found")
        );
// В метод ifPresentOrElse передается две функции. Первая обрабатывает значение в Optional, если оно присутствует.
// Вторая функция представляет действия, которые выполняются, если значение в Optional отсутствует.

    }









}
