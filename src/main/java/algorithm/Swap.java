package algorithm;


import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.time.Month;

public class Swap {

    // Метод swap
    // Часто в процессе решения той или иной задачи, две переменные должны обменяться значениями.
    // Есть два варианта реализации обмена значениями:

    public static void main(String[] args) {



        //Вариант 1: обмен значениями с использованием временной переменной
        //Вводим временную переменную, которая на время придержит значение из одной переменной:
        int a = 3;
        int b = 5;

        int tmp = a;
        a = b;
        b = tmp;

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        // Вариант 2: обмен значениями без использования временной переменной
        // Третья переменная не вводится, обмен достигается путем сложения и вычитания:

        int c = 3;
        int d = 5;

        c = c + d; // c = 8, d = 5
        d = c - d; // c = 8, d = 3
        c = c - d; // c = 5, d = 3

        System.out.println("c = " + c);
        System.out.println("d = " + d);






    }









}























