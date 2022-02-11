package Sorting;

public class Insertion<T extends Comparable<T>> implements ISort<T> {

    @Override
    public T[] sort(T[] arr) {
        T key;
        int itr = 0, comp = 0, j;
        for (int i = 1; i < arr.length; i++) {
            key = arr[i];
            itr++;
            j = i - 1;

            while (j >= 0 && key.compareTo(arr[j]) < 0) {
                comp++;
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        System.out.println("Iterations: " + itr + ", Comparisions: " + comp);
        return arr;
    }

}