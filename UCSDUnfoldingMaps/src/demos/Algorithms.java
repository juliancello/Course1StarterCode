package demos;

import processing.core.PApplet;

import java.util.List;
import java.util.Arrays;

public class Algorithms{
    public void mySelectionSort() {
        // Instructions: implement selection sort algorithm

        // Have array
        List<Integer> arrayToSort = Arrays.asList(5, 0, 1, 10, 2, 9);
        // Find smallest element by comparing the one found at index 0 to the next one in the sequence. If a smaller
        // element is found, that one becomes the one to compare the rest of the array to.
        System.out.println(arrayToSort.size());
        int i = 0;
        int sorted = 0;
//        System.out.println(("bp0 i = " + i));
        while (sorted <= arrayToSort.size()) { // set smallest
//            System.out.println(("bp1 i = " + i));
            int smallest = arrayToSort.get(sorted);
            int j = i + 1;
//            System.out.println(("bp2 i = " + i + " j = " + j));
            if (i >= (arrayToSort.size() - 1)) {
//                System.out.println(("bp3 array[i] = " + arrayToSort.get(i) + " array[j] = " + arrayToSort.get(j)));
                break;
            } // to avoid out of range error
            while( j != arrayToSort.size()) { // compare two
                if (j >= (arrayToSort.size() - 1)) {break;}
//                System.out.println(("bp4 array[i] = " + arrayToSort.get(i) + " array[j] = " + arrayToSort.get(j)));
//                System.out.println(("bp5 i = " + i + " j = " + j));
                int compare = arrayToSort.get(j);
                // if compare is smaller, i is set equal to j
                if (compare < smallest) {
                    i = j;
                    break;
                }
                j++;
            }
            if (i >= (arrayToSort.size() - 1)) {
                System.out.println("bp8 break triggered");
                break;
            }
            else if (!arrayToSort.get(sorted).equals(arrayToSort.get(j))) { // if smallest not already in index 'sorted'
                int temp;
                temp = arrayToSort.get(sorted);
                arrayToSort.set(sorted, arrayToSort.get(j)); // switch them
                arrayToSort.set(j, temp);
            }
            System.out.println(arrayToSort);
            System.out.println("bp7 sorted = " + sorted);
            sorted++;
        }
        System.out.println("Done?" + arrayToSort);
        // Once found, move it into 0 index. It becomes sorted.
        // Do this for the remaining elements after the already sorted elements
        // Skip last element as it is naturally already the biggest
        // Done
        // Doesn't work. Too many unnecessary getters and if/else blocks
    }
    public void wikiSelectionSort() {
        /* a[0] to a[aLength-1] is the array to sort */
        int i,j;
        List<Integer> arrayToSort = Arrays.asList(5, 0, 1, 10, 2, 9);
        int aLength = arrayToSort.size(); // initialise to a's length

        /* advance the position through the entire array */
        /*   (could do i < aLength-1 because single element is also min element) */
        for (i = 0; i < aLength-1; i++)
        {
            /* find the min element in the unsorted a[i .. aLength-1] */

            /* assume the min is the first element */
            int jMin = i;
            /* test against elements after i to find the smallest */
            for (j = i+1; j < aLength; j++)
            {
                /* if this element is less, then it is the new minimum */
                if (arrayToSort.get(j) < arrayToSort.get(jMin))
                {
                    /* found new minimum; remember its index */
                    jMin = j;
                }
            }

            if (jMin != i)
            {
                int temp;
                temp = arrayToSort.get(i);
                arrayToSort.set(i, arrayToSort.get(jMin)); // switch them
                arrayToSort.set(jMin, temp);
            }
        }
        System.out.println(arrayToSort);
    }

    public void courseraSelectionSort( int[] vals) {
        for ( int i=0; i< vals.length-1; i++){
            int indexMin = i;
            for (int j=i+1; j< vals.length; j++) {
                if (vals[j] < vals[indexMin] ){
                    indexMin = j;
                }
            }
            int temp;
            temp = vals[i];
            vals[i] = vals[indexMin]; // switch them
            vals[indexMin] = temp;
        }
        for (int i: vals){
            System.out.println(i);
        }
    }

    public static void main (String... args) {
        Algorithms pt = new Algorithms();

        pt.wikiSelectionSort();
        
        int[] myVals = new int[6];
        myVals[0] = 5; //5, 0, 1, 10, 2, 9
        myVals[1] = 0;
        myVals[2] = 1;
        myVals[3] = 10;
        myVals[4] = 2;
        myVals[5] = 9;
        pt.courseraSelectionSort(myVals);
    }
}
