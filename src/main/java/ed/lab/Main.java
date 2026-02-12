package ed.lab;

import java.util.Random;

public class Main {
    private static final ArrayGenerator<String> sortedArrayGenerator = length -> {
        String[] array = new String[length];
        for (int i = 0; i < length; i++) {
            array[i] = String.format("%03d", i); // "000", "001", ...
        }
        return array;
    };

    private static final ArrayGenerator<String> invertedArrayGenerator = length -> {
        String[] array = new String[length];
        for (int i = 0; i < length; i++) {
            array[i] = String.format("%03d", length - 1 - i);
        }
        return array;
    };

    private static final ArrayGenerator<String> randomArrayGenerator = length -> {
        java.util.Random random = new java.util.Random();
        String[] array = new String[length];
        for (int i = 0; i < length; i++) {
            array[i] = String.format("%03d", random.nextInt(length));
        }
        return array;
    };


    private static final QuickSort<String> highPivotQuickSort =
            SortingAlgorithms::highPivotQuickSort;

    private static final QuickSort<String> lowPivotQuickSort =
            SortingAlgorithms::lowPivotQuickSort;

    private static final QuickSort<String> randomPivotQuickSort =
            SortingAlgorithms::randomPivotQuickSort;


    public static QuickSort<Integer> getHighPivotQuickSort() {
        return highPivotQuickSort;
    }

    public static QuickSort<Integer> getLowPivotQuickSort() {
        return lowPivotQuickSort;
    }

    public static QuickSort<Integer> getRandomPivotQuickSort() {
        return randomPivotQuickSort;
    }

    public static ArrayGenerator<Integer> getSortedArrayGenerator() {
        return sortedArrayGenerator;
    }

    public static ArrayGenerator<Integer> getInvertedArrayGenerator() {
        return invertedArrayGenerator;
    }

    public static ArrayGenerator<Integer> getRandomArrayGenerator() {
        return randomArrayGenerator;
    }

    public static void main(String[] args) {
        final SortingTester<Integer> tester = new SortingTester<>();

        System.out.println("Ordenando un arreglo ordenado:");
        System.out.println("\tUtilizando el último elemento como pivote: ");
        tester.testSorting(sortedArrayGenerator, highPivotQuickSort);
        System.out.println("\tUtilizando el primer elemento como pivote: ");
        tester.testSorting(sortedArrayGenerator, lowPivotQuickSort);
        System.out.println("\tUtilizando un elemento aleatorio como pivote: ");
        tester.testSorting(sortedArrayGenerator, randomPivotQuickSort);
        System.out.println("================================");

        System.out.println("Ordenando un arreglo invertido:");
        System.out.println("\tUtilizando el último elemento como pivote: ");
        tester.testSorting(invertedArrayGenerator, highPivotQuickSort);
        System.out.println("\tUtilizando el primer elemento como pivote: ");
        tester.testSorting(invertedArrayGenerator, lowPivotQuickSort);
        System.out.println("\tUtilizando un elemento aleatorio como pivote: ");
        tester.testSorting(invertedArrayGenerator, randomPivotQuickSort);
        System.out.println("================================");

        System.out.println("Ordenando un arreglo aleatorio:");
        System.out.println("\tUtilizando el último elemento como pivote: ");
        tester.testSorting(randomArrayGenerator, highPivotQuickSort);
        System.out.println("\tUtilizando el primer elemento como pivote: ");
        tester.testSorting(randomArrayGenerator, lowPivotQuickSort);
        System.out.println("\tUtilizando un elemento aleatorio como pivote: ");
        tester.testSorting(randomArrayGenerator, randomPivotQuickSort);
        System.out.println("================================");
    }
}