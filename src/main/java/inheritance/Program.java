package inheritance;

public class Program {
    public static void main(String[] args) {
        Person tom = new Person("Tom");
        tom.display();
        //  tom.getLevelPlamber(); НЕЛЬЗЯ, т.к. это метод подкласса
        Employee sam = new Employee("Sam");
        sam.display();
        sam.getLevelEmployee();
        Employee olga = new Employee("Olga", "Super 1");
        olga.display();
        olga.getLevelEmployee();


        //  1)

        Person lev = new Employee("Lev", "Super 2");
        lev.display();
        //    lev.getLevelEmployee();  - НЕЛЬЗЯ, только если привести тип:
        ((Employee) lev).getLevelEmployee();

        //  2)

        //  Employee peter = new Person("Peter");  - НЕЛЬЗЯ, просит привести тип НО!!!!!! ИСКЛЮЧЕНИЕ ВЫБРАСЫВАЕТ
        //  Employee peter = (Employee) new Person("Peter");
        //  нельзя - Exception in thread "main" java.lang.ClassCastException:
        //  class inheritance.Person cannot be cast to class inheritance.Employee

        // ТАКЖЕ
        //  Employee peter2 = (Employee) new Person("Peter", "Super 3");  - при это НЕЛЬЗЯ добавить переменную level из класса Employee
        //     peter.display(); // Это метод Person  - метод родителя
        //     peter.getLevelEmployee();


        //  3)       с интерфейсами

        EmployeeImpl emp = new Employee("Sova", "Super 24");
        // можно создать такой объект, ЕСЛИ класс реализует такой интерфес. ПРИ ЭТОМ можно вызвать методы интерфейса, реализованные в этом классе:
        emp.sendMessage();
        //   emp.getLevelEmployee(); - НЕ позволяет метод не интерфейса! Можно только если привести тип:
        ((Employee) emp).getLevelEmployee();
        // также приведя тип можно вызвать метод родителя.
        ((Employee) emp).display();

        //  4)    с абстрактными классами
        Person lena = new Person("Lena");
        lena.getPositionInfo();
      //   Person oleg = new PersonAbstr(); - НЕЛЬЗЯ
        PersonAbstr sara = new Person("Sara");
        sara.getPositionInfo();
      //  sara.display;  - НЕЛЬЗЯ вызвать метод класса  Person! Только методы абстрактного класса (в отличие от интерфесов, где можно привести тип)

        PersonAbstr oleg = new Employee("Oleg", "Super 1"); // !!!! МОЖНО  создать объект, хотя и абстрактный класс унаследован родителем подкласса
        oleg.getPositionInfo();
        // метод можно вызвать только у абстрактного класса





    }
}
