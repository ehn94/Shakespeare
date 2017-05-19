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
public class ArraySymbolTable implements OrderedSymbolTable<String, Integer> {

    private FlexibleArray<Word> words = new FlexibleArray<>();
    
    @Override
    public String min() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String max() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String floor(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String ceiling(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int rank(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String select(int rank) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteMin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size(String low, String high) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<String> keys(String low, String high) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void put(String key, Integer value) {
        for (int i = 1; i < words.size(); i++) {
            String temp = words.get(i).key;
            int tempVal = words.get(i).value;
            int j;
            for (j = i - 1; j >= 0 && temp.compareTo(words.get(j).key) < 1; j--) {
                words.get(j + 1).key = words.get(j).key;
                words.get(j + 1).value = words.get(j).value;
            }
            words.get(j + 1).key = temp;
            words.get(j + 1).value = tempVal;

        }
    }

    @Override
    public Integer get(String key) {
        for(int i = 0; i < words.size(); i++)
        {
            int c = words.get(i).key.compareTo(key);
            if(c > 0){
                return null;
            }
            if(c == 0)
            {
                return words.get(i).value;
            }
        }return null;
    }

    @Override
    public int size() {
       return words.size();
    }

    @Override
    public Iterable<String> keys() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
