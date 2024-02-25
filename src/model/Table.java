package model;

import java.util.ArrayList;
import java.util.List;

public class Table {

    private List<String> elements = new ArrayList<>(100);

    public Table(){

    }

    public List<String> getElements() {
        return elements;
    }

    public void setElements(List<String> elements) {
        this.elements = elements;
    }
}
