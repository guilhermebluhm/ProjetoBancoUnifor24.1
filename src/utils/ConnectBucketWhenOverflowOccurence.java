package utils;

import model.BucketOverflowType;

import java.util.*;
import java.util.stream.Collectors;

public class ConnectBucketWhenOverflowOccurence {

    List<String> tmp = new ArrayList<>();

    public void addLogic(String v, String s, HashMap<String, BucketOverflowType> overflowBucket){

        /*
            logica de aninhamento dos buckets sera baseado em arvore
            o primeiro bucket criado será com base no ID gerado pelo bucket
            que acumulou 4 registros, então o overflow passará a apontar para aquele
            ID.

            todos os overflow deverao contar com um UUID para indicar sua unicidade
            caso um overflow gere um outro overflow seu id será ao UUID daquele que o criou
            e assim por diante
         */

        if(overflowBucket.containsKey(v)){
            BucketOverflowType next = overflowBucket.values().iterator().next();
            for (List<String> strings : next.getBuckets().values()) {
                tmp = strings;
            }
            if(tmp.size() == 4){
                //criando filhos... dos filhos...
                UUID uid = (UUID) next.getBuckets().keySet().toArray()[0];
                overflowBucket.put(uid.toString(),new BucketOverflowType(UUID.randomUUID().toString(),s));
            }
            overflowBucket.get(v).getBuckets().get(overflowBucket.get(v).getBuckets().keySet().toArray()[0]).add(s);
        }
        else{
            overflowBucket.put(v,new BucketOverflowType(UUID.randomUUID().toString(),s));
        }
    }
}
