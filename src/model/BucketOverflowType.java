package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class BucketOverflowType {

    HashMap<UUID, List<String>> buckets;

    public BucketOverflowType(UUID uid, String v) {
        buckets = new HashMap<>();
        List<String> listObjectForBucketOverflow = new ArrayList<>();
        listObjectForBucketOverflow.add(v);
        buckets.put(uid, listObjectForBucketOverflow);
    }

    public HashMap<UUID, List<String>> getBuckets() {
        return buckets;
    }
}
