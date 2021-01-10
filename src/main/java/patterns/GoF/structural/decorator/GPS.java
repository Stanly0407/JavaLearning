package patterns.GoF.structural.decorator;


//5.
// классы для дополнительных опций.
//Для простоты разработаем два класса – встроенный GPS навигатор и кондиционер:
public class GPS extends Decorator {

    Car car;

    // В конструкторе классов мы передаем объект автомобиля, а в методах getInfo() и getPrice() добавляем описание и цену для новой комплектации.

    public GPS(Car car){
        this.car = car;
    }

    public String getInfo() {
        return car.getInfo() + " + GPS";
    }

    public int getPrice() {
        return car.getPrice() + 1500;
    }
}
