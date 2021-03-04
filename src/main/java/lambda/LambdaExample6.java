package lambda;

public class LambdaExample6 {

    //Начиная с JDK 8 в Java можно в качестве параметра в метод передавать ссылку на другой метод.
    // В принципе данный способ аналогичен передаче в метод лямбда-выражения.
    //
    //Ссылка на метод передается в виде имя_класса::имя_статического_метода (если метод статический)
    // или объект_класса::имя_метода (если метод нестатический). Рассмотрим на примере:

    public static void main(String[] args) {

        int[] nums = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5};
        System.out.println(sum(nums, Lambda6Methods::isEven));    // имя_класса::имя_статического_метода

        Expression expr = LambdaExample6::isPositive;
        System.out.println(sum(nums, expr));
    }

    private static int sum(int[] numbers, Expression func) {
        int result = 0;
        for (int i : numbers) {
            if (func.isEqual(i))
                result += i;
        }
        return result;
    }


    static boolean isPositive(int n) {

        return n > 0;
    }

}

