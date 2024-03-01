package utils;

import dataFile.FindPath;
import hashLogic.hashBehavior;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reading {

    private BufferedReader rd;
    private int countLinesInFile;


    int nB = 58000;

    int[] valores= new int[nB+1];
    private List<String> tmpFileData = new ArrayList<>();

    public void readData() {
        try {
            rd = new BufferedReader(new FileReader(FindPath.getPath()));
            String line;

            while ((line = rd.readLine()) != null) {
                tmpFileData.add(line);
                //System.out.println(line);
                //System.out.println(hashBehavior.hash(line, nB));

                int hashValue = hashBehavior.hash(line, nB);
                valores[hashValue]++;
                countLinesInFile += 1;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);


        }
    }

    public int [] valores(){
        readData();

        return valores;
    }
}