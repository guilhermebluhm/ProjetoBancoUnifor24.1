package BucketLogic;

import hashLogic.hashBehavior;
import model.Bucket;
import model.Table;
import utils.ConnectBucketWhenOverflowOccurence;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CoreLogicForBucket {

    List<Integer> hashPositionByElement = new ArrayList<>();
    ConnectBucketWhenOverflowOccurence oc = new ConnectBucketWhenOverflowOccurence();

    public ArrayList<Bucket> behaviorBucket(int numberCreatedRegistry, List<Table> lTable, int rBucket){

        ArrayList<Bucket> buckets = new ArrayList<>(numberCreatedRegistry / rBucket);
        for(int i = 0 ; i < numberCreatedRegistry / rBucket ; i+=1){
            buckets.add(new Bucket(i));
        }

        for(int i = 0 ; i < lTable.size() ; i+=1){
            for(int j = 0 ; j < 100 ; j+=1){
                int hash = hashBehavior.hash(lTable.get(i).getElements().get(j), buckets.size());
                Bucket bucket = buckets.get(hash);
                if(bucket != null){
                    if(bucket.getBuckets().containsKey(hash)){
                        if(bucket.getBuckets().values().stream().flatMap(Collection::stream).toList().size() == 4){
                            int keyFromThisBucket = (int) bucket.getBuckets().keySet().toArray()[0];
                            System.out.println(keyFromThisBucket);
                            //oc.addLogic(keyFromThisBucket,lTable.get(i).getElements().get(j));
                        }
                        else{
                            String valueToInsert = lTable.get(i).getElements().get(j);
                            bucket.getBuckets().get(hash).add(valueToInsert);
                            System.out.println(bucket);
                        }
                    }
                }
            }
            System.out.println("bucket");
        }
        return buckets;
    }
}
