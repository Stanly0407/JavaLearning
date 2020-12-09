package algorithm.training;

import java.util.Scanner;

public class GCDTwoNumbers {
    // Наибольший ощий делитель двух чисел (НОД = GCD (Greatest Common Divisor))
    public static void main(String[] args) {

        int num1, num2;

        //Reading the input numbers
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number:");
        num1 = scanner.nextInt();

        System.out.print("Enter second number:");
        num2 = scanner.nextInt();

        //closing the scanner to avoid memory leaks
        scanner.close();
        while (num1 != num2) {
            if(num1 > num2)
                num1 = num1 - num2;
            else
                num2 = num2 - num1;
        }

        System.out.printf("GCD of given numbers is: %d", num2);
    }
}