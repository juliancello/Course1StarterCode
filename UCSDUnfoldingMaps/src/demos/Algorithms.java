package demos;

import processing.core.PApplet;

import java.util.List;
import java.util.Arrays;

public class Algorithms{
    public void selectionSort() {
        // Instructions: implement selection sort algorithm

        // Have array
        List<Integer> arrayToSort = Arrays.asList(0, 5, 1, 10, 2, 9);
        // Find smallest element by comparing the one found at index 0 to the next one in the sequence. If a smaller
        // element is found, that one becomes the one to compare the rest of the array to.
        for (int i = 0; i < arrayToSort.size(); i++) {
            System.out.println(arrayToSort.get(i)); //debug
            int smallest = arrayToSort.get(i);
            if (arrayToSort.get(i+1) < smallest) {

            }
        }

        // Once found, move it into 0 index. It becomes sorted.
        // Do this for the remaining elements after the already sorted elements
        // Skip last element as it is naturally already the biggest
        // Done



    }

    public static void main (String... args) {
        Algorithms pt = new Algorithms();
        pt.selectionSort();
    }
}
