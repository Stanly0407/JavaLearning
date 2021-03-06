package patterns.GoF.structural.facade;

public class GPSPower {

    /*
    Паттерн Фасад — структурный шаблон проектирования, позволяющий скрыть сложность системы путем
    сведения всех возможных внешних вызовов к одному объекту, делегирующему их соответствующим объектам системы.

    Реализация: давайте попробуем разработать навигационную систему автомобиля.
    Перед поездкой водитель будет включать GPS, загружать данные о пробках, прокладывать путь и выключать после поездки.
    За каждое описанное действие будет отвечать отдельный класс, кроме включения и выключения.
     */

    // 1. И так, класс управления электропитанием GPSPower: Класс содержит два метода, один включает GPS другой выключает.

    public void powerOn(){
        System.out.println("Power ON");
    }

    public void powerOff(){
        System.out.println("Power OFF");
    }



}
