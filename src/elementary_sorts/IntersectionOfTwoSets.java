package elementary_sorts;

import java.util.Arrays;

/*
    Question 1
    Intersection of two sets. Given two arrays 𝚊[] and 𝚋[], each containing n distinct 2D points in the plane,
    design a subquadratic algorithm to count the number of points that are contained both in array 𝚊[] and array 𝚋[].
 */
public class IntersectionOfTwoSets {

    static class Point implements Comparable<Point>{
        private int x;
        private int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point other) {
            if( this.x > other.x ) return 1;
            if( this.x < other.x ) return -1;
            if( this.y > other.y ) return 1;
            if( this.y < other.y ) return -1;
            return 0;
        }
    }

    private static int countDuplicates(Point[] arr1, Point[] arr2){
        Arrays.sort(arr1); // N*Log(N)
        Arrays.sort(arr2); // N*Log(N)

        int i = 0;
        int j = 0;
        int result = 0;

        // N complexity
        while(i < arr1.length && j < arr2.length){
            if(arr1[i].compareTo(arr2[j]) == 0){
                i++; j++; result++;
            }else if(arr1[i].compareTo(arr2[j]) > 0){
                j++;
            }else{
                i++;
            }
        }
        return result;
    }

    //TODO Implement solution with binary search

    public static void main(String[] args) {
        Point p1 = new Point(1,2);
        Point p2 = new Point(10,4);
        Point p3 = new Point(3,4);
        Point p4 = new Point(5,4);
        Point p5 = new Point(-1,-2);
        Point p6 = new Point(1,7);

        Point[] arr1 = {p1, p2, p3, p4};
        Point[] arr2 = {p4, p5, p6, p1, p3};

        System.out.println("Number of Duplicates: " + countDuplicates(arr1, arr2));
    }
}
