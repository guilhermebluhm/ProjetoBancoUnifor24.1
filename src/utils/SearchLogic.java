package utils;

import model.Bucket;
import model.BucketAndOverflow;
import model.BucketOverflowType;

import java.util.Collection;
import java.util.List;

public class SearchLogic {

    public void searchBehaviour(BucketAndOverflow behavior, String bckSeach){
        for(Bucket bck : behavior.getBuckets()){

            List<String> bucketregtryLevel0 = bck.getBuckets().values().stream().flatMap(Collection::stream).toList();
            if(bucketregtryLevel0.contains(bckSeach)){
                if(bucketregtryLevel0.size() == 4) {
                    BucketOverflowType bucketOverflowTypeLevel1 = behavior.getOverflowType()
                            .get(String
                                    .valueOf((int) bck
                                            .getBuckets()
                                            .keySet()
                                            .toArray()[0]));
                    if(bucketOverflowTypeLevel1 != null){
                        BucketOverflowType bucketOverflowTypeLevel2 = behavior
                                .getOverflowType()
                                .get((bucketOverflowTypeLevel1.getBuckets().keySet().toArray()[0]).toString());
                        if(bucketOverflowTypeLevel2 != null) {
                            System.out.println("overflow de nivel 2");
                            System.out.println(bucketOverflowTypeLevel2);
                            //quando ha 2 niveis de overflow
                            break;
                        }
                        //quando ha 1 nivel de overflow
                        break;
                    }
                }
                else{
                    //quando o bucket nunca lotou 4 casas
                    System.out.println(bucketregtryLevel0);
                    break;
                }
            }
        }
    }

}
