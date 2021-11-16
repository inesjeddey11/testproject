package com.pharmacie.pharmacie.domain.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class admin extends user{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int adminID;

    public admin(int adminID) {
        this.adminID = adminID;
    }

    public admin() {
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }
    
}
