package collections;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;
import java.util.stream.Collectors;

public class StackExample {

    public static void main(String[] args) {

        Stack<Integer> intStack = new Stack<>();
        System.out.println(intStack.size());
        System.out.println(intStack.capacity());

        intStack.push(1);
        intStack.addElement(2323);

        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 89);
        boolean result = intStack.addAll(intList);
        System.out.println(result);

        System.out.println(intStack.size());
        System.out.println(intStack.capacity()); //удваивается стек

        Integer element = intStack.pop(); // получить и удалить последний элемент
        System.out.println(element);

        Integer element2 = intStack.pop(); //  последний элемент удален
        System.out.println(element2);

        Integer element3 = intStack.peek(); // получить последний элемент, не удаляя
        System.out.println(element3);
        Integer element4 = intStack.peek();  //  последний элемент не удален
        System.out.println(element4);

        System.out.println(intStack.search(5)); // расстояние элемента от вершины стека
        // ищем элемент "5", поиск начинается с конца ("с верху стека") и первая позиция не 0, а 1!!!
        // Т.к. два элемента с конца удалили, индекс "5"  = 2.
        // Если объект не найден, search () вернет -1.
        // Здесь индекс в смысле расположения элемента сверху стека

        // если необходим просто индекс, но поиск не с вершины стека
        int indexOf = intStack.indexOf(1);
        System.out.println(indexOf); //т.е. индекс = 0

        // lastIndexOf() найти индекс элемента, который ближе всего к вершине стека, т.е. поиска с конца
        int lastIndexOf = intStack.lastIndexOf(1);
        System.out.println(lastIndexOf);

// Удаление элементов из стека. Помимо операции pop() есть несколько операций, унаследованных от класса Vector, для удаления элементов.
        // для удаления первого вхождения данного элемента (не с вершины)
        intStack.removeElement(5);
        System.out.println(intStack.search(5)); // -1  = элемент удален
        // для удаления элементов по указанному индексу в стеке:
        intStack.removeElementAt(6); // последний элемент 6 с индексом 6, элемент "5" удален по индексу
        Integer element5 = intStack.peek();
        System.out.println(element5); //4

        // удалить все элементы из стека
       // intStack.clear(); //b or
        intStack.removeAllElements();
        System.out.println(intStack.isEmpty()); // стек пуст

        // Удаление элементов с помощью фильтра
        //  условие для удаления элементов из стека
        List<Integer> intList2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        intStack.addAll(intList2);
        System.out.println(intStack.size());
        intStack.removeIf(element7 -> element7 < 6); // удалит первые 5 элементов
        System.out.println(intStack.size()); // останется 2 последних
        Integer element8 = intStack.peek();
        System.out.println(element8); // 7

        intStack.clear();
        List<Integer> intList3 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        intStack.addAll(intList3);
        // Итерации по стеку
        System.out.println("Итерации по стеку");
        ListIterator<Integer> it = intStack.listIterator();

        Stack<Integer> resultt = new Stack<>();
        while(it.hasNext()) {
            resultt.push(it.next());
            Integer el= resultt.peek();
            System.out.println(el);
        } // т.е. здесь перезаписываем элементы из одного стека в другой и при этом выводим то, что перезаписываем в новый стек


        //Stream API для стека
        Stack<Integer> intStack2 = new Stack<>();
        List<Integer> inputIntList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 9, 10);
        intStack2.addAll(inputIntList);
        List<Integer> filtered = intStack
                .stream()
                .filter(element11 -> element11 <= 3)
                .collect(Collectors.toList());
        System.out.println(filtered); // 1, 2, 3



}
}
