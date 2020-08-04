package mathematic;

import java.math.BigInteger;

public class BigIntegerEx {
    public static void main(String[] args) {


// Большие числа BigInteger и BigDecimal

        //Встроенные примитивные числовые типы не всегда могут подходить для определенных программ.
        // Например, необходимо хранить и использовать в программе очень большие числа, которые выходят за пределы лопустимых значений
        // для типов long и double. В этом случае для работы с числовыми данными можно использовать два дополнительных типа
        // из пакета java.math - BigInteger (для целочисленных данных) и BigDecimal (для чисел с плавающей точкой).

        //Основные методы класса BigInteger:

        //BigInteger add(BigInteger other): возвращает сумму двух чисел

        //BigInteger subtract(BigInteger other): возвращает разность двух чисел

        //BigInteger multiply(BigInteger other): возвращает произведение двух чисел

        //BigInteger divide(BigInteger other): возвращает частное двух чисел

        //BigInteger mod(BigInteger other): возвращает остаток от целочисленного деления двух чисел

        //BigInteger sqrt(): возвращает квадратный корень числа

        //int compareTo(BigInteger other): сравнивает два числа. Возвращает -1, если текущий объект меньше числа other,
        // 1 - если текущий объект больше и 0 - если числа равны

        //static BigInteger valueOf(long x): возвращает объект BigInteger, значение которого равно числу, переданному в качестве параметра

        //int intValue(): конвертирует объект BigInteger в объект int

        //byte byteValue(): преобразует объект BigInteger в byte

        //short shortValue(): преобразует объект BigInteger в short

        //long longValue(): преобразует объект BigInteger в long

        BigInteger a = BigInteger.valueOf(2147483647);
        BigInteger b = BigInteger.valueOf(2147483641);
        //a = a + b;  // так нельзя
        a = a.multiply(b);
        System.out.println(a);  // 4611686001247518727
        long x = a.longValue();
        System.out.println(x);  // 4611686001247518727

    }
}
