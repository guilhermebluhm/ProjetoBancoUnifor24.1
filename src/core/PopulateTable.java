package core;

import model.Table;
import utils.DataClassReadFile;

import java.util.ArrayList;
import java.util.List;

public class PopulateTable {

    public static List<Table> createTable(int totalPageToGenerate, DataClassReadFile file, Integer registryByUser){

        List<Table> vTable = new ArrayList<>(totalPageToGenerate);

        /*
           limites de controle para sempre
           pegar novos registros a serem inseridos na tabela
         */

        int lowerBound = 0;
        int upperBound = registryByUser;

        for(int i = 0 ; i < totalPageToGenerate ; i+=1){

                vTable.add(new Table());

                /*
                    logica da list<?> r e para montar as palavras dentro de
                    paginas de 100 registros
                 */

                List<String> tmp = new ArrayList<>();
                for(int j = lowerBound ; j < upperBound ; j+=1){
                    tmp.add(file.getElementsRead().get(j));
                }

                lowerBound = upperBound;
                upperBound += registryByUser;

                vTable.get(i).setElements(tmp);
        }
        return vTable;
    }

}
