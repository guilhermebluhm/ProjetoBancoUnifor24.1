package core;

import BucketLogic.CoreLogicForBucket;
import model.BucketAndOverflow;
import model.Table;
import utils.DataClassReadFile;
import utils.ReadFileUtils;

import java.util.List;
import java.util.Scanner;

public class CoreLogic {

    private final int registryByBuckets = 4;
    private final ReadFileUtils fl = new ReadFileUtils();
    private final CoreLogicForBucket bk = new CoreLogicForBucket();
    private final Scanner sc = new Scanner(System.in);
    private int pageByPages;


    public BucketAndOverflow behavior(){

        DataClassReadFile dataClassReadFile = fl.readData();
        System.out.println("informe a quantidade de registros por pagina: ");
        int pageInformByUser = sc.nextInt();
        pageByPages = (dataClassReadFile.getNumberLineRead()/pageInformByUser);

        List<Table> table = PopulateTable.createTable(pageByPages, dataClassReadFile, pageInformByUser);
        return bk.behaviorBucket(dataClassReadFile.getNumberLineRead(), table, registryByBuckets, pageInformByUser);
    }
}
