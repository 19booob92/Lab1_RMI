package com.pwr.lab8.model;

import java.io.Serializable;


public class Car implements Serializable{

    private static final long serialVersionUID = -6922977235941407078L;

    private long id;
    
    private String number;

    private long reservation;
    
    public Car(long id, String number, long reservation) {
        setId(id);
        setNumber(number);
        setReservation(reservation);
    }
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    
    public String getNumber() {
        return number;
    }


    
    public void setNumber(String number) {
        this.number = number;
    }


    
    public long getReservation() {
        return reservation;
    }


    
    public void setReservation(long reservation) {
        this.reservation = reservation;
    }
    
}
