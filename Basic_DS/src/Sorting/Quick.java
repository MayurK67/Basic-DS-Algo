package Sorting;

public class Quick<T extends Comparable<T>> implements ISort<T> {

    @Override
    public T[] sort(T[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return null;
    }

    private void quickSort(T[] arr, int left, int right) {
        if (left < right) {
            T pivot = arr[left];
            int i = left;
            int j = right;
            while (i < j) {
                while (i <= right && arr[i].compareTo(pivot) < 0) {
                    i++;
                }
                while (arr[j].compareTo(pivot) > 0) {
                    j--;
                }
                if (i < j)
                    swapArrayElements(arr, i, j);
            }
            swapArrayElements(arr, j, left);

            quickSort(arr, left, j - 1);
            quickSort(arr, j + 1, right);

        }
    }

    private void swapArrayElements(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
