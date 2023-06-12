package com.example.se1sl.Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Fakultaet {
    private String studiengang;
    private int bewerber;

    public Fakultaet(String studiengang, int bewerber) {
        this.studiengang = studiengang;
        this.bewerber = bewerber;
    }

    public String getStudiengang() {
        return this.studiengang;
    }

    public int getBewerber() {
        return this.bewerber;
    }

    public void change_name(String studiengang) {
        this.studiengang = studiengang;
    }

    public void change_bewerber(Integer bewerber) {
        this.bewerber = bewerber;
    }
}