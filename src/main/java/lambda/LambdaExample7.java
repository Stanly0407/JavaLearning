package lambda;

public class LambdaExample7 {

    public static void main(String[] args) {

        // Подобным образом мы можем использовать конструкторы: название_класса::new.
        //При использовании конструкторов методы функциональных интерфейсов должны принимать
        // тот же список параметров, что и конструкторы класса, и должны возвращать объект данного класса.

        UserBuilder userBuilder = User::new;
        User user = userBuilder.create("Tom");
        System.out.println(user.getName());
    }


}
