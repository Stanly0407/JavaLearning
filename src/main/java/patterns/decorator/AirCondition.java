package patterns.decorator;

//6.
public class AirCondition extends Decorator {
    Car car;

    public AirCondition(Car car){
        this.car = car;
    }

    public String getInfo() {
        return car.getInfo() + " + Air Conditioning";
    }

    public int getPrice() {
        return car.getPrice() + 1000;
    }
}
