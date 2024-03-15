package core;

import model.Table;
import utils.DataClassReadFile;

import java.util.ArrayList;
import java.util.List;

public class PopulateTable {

    public static List<Table> createTable(int totalPageToGenerate, DataClassReadFile file, int pageSize){

        List<Table> vTable = new ArrayList<>(totalPageToGenerate);


        int lowerBound = 0;
        int upperBound = pageSize;

        for(int i = 0 ; i < totalPageToGenerate ; i+=1){

                vTable.add(new Table());

                // adicionar na tabela e adicionar no bus=ket

                List<String> tmp = new ArrayList<>();
                for(int j = lowerBound ; j < upperBound ; j+=1){
                    tmp.add(file.getElementsRead().get(j));
                }

                lowerBound = upperBound;
                upperBound += pageSize;

                vTable.get(i).setElements(tmp);
        }
        System.out.println((upperBound-pageSize) + " Elementos criados");
        return vTable;
    }

}
