package lambda;

public class LambdaExample8 {

    public static void main(String[] args) {

        // Вариант 1
        Operation2 func = action(1);
        int a = func.execute(6, 5);
        System.out.println(a);          // 11

        // Вариант 2
        int b = action(2).execute(8, 2);
        System.out.println(b);          // 6
    }

    private static Operation2 action(int number) {
        switch (number) {
            case 1:
                return (x, y) -> x + y;
            case 2:
                return (x, y) -> x - y;
            case 3:
                return (x, y) -> x * y;
            default:
                return (x, y) -> 0;
        }
    }
}
