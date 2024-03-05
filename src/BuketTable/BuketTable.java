package BuketTable;

import model.Bucket;

import java.util.HashMap;

public class BuketTable {
    private int overflowBukets;
    private int overflowSize;
    private Bucket bucket;


    public BuketTable(){
        overflowSize = 0;
        overflowBukets = 0;
    }

    public int getOverflowBukets() {
        return overflowBukets;
    }

    public void setOverflowBukets(int overflowBukets) {
        this.overflowBukets = overflowBukets;
    }

    public int getOverflowSize() {
        return overflowSize;
    }

    public void setOverflowSize(int overflowSize) {
        this.overflowSize = overflowSize;
    }

    public Bucket getBucket() {
        return bucket;
    }

    public void setBucket(Bucket bucket) {
        this.bucket = bucket;
    }

    public Bucket add(HashMap<String, Integer> indice){

        if(bucket == null){
            Bucket newBucket = new Bucket();
            newBucket.add(indice);
            bucket = newBucket;
        }else if(bucket.getSize() == 4){
            Bucket currentBuket = bucket;
            overflowSize += 1;
            do{
                if(currentBuket.getSize() < 4){
                    currentBuket.add(indice);
                    break;
                }else if(currentBuket.getOverflow() == null){
                    Bucket newBucket = new Bucket();
                    newBucket.add(indice);
                    currentBuket.setOverflow(newBucket);
                    overflowBukets += 1;
                    break;
                }
                currentBuket = currentBuket.getOverflow();
            }while(true);
        }else{
            bucket.add(indice);
        }

        return bucket;
    }

    private Boolean hasValue(HashMap<String, Integer>[] indices, String word){
        for(HashMap<String, Integer> indice: indices){
            if(indice == null){
                return false;
            }
            if(indice.containsKey(word)){
                return true;
            }
        }
        return false;
    }

    public int find(String word){
        if(bucket == null){
            return -1;
        }
        int count = bucket.getSize();

        Bucket serchBucket = bucket;
        HashMap<String, Integer>[] indices = serchBucket.getIndices();

        while(!hasValue(indices, word)){
            if (serchBucket.getOverflow() != null) {
                serchBucket = serchBucket.getOverflow();
                indices = serchBucket.getIndices();
            } else {
                return -1;
            }

            count++;
        }
        for(HashMap<String, Integer> indice: indices){
            if(indice.containsKey(word)){
                return indice.get(word);
            }
        }
        return -1;
    }
}
