package com.pwr.lab8.model;

import java.io.Serializable;
import java.sql.Date;


public class Reservation implements Serializable{

    private static final long serialVersionUID = 4766571812256248408L;

    private long id;
    
    private long number;
    
    private Date date;

    
    public long getId() {
        return id;
    }

    
    public void setId(long id) {
        this.id = id;
    }

    
    public long getNumber() {
        return number;
    }

    
    public void setNumber(long number) {
        this.number = number;
    }

    
    public Date getDate() {
        return date;
    }

    
    public void setDate(Date date) {
        this.date = date;
    }
    
}
