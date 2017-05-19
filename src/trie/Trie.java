package trie;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import shakespeare.FileUtility;
import shakespeare.Shakespeare;

/**
 *
 * @author ehn19
 */
public class Trie {

   public static void main(String[] args) {

        try {
            ShakespeareTrie st = new ShakespeareTrie();
            String[] array = FileUtility.toStringArray("C:\\Users\\ehn19\\Documents\\Skole\\4. semester\\Algoritmer og Datastrukturer\\Opgaver\\ShakespeareMin\\Shakespeare.txt", "[^A-Za-z']");
            //Begræns arrayet
            String[] partialShakespeare = getPartialArray(array, 100000);
            for (String word : partialShakespeare) {
                st.put(word,word);
            }
            System.out.println("Shakespeare Trie and soundex:");
            st.print(System.out);
            
        } catch (IOException ex) {
            Logger.getLogger(Shakespeare.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String[] getPartialArray(String[] array, int size) {
        String[] toReturn = new String[size];
        for (int i = 0; i < size; i++) {
            toReturn[i] = array[i];
        }
        return toReturn;
    }
}
