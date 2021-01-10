package patterns.GoF.behavioral.strategy;

public class AudiA3 extends AudiCar {

    public AudiA3(){
        setDrivable(new RearWheelDrive());
    }
}
