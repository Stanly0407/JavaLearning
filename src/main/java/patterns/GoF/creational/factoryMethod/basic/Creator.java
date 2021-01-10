package patterns.GoF.creational.factoryMethod.basic;

public abstract class Creator {
    public abstract Product factoryMethod();
    public void anOperation() {
        System.out.println("operation");
    }
}
