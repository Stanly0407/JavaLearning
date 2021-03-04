package lambda;

public class LambdaExapmle1 {

    public static void main(String[] args) {
        // лямбда-оператор  ->
        // левая часть содержит список параметров выражения,
        // а правая собственно представляет тело лямбда-выражения, где выполняются все действия

        // Лямбда-выражение не выполняется само по себе, а образует реализацию метода, определенного в функциональном интерфейсе.
        // При этом важно, что функциональный интерфейс должен содержать только один единственный метод без реализации.

        Operationable operation;
        operation = (x, y) -> x + y;

        int result = operation.calculate(10, 20);
        System.out.println(result); //30

        Operationable operation1 = (int x, int y) -> x + y;
        Operationable operation2 = (int x, int y) -> x - y;
        Operationable operation3 = (int x, int y) -> x * y;

        System.out.println(operation1.calculate(20, 10)); //30
        System.out.println(operation2.calculate(20, 10)); //10
        System.out.println(operation3.calculate(20, 10)); //200

        //отложенное выполнение (deferred execution) - мы определяем в одном месте программы лямбда-выражение и затем можем его вызывать
        // при необходимости неопределенное количество раз в различных частях программы. может потребоваться:
        //Выполнение кода отдельном потоке
        //Выполнение одного и того же кода несколько раз
        //Выполнение кода в результате какого-то события
        //Выполнение кода только в том случае, когда он действительно необходим и если он необходим

        // Передача параметром. Если метод не принимает никаких параметров, то пишутся пустые скобки, например:
        // ()-> 30 + 20;
        // Если метод принимает только один параметр, то скобки можно опустить:
        // n-> n * n;

        // Терминальные лямбда-выражения. не возвращают никакого значения!
        Printable printer = s -> System.out.println(s);
        printer.print("Hello Java!");


    }


}


