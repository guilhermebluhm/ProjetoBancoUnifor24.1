package core;

import BucketLogic.CoreLogicForBucket;
import model.Bucket;
import model.Table;
import utils.DataClassReadFile;
import utils.ReadFileUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CoreLogic {

    private final int registryByBuckets = 4;
    private final ReadFileUtils fl = new ReadFileUtils();
    private final CoreLogicForBucket bk = new CoreLogicForBucket();
    private final Scanner sc = new Scanner(System.in);
    private int pageByPages;


    public void behavior(){

        int z = 0;

        DataClassReadFile dataClassReadFile = fl.readData();
        System.out.println("informe a quantidade de registros por pagina: ");
        int pageInformByUser = sc.nextInt();
        pageByPages = (dataClassReadFile.getNumberLineRead()/pageInformByUser);

        List<Table> table = PopulateTable.createTable(pageByPages, dataClassReadFile);
        ArrayList<Bucket> buckets = bk.behaviorBucket(dataClassReadFile.getNumberLineRead(), table, registryByBuckets);
/*        for(int i = 0 ; i < buckets.size() ; i+=1){
            List<String> values = buckets.get(i).getBuckets().values().stream().flatMap(Collection::stream).collect(Collectors.toList());
            if(values.isEmpty())
                z+=1;
        }
        System.out.println(z);*/
    }

}
