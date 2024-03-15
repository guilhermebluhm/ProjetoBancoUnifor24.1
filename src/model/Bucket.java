package model;

import java.util.HashMap;
import java.util.List;

public class Bucket {
    private Bucket overflow;
    private int size;
    private HashMap<String, Integer>[] indices;


    public Bucket getOverflow() {
        return overflow;
    }

    public void setOverflow(Bucket overflow) {
        this.overflow = overflow;
    }
    public int getSize() {
        return size;
    }




    public Bucket(){
       indices = new HashMap[6];
       size = 0;
    }

    public void add(HashMap<String, Integer> indice){
        indices[size] = indice;
        size += 1;
    }
    public HashMap<String, Integer>[] getIndices() {
        return indices;
    }

}
