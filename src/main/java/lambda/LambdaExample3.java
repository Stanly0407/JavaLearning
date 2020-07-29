package lambda;

public class LambdaExample3 {

    public static void main(String[] args) {
        //другой пример - локальные переменные на уровне метода:

        int n=70;
        int m=30;
        Operation op = ()->
        {
            //n=100; - так нельзя сделать
            return m+n;
        };

        // n=100;  - так тоже нельзя
        System.out.println(op.calculate()); // 100

    }
}
