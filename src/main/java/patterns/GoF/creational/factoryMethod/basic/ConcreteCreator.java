package patterns.GoF.creational.factoryMethod.basic;

public class ConcreteCreator extends Creator {
    @Override
    public Product factoryMethod() {
        // подготовительные действия
        this.anOperation();
        return new ConcreteProduct();
    }
}
