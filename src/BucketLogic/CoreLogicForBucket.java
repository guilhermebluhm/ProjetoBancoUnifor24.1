package BucketLogic;

import hashLogic.hashBehavior;
import model.Bucket;
import model.Table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CoreLogicForBucket {

    List<Integer> hashPositionByElement = new ArrayList<>();

    public void behaviorBucket(int numberCreatedRegistry, List<Table> lTable, int rBucket){

        ArrayList<Bucket> buckets = new ArrayList<>(numberCreatedRegistry / rBucket);
        for(int i = 0 ; i < numberCreatedRegistry / rBucket ; i+=1){
            buckets.add(new Bucket(i));
        }

        for(int i = 0 ; i < lTable.size() ; i+=1){
            for(int j = 0 ; j < 100 ; j+=1){
                int hash = hashBehavior.hash(lTable.get(i).getElements().get(j), buckets.size());
                //hash deve estar dentro de ~58k posicoes de buckets(a funcao hash deve limitar isso
                Bucket bucket = buckets.get(hash);
                if(bucket != null){
                    //tem o papel de verificar se a hash já foi criada pois a função hash
                    //tem que gerar o mesmo range dos i´s instanciados na criação do bucket
                    if(bucket.getBuckets().containsKey(hash)){
                        //cada bucket deve suportar no maximo 4 posicoes, se houver mais
                        //criar novo bucket, deus sabe como fazer isso ainda :D
                        if(bucket.getBuckets().values().size() > 4){
                            //fazer logica do bucket overflow
                        }
                        else{
                            //logica de inserir o dado da pagina que passou no hash para
                            //o espaço no bucket
                            String valueToInsert = lTable.get(i).getElements().get(j);
                            List<String> collect = bucket.getBuckets()
                                    .values()
                                    .stream()
                                    .flatMap(Collection::stream)
                                    .collect(Collectors.toList());
                            collect.add(valueToInsert);
                            bucket.getBuckets().values().add(collect);
                        }
                    }
                }
            }
        }
    }
}
