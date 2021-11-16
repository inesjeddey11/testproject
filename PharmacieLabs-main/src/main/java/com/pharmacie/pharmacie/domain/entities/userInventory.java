package com.pharmacie.pharmacie.domain.entities;

import java.util.HashMap;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class userInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int inventoryID;
    
    int clientID;
    HashMap<Integer,Integer> medecines;
    
    public userInventory() {
    }

    public userInventory(int inventoryID, int clientID, HashMap<Integer, Integer> medecines) {
        this.inventoryID = inventoryID;
        this.clientID = clientID;
        this.medecines = medecines;
    }

    public int getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(int inventoryID) {
        this.inventoryID = inventoryID;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public HashMap<Integer, Integer> getMedecines() {
        return medecines;
    }

    public void setMedecines(HashMap<Integer, Integer> medecines) {
        this.medecines = medecines;
    }

    
}
