package utils;

import dataFile.FindPath;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFileUtils {

    private BufferedReader rd;
    private int countLinesInFile;
    private List<String> tmpFileData = new ArrayList<>();

    public DataClassReadFile readData(){

        try{
            rd = new BufferedReader(new FileReader(FindPath.getPath()));
            while(rd.readLine() != null){
                tmpFileData.add(rd.readLine());
                countLinesInFile+=1;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        DataClassReadFile data = new DataClassReadFile(countLinesInFile);
        data.setElementsRead(tmpFileData);
        return data;
    }

}
