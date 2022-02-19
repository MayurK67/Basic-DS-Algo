package Sorting;

public class Main {
    public static void main(String[] args) throws Exception {
        Bubble<Integer> bubble = new Bubble<Integer>();
        MergeSort<Integer> mergeSort = new MergeSort<>();
        // Selection<Integer> selection = new Selection<>();
        // Insertion<Integer> insertion = new Insertion<>();
        Integer[] arr = { 10, 90, 30, 15, 60, 80, 45 };

        Integer[] arr2 = mergeSort.sort(arr);
        // Integer[] arr2 = Bubble.sortModified(arr);
        // Integer[] arr2 = selection.sort(arr);
        for (Integer integer : arr2) {

            System.out.print(integer);

            System.out.print(", ");
        }

    }
}
