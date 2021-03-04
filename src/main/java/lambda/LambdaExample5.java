package lambda;

public class LambdaExample5 {
    // Лямбды как параметры методов

    //Одним из преимуществ лямбд в java является то, что их можно передавать в качестве параметров в методы.

    public static void main(String[] args) {

        //Вариант 1
        Expression func = n-> n%2==0;
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        System.out.println(sum(nums, func)); // 20


        // вариант 2
        // При этом можно не определять переменную интерфейса, а сразу передать в метод лямбда-выражение:
        int[] nums2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        int x = sum(nums2, (n)-> n > 5); // сумма чисел, которые больше 5
        System.out.println(x);  // 30
    }



    private static int sum (int[] numbers, Expression func)
    {
        int result = 0;
        for(int i : numbers)
        {
            if (func.isEqual(i))
                result += i;
        }
        return result;
    }



}
