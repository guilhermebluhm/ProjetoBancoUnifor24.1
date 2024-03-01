package BuketTable;

import model.Bucket;

import java.util.HashMap;

public class BuketTable {
    private int overflowSize;
    private Bucket bucket;


    public BuketTable(Bucket startBucket){
        bucket = startBucket;
        overflowSize = 0;
    }

    public void add(HashMap<String, Integer> indice){

        if(bucket == null){
            Bucket newBucket = new Bucket();
            newBucket.add(indice);
            bucket = newBucket;
        }else if(bucket.getSize() == 4){
            Bucket overflowBucket = bucket.getOverflow();
            while(overflowBucket != null){
                if(overflowBucket.getSize() == 4){
                    overflowBucket = bucket.getOverflow();
                }else if(overflowBucket.getSize() < 4){
                    overflowBucket.add(indice);
                }else {
                    Bucket newBucket = new Bucket();
                    newBucket.add(indice);
                    overflowBucket.setOverflow(newBucket);
                }
            }
        }else{
            bucket.add(indice);
        }
    }

    public int find(String word){

        if(bucket == null){
            return -1;
        }
        int count = bucket.getSize();
        Bucket serchBucket = bucket;
        HashMap<String, Integer>[] indices = serchBucket.getIndices();
        while(!indices[count].containsKey(word)){
            if(count == 4) {
                if (serchBucket.getOverflow() != null) {
                    serchBucket = serchBucket.getOverflow();
                    indices = serchBucket.getIndices();
                } else {
                    return -1;
                }
            }
            count++;
        }
        return -1;
    }
}
