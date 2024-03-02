package model;

import java.util.ArrayList;
import java.util.HashMap;

public class BucketAndOverflow {

    private ArrayList<Bucket> buckets;
    private HashMap<String, BucketOverflowType> overflowType;

    public BucketAndOverflow(ArrayList<Bucket> buckets, HashMap<String, BucketOverflowType> overflowType) {
        this.buckets = buckets;
        this.overflowType = overflowType;
    }

    public ArrayList<Bucket> getBuckets() {
        return buckets;
    }

    public void setBuckets(ArrayList<Bucket> buckets) {
        this.buckets = buckets;
    }

    public HashMap<String, BucketOverflowType> getOverflowType() {
        return overflowType;
    }

    public void setOverflowType(HashMap<String, BucketOverflowType> overflowType) {
        this.overflowType = overflowType;
    }
}
