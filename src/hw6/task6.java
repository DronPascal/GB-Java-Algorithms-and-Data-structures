package hw6;

import java.util.Arrays;
import java.util.Random;

public class task6 {
    /*
    Задание 6.6
        Реализуйте на основе массива из задания 2.1 алгоритм пирамидальной сортировки с реализацией бинарной пирамиды.
        Выполните оценку алгоритма пирамидальной сортировки с помощью System.nanoTime() и сравните с предыдущими алгоритмами сортировки.
     */
    public static void main(String[] args) {
        int[] arr;
        Random rand = new Random();
        arr = new int[1000];
        for (int i=0; i<arr.length; i++ ){
            arr[i] = rand.nextInt( 10000);
        }

        System. out.println(Arrays.toString(arr) );

        HeapSort heapSort = new HeapSort();
        long start = System.nanoTime();
        heapSort.sort(arr);
        long stop = System.nanoTime();
        System.out.println("\nheapSort.sort(arr) done in "+ (stop-start)+ "ns\n");

        System. out.println (Arrays. toString(arr));
    }
}

class HeapSort {
    private static int heapSize;

    public static void sort(int[] a) {
        buildHeap(a);
        while (heapSize > 1) {
            swap(a, 0, heapSize - 1);
            heapSize--;
            heapify(a, 0);
        }
    }

    private static void buildHeap(int[] a) {
        heapSize = a.length;
        for (int i = a.length / 2; i >= 0; i--) {
            heapify(a, i);
        }
    }

    private static void heapify(int[] a, int i) {
        int l = left(i);
        int r = right(i);
        int largest = i;

        if (l < heapSize && a[i] < a[l]) {
            largest = l;
        }
        if (r < heapSize && a[largest] < a[r]) {
            largest = r;
        }
        if (i != largest) {
            swap(a, i, largest);
            heapify(a, largest);
        }
    }

    private static int right(int i) {
        return 2 * i + 2;
    }

    private static int left(int i) {
        return 2 * i + 1;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

