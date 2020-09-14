package inheritance;

public class Employee extends Person implements EmployeeImpl {
    String level;


    public final double secret = 4;

    public void getLevelEmployee (){
        System.out.println(level);
    }

    public Employee(String name) {
        super(name);
    }

    public Employee(String name, String level) {
        super(name);
        this.level = level;
    }

    @Override
    public void sendMessage() {
        System.out.println("I'm employee");
    }

    public static void getTest(){
        System.out.println("TEST STATIC");
    }

}
