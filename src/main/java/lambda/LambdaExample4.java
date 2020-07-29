package lambda;

public class LambdaExample4 {

    public static void main(String[] args) {
        // Обобщенный функциональный интерфейс

        // Функциональный интерфейс может быть обобщенным, однако в лямбда-выражении использование обобщений не допускается.
        // В этом случае нам надо типизировать объект интерфейса определенным типом, который потом будет применяться в лямбда-выражении. Например:

        Operationab<Integer> operation1 = (x, y)-> x + y;
        Operationab<String> operation2 = (x, y) -> x + y;

        System.out.println(operation1.calculate(20, 10)); //30
        System.out.println(operation2.calculate("20", "10")); //2010
    }

}
