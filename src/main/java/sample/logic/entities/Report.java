package sample.logic.entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Report extends Exportable implements Serializable {
    private String criteria;
    private int count=0;
    private String description;

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