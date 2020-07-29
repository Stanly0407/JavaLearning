package funInterface;

import java.util.Scanner;
import java.util.function.Supplier;

public class LambdaApp1 {
    // Встроенные функциональные интерфейсы.

    // !!!  встроенные функциональные интерфейсы размещеныв пакете java.util.function.
    // Однако здесь для изучения они реализованы!

    // В JDK 8 вместе с самой функциональностью лямбда-выражений также было добавлено некоторое количество встроенных функциональных интерфейсов,
    // которые мы можем использовать в различных ситуациях и в различные API в рамках JDK 8.
    // В частности, ряд далее рассматриваемых интерфейсов широко применяется в Stream API - новом прикладном интерфейсе для работы с данными.

    public static void main(String[] args) {

        // 1. Predicate<T>  (англ.) - логическое условие
        // Функциональный интерфейс Predicate<T> проверяет соблюдение некоторого условия. Если оно соблюдается, то возвращается значение true.
        // В качестве параметра лямбда-выражение принимает объект типа T

        Predicate<Integer> isPositive = x -> x > 0;

        System.out.println(isPositive.test(5)); // true
        System.out.println(isPositive.test(-7)); // false

        // 2. BinaryOperator<T>
        //BinaryOperator<T> принимает в качестве параметра два объекта типа T,
        // выполняет над ними бинарную операцию и возвращает ее результат также в виде объекта типа T:

        BinaryOperator<Integer> multiply = (x, y) -> x*y;

        System.out.println(multiply.apply(3, 5)); // 15
        System.out.println(multiply.apply(10, -2)); // -20

        // 3. UnaryOperator<T>
        // UnaryOperator<T> принимает в качестве параметра объект типа T,
        // выполняет над ними операции и возвращает результат операций в виде объекта типа T:

        UnaryOperator<Integer> square = x -> x*x;
        System.out.println(square.apply(5)); // 25

        // 4. Function<T,R>
        // Функциональный интерфейс Function<T,R> представляет функцию перехода от объекта типа T к объекту типа R:

        Function<Integer, String> convert = x-> String.valueOf(x) + " долларов";
        System.out.println(convert.apply(5)); // 5 долларов

        // 5. Consumer<T>
        // Consumer<T> выполняет некоторое действие над объектом типа T, при этом ничего не возвращая:

        Consumer<Integer> printer = x-> System.out.printf("%d долларов \n", x);
        printer.accept(600); // 600 долларов

        // 6. Supplier<T>
        // Supplier<T> не принимает никаких аргументов, но должен возвращать объект типа T:


        Supplier<User> userFactory = ()->{
            Scanner in = new Scanner(System.in);
            System.out.println("Введите имя: ");
            String name = in.nextLine();
            return new User(name);
        };

        User user1 = userFactory.get();
        User user2 = userFactory.get();

        System.out.println("Имя user1: " + user1.getName());
        System.out.println("Имя user2: " + user2.getName());

      // Обратить внимание на сущ-ие @FunctionalInterface
      // К функциональному интерфейсу можно добавить аннотацию @FunctionalInterface. Это не обязательно,
      // но при наличии данной аннотации код не скомпилируется,
      // если будет больше или меньше, чем 1 абстрактный метод.
      // Рекомендуется добавлять @FunctionalInterface. Это позволит использовать интерфейс в лямбда выражениях,
      // не остерегаясь того, что кто-то добавит в интерфейс новый абстрактный метод и он перестанет быть функциональным.


        // Наличие 1 абстрактного метода - это единственное условие,
        // !!! таким образом функциональный интерфейс может содержать так же default и static методы.
    }
}
