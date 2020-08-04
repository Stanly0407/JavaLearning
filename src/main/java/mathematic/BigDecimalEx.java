package mathematic;

import java.math.BigDecimal;

public class BigDecimalEx {

    public static void main(String[] args) {

        //Основные методы класса BigDecimal:

        //BigDecimal add(BigDecimal other): возвращает сумму двух чисел

        //BigDecimal subtract(BigDecimal other): возвращает разность двух чисел

        //BigDecimal multiply(BigDecimal other): возвращает произведение двух чисел

        //BigDecimal divide(BigDecimal other): возвращает частное двух чисел

        //BigDecimal divide(BigDecimal other, RoundingMode mode): результат деления двух чисел, округленное в соответствии с режимом mode

        //int compareTo(BigDecimal other): сравнивает два числа. Возвращает -1, если текущий объект меньше числа other,
        // 1 - если текущий объект больше и 0 - если числа равны

        //static BigDecimal valueOf(double x): возвращает объект BigDecimal, значение которого равно числу, переданному в качестве параметра

        //double doubleValue(): преобразует объект BigDecimal в double

        //float floatValue(): преобразует объект BigDecimal в float

        BigDecimal c = BigDecimal.valueOf(2325.06);
        BigDecimal d = BigDecimal.valueOf(215.06);
        c = c.subtract(d.multiply(BigDecimal.valueOf(2.1)));
        System.out.println(c);      // 1873.434
        double y = c.doubleValue();
        System.out.println(y);      // 1873.434

    }
}
