package com.pharmacie.pharmacie.domain.entities;

import java.sql.Time;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class reminder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int reminderID;
    int clientID;
    Time reminderTime;
    boolean isEnabled;
    @ElementCollection(targetClass = String.class)
    List<String> Hours;
    
    public reminder() {
    }

    public reminder(int reminderID, int clientID, Time reminderTime, boolean isEnabled, List<String> hours) {
        this.reminderID = reminderID;
        this.clientID = clientID;
        this.reminderTime = reminderTime;
        this.isEnabled = isEnabled;
        Hours = hours;
    }

    public int getReminderID() {
        return reminderID;
    }

    public void setReminderID(int reminderID) {
        this.reminderID = reminderID;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public Time getReminderTime() {
        return reminderTime;
    }

    public void setReminderTime(Time reminderTime) {
        this.reminderTime = reminderTime;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public List<String> getHours() {
        return Hours;
    }

    public void setHours(List<String> hours) {
        Hours = hours;
    }

    
    
}
