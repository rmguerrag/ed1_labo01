package ed.lab;

import java.util.Random;

public class SortingAlgorithms {


    public static <T extends Comparable<T>> void highPivotQuickSort(T[] array) {
        quickSort(array, 0, array.length - 1, 0);
    }


    public static <T extends Comparable<T>> void lowPivotQuickSort(T[] array) {
        quickSort(array, 0, array.length - 1, 1);
    }


    public static <T extends Comparable<T>> void randomPivotQuickSort(T[] array) {
        quickSort(array, 0, array.length - 1, 2);
    }


    private static <T extends Comparable<T>> void quickSort(T[] arr, int low, int high, int type) {
        if (low < high) {
            int pi = partition(arr, low, high, type);
            quickSort(arr, low, pi - 1, type);
            quickSort(arr, pi + 1, high, type);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] arr, int low, int high, int type) {
        Random rand = new Random();

        if (type == 1) {
            swap(arr, low, high);
        } else if (type == 2) {
            swap(arr, rand.nextInt(high - low + 1) + low, high);
        }

        T pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                swap(arr, ++i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
