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
public interface OrderedSymbolTable <K extends Comparable<K>, V> extends SymbolTable<K, V>{
    K min();
    K max();
    K floor(K key);
    K ceiling(K key);
    int rank (K key);
    K select(int rank);
    void deleteMin();
    void delete();
    int size(K low, K high);
    Iterable<K> keys(K low, K high);
}
