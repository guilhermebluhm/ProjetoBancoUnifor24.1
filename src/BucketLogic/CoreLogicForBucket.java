package BucketLogic;

import hashLogic.HashBehavior;
import model.Bucket;
import model.BucketAndOverflow;
import model.BucketOverflowType;
import model.Table;
import utils.ConnectBucketWhenOverflowOccurence;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class CoreLogicForBucket {


    private final HashMap<String, BucketOverflowType> overflowBucket = new HashMap<>();
    private ConnectBucketWhenOverflowOccurence oc = new ConnectBucketWhenOverflowOccurence();


    public BucketAndOverflow behaviorBucket(int numberCreatedRegistry, List<Table> lTable, int rBucket){

        ArrayList<Bucket> buckets = new ArrayList<>(numberCreatedRegistry / rBucket);
        for(int i = 0 ; i < numberCreatedRegistry / rBucket ; i+=1){
            buckets.add(new Bucket(i));
        }

        for(int i = 0 ; i < lTable.size() ; i+=1){
            for(int j = 0 ; j < 100 ; j+=1){
                int hash = HashBehavior.hash(lTable.get(i).getElements().get(j), buckets.size());
                Bucket bucket = buckets.get(hash);
                if(bucket != null){
                    if(bucket.getBuckets().containsKey(hash)){
                        if(bucket.getBuckets().values().stream().flatMap(Collection::stream).toList().size() == 4){
                            Integer keyFromThisBucket = (Integer) bucket.getBuckets().keySet().toArray()[0];
                            oc.addLogic(keyFromThisBucket.toString(),lTable.get(i).getElements().get(j), overflowBucket);
                        }
                        else{
                            String valueToInsert = lTable.get(i).getElements().get(j);
                            bucket.getBuckets().get(hash).add(valueToInsert);
                        }
                    }
                }
                else{
                    throw new RuntimeException("null bucket");
                }
            }
        }
        return new BucketAndOverflow(buckets, overflowBucket);
    }
}
