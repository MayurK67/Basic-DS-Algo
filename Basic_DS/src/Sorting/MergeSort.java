package Sorting;

import java.util.ArrayList;

import java.util.List;

public class MergeSort<T extends Comparable<T>> implements ISort<T> {

    @Override
    public T[] sort(T[] arr) {
        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void mergeSort(T[] arr, int l, int r) {

        if (l < r)
            {
        int m = (l + r) / 2;

        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);

        merge(arr, l, m, r);
            }
    }

    private void merge(T[] arr, int l, int m, int r) {

        int i = l;// index for arr1
        int j = m + 1;// index for arr2
        int k = l;// index for arr
        List<T> temp = new ArrayList<>();
        while (i <= m && j <= r) {
            if (arr[i].compareTo(arr[j]) <= 0) {
                temp.add(k, arr[i]);
                i++;
                k++;
            } else {
                temp.add(k, arr[j]);
                j++;
                k++;
            }
        }

        while (i <= m) {
            temp.add(k, arr[i]);
            i++;
            k++;
        }
        while (j <= r) {
            temp.add(k, arr[j]);
            j++;
            k++;
        }

        // now replace values of arr with temp
        int z = l;
        for (T t : temp) {
            arr[z] = t;
            z++;
        }

    }

}
