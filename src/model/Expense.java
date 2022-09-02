package model;

import java.util.*;

public class Expense {

    private Date date;
    private Double value;
    private String name;

    public Expense(Date date, Double value, String name) {
        super();
        this.date = date;
        this.value = value;
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

 
}
