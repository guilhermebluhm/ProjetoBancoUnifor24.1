package utils;

import hashLogic.HashBehavior;
import model.Bucket;
import model.BucketAndOverflow;
import model.BucketOverflowType;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class SearchLogic {

    public void searchBehaviour(BucketAndOverflow behavior, String bckSeach){

        int hash = HashBehavior.hash(bckSeach, behavior.getBuckets().size());
        Bucket bucket = behavior.getBuckets().get(hash);
        List<String> bckElements = bucket.getBuckets().get(hash);

        if(bckElements.size() == 4) {
            for (String v : bckElements) {
                if (v.contains(bckSeach)) {
                    System.out.println("sim, o registro esta no bucket");
                    BucketOverflowType bucketOverflowType = behavior
                            .getOverflowType()
                            .get(bucket
                                    .getBuckets()
                                    .keySet()
                                    .toArray()[0]
                                    .toString()
                            );
                    if(bucketOverflowType != null){
                        if(bucketOverflowType.getBuckets().values().stream().toList().size() == 4){
                            System.out.println("overflow nivel 2 - nao implementado");
                        }
                        else {
                            System.out.println("overflow nivel 1");
                            break;
                        }
                    }
                }
            }
        }
        else{
            System.out.println("somente nivel 0");
        }
    }
}
