package patterns.singleton;

public class Main {
    public static void main(String[] args) {
        DirectorCar dirCar = DirectorCar.getInstance(); // получили объект одиночку (мы его не создавали!)
        System.out.println(dirCar.getArmor());
        dirCar.setArmor(250); // для примера поменяли его поле про броню машины
        DirectorCar dirCar1 = DirectorCar.getInstance(); // получили объект одиночку в другую переменную
        System.out.println(dirCar1.getArmor()); // вывели ее на печать, но печатает тот же объект, но с изменнным ранее полем
        System.out.println(dirCar.getArmor());  // для примера снова напечатаю об этом объекте через первую переменную
    }


}
