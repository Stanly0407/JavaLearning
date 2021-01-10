package patterns.GoF.behavioral.strategy;

public class AudiA4 extends AudiCar{

    public AudiA4(){
        setDrivable(new FullWheelDrive());
    }

}
