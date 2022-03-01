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
            // starting from first position every time find approropriate position for key
            // on left side
            while (j >= 0 && key.compareTo(arr[j]) < 0) { // if key is less than previous value then shift that value to
                                                          // next [j+1] this way
                                                          // we will go till position which is appropriate for key on
                                                          // left side
                comp++;
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key; // place the key at position which was last time copied
        }
        System.out.println("Iterations: " + itr + ", Comparisions: " + comp);
        return arr;
    }
}