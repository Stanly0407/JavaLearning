package streamAPI;

public class Phone {

    private String name;
    private int price;
    //
    private String company;


    public Phone(String name, String comp, int price){
        this.name=name;
        this.company=comp;
        this.price = price;
    }


    public String getCompany() { return company; }


    public Phone(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // ex 7
    public static int compare (Phone p1, Phone p2){
        if(p1.getPrice() > p2.getPrice())
            return 1;
        return -1;
    }




}
