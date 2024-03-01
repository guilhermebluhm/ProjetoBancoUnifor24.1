package model;

import java.util.HashMap;
import java.util.List;

public class Bucket {
    public Bucket getOverflow() {
        return overflow;
    }

    public void setOverflow(Bucket overflow) {
        this.overflow = overflow;
    }

    private Bucket overflow;
    private int size;

    public int getSize() {
        return size;
    }



    private HashMap<String, Integer>[] indices;

    public Bucket(){
       indices = new HashMap[4];
       size = 0;
    }

    public void add(HashMap<String, Integer> indice){
        indices[size] = indice;
    }
    public HashMap<String, Integer>[] getIndices() {
        return indices;
    }
    public HashMap<String, Integer> find(String word){
        for(int i = 0; i < size; i++){
            if( indices[i].containsKey(word) ) {
                return indices[i];
            }
        }
        return overflow.find(word);
    }
}
