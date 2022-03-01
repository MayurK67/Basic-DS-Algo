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
        // logically divide arr into left and right from mth element
        int i = l;// index for arr1
        int j = m + 1;// index for arr2
        int k = l;// index for arr
        List<T> temp = new ArrayList<>(); //temporory array
        while (i <= m && j <= r) { //traverse both arrays and compare elements from both and 
                                    //place smallest (for ascnd ordr) of both in
                                     //new temporory array
            if (arr[i].compareTo(arr[j]) <= 0) { //left arr has smaller or equal elem
                temp.add(k, arr[i]); 
                i++;
                k++;
            } else {                         //right arr has larger smaller elem
                temp.add(k, arr[j]);
                j++;
                k++;
            }
        }

        while (i <= m) {       //when right array finished append left remaining arr as it is
            temp.add(k, arr[i]);
            i++;
            k++;
        }
        while (j <= r) { // else left array is finished hence append right arr as it is 
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
