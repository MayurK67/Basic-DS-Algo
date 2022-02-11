package Sorting;

public class Bubble<T extends Comparable<T>> implements ISort<T> {
    @Override
    public T[] sort(T[] arr) {
        int itr = 0;
        int comp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            itr++;
            for (int j = 0; j < arr.length - i - 1; j++) {
                comp++;
                int check = arr[j].compareTo(arr[j + 1]);
                if (check > 0) {
                    swap(arr, j, j + 1);
                }
            }

        }

        System.out.println("Iterations: " + itr + ", Comparisions: " + comp);

        return arr;
    }

    private static <T> void swap(T[] arr, int j, int m) {
        T x = arr[j];
        arr[j] = arr[m];
        arr[m] = x;
    }

    public static <T extends Comparable<T>> T[] sortModified(T[] arr) {
        boolean flag = true;
        int itr = 0;
        int comp = 0;
        for (int i = 0; i < arr.length - 1 && flag; i++) {
            itr++;
            flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                comp++;
                int check = arr[j].compareTo(arr[j + 1]);
                if (check > 0) {
                    flag = true;
                    swap(arr, j, j + 1);
                }
            }

        }
        System.out.println("Iterations: " + itr + ", Comparisions: " + comp);

        return arr;
    }

}
