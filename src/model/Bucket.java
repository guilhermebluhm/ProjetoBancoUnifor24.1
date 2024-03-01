package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bucket {

    HashMap<Integer, List<String>> buckets;

    public Bucket(int v){
       buckets = new HashMap<>();
       buckets.put(v, new ArrayList<>());
    }

    public HashMap<Integer, List<String>> getBuckets() {
        return buckets;
    }

    public void setBuckets(HashMap<Integer, List<String>> buckets) {
        this.buckets = buckets;
    }
}
