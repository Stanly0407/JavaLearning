package inClasses.inner;

import java.util.Random;

public class Abonent {
    private long id;
    private String name;
    private String tariffPlan;
    private PhoneNumber phoneNumber;

    public Abonent(long id, String name) {
        this.id = id;
        this.name = name;
    }
    // объявление внутреннего класса
    private class PhoneNumber {
        private int countryCode;
        private int netCode;
        private int number;

        public void setCountryCode(int countryCode) { // проверка на допустимые значения кода страны
            this.countryCode = countryCode;        }

        public void setNetCode(int netCode) { // проверка на допустимые значения кода сети
            this.netCode = netCode;        }

        public int generateNumber (){
           number = new Random().nextInt(10_000_000);
           return number;}
    } // окончание внутреннего класса

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTariffPlan() {
        return tariffPlan;
    }

    public void setTariffPlan(String tariffPlan) {
        this.tariffPlan = tariffPlan;
    }

    public String getPhoneNumber() {
       if(phoneNumber!=null) {
           return ("+" + phoneNumber.countryCode + "-" + phoneNumber.netCode + "-" + phoneNumber.number);
       }else {
           return "phone number is empty!";
       }
    }

    // Соответсвует шаблону Facade!!
    public void obtainPhoneNumber(int countryCode, int netCode) {
        phoneNumber = new PhoneNumber();   // т е создали объект внутреннего класса в методе внешнего класс, чтоб использовать его элементы.
        phoneNumber.setCountryCode(countryCode);
        phoneNumber.setNetCode(netCode);
        phoneNumber.generateNumber();
    }

    @Override
    public String toString() {
        return "Abonent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tariffPlan='" + tariffPlan + '\'' +
                ", phoneNumber=" + phoneNumber + "      "+ getPhoneNumber() +
                '}';
    }

    public static void main(String[] args) {
        Abonent abonent = new Abonent(819002, "Ivan");
        abonent.setTariffPlan("free");
        abonent.obtainPhoneNumber(375, 25);
        System.out.println(abonent);
    }


}
