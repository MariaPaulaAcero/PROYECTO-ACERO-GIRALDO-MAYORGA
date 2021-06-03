package sample.logic.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Report extends Exportable implements Serializable {
    private String criteria;
    private int count=0;
    private String description;

    public Report(){

    }

    public Report(String criteria, int count, String description) {
        this.criteria = criteria;
        this.count = count;
        this.description = description;
    }

    public String getCriteria() {
        return criteria;
    }

    public int getCount() {
        return count;
    }

    public String getDescription() {
        return description;
    }

    public void incrementCount(){
        this.count += 1;
    }

    @Override
    public List<String> toListString() {
        List<String> result = new ArrayList<>();
        result.add(this.criteria);
        result.add(this.description);
        return result;
    }

    @Override
    public String getHeader() {
        return "criteria, count, description";
    }

}
