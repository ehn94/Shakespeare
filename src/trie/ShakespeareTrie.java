/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trie;

import java.io.PrintStream;
import java.util.regex.Pattern;

/**
 *
 * @author ehn19
 */
public class ShakespeareTrie {

    public static int SIZE = indexOf('Z') + 2;

    private WordCounter data = null;
    private ShakespeareTrie[] tries = null;
    
    public class WordCounter{
        String word;
        int count;
        
        WordCounter(String word){
            this.word = word;
            this.count = 1;
        }
    }

    private static int indexOf(char letter) {
        if ((char) letter == '\'') return 26;
        else return (int) (letter - 'A');
    }

    public void put(String word, String data) {

        if (word.isEmpty()) {
            if(this.data == null) this.data = new WordCounter(data);
            else{
                this.data.count++;
                
            } 
        } else {
            char letter = word.charAt(0);
            int index = indexOf(letter);
            if (tries == null) {
                tries = new ShakespeareTrie[SIZE];
            }
            if (tries[index] == null) {
                tries[index] = new ShakespeareTrie();
            }
            ShakespeareTrie trie = tries[index];
            trie.put(word.substring(1), data);
        }
    }

    public WordCounter get(String word) {
        if (word.isEmpty()) {
            return data;
        }
        if (tries == null) {
            return null;
        }
        char letter = word.charAt(0);
        int index = indexOf(letter);
        ShakespeareTrie trie = tries[index];
        if (tries[index] == null) {
            return null;
        }
        return trie.get(word.substring(1));
    }
    
    

    public void print(PrintStream out) {
        
        if (data != null) {
            out.println(data.word  + " : " + data.count + "\t-->" +"\tSOUNDEX:" + Soundex.soundex(data.word));
        }
        if (tries != null) {
            for (ShakespeareTrie trie : tries) {
                if (trie == null) {
                    continue;
                }
                trie.print(out);
            }
        }
    }

}
