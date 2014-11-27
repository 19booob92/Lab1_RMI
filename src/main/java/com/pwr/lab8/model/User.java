package com.pwr.lab8.model;

import java.io.Serializable;


public class User implements Serializable {

    private static final long serialVersionUID = 8403794143388376427L;

    private long id;

    private String name;

    private int transactionsAmount;

    private long spentMoneys;


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getTransactionsAmount() {
        return transactionsAmount;
    }


    public void setTransactionsAmount(int transactionsAmount) {
        this.transactionsAmount = transactionsAmount;
    }


    
    public long getSpentMoneys() {
        return spentMoneys;
    }


    
    public void setSpentMoneys(long spentMoneys) {
        this.spentMoneys = spentMoneys;
    }


}
