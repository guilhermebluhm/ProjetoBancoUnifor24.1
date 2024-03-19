package BucketLogic;

import BuketTable.BuketTable;
import hashLogic.hashBehavior;
import model.Bucket;
import model.Table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CoreLogicForBucket {
    private ArrayList<BuketTable> buckets;
    private int numberCreatedRegistry;


    public void behaviorBucket(int numberCreatedRegistry, List<Table> lTable, int rBucket){
        this.numberCreatedRegistry = numberCreatedRegistry;
        buckets = new ArrayList<>(numberCreatedRegistry / rBucket);

        for(int i = 0 ; i < numberCreatedRegistry / rBucket ; i+=1){
            buckets.add(new BuketTable(rBucket));
        }

        int page = 0;
        for (Table t:lTable) {
            for(String word: t.getElements()){
                int hash = hashBehavior.hash(word, buckets.size());

                HashMap<String, Integer> indice = new HashMap<>();
                indice.put(word, page);
                buckets.get(hash).add(indice);
            }
            page++;
        }

        System.out.println();
        estatistics();
        //hashBehavior.hash("...",buckets.size());
    }

    public void estatistics(){
        int overflows = 0;
        int tBukets = 0;
        int tBuketsOverflow = 0;

        for (BuketTable table: buckets ) {
            if(table.getBucket() != null){
                tBukets += 1;
                tBuketsOverflow += table.getOverflowBukets();
                overflows += table.getOverflowSize();
            }
        }

        System.out.println("Estatisticas");
        System.out.printf("Total de bukets preenchidos: %d / %d\n", tBukets, buckets.size());
        System.out.println();

        System.out.printf("Qnt Bukets em overflow: %d\n", tBuketsOverflow);
        System.out.printf("Taxa de colisão: %f\n", tBuketsOverflow/((double) tBukets));
        System.out.println();

        System.out.println("Qnt de overflow: " + overflows);
        System.out.println("Taxa de overflow: " + overflows/(float)numberCreatedRegistry);
        System.out.println();
    }

    public int getIndice(String word){
        int hash = hashBehavior.hash(word, buckets.size());
        BuketTable b = buckets.get(hash);
        int page = buckets.get(hash).find(word);
        return page;
    }

}
