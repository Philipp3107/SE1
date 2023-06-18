package com.example.se1sl.Model;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Fakultaet{
    private StringProperty studiengang;
    private IntegerProperty bewerber;

    public Fakultaet(String studiengang, int bewerber) {

        this.studiengang = new SimpleStringProperty(studiengang);
       this.bewerber = new SimpleIntegerProperty(bewerber);
    }

    public final String getStudiengang() {
        return studiengang.get();
    }
    public final StringProperty getStudiengangProperty(){
        return studiengang;
    }

    public final int getBewerber() {
        return bewerber.get();
    }

    public final IntegerProperty getBewerberProperty(){
        return bewerber;
    }

    public void change_name(String studiengang) {
        this.studiengang.set(studiengang);
    }

    public void change_bewerber(Integer bewerber) {
        this.bewerber.set(bewerber);
    }

}