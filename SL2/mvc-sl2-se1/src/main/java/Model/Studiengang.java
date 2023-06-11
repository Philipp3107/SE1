package Model;

import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Studiengang implements ObservableValue {
    private SimpleStringProperty name;
    private SimpleIntegerProperty bewerber;
    ChangeListener<? extends String> listener;

    public Studiengang(SimpleStringProperty name, SimpleIntegerProperty bewerber) {
        this.name = name;
        this.bewerber = bewerber;
    }

    public Studiengang(String name, Integer bewerber) {
        this.name = new SimpleStringProperty(name);
        this.bewerber = new SimpleIntegerProperty(bewerber);
    }

    public Studiengang(SimpleStringProperty name, Integer bewerber) {
        this.name = name;
        this.bewerber = new SimpleIntegerProperty(bewerber);
    }

    public Studiengang(String name, SimpleIntegerProperty bewerber) {
        this.name = new SimpleStringProperty(name);
        this.bewerber = bewerber;
    }

    public SimpleStringProperty getName() {
        return this.name;
    }

    public SimpleIntegerProperty getBewerber() {
        return this.bewerber;
    }

    public void change_name(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public void change_bewerber(Integer bewerber) {
        this.bewerber = new SimpleIntegerProperty(bewerber);
    }

    @Override
    public void addListener(ChangeListener changeListener) {

    }

    @Override
    public void removeListener(ChangeListener changeListener) {

    }

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public void addListener(InvalidationListener invalidationListener) {

    }

    @Override
    public void removeListener(InvalidationListener invalidationListener) {

    }
}