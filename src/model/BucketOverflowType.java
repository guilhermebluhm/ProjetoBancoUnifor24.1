package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BucketOverflowType {

    HashMap<String, List<String>> buckets;

    public BucketOverflowType(String uid, String v) {
        buckets = new HashMap<>();
        List<String> listObjectForBucketOverflow = new ArrayList<>();
        listObjectForBucketOverflow.add(v);
        buckets.put(uid, listObjectForBucketOverflow);
    }

    public HashMap<String, List<String>> getBuckets() {
        return buckets;
    }
}
