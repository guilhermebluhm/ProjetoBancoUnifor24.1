package utils;

import model.BucketOverflowType;

import java.util.*;

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
