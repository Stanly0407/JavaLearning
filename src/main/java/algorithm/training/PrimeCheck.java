package algorithm.training;

import java.util.Scanner;

// check prime number
public class PrimeCheck {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter any number:");
        long num = scan.nextLong();
        scan.close();

        long temp;

        boolean isPrime = true;

        for (long i = 2; i <= num / 2; i++) {
            temp = num % i;

            if (temp == 0) {

                isPrime = false;

                break;
            }

        }
        //If isPrime is true then the number is prime else not
        if (isPrime)
            System.out.println(num + " is a Prime Number");
        else
            System.out.println(num + " is not a Prime Number");
    }
}
