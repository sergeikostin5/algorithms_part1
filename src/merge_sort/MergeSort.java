package merge_sort;

import elementary_sorts.SortUtil;

/**
 * Created by sergei.kostin on 6/28/17.
 */
public class MergeSort {

    public static void main(String[] args) {
        Integer[] arr = {10,4,3,1,8,7,9,5};
        sort(arr);
        SortUtil.printArray(arr);
        System.out.println(SortUtil.isSorted(arr));

    }

    private static void  merge(Comparable[] arr, Comparable[] aux, int lo, int mid, int hi){

        int j = mid + 1;

        for(int k = 0; k <= hi; k++){
            aux[k] = arr[k];
        }

        for(int k = lo; k <= hi; k++){
            if(lo > mid) arr[k] = aux[j++];
            else if(j > hi) arr[k] = aux[lo++];
            else if(SortUtil.less(aux[j], aux[lo])) arr[k] = aux[j++];
            else arr[k] = aux[lo++];
        }
    }

    public static void sort(Comparable[] arr){
        Comparable[] aux = new Comparable[arr.length];
        sort(arr, aux, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, Comparable[] aux, int lo, int hi){
        if(hi <= lo) return;
        int mid = lo + (hi -lo) / 2;
        sort(arr, aux, lo, mid);
        sort(arr,aux,mid+1,hi);
        merge(arr, aux, lo, mid, hi);
    }

}
