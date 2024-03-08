package utils;

import dataFile.FindPath;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFileUtils {
    private int countLinesInFile;
    private List<String> tmpFileData = new ArrayList<>();

    public DataClassReadFile readData(){

        try {
            File myObj = new File(FindPath.getPath());
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                tmpFileData.add(data);
                countLinesInFile+=1;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            throw new RuntimeException(e);
        }

        DataClassReadFile data = new DataClassReadFile(countLinesInFile);
        data.setElementsRead(tmpFileData);
        return data;
    }

}
