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
            while (i < j) {// till i==j find elements larger than pivot and swap them with elements smaller than pivot 
                while (i <= right && arr[i].compareTo(pivot) < 0) { //traverse till element larger than pivot is found
                    i++;
                }
                while (arr[j].compareTo(pivot) > 0) { //traverse backward till elem smaller than pivot found
                    j--;
                }
                if (i < j) // insure that i and j are not crossed 
                    swapArrayElements(arr, i, j); //swap ith larger and jth smaller elems 
            }
            swapArrayElements(arr, j, left); //at last swap jth elem with pivot
            //now elements from left are smaller than jth and right are larger than jth

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
