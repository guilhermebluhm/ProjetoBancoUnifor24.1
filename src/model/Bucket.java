package model;

import java.util.HashMap;
import java.util.List;

public class Bucket {

    HashMap<Integer, String> buckets = new HashMap<>();

    public Bucket(){

    }

    public HashMap<Integer, String> getBuckets() {
        return buckets;
    }

    public void setBuckets(HashMap<Integer, String> buckets) {
        this.buckets = buckets;
    }

}
