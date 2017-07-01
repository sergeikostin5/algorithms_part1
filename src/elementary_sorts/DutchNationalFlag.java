package elementary_sorts;

/*
    Question 3
    Dutch national flag. Given an array of n buckets, each containing a red, white,
    or blue pebble, sort them by color. The allowed operations are:
    - swap(i,j): swap the pebble in bucket i with the pebble in bucket j.
    - color(i): color of pebble in bucket i.

    The performance requirements are as follows:
    - At most n calls to color().
    - At most n calls to swap().
    - Constant extra space.
 */

import java.util.Arrays;

public class DutchNationalFlag {

    enum Color{
        RED, WHITE, BLUE;
    }

    static class Bucket {

        private Color color;

        Bucket(Color color){
            this.color = color;
        }

        public Color getColor() {
            return color;
        }

        @Override
        public String toString() {
            return color.toString();
        }
    }

    public static void swap(Bucket[] buckets, int i, int j){
        Bucket temp = buckets[i];
        buckets[i] = buckets[j];
        buckets[j] = temp;
    }

    public static void sort(Bucket[] buckets){
        int i=0; int j = 0; int k = buckets.length - 1;
        while( j <= k){
            if(buckets[j].getColor() == Color.RED ){
                  swap(buckets, i, j);
                  j++; i++;
            } else if (buckets[j].getColor() == Color.WHITE){
                j++;
            } else {
                swap(buckets, j, k);
                k--;
            }
        }
    }


    public static void main(String[] args) {

        Bucket[] buckets = new Bucket[9];
        Bucket b1 = new Bucket(Color.WHITE);
        Bucket b2 = new Bucket(Color.BLUE);
        Bucket b3 = new Bucket(Color.WHITE);
        Bucket b4 = new Bucket(Color.RED);
        Bucket b5 = new Bucket(Color.RED);
        Bucket b6 = new Bucket(Color.BLUE);
        Bucket b7 = new Bucket(Color.RED);
        Bucket b8 = new Bucket(Color.WHITE);
        Bucket b9 = new Bucket(Color.WHITE);
        buckets[0] = b1;
        buckets[1] = b2;
        buckets[2] = b3;
        buckets[3] = b4;
        buckets[4] = b5;
        buckets[5] = b6;
        buckets[6] = b7;
        buckets[7] = b8;
        buckets[8] = b9;

        sort(buckets);
        System.out.println(Arrays.toString(buckets));
    }


}
