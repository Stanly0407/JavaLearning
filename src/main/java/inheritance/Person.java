package inheritance;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Person extends PersonAbstr{

    private String name;

    public Person() {
        super();
    }

    String[] array = {"Natural History", "Science"};
    List<String> museums = Arrays.asList(array);
    public final double secret = 2;

    public String getName(){ return name; }

    public Person(String name){

        this.name=name;
    }

    public void display(){

        System.out.println("Name: " + name);
    }

    public static void getTest(){
        System.out.println("TEST STATIC");
    }


}
