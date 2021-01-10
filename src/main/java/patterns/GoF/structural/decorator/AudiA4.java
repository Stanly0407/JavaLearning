package patterns.GoF.structural.decorator;

public class AudiA4 extends Car {
    //4.
    public AudiA4() {
        name = "Audi A4";
    }

    public int getPrice() {
        return 15_000;
    }
}

/* Оба класса машин наследуются от базового абстрактного класса Car и реализуют его метод getPrice()
устанавливая индивидуальную цену на базовую модель машины.
 */
