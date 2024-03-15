package core;

import BucketLogic.CoreLogicForBucket;
import model.Table;
import utils.DataClassReadFile;
import utils.ReadFileUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoreLogic {

    private final int registryByBuckets = 6;
    private final ReadFileUtils fl = new ReadFileUtils();
    private final CoreLogicForBucket bk = new CoreLogicForBucket();
    private final Scanner sc = new Scanner(System.in);
    private int pageByPages;
    private List<Table> table;


    public void behavior(){

        DataClassReadFile dataClassReadFile = fl.readData();

        System.out.println("informe a quantidade de registros por pagina: ");
        int pageInformByUser = sc.nextInt();
        pageByPages = (dataClassReadFile.getNumberLineRead()/pageInformByUser);


        System.out.println("Criando paginas ...");
        List<Table> table = PopulateTable.createTable(pageByPages, dataClassReadFile, pageInformByUser);
        this.table = table;

        System.out.println();
        System.out.println("Criando indices ...");
        bk.behaviorBucket(dataClassReadFile.getNumberLineRead(), table, registryByBuckets);

        System.out.println("End ...");
    }

    public int search(String word) {
        int page = bk.getIndice(word);
        if(page == -1){
            return page;
        }

        if(table != null){
            for(String element: table.get(page).getElements()){
                if(element.equals(word)) return page;
            };
        }

        return -1;
    }

    public String[] tableScan() {

        return new String[0];
    }

    public List<String> scan() {
        List<String> results = new ArrayList<String>();
        for(Table t: table){
            List<String> elements = t.getElements();
            for(String word: elements){
                results.add(word);
            }
        }

        System.out.println(results.size() + " Elementos encontrados");
        return results;
    }
}
