package lambda;

public class LambdaExample2 {
    //Лямбды и локальные переменные

    // Пример 1 - использование переменных уровня класса
    static int x = 10;
    static int y = 20;

    public static void main(String[] args) {

        Operation op = ()->{

            x=30;
            return x+y;
        };

        System.out.println(op.calculate()); // 50
        System.out.println(x); // 30 - значение x изменилось
    }
    //Переменные x и y объявлены на уровне класса, и в лямбда-выражении мы их можем получить и даже изменить.
    //НО. См. класс LambdaExample3

    }


