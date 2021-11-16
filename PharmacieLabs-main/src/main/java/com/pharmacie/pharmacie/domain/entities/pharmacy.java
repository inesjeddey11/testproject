package com.pharmacie.pharmacie.domain.entities;

import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class pharmacy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int pharmacyID;
    HashMap<Integer,Integer> catalogue;
    
    public pharmacy() {
    }

    public pharmacy(int pharmacyID, HashMap<Integer, Integer> catalogue) {
        this.pharmacyID = pharmacyID;
        this.catalogue = catalogue;
    }

    public int getPharmacyID() {
        return pharmacyID;
    }

    public void setPharmacyID(int pharmacyID) {
        this.pharmacyID = pharmacyID;
    }

    public HashMap<Integer, Integer> getCatalogue() {
        return catalogue;
    }

    public void setCatalogue(HashMap<Integer, Integer> catalogue) {
        this.catalogue = catalogue;
    }

    
}
