package dataFile;

import java.net.URL;

public class FindPath {

    public static String getPath(){
        return System.getProperty("user.dir") + "\\" + "src\\dataFile" + "\\words.txt";
    }

}
