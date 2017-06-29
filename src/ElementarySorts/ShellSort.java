package ElementarySorts;

/**
 * Created by sergei.kostin on 6/28/17.
 */
public class ShellSort {

    public static void sort(Comparable[] arr){

        int inner, outer;
        Comparable temp;
        int interval = 1;

        // Calculate starting interval
        while(interval <= arr.length/3){
            interval = interval*3 + 1;
        }

        // Keep looping until the interval is 1
        // Then this becomes an insertion sort

        while (interval > 0){
            // Continue incrementing outer until the end of array is reached

            for(outer = interval; outer < arr.length; outer++){

                // Store the value of the array in temp unless it has to be copied to a space occupied
                // by a bigger number closer to the begining of the array

                temp = arr[outer];
                System.out.println("Copy " + arr[outer] + " into temp");

                // inner is assigned the value of the highest index to check against all values
                // the proceed it. Along the way if a number is greater than temp it will be moved up in
                // the array

                inner = outer;

                System.out.println("Checking is " + arr[inner - interval] + " in index " + (inner - interval) +
                    " is bigger than " + temp);

                // while there is number bigger than temp move it further up in the array
                while (inner > (interval - 1) && SortUtil.less(temp, arr[inner - interval])) {

                    System.out.println("In While Checking if " + arr[inner - interval] + " in index "
                            + (inner - interval) + " is bigger than " + temp);

                    SortUtil.printArray(arr);

                    // Make room for the smaller temp by moving values in the array
                    // up one space if they are greater than temp
                    arr[inner] = arr[inner - interval];


                    System.out.println(arr[inner - interval] + " moved to index " + inner);
                    inner -= interval;
                    System.out.println("inner= " + inner);
                    SortUtil.printArray(arr);
                    System.out.println("outer= " + outer);
                    System.out.println("temp= " + temp);
                    System.out.println("interval= " + interval);

                }

                // Now that everything has been moved into place put the value stored in temp into the index above
                // the first value smaller than it is
                arr[inner] = temp;
                System.out.println(temp + " moved to index " + inner);
                SortUtil.printArray(arr);
            }

            // Once we get here we have interval sorted our array so we decrement interval and go again
            interval = (interval - 1) / 3;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = SortUtil.generateArray(9, 10);
        SortUtil.printArray(arr);
        sort(arr);
        SortUtil.printArray(arr);
    }

}
