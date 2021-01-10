package patterns.GoF.behavioral.strategy;

public class Main {

    public static void main(String[] args) {
        AudiCar audiA4 = new AudiA4();
        audiA4.performDrive();
        audiA4.setDrivable(new RearWheelDrive());
        audiA4.performDrive();
    }

}
