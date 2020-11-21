package hw2;

import java.util.Arrays;
import java.util.Random;

public class hw2 {
    public static void main(String[] args) {
        /*
        Задание 2.1
            На основе программного кода из домашнего задания №1 реализуйте массив на основе существующих примитивных или ссылочных типов данных.
            Выполните обращение к массиву и базовые операции класса Arrays.
            Оценить выполненные методы с помощью базового класса System.nanoTime().
         */
        int[] arr = new int[20];
        int[] arrCopy;
        int[] arrSort;
        rndFill(arr, 200);

        long start = System.nanoTime();
        arrCopy = Arrays.copyOf(arr, arr.length);
        System.out.println("1) Copy: " + (System.nanoTime() - start));

        start = System.nanoTime();
        Arrays.toString(arr);
        System.out.println("toString: " + (System.nanoTime() - start));

        start = System.nanoTime();
        Arrays.toString(arrCopy);
        System.out.println("toString: " + (System.nanoTime() - start));

        start = System.nanoTime();
        Arrays.equals(arr, arrCopy);
        System.out.println("Equals: " + (System.nanoTime() - start));

        arrSort = Arrays.copyOf(arr, arr.length);
        start = System.nanoTime();
        Arrays.sort(arrSort);
        System.out.println("Sort: " + (System.nanoTime() - start) + "\n");

        /*
        Задание 2.2
            На основе написанного кода в задании 2.1 реализуйте линейный и двоичный поиск.
            Оценить алгоритмы линейного и двоичного поиска с помощью базового класса System.nanoTime(), при необходимости расширьте уже существующий массив данных.
         */
        int searching = arrSort[new Random().nextInt(20)];
        System.out.println("2) Searching " + searching + " in " + Arrays.toString(arrSort));

        start = System.nanoTime();
        linearSearch(arrSort, searching);
        System.out.println("Linear search: " + (System.nanoTime() - start));

        start = System.nanoTime();
        booleanSearch(arrSort, searching);
        System.out.println("Boolean search: " + (System.nanoTime() - start) + "\n");

        /*
        Задание 2.3
            Создайте массив размером 400 элементов.
            Выполните сортировку с помощью метода sort().
            Оцените сортировку с помощью базового класса System.nanoTime().
         */
        int[] t3arr = new int[400];
        rndFill(t3arr, 2000);
        int[] t3arrCopy = Arrays.copyOf(t3arr, t3arr.length);
        start = System.nanoTime();
        Arrays.sort(t3arrCopy);
        System.out.println("3) Arrays.sort: " + (System.nanoTime() - start) + "\n");

        /*
        Задание 2.4
            На основе существующего массива данных из задания 2.3 реализуйте алгоритм сортировки пузырьком.
            Оцените сортировку с помощью базового класса System.nanoTime().
            Сравните время выполнения алгоритмы сортировки методом sort() из задания 2.1 и сортировку пузырьком.
         */
        t3arrCopy = Arrays.copyOf(t3arr, t3arr.length);
        start = System.nanoTime();
        bubbleSort(t3arrCopy);
        System.out.println("4) Bubble sort: " + (System.nanoTime() - start) + "\n");

        /*
        Задание 2.5
            На основе массива данных из задания 2.3 реализуйте алгоритм сортировки методом выбора.
            Оцените сортировку с помощью базового класса System.nanoTime().
            Сравните с временем выполнения алгоритмов сортировки из прошлых заданий 2.3 и 2.4.
         */
        t3arrCopy = Arrays.copyOf(t3arr, t3arr.length);
        start = System.nanoTime();
        selectionSort(t3arrCopy);
        System.out.println("5) Selection sort: " + (System.nanoTime() - start) + "\n");

        /*
        Задание 2.6
            На основе массива данных из задания 2.3 реализуйте алгоритм сортировки методом вставки.
            Оцените сортировку с помощью базового класса System.nanoTime().
            Сравните с временем выполнения алгоритмов сортировки из прошлых заданий 2.3, 2.4 и 2.5.
         */
        t3arrCopy = Arrays.copyOf(t3arr, t3arr.length);
        start = System.nanoTime();
        insertionSort(t3arrCopy);
        System.out.println("6) Insertion sort: " + (System.nanoTime() - start) + "\n");
    }

    static int linearSearch(int[] arr, int a) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == a) return i;
        return -1;
    }

    static int booleanSearch(int[] arr, int a) {
        int first = 0;
        int last = arr.length - 1;
        while (first <= last) {
            int middle = (first + last) / 2;
            if (arr[middle] == a) return middle;
            else if (arr[middle] < a)
                first = middle + 1;
            else
                last = middle - 1;
        }
        return -1;
    }

    static void bubbleSort(int[] arr) {
        int len = arr.length;
        for (int i = 1; i < len - 1; i++)
            for (int j = 0; j < len - i; j++)
                if (arr[j] > arr[j + 1]) {
                    int buf = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = buf;
                }
    }

    static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int pos = i;
            int min = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    pos = j;
                    min = array[j];
                }
            }
            array[pos] = array[i];
            array[i] = min;
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > value) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = value;
        }
    }

    static void rndFill(int[] arr, int max) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++)
            arr[i] = random.nextInt(max);
    }
}
