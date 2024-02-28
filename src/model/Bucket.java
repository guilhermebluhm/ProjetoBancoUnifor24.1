package model;

import java.util.HashMap;
import java.util.List;

public class Bucket {

    HashMap<Integer, HashMap<String, Integer>> buckets;

    public Bucket(){
       buckets = new HashMap<>();
    }

    public HashMap<Integer, HashMap<String, Integer>> getBuckets() {
        return buckets;
    }

    public void setBuckets(HashMap<Integer, HashMap<String, Integer>> buckets) {
        this.buckets = buckets;
    }
}
