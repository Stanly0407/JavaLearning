package patterns.decorator;

// 3. когда у нас есть основа нашего приложения приступим к созданию классов машин:

public class AudiA3 extends Car {
    public AudiA3() {
        name = "Audi A3";
    }

    public int getPrice() {
        return 10_000;
    }
}
