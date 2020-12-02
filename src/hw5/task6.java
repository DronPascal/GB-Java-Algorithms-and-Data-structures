package hw5;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class task6 {
    public static void main(String[] args) {
        /*
        Задание 5.6
            На основе массива из задания 2.1 реализуйте алгоритм сортировки слиянием.
            Оцените алгоритм сортировки слиянием с помощью базового метода System.nanoTime() и сравните с сортировкой методом sort().
         */
        int[] arr = new int[10000];
        rndFill(arr, 300000);
        int[] arrCopy;
        int[] arrbuf = new int[10000];
        arrCopy = arr.clone();

        // MergeSort()
        System.out.println(Arrays.toString(arr));
        long start = System.nanoTime();
        arr = mergeSort(arr);
        long stop = System.nanoTime();
        long mergeSortTime = stop - start;
        System.out.println(Arrays.toString(arr));
        System.out.println("mergeSort() time: " + mergeSortTime + "ns");

        // Sort()
        System.out.println(Arrays.toString(arrCopy));
        start = System.nanoTime();
        Arrays.sort(arrCopy);
        stop = System.nanoTime();
        System.out.println(Arrays.toString(arrCopy));
        System.out.println("sort() time: " + (stop - start) + "ns");

        System.out.println("mergeSort " + ((stop - start)-mergeSortTime) + "ns faster then sort()");
    }

    static int[] mergeSort(int[] arr) {
        int[] buffer = new int[arr.length];
        return mergeSort(arr, buffer, 0, arr.length - 1);
    }

    static int[] mergeSort(int[] arr, int[] buffer, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return arr;
        }
        // Отсортирован
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergeSort(arr, buffer, startIndex, middle);
        int[] sorted2 = mergeSort(arr, buffer, middle, endIndex);

        // Слияние
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == arr ? buffer : arr;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }

    static void rndFill(int[] arr, int max) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++)
            arr[i] = random.nextInt(max);
    }
}
