package Sorting;
public class Selection<T extends Comparable<T>> implements ISort<T> {

    @Override
    public T[] sort(T[] arr) {
        int itr=0,comp=0;;
        for (int i = 0; i < arr.length-1; i++) {
            itr++;
            for(int pos = i+1;pos<arr.length;pos++){
                comp++;
                if(arr[i].compareTo(arr[pos])>0){
                    swap(arr, i, pos);
                }
            }
        }
        System.out.println("Iterations: "+itr+", Comparisions: "+comp);
        return arr;
    }
     private static <T> void swap(T[] arr,int j,int m){
        T x = arr[j];
        arr[j] = arr[m];
        arr[m] = x;
    }
}
