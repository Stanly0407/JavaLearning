package patterns.GoF.structural.decorator;

abstract class Car {

    /*
     Паттерн Декоратор – шаблон проектирования, предназначенный для динамического подключения к объекту дополнительного поведения.
     Паттерн Декоратор представляет гибкую альтернативу практике создания подклассов с целью расширения функциональности.
     Реализация: попробуем написать программу для расчета стоимости автомобиля на основании его комплектации.
     Ранее при рассмотрении шаблонов проектирования старались избегать механизма наследования отдавая предпочтение композиции.

     Начнем работу с создания двух абстрактных классов один для машин (Car, Decorator), второй для дополнительных опций к машинам:

       1.
     */

    String name = "Unnamed Car";

    public String getInfo(){         //  для перечисления дополнительных опций встраиваемых в машину
        return name;
    }

    public abstract int getPrice();  //  для подсчета окончательной цены автомобиля
}




