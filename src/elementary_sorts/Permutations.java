package elementary_sorts;

import java.util.Arrays;

/*
    Question 2
    Permutation. Given two integer arrays of size n, design a subquadratic algorithm to determine whether one is
    a permutation of the other. That is, do they contain exactly the same entries but, possibly, in a different order.
 */
public class Permutations {

    public static boolean isPermutation(int[] arr1, int[] arr2){

        if(arr1.length != arr2.length) return false;

        Arrays.sort(arr1); // N*Log(N)
        Arrays.sort(arr2); // N*Log(N)

        // Complexity N
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] != arr2[i]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1,10,3,6,17};
        int[] arr2 = {17,10,3,1,6};

        System.out.println(isPermutation(arr1, arr2));

    }

}
