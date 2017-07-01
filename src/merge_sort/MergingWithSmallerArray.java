package merge_sort;

import elementary_sorts.SortUtil;

/*
    Merging with smaller auxiliary array. Suppose that the subarray 𝚊[𝟶] to 𝚊[𝚗−𝟷] is sorted and the subarray 𝚊[𝚗]
    to 𝚊[𝟸∗𝚗−𝟷] is sorted. How can you merge the two subarrays so that 𝚊[𝟶] to 𝚊[𝟸∗𝚗−𝟷] is sorted using an auxiliary
    array of length n (instead of 2n)?
 */
public class MergingWithSmallerArray {

    public static void merge(Comparable[] arr, Comparable[] aux, int lo, int mid, int hi){
        int i= lo; // first element of original subarray
        int k = lo; // first element of aux array
        int j = mid + 1; //fist element of second subarray

        for(int n = 0; n < aux.length; n++){
            aux[n] = arr[n];
        }

        while(j < arr.length ){
            if(SortUtil.less(arr[j], aux[k])){
                arr[i] = arr[j];
                i++; j++;
            }else{
                arr[i] = aux[k];
                i++; k++;
            }
        }

        while( k < aux.length){
            arr[i]= aux[k];
            i++; k++;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {10,32,55, 60, 1, 9,17, 18,28};
        int length = arr.length;
        merge(arr, new Integer[length/2], 0, length/2 -1, length-1);
        SortUtil.printArray(arr);
        System.out.println(SortUtil.isSorted(arr));
    }

}
