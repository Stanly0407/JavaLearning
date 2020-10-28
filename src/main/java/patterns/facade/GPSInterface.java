package patterns.facade;

public class GPSInterface {

    // класс - ФАСАД

    /* 4.   public static void main(String... args){
        GPSPower power = new GPSPower();
        GPSNotifier notifier = new GPSNotifier();
        RoadAdvisor advisor = new RoadAdvisor();

        //Водитель включает навигационную систему
        power.powerOn();
        //Водитель нажимает кнопку загрузки информации о дорогах
        notifier.downloadRoadInfo();
        //Водитель нажимает кнопку прокладки маршрута
        advisor.route();
        //Водитель выключает навигационную систему
        power.powerOff();
    }

Работает неплохо, но как вы можете заметить водитель приходится слишком много взаимодействовать
с навигационной системой, если мы ничего не предпримем конкуренты нас смогут обойти.
В этом нам и поможет паттерн Фасад, в качестве фасада, у нас будет выступать класс GPSInterface,
который будет за водителя выполнять однотипные действия:
     */

    // как вариант не через конструктор это проинициазировать поля - создать экземпляры

    private GPSPower power = new GPSPower();
    private GPSNotifier notifier = new GPSNotifier();
    private RoadAdvisor advisor = new RoadAdvisor();

//    public GPSInterface(GPSPower power, GPSNotifier notifier, RoadAdvisor advisor){
//        this.power = power;
//        this.notifier = notifier;
//        this.advisor = advisor;
//    }

    public void activate(){
        power.powerOn();
        notifier.downloadRoadInfo();
        advisor.route();
    }

    /*
    В конструктор класса передаются все элементы, управление которыми мы хотим скрыть «за фасадом».
    Метод activate() будет выполнять всю рутинную работу за водителя – включать систему, загружать информацию
    о ситуации на дорогах и прокладывать оптимальный маршрут и это все по нажатию одной кнопки!
    Давайте проверим как работает наш новый класс в классе Main.
     */

}
