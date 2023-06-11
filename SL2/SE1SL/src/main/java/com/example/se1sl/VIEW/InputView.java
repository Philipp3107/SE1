package com.example.se1sl.VIEW;

import com.example.se1sl.Controller.AppController;
import com.example.se1sl.Model.Studiengang;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

public class InputView extends Stage {

    private TableView<Studiengang> table = new TableView<>();
    private final AppController controller;

    public InputView(){
        this.controller = new AppController();
        init();
    }
    public void init(){
        VBox vb = new VBox();
        this.setResizable(false);
        this.setTitle("Eingabe");
        table = setup_table();
        vb.getChildren().add(table);
        Scene scene = new Scene(vb, 400, 125);
        this.setScene(scene);
        this.setOnCloseRequest(windowEvent -> controller.close_other_stage());
        this.show();
    }

    public TableColumn[] setup_columns(){
        TableColumn[] columns = new TableColumn[2];
        TableColumn<Studiengang, String> name = new TableColumn<>("Studiengang");
        name.setCellValueFactory((n) -> {
            return n.getValue().getName();
        });
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        name.setOnEditCommit((TableColumn.CellEditEvent<Studiengang, String> t) -> {
            controller.change_name(t.getTablePosition().getRow(), t.getOldValue(), t.getNewValue());
        });
        columns[0] = name;
        TableColumn<Studiengang, Integer> bewerber = new TableColumn<>("Bewerber");
        bewerber.setCellValueFactory((b) -> b.getValue().getBewerber().asObject());
        bewerber.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        bewerber.setOnEditCommit((TableColumn.CellEditEvent<Studiengang, Integer> t) -> {
            controller.change_bewerber(t.getTablePosition().getRow(), t.getOldValue(), t.getNewValue());

        });
        columns[1] = bewerber;
        return columns;
    }

    public TableView<Studiengang> setup_table(){
        TableView<Studiengang> table = new TableView<>();
        table.setEditable(true);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn[] tc = setup_columns();
        for(TableColumn s : tc){
            table.getColumns().add(s);
        }
        table.setItems(controller.getOm());

        return table;
    }
}