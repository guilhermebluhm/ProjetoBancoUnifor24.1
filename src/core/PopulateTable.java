package core;

import model.Table;
import utils.DataClassReadFile;

import java.util.ArrayList;
import java.util.List;

public class PopulateTable {

    public static List<Table> createTable(int totalPageToGenerate, DataClassReadFile file){

        List<Table> vTable = new ArrayList<>(totalPageToGenerate);



        /*
           limites de controle para sempre
           pegar novos registros a serem inseridos na tabela
         */

        int lowerBound = 0;
        int upperBound = 100;

        for(int i = 0 ; i < totalPageToGenerate ; i+=1){

                vTable.add(new Table());

                // adicionar na tabela e adicionar no bus=ket

                List<String> tmp = new ArrayList<>();
                for(int j = lowerBound ; j < upperBound ; j+=1){
                    tmp.add(file.getElementsRead().get(j));
                }

                lowerBound = upperBound;
                upperBound += 100;

                vTable.get(i).setElements(tmp);
        }
        System.out.println((upperBound-100) + " Elementos criados");
        return vTable;
    }

}
