package patterns.decorator;

abstract class Decorator extends Car{
//2.
    // Decorator наследуется от класса Car!
    // Это необходимо для согласования типов – !!! декораторы должны относиться к тому же типу, что и декорируемые объекты !!!

    public abstract String getInfo();
}
