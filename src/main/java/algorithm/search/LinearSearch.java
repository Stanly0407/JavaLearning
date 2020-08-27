package algorithm.search;

public class LinearSearch {

    // Линейный поиск
    // Линейный или последовательный поиск – простейший алгоритм поиска. Он редко используется из-за своей неэффективности.
    // По сути, это метод полного перебора, и он уступает другим алгоритмам.
    // У линейного поиска нет предварительных условий к состоянию структуры данных.

    // Алгоритм ищет элемент в заданной структуре данных, пока не достигнет конца структуры.
    // При нахождении элемента возвращается его позиция в структуре данных. Если элемент не найден, возвращаем -1.


    //!!!
    public int linearSearch ( int arr[], int elementToSearch){
        for (int index = 0; index < arr.length; index++) {      // arr - это длина lol
            if (arr[index] == elementToSearch)
                return index;
        }
        return -1;
    }

    public void print(int elementToSearch, int index){
        if (index == -1) {
            System.out.println(elementToSearch + " not found.");
        } else {
            System.out.println(elementToSearch + " found at index: " + index);
        }
    }


    public static void main(String[] args) {
        LinearSearch linear = new LinearSearch();

        int lol = linear.linearSearch(new int[]{89, 57, 91, 47, 95, 3, 27, 22, 67, 99}, 67);

        linear.print(67, lol);
    }


}
