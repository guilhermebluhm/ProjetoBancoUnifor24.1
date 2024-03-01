package utils;

import model.BucketOverflowType;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ConnectBucketWhenOverflowOccurence {

    private static HashMap<Integer, BucketOverflowType> overflowBucket;

    public static HashMap<Integer, BucketOverflowType> getReturn(){
        return overflowBucket;
    }

    public void addLogic(int v, String s){
        //requer a logica para verificar se o bucket ja existe e inserir nesse cara
        //senao, criar sempre que e criado, uma nova instancia sera gerada com sua respectiva instancia
        //de List<?>

        if(!overflowBucket.isEmpty()){
            if(overflowBucket.containsKey(v)){
                //verificar se funciona
                //tem que melhorar a logica central para saber se precisa
                //ficar apontando para novos overflow
                BucketOverflowType next = overflowBucket.values().iterator().next();
                List<String> collect = next.getBuckets()
                        .values()
                        .stream()
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList());
                collect.add(s);
                next.getBuckets().values().add(collect);
            }
        }

        overflowBucket.put(v,new BucketOverflowType(UUID.randomUUID(),s));
    }

}
