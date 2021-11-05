package demos;

import processing.core.PApplet;

//import java.util.Random;
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

//    public int[] A = {70, 2, 97, 37, 58, 85, 21, 59, 57, 11, 15, 61, 93, 50, 5, 25, 24, 71, 30, 101}; // unsorted
//    public List<Integer> A = Arrays.asList(70, 2, 97, 37, 58, 85, 21, 59, 57, 11, 15, 61, 93, 50, 5, 25, 24, 71, 30, 101);
//    public List<Integer> A = Arrays.asList(70, 2, 97, 37, 58, 85, 101);
//    public List<Integer> A = Arrays.asList(70, 2, 97, 101);  // sorts this correctly
    public List<Integer> A = Arrays.asList(255, 560, 352, 32, 21, 103, 622, 709, 985, 743, 238, 340, 441, 73, 327, 909, 444, 774, 320, 437, 217, 532, 600, 535, 431, 416, 922, 6, 154, 143, 991, 393, 94, 832, 264, 188, 495, 363, 289, 981, 960, 730, 844, 681, 772, 457, 820, 765, 347, 284, 559, 110, 545, 900, 826, 868, 910, 288, 368, 682, 669, 148, 676, 827, 523, 461, 672, 211, 467, 93, 784, 596, 382, 690, 696, 204, 957, 22, 697, 835, 443, 412, 407, 728, 758, 901, 160, 539, 871, 230, 294, 345, 125, 620, 82, 140, 75, 898, 815, 453, 1001);

    public void swap( int first, int second, int ind1, int ind2 ) {
//        System.out.println("preswap A" + A);
        A.set(ind1, second);
        A.set(ind2, first);
//        System.out.println("postswap A" + A);
    }

    public int partition( int low, int high ) {
        int pivot = A.get(low);
        int i = low;
        int j = high;
//        System.out.println("pivot " + pivot);
        while (i < j) {
            do {
                i++;
//                System.out.println("i " + i);
//                System.out.println("A.get(i) " + A.get(i));
            } while (A.get(i) <= pivot);
            do {
                j--;
//                System.out.println("j " + j);
//                System.out.println("A.get(j) " + A.get(j));
            } while (A.get(j) > pivot);
            if (i < j) {
//                System.out.println("swap1 ");
//                System.out.println("i, j, low, high " + i + j + low + high);
                swap(A.get(i), A.get(j), i, j);
            }
        }
//        System.out.println("swap2 ");
//        System.out.println("i, j, low, high " + i + j + low + high);
        swap(A.get(low), A.get(j), low, j);
//        System.out.println("returning " + j);
        return j;
    }

    public void quickSort(int low, int high) {
        if (low < high){
            int j = partition(low, high);
//            System.out.println("qs j, low, high "  + j + low + high);
            this.quickSort(low, j);
            this.quickSort((j+1), high);
        }
        System.out.println("qs A " + A);
    }

    public void main2 () {
        Algorithms pt = new Algorithms();

//        List<Integer> A = Arrays.asList(70, 2, 97, 37, 58, 85, 21, 59, 57, 11, 15, 61, 93, 50, 5, 25, 24, 71, 30, 101);
//        pt.wikiSelectionSort();
//
//        int[] myVals = new int[6];
//        myVals[0] = 5; //5, 0, 1, 10, 2, 9
//        myVals[1] = 0;
//        myVals[2] = 1;
//        myVals[3] = 10;
//        myVals[4] = 2;
//        myVals[5] = 9;
//        pt.courseraSelectionSort(myVals);
        pt.quickSort(0, (A.size() - 1));
        System.out.println(A);
    }

    public static void main(String... args) {
        Algorithms pt = new Algorithms();
        pt.main2();
    }
}
