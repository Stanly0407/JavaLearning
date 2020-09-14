package patterns.facade;

public class Main {

    //4.

    public static void main(String... args){
        GPSPower power = new GPSPower();
        GPSNotifier notifier = new GPSNotifier();
        RoadAdvisor advisor = new RoadAdvisor();

        GPSInterface gps = new GPSInterface(power, notifier, advisor);

        //Водитель включает навигационную систему
        gps.activate();
        //Водитель выключает навигационную систему
        power.powerOff();

    }
}

/*
Я надеюсь вы обратили внимание, что отключение навигационной системы в нашем примере осталось низменным:
power.powerOff();
Это одна из полезных особенностей данного паттерна – мы вольны работать с классами,
которые скрыты интерфейсом (фасадом), напрямую, если в этом есть необходимость.
И так, если вам необходимо упростить работу с каким-либо интерфейсом или изолировать клиента от сложной системы,
 то паттерн Фасад будет идеальным выбором.
 */
