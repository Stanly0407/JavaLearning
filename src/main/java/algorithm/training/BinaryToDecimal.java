package algorithm.training;

import java.util.Scanner;

public class BinaryToDecimal {

    public static int binaryToDecimal(int binaryNumber){
        int decimal = 0;
        int p = 0;
        while(true){
            if(binaryNumber == 0){
                break;
            } else {
                int temp = binaryNumber%10;
                decimal += temp*Math.pow(2, p);
                binaryNumber = binaryNumber/10;
                p++;
            }
        }
        return decimal;
    }
    public static void main(String args[]){
        Scanner input = new Scanner( System.in );
        System.out.print("Enter a binary number: ");
        int binar = input.nextInt();

        System.out.println("Output: " + binaryToDecimal(binar));
    }





//        Details obj = new Details();
//        System.out.println("110 --> "+obj.BinaryToDecimal(110));
//        System.out.println("1101 --> "+obj.BinaryToDecimal(1101));
//        System.out.println("100 --> "+obj.BinaryToDecimal(100));
//        System.out.println("110111 --> "+obj.BinaryToDecimal(110111));

}
