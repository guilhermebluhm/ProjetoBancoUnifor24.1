package utils;

import model.BucketOverflowType;

import java.util.*;

public class ConnectBucketWhenOverflowOccurence {

    List<String> tmp = new ArrayList<>();

    public void addLogic(String v, String s, HashMap<String, BucketOverflowType> overflowBucket){

        /*
            falta a parte das estatisticas de colisao e overflow
         */

        if(overflowBucket.containsKey(v)){
            HashMap<String, List<String>> buckets = overflowBucket.get(v).getBuckets();
            for (List<String> strings : buckets.values().stream().toList()) {
                tmp = strings;
            }
            if(tmp.size() == 4){
                //aqui e quando e gerado um overflow do overflow
                Set<String> strings = buckets.keySet();
                String uid = strings.toString();
                overflowBucket.put(uid,new BucketOverflowType(UUID.randomUUID().toString(),s));
            }
            else {
                //aqui e quando e gerado uma colisao dentro do overflow atual
                overflowBucket.get(v).getBuckets().get(overflowBucket.get(v).getBuckets().keySet().toArray()[0]).add(s);
            }
        }
        else{
            //aqui quando o overflow inicial e criado por conta do bucket pai ter 4 registros
            overflowBucket.put(v,new BucketOverflowType(UUID.randomUUID().toString(),s));
        }
    }
}
