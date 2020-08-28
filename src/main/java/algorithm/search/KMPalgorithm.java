package algorithm.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KMPalgorithm {

    // Алгоритм Кнута – Морриса – Пратта
    // Алгоритм КМП осуществляет поиск текста по заданному шаблону.
    // В этом поиске сначала компилируется заданный шаблон. Компилируя шаблон, мы пытаемся найти префикс и суффикс строки шаблона.
    // Это поможет в случае несоответствия – не придётся искать следующее совпадение с начального индекса.
    // Вместо этого мы пропускаем часть текстовой строки, которую уже сравнили, и начинаем сравнивать следующую.
    // Необходимая часть определяется по префиксу и суффиксу, поэтому известно, какая часть уже прошла проверку и может быть безопасно пропущена.

    // КМП работает быстрее алгоритма перебора благодаря пропускам.

 // Итак, пишем метод compilePatternArray(), который позже будет использоваться алгоритмом поиска КМП:

    public int[] compilePatternArray(String pattern) {
        int patternLength = pattern.length();
        int len = 0;
        int i = 1;
        int[] compliedPatternArray = new int[patternLength];
        compliedPatternArray[0] = 0;

        while (i < patternLength) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                compliedPatternArray[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = compliedPatternArray[len - 1];
                } else {
                    compliedPatternArray[i] = len;
                    i++;
                }
            }
        }
        System.out.println("Compiled Pattern Array " + Arrays.toString(compliedPatternArray));
        return compliedPatternArray;
    }

// Скомпилированный массив Java можно рассматривать как массив, хранящий шаблон символов.
// Цель – найти префикс и суффикс в шаблоне. Зная эти элементы, можно избежать сравнения
// с начала текста после несоответствия и приступать к сравнению следующего символа.

// Скомпилированный массив сохраняет позицию предыдущего местонахождения текущего символа в массив шаблонов.

// реализуем сам алгоритм:

    public List<Integer> performKMPSearch(String text, String pattern) {
        int[] compliedPatternArray = compilePatternArray(pattern);

        int textIndex = 0;
        int patternIndex = 0;

        List<Integer> foundIndexes = new ArrayList<>();

        while (textIndex < text.length()) {
            if (pattern.charAt(patternIndex) == text.charAt(textIndex)) {
                patternIndex++;
                textIndex++;
            }
            if (patternIndex == pattern.length()) {
                foundIndexes.add(textIndex - patternIndex);
                patternIndex = compliedPatternArray[patternIndex - 1];
            }

            else if (textIndex < text.length() && pattern.charAt(patternIndex) != text.charAt(textIndex)) {
                if (patternIndex != 0)
                    patternIndex = compliedPatternArray[patternIndex - 1];
                else
                    textIndex = textIndex + 1;
            }
        }
        return foundIndexes;
    }

// Здесь мы последовательно сравниваем символы в шаблоне и текстовом массиве.
// Мы продолжаем двигаться вперёд, пока не получим совпадение.
// Достижение конца массива при сопоставлении означает нахождение шаблона в тексте.

// Но! Есть один момент.
// Если обнаружено несоответствие при сравнении двух массивов, индекс символьного массива
// перемещается в значение compiledPatternArray(). Затем мы переходим к следующему символу в текстовом массиве.
// КМП превосходит метод грубой силы однократным сравнением текстовых символов при несоответствии.

    public static void main(String[] args) {

        KMPalgorithm kmPalgorithm = new KMPalgorithm();

        String pattern = "AAABAAA";
        String text = "ASBNSAAAAAABAAAAABAAAAAGAHUHDJKDDKSHAAJF";

        List<Integer> foundIndexes = kmPalgorithm.performKMPSearch(text, pattern);

        if (foundIndexes.isEmpty()) {
            System.out.println("Pattern not found in the given text String");
        } else {
            System.out.println("Pattern found in the given text String at positions: " +
                    foundIndexes.stream().map(Object::toString).collect(Collectors.joining(", ")));
        }
    }
// В текстовом шаблоне AAABAAA наблюдается и кодируется в массив шаблонов следующий шаблон:
// Шаблон A (Одиночная A) повторяется в 1 и 4 индексах.
// Паттерн AA (Двойная A) повторяется во 2 и 5 индексах.
// Шаблон AAA (Тройная A) повторяется в индексе 6.


    // Описанный выше шаблон ясно показан в скомпилированном массиве.
    // С помощью этого массива КМП ищет заданный шаблон в тексте, не возвращаясь в начало текстового массива.

    // Временная сложность
    // Для поиска шаблона алгоритму нужно сравнить все элементы в заданном тексте.
    // Необходимое для этого время составляет O(N).
    // Для составления строки шаблона нам нужно проверить каждый символ в шаблоне – это еще одна итерация O(M).
    // O (M + N) – общее время алгоритма.

    // Пространственная сложность
    // O(M) пространства необходимо для хранения скомпилированного шаблона для заданного шаблона размера M.

    // Применение
    // Этот алгоритм используется в текстовых инструментах для поиска шаблонов в текстовых файлах.



}
