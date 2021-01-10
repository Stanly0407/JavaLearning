package patterns.GoF.structural.decorator;

public class Main3 {
    public static void main(String[] args) {
        Car car1 = new AudiA3();
        System.out.println(car1.getInfo());
        System.out.println(car1.getPrice());

        car1 = new GPS(car1);
        System.out.println(car1.getInfo());
        System.out.println(car1.getPrice());

        car1 = new AirCondition(car1);
        System.out.println(car1.getInfo());
        System.out.println(car1.getPrice());

        Car car2 = new AirCondition(new GPS(new AudiA4()));
        System.out.println(car2.getInfo());
        System.out.println(car2.getPrice());

        Car car3 = new AirCondition(new GPS(new AudiA3()));
        System.out.println(car3.getInfo());
        System.out.println(car3.getPrice());

    }
}
//Классы должны быть открыты для расширения, но закрыты для изменений
// в качестве основного плюса - возможность динамически подключать новую функциональность объектам.
