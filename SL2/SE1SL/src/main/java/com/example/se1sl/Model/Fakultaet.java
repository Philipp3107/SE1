package com.example.se1sl.Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Fakultaet {
    private SimpleStringProperty studiengang;
    private SimpleIntegerProperty bewerber;

    public Fakultaet(String Studiengang, Integer bewerber) {
        this.studiengang = new SimpleStringProperty(Studiengang);
        this.bewerber = new SimpleIntegerProperty(bewerber);
    }

    public SimpleStringProperty getStudiengang() {
        return this.studiengang;
    }

    public SimpleIntegerProperty getBewerber() {
        return this.bewerber;
    }

    public void change_name(String studiengang) {
        this.studiengang = new SimpleStringProperty(studiengang);
    }

    public void change_bewerber(Integer bewerber) {
        this.bewerber = new SimpleIntegerProperty(bewerber);
    }
}