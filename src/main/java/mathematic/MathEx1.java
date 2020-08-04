package mathematic;

import java.util.Scanner;

public class MathEx1 {
    public static void main(String[] args) {


// Дополнительные классы
//Математические вычисления и класс Math

        // Для выполнения различных математических операций в Java в пакете java.lang определен класс Math. Рассмотрим его основные методы:

        //max(double a, double b): возвращает максимальное число из a и b
        //min(double a, double b): возвращает минимальное число из a и b

        //pow(double a, double b): возвращает число a, возведенное в степень
        //sqrt(double value): возвращает квадратный корень числа value
        double result1 = Math.sqrt(16); // 4

        //round(double d): возвращает число d, округленное до ближайшего целого числа
        System.out.println(Math.round(2.3)); // 2
        System.out.println(Math.round(2.5)); // 3
        System.out.println(Math.round(2.5001)); // 3
        System.out.println(Math.round(2.8)); // 3

        //rint(double value): возвращает число double, которое представляет ближайшее к числу value целое число
        System.out.println(Math.rint(2)); // 2.0
        System.out.println(Math.rint(2.3)); // 2.0
        System.out.println(Math.rint(2.5)); // 2.0
        System.out.println(Math.rint(2.5001)); // 3.0
        System.out.println(Math.rint(2.8)); // 3.0

        //ceil(double value): возвращает наименьшее целое число с плавающей точкой, которое не меньше value
        double result4 = Math.ceil(2.34); // 3.0

        //floor(double d): возвращает наибольшее целое число, которое не больше d
        double result5 = Math.floor(2.56); // 2

        //floorDiv(int a, int b): возвращает целочисленный результат деления a на b
        System.out.println(Math.floorDiv(1, 2)); // 0
        System.out.println(Math.floorDiv(7, 2)); // 3
        System.out.println(Math.floorDiv(9, 2)); // 4

        //random(): возвращает случайное число от 0.0 до 1.0

        //ДОПОЛНИТЬ


        // Также класс Math определяет две константы: Math.E и Math.PI. Например, вычислим площадь круга:
        Scanner in = new Scanner(System.in);

        System.out.print("Введите радиус круга: ");
        int radius = in.nextInt();
        long area = Math.round(Math.PI * Math.pow(radius, 2));
        System.out.printf("Площадь круга с радиусом %d равна %d \n", radius, area);


        //ДОП

        //abs(double value): возвращает абсолютное значение для аргумента value
        double result = Math.abs(-13.5); // 13.5

        //acos(double value): возвращает арккосинус value. Параметр value должен иметь значение от -1 до 1
        double result2 = Math.acos(1); // 0.0
        //asin(double value): возвращает арксинус value. Параметр value должен иметь значение от -1 до 1
        //atan(double value): возвращает арктангенс value

        //cbrt(double value): возвращает кубический корень числа value
        double result3 = Math.cbrt(27); // 3

        //cos(double d): возвращает косинус угла d
        //cosh(double d): возвращает гиперболический косинус угла d
        //exp(double d): возвращает основание натурального логарифма, возведенное в степень d

        //log(double a): возвращает натуральный логарифм числа a
        //log1p(double d): возвращает натуральный логарифм числа (d + 1)
        //log10(double d): возвращает десятичный логарифм числа d

        //scalb(double value, int factor): возвращает произведение числа value на 2 в степени factor
        System.out.println(Math.scalb(5, 3)); // 5*2*2*2 = 40
        System.out.println(Math.scalb(3, 4)); // 3*2*2*2*2 = 48

        //signum(double value): возвращает число 1, если число value положительное, и -1, если значение value отрицательное.
        // Если value равно 0, то возвращает 0
        System.out.println(Math.signum(2.3)); // 1
        System.out.println(Math.signum(-2.3)); // -1

        //sin(double value): возвращает синус угла value
        //sinh(double value): возвращает гиперболический синус угла value
        //tan(double value): возвращает тангенс угла value
        //tanh(double value): возвращает гиперболический тангенс угла value
        //toDegrees(double value) переводит радианы в градусы и toRadians(double value) - градусы в радианы
        System.out.println(Math.toDegrees(3.14159)); // 180
        System.out.println(Math.toRadians(90)); // 1,57079....

    }
}