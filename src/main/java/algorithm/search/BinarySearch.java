package algorithm.search;

public class BinarySearch {

    // Двоичный поиск
    // Двоичный или логарифмический поиск часто используется из-за быстрого времени поиска.

    // Объяснение
    // Этот вид поиска использует подход «Разделяй и властвуй», требует ПРЕДВАРИТЕЛЬНОЙ СОРТИРОВКИ набора данных.
    // Алгоритм делит входную коллекцию на равные половины, и с каждой итерацией сравнивает целевой элемент с элементом в середине.
    // Поиск заканчивается при нахождении элемента. Иначе продолжаем искать элемент, разделяя и выбирая соответствующий раздел массива.
    // Целевой элемент сравнивается со средним. Вот почему важно иметь отсортированную коллекцию при использовании двоичного поиска.
    // Поиск заканчивается, когда firstIndex (указатель) достигает lastIndex (последнего элемента). Значит мы проверили весь массив Java и не нашли элемента.

    // Есть два способа реализации этого алгоритма: итеративный и рекурсивный.

    // Временная и пространственная сложности одинаковы для обоих способов в реализации на Java.

    // 1. Итеративный подход

    public int binarySearch(int arr[], int elementToSearch) {

        int firstIndex = 0;
        int lastIndex = arr.length - 1;

        // условие прекращения (элемент не представлен)
        while(firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2; // делим на два
            // если средний элемент - целевой элемент, вернуть его индекс
            if (arr[middleIndex] == elementToSearch) {
                return middleIndex;
            }

            // если средний элемент меньше
            // направляем наш индекс в middle+1, убирая первую часть из рассмотрения
            else if (arr[middleIndex] < elementToSearch)
                firstIndex = middleIndex + 1;

                // если средний элемент больше
                // направляем наш индекс в middle-1, убирая вторую часть из рассмотрения
            else if (arr[middleIndex] > elementToSearch)
                lastIndex = middleIndex - 1;

        }
        return -1;
    }

    // Рекурсивный подход
    // Рекурсивный подход отличается вызовом самого метода при получении нового раздела.
    // В итеративном подходе всякий раз, когда мы определяли новый раздел, мы изменяли первый и последний элементы, повторяя процесс в том же цикле.

    // Другое отличие – рекурсивные вызовы помещаются в стек и занимают одну единицу пространства за вызов.

    public int recursiveBinarySearch(int arr[], int firstElement, int lastElement, int elementToSearch) {

        // условие прекращения
        if (lastElement >= firstElement) {
            int mid = firstElement + (lastElement - firstElement) / 2;

            // если средний элемент - целевой элемент, вернуть его индекс
            if (arr[mid] == elementToSearch){
                return mid;}

            // если средний элемент больше целевого
            // вызываем метод рекурсивно по суженным данным
            if (arr[mid] > elementToSearch){
                return recursiveBinarySearch(arr, firstElement, mid - 1, elementToSearch);}

            // также, вызываем метод рекурсивно по суженным данным
            return recursiveBinarySearch(arr, mid + 1, lastElement, elementToSearch);
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

        BinarySearch binary = new BinarySearch();

        int index = binary.binarySearch(new int[]{89, 57, 91, 47, 95, 3, 27, 22, 67, 99, 56}, 67); // проблема если нечное количество элементов массиве
        binary.print(67, index);

        int index2 = binary.recursiveBinarySearch(new int[]{3, 22, 27, 47, 57, 67, 89, 91, 95, 99}, 0, 10, 67);
        binary.print(67, index2);

    }

// Временная сложность
// Временная сложность алгоритма двоичного поиска равна O(log (N)) из-за деления массива пополам. Она превосходит O(N) линейного алгоритма.

// Пространственная сложность
// Одна единица пространства требуется для хранения искомого элемента. Следовательно, пространственная сложность равна O(1).
// Рекурсивный двоичный поиск хранит вызов метода в стеке. В худшем случае пространственная сложность потребует O(log (N)).

// Применение
// Этот алгоритм используется в большинстве библиотек и используется с отсортированными структурами данных.

//Двоичный поиск реализован в методе Arrays.binarySearch Java API.

}
