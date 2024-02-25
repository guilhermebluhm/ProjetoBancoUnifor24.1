package core;

import model.Table;
import utils.DataClassReadFile;

import java.util.ArrayList;
import java.util.List;

public class PopulateTable {

    public static List<Table> createTable(int totalPageToGenerate, DataClassReadFile file){

        List<Table> v = new ArrayList<>(totalPageToGenerate);
        List<String> r = new ArrayList<>();

        /*
           limites de controle para sempre
           pegar novos registros a serem inseridos na tabela
         */

        int lowerBound = 0;
        int upperBound = 100;

        for(int i = 0 ; i < totalPageToGenerate ; i+=1){

                v.add(new Table());

                /*
                    logica da list<?> r e para montar as palavras dentro de
                    paginas de 100 registros
                 */

                for(int j = lowerBound ; j < upperBound ; j+=1){
                    r.add(file.getElementsRead().get(j));
                }

                lowerBound = upperBound+1;
                upperBound += 100;

                v.get(i).setElements(r);
        }
        return v;
    }

}
