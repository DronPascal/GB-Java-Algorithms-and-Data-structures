package hw5;

import java.util.Arrays;
import java.util.Random;

public class task5 {
    /*
    Задание 5.5
        Реализуйте алгоритм двоичного рекурсивного поиска на основе массива из задания 2.1.
        Оцените алгоритм двоичного рекурсивного поиска с помощью базового метода System.nanoTime() и сравните с обычным двоичным поиском.
     */
    public static void main(String[] args) {
        int[] arr = new int[20000];
        rndFill(arr, 1000000);
        Arrays.sort(arr);

        int randomIndex = (int) (Math.random() * arr.length);
        long start = System.nanoTime();
        binarySearch(arr, arr[randomIndex]);
        long stop = System.nanoTime();
        System.out.println("binarySearch time: " + (stop - start) + "ns");

        start = System.nanoTime();
        recursiveBinarySearch(arr, arr[randomIndex]);
        stop = System.nanoTime();
        System.out.println("recursiveBinarySearch time: " + (stop - start) + "ns");
    }

    static int binarySearch(int[] arr, int searchingElement) {
        int first = 0;
        int last = arr.length - 1;
        while (first <= last) {
            int middle = (first + last) / 2;
            if (arr[middle] == searchingElement) return middle;
            else if (arr[middle] < searchingElement)
                first = middle + 1;
            else
                last = middle - 1;
        }
        return -1;
    }

    public static int recursiveBinarySearch(int arr[], int searchingElement) {
        return recursiveBinarySearch(arr, searchingElement, 0, arr.length - 1);
    }

    public static int recursiveBinarySearch(int arr[], int searchingElement, int firstIndex, int lastIndex) {
        if (lastIndex >= firstIndex) {
            int middle = firstIndex + (lastIndex - firstIndex) / 2;
            if (arr[middle] == searchingElement) {
                return middle;
            }
            if (arr[middle] > searchingElement) {
                return recursiveBinarySearch(arr, searchingElement, firstIndex, middle - 1);
            }
            return recursiveBinarySearch(arr, searchingElement, middle + 1, lastIndex);
        }
        return -1;
    }

    static void rndFill(int[] arr, int max) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++)
            arr[i] = random.nextInt(max);
    }
}
