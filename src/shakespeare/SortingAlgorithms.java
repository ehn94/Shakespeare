    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakespeare;

/**
 *
 * @author ehn19
 */
public class SortingAlgorithms {
    
    private static String[] aux;
    

    public SortingAlgorithms(String[] strArr) {
        this.strArr = strArr;
    }

    String[] strArr;

    public void selectionSort() {
        for (int j = 0; j < strArr.length - 1; j++) {
            String min = strArr[j];
            String temp;
            int minIndex = j;

            for (int i = j + 1; i < strArr.length; i++) {
                if (strArr[i].compareTo(min) < 0) {
                    min = strArr[i];
                    minIndex = i;
                }
            }
            temp = strArr[j];
            strArr[j] = min;
            strArr[minIndex] = temp;
        }
    }

    public void insertionSort() {

        for (int i = 1; i < strArr.length; i++) {
            String temp = strArr[i];
            int j;
            for (j = i - 1; j >= 0 && temp.compareTo(strArr[j]) < 1; j--) {
                strArr[j + 1] = strArr[j];
            }
            strArr[j + 1] = temp;

        }
    }
    
    public void sort() // Top down s.273
    {
        aux = new String[strArr.length];
        sort(strArr, 0, strArr.length - 1);

    }

    public void sort(String[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);       // Sort left half. 
        sort(a, mid + 1, hi);     // Sort right half.
        merge(a, lo, mid, hi);  // Merge results (code on page 271)
    }

    public void merge(String[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    private boolean less(String v, String w) {
        return v.compareTo(w) < 1;
    }

    public String arrToString() {
        String str = strArr[0] + ", ";
        for (int i = 1; i < strArr.length; i++) {
            if (!strArr[i].equals(strArr[i - 1]))// ignorerer dublikanter
            {
                str += strArr[i] + " , ";
            }

        }
        return str;
    }
}
