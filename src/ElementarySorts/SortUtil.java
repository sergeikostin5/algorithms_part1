package ElementarySorts;

import java.util.Random;

/**
 * Created by sergei.kostin on 6/27/17.
 */
public class SortUtil {

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean isSorted(Comparable[] arr) {
        for(int i = 1; i < arr.length; i++){
            if(less(arr[i], arr[i-1])) return false;
        }
        return true;
    }

    public static Integer[] generateArray(int size, int limit){
        Random random = new Random();
        Integer[] array = new Integer[size];
        for(int i = 0; i < size; i++){
            array[i] = random.nextInt(limit);
        }
        return array;
    }

    public static void printArray(Comparable[] arr){

        System.out.print("|");

        for(int i = 0; i < arr.length; i++){
            System.out.printf(" %2d |", i);
        }

        System.out.println();
        System.out.print("-");

        for(int i = 0; i < arr.length; i++){
            System.out.print("-----");
        }

        System.out.println();
        System.out.print("|");

        for(int i = 0; i < arr.length; i++){
            System.out.printf(" %2d |", arr[i]);
        }

        System.out.println();
    }



}
