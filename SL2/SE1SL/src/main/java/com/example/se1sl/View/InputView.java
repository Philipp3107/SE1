package com.example.se1sl.View;

import com.example.se1sl.Controller.AppController;
import com.example.se1sl.Model.Fakultaet;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

public class InputView extends Stage {

    //com.example.se1sl.Controller für die MVC Architektur
    private final AppController controller;


    public InputView(){
        this.controller = new AppController();
        init();
    }

    /**
     *Fenster für den Input mit Table. Größe nicht veränderbar und windowEvent für das Schließen der anderen Fenster
     */
    public void init(){
        this.setResizable(false);
        this.setTitle("Eingabe");
        TableView<Fakultaet> table = setup_table();
        VBox vb = new VBox(table);
        Scene scene = new Scene(vb, 400, 148);
        this.setScene(scene);
        this.setOnCloseRequest(windowEvent -> controller.close_other_stage());
        this.show();
    }

    /**
     * Legt die einzlenen TableColumns fest.
     * <p>Legt für jede einzelne TableColumn das setOnEditCommit-Event fest.</p>
     * <p>Für TableColumn -> name {@link AppController#change_name(int, String)}</p>
     * <p>Für TableColumn -> bewerber {@link AppController#change_bewerber(int, Integer)}</p>
     * @return Array of TableColumns
     * @implNote Diese Methode ist extrahierter Code und nur dazu gedacht in der Methode {@link #setup_table()} aufgerufen zu werden
     */
    public TableColumn[] setup_columns(){

        //Array aus TableColumns
        TableColumn[] columns = new TableColumn[2];

        //TableColumn für den Studiengangnamen
        TableColumn<Fakultaet, String> name = new TableColumn<>("Studiengang");
        //Wert der jeweiligen Zellen
        name.setCellValueFactory((n) -> new SimpleStringProperty(n.getValue().getStudiengang()));
        //Setzt die Zelle als Textfeld
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        //Wenn die Zelle bearbeitet wurde
        name.setOnEditCommit((TableColumn.CellEditEvent<Fakultaet, String> t) -> {
            controller.change_name(t.getTablePosition().getRow(), t.getNewValue());
        });
        columns[0] = name;

        //TableColumn für die Bewereranzahl
        TableColumn<Fakultaet, Integer> bewerber = new TableColumn<>("Bewerber");
        //Wert der jeweiligen Zellen
        bewerber.setCellValueFactory((b) -> new SimpleIntegerProperty(b.getValue().getBewerber()).asObject());
        //Setzt die Zelle als Textfeld
        bewerber.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        //Wenn die Zelle bearbeitet wurde
        bewerber.setOnEditCommit((TableColumn.CellEditEvent<Fakultaet, Integer> t) -> {
            controller.change_bewerber(t.getTablePosition().getRow(), t.getNewValue());

        });
        columns[1] = bewerber;
        return columns;
    }

    /**
     * Fügt die einzelnen Elemente aus der Liste in AppController mit den Fakultätobjekten als ObservableList hinzu
     * @return Table mit den einzelnen Columns.
     */
    public TableView<Fakultaet> setup_table(){
        TableView<Fakultaet> table = new TableView<>();
        //Setzt den Table als bearbeitbar
        table.setEditable(true);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        //Fügt die TableColumns dem Table hinzu
        TableColumn[] tc = setup_columns();
        for(TableColumn s : tc){
            table.getColumns().add(s);
        }
        //Fügt die einzelnen Elemente aus der Liste in AppController mit den Fakultätobjekten als ObservableList hinzu
        table.setItems(FXCollections.observableArrayList(controller.getOm()));

        return table;
    }
}