package com.pharmacie.pharmacie.domain.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class moderator extends user {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int moderatorID;

    public moderator() {
        super();
    }

    public moderator(int moderatorID) {
        this.moderatorID = moderatorID;
    }

    public int getModeratorID() {
        return moderatorID;
    }

    public void setModeratorID(int moderatorID) {
        this.moderatorID = moderatorID;
    }
    
}
