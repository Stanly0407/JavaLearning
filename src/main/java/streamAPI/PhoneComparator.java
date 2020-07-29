package streamAPI;

import java.util.Comparator;

class PhoneComparator implements Comparator<Phone> {

    public int compare(Phone a, Phone b){

        return a.getName().toUpperCase().compareTo(b.getName().toUpperCase());
    }
}
