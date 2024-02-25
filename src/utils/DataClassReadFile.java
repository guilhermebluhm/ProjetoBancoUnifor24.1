package utils;

import java.util.List;

public class DataClassReadFile {

    private int numberLineRead;
    private List<String> elementsRead;

    public DataClassReadFile(int numberLineRead) {
        this.numberLineRead = numberLineRead;
    }

    public int getNumberLineRead() {
        return numberLineRead;
    }

    public void setNumberLineRead(int numberLineRead) {
        this.numberLineRead = numberLineRead;
    }

    public List<String> getElementsRead() {
        return elementsRead;
    }

    public void setElementsRead(List<String> elementsRead) {
        this.elementsRead = elementsRead;
    }
}
