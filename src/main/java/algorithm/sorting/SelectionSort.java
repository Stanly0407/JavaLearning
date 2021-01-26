package algorithm.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.swap;

public class SelectionSort {

    // имеет квадратичную сложность

    //Итак, идея простая. Каждый проход выбирать самый минимальный элемент и смещать его в начало.
    // При этом каждый новый проход начинать сдвигаясь вправо,
    // то есть первый проход — с первого элемента, второй проход — со второго.
    // Выглядеть это будет следующим образом:
    public static void main(String[] args) {

        List<Integer> elements = new ArrayList<>();
        elements.add(10);
        elements.add(-2);
        elements.add(55);
        elements.add(-52);
        elements.add(102);
        elements.add(0);

        for (int min = 0; min < elements.size() - 1; min++) {
            int minElement = min;
            for (int i = min + 1; i < elements.size(); i++) {
                if (elements.get(i) < elements.get(minElement)) {
                    minElement = i;
                }
            }
            int temporaryElement = elements.get(min);
            elements.set(min, elements.get(minElement));
            elements.set(minElement, temporaryElement);
        }
        for (Integer element : elements){
            System.out.println(element);
        }
    }
}
