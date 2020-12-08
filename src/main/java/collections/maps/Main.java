package collections.maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<String, Product> productsByName = new HashMap<>();

        Product eBike = new Product("E-Bike", "A bike with a battery");
        Product roadBike = new Product("Road bike", "A bike for competition");

        // put. Кладем в мапу продукты, ключом выбираем имя продукта.
        productsByName.put(eBike.getName(), eBike);
        productsByName.put(roadBike.getName(), roadBike);

        // создаем значение из объекта из карты по ключу
        Product nextPurchase = productsByName.get("E-Bike");
        System.out.println(nextPurchase.getDescription()); // A bike with a battery

        // If we try to find a value for a key that doesn 't exist in the map, we' ll get a null value:
        Product nextPurchase2 = productsByName.get("Car");
        System.out.println(nextPurchase2); // null

        // И если мы вставим второе значение с тем же ключом, мы получим только последнее вставленное значение для этого ключа:
        Product newEBike = new Product("E-Bike", "A bike with a better battery");
        productsByName.put(newEBike.getName(), newEBike);
        System.out.println(productsByName.get("E-Bike").getDescription());

        // HashMap also allows us to have null as a key:
        Product defaultProduct = new Product("Chocolate", "At least buy chocolate");
        productsByName.put(null, defaultProduct);
        Product nextPurchase3 = productsByName.get(null);
        System.out.println(nextPurchase3.getDescription());

        // We can remove a key-value mapping from the HashMap:
        productsByName.remove("E-Bike");
        System.out.println(productsByName.get("E-Bike"));

        // To check if a key is present in the map, we can use the containsKey() method:
        System.out.println(productsByName.containsKey("E-Bike"));

        // Or, to check if a value is present in the map, we can use the containsValue() method:
        System.out.println(productsByName.containsValue(eBike));

        // We can iterate over the set of all keys:
        for (String key : productsByName.keySet()) {
            System.out.println(productsByName.get(key));
        }

//Additional Methods as of Java 8

        // The forEach method is the functional-style way to iterate over all elements in the map:
        productsByName.forEach((key, product) -> {
            System.out.println("Key: " + key + " Product:" + product.getDescription());
            //do something with the key and value
        });

        // Prior to Java 8:
        // Or we can iterate over the set of all entries:
        for (Map.Entry<String, Product> entry : productsByName.entrySet()) {
            System.out.println(entry.getValue() + " = " + entry.getKey());
        }

       // Using the getOrDefault() method, we can get a value from the map
        // or return a default element in case there is no mapping for the given key:
        Product chocolate = new Product("chocolate", "something sweet");
        Product defaultProduct1 = productsByName.getOrDefault("horse carriage", chocolate);
        Product bike = productsByName.getOrDefault("E-Bike", chocolate);

    //    Prior to Java 8:
        Product bike2 = productsByName.containsKey("E-Bike")
                ? productsByName.get("E-Bike")
                : chocolate;
        Product defaultProduct2 = productsByName.containsKey("horse carriage")
                ? productsByName.get("horse carriage")
                : chocolate;

     //   With this method, we can add a new mapping, but only if there is not yet a mapping for the given key:
        productsByName.putIfAbsent("E-Bike", chocolate);

       // Prior to Java 8:
        if(productsByName.containsKey("E-Bike")) {
            productsByName.put("E-Bike", chocolate);
        }

  //      And with merge(), we can modify the value for a given key if a mapping exists, or add a new value otherwise:
        Product eBike2 = new Product("E-Bike", "A bike with a battery");
        System.out.println(eBike2.getTags().add("sport"));
        productsByName.merge("E-Bike", eBike2, Product::addTagsOfOtherProdcut);

      //  Prior to Java 8:
        if(productsByName.containsKey("E-Bike")) {
            productsByName.get("E-Bike").addTagsOfOtherProdcut(eBike2);
        } else {
            productsByName.put("E-Bike", eBike2);
        }








    }
}
