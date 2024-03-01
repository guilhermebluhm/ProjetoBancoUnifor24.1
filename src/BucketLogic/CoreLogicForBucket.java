package BucketLogic;

import BuketTable.BuketTable;
import hashLogic.hashBehavior;
import model.Bucket;
import model.Table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CoreLogicForBucket {

    public void behaviorBucket(int numberCreatedRegistry, List<Table> lTable, int rBucket){

        ArrayList<BuketTable> buckets = new ArrayList<>(numberCreatedRegistry / rBucket);

        for(int i = 0 ; i < numberCreatedRegistry / rBucket ; i+=1){
            Bucket startBucket = new Bucket();
            buckets.add(new BuketTable(startBucket));
        }

        int page = 1;
        for (Table t:lTable) {
            for(String word: t.getElements()){
                int hash = hashBehavior.hash(word, buckets.size());

                HashMap<String, Integer> indice = new HashMap<>();
                indice.put(word, page);
                buckets.get(hash).add(indice);
            }
            page++;
        }
        //hashBehavior.hash("...",buckets.size());
    }

}
