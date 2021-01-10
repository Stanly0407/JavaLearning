package patterns.GoF.creational.factoryMethod.basic;

public class ConcreteProduct implements Product {
    @Override
    public void check() {
        System.out.println("concrete product");
    }
}
