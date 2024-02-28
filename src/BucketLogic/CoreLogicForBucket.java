package BucketLogic;

import hashLogic.hashBehavior;
import model.Bucket;
import model.Table;

import java.util.ArrayList;
import java.util.List;

public class CoreLogicForBucket {

    public void behaviorBucket(int numberCreatedRegistry, List<Table> lTable, int rBucket){

        ArrayList<Bucket> buckets = new ArrayList<>(numberCreatedRegistry / rBucket);
        for(int i = 0 ; i < numberCreatedRegistry / rBucket ; i+=1){
            buckets.add(new Bucket());
        }
        hashBehavior.hash("...",buckets.size());
    }

}
