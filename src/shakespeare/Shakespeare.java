/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakespeare;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ehn19
 */
public class Shakespeare {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Shakespeare shake = new Shakespeare();
        SortingAlgorithms selectionS = new SortingAlgorithms(shake.fileReader());// Selection
        SortingAlgorithms insertionS = new SortingAlgorithms(shake.fileReader());// Insertion
        SortingAlgorithms mergeS = new SortingAlgorithms(shake.fileReader());// Merge
        
        Stopwatch timer1 = new Stopwatch();
        selectionS.selectionSort();  //Selection sort
        double elapsed1 = timer1.elapsedTime();

        System.out.println("Selection sort: ");
        System.out.println(selectionS.arrToString());
        System.out.println("Selection sort took: " + elapsed1);

        Stopwatch timer2 = new Stopwatch();
        insertionS.insertionSort();  //Insertion sort
        double elapsed2 = timer2.elapsedTime();

        System.out.println("Insertion sort: ");
        System.out.println(insertionS.arrToString());
        System.out.println("Insertion sort took: " + elapsed2);
        
        Stopwatch timer3 = new Stopwatch();
        mergeS.sort();  //Merge sort
        double elapsed3 = timer3.elapsedTime();

        System.out.println("Merge sort: ");
        System.out.println(mergeS.arrToString());
        System.out.println("Merge sort took: " + elapsed3);
    }

    public String[] fileReader() {
        String[] words = null;
        try {
            words = FileUtility.toStringArray("C:\\Users\\ehn19\\Documents\\Skole\\4. semester\\Algoritmer og Datastrukturer\\Shakespeare.txt", "[^A-Za-z]");

        } catch (IOException ex) {
            ex.toString();
        }
        String[] sArr = new String[100000];// Nyt String array med begrænset plads

        for (int i = 0; i < sArr.length; i++)// Lægger de første 10000 ord fra Shakespeare ind i det nye array
        {
            sArr[i] = words[i];
        }
        return sArr;
    }
}
