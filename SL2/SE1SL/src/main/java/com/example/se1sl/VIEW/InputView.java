package com.example.se1sl.VIEW;

import com.example.se1sl.Model.Studiengang;
import com.example.se1sl.Controller.AppController;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.converter.IntegerStringConverter;

public class InputView extends Stage {

    private TableView<com.example.se1sl.Model.Studiengang> table = new TableView<>();
    private Stage second;
    private AppController controller;

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
        this.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                controller.close_other_stage();
            }
        });
        this.show();
    }

    public TableColumn[] setup_columns(){
        TableColumn[] columns = new TableColumn[2];
        TableColumn<com.example.se1sl.Model.Studiengang, String> name = new TableColumn<>("Studiengang");
        name.setCellValueFactory((n) -> {
            return n.getValue().getName();
        });
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        name.setOnEditCommit((TableColumn.CellEditEvent<com.example.se1sl.Model.Studiengang, String> t) -> {
            controller.change_name(t.getTablePosition().getRow(), t.getOldValue(), t.getNewValue());
        });
        columns[0] = name;
        TableColumn<com.example.se1sl.Model.Studiengang, Integer> bewerber = new TableColumn<>("Bewerber");
        bewerber.setCellValueFactory((b) -> {
            return b.getValue().getBewerber().asObject();
        });
        bewerber.setCellFactory(TextFieldTableCell.<com.example.se1sl.Model.Studiengang, Integer>forTableColumn(new IntegerStringConverter()));
        bewerber.setOnEditCommit((TableColumn.CellEditEvent<com.example.se1sl.Model.Studiengang, Integer> t) -> {
            controller.change_bewerber(t.getTablePosition().getRow(), t.getOldValue(), t.getNewValue());

        });
        columns[1] = bewerber;
        return columns;
    }

    public TableView<com.example.se1sl.Model.Studiengang> setup_table(){
        TableView<com.example.se1sl.Model.Studiengang> table = new TableView<>();
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


/**
 *
 * public class Eingabe extends Stage {
 *     ObservableList<Studiengang> studiengaenge;
 *     private TableView<Studiengang> tView = new TableView<Studiengang>();
 *     private Studiengaenge sg;
 *     public Eingabe(Studiengaenge sg){
 *         this.sg = sg;
 *         this.studiengaenge = sg.getSg();
 *         init();
 *     }
 *     public void init(){
 *
 *         VBox vb = new VBox();
 *         this.setResizable(false);
 *         this.setTitle("Eingabe");
 *
 *         tView.setEditable(true);
 *
 *         TableColumn<Studiengang, String> studiengang = new TableColumn<>("Studiengang");
 *         studiengang.setCellValueFactory((p) -> {
 *             return p.getValue().getName();
 *         });
 *         studiengang.setCellFactory(TextFieldTableCell.forTableColumn());
 *         studiengang.setOnEditCommit((TableColumn.CellEditEvent<Studiengang, String> t) -> {
 *             System.out.println("Edited Studiengang on commit " + t.getNewValue());
 *             System.out.println("old value " + (t.getTableView().getItems().get(t.getTablePosition().getColumn()).getName()));
 *             (t.getTableView().getItems().get(t.getTablePosition().getColumn())).setName(new SimpleStringProperty(t.getNewValue()));
 *             System.out.println("new value " +(t.getTableView().getItems().get(t.getTablePosition().getColumn()).getName()));
 *             System.out.println("---------------------------------------------------------------");
 *             //print_stud();
 *         });
 *         TableColumn<Studiengang, Integer> bewerber = new TableColumn<>("Bewerber");
 *         bewerber.setCellValueFactory((p) -> {
 *             return p.getValue().getBewerber().asObject();
 *         });
 *         bewerber.setCellFactory(TextFieldTableCell.<Studiengang, Integer>forTableColumn(new IntegerStringConverter()));
 * //        bewerber.setOnEditCommit((TableColumn.CellEditEvent<Studiengang, Integer> t) -> {
 * //            System.out.println("Did something");
 * //            print_stud();
 * //            ((Studiengang) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBewerber(new SimpleIntegerProperty(t.getNewValue()));
 * //        });
 * //        bewerber.setOnEditStart((TableColumn.CellEditEvent<Studiengang, Integer> t) -> {
 * //            System.out.println("started changes");
 * //        });
 * //        bewerber.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Studiengang, Integer>>() {
 * //            @Override
 * //            public void handle(TableColumn.CellEditEvent<Studiengang, Integer> studiengangIntegerCellEditEvent) {
 * //                print_stud();
 * //            }
 * //        });
 *         bewerber.setOnEditCommit((TableColumn.CellEditEvent<Studiengang, Integer> t) -> {
 *             System.out.println("Edited bewerber on commit " + t.getNewValue());
 *             System.out.println((t.getTableView().getItems().get(t.getTablePosition().getColumn()).getBewerber()));
 *             (t.getTableView().getItems().get(t.getTablePosition().getRow())).setBewerber(new SimpleIntegerProperty(t.getNewValue()));
 *             System.out.println((t.getTableView().getItems().get(t.getTablePosition().getColumn()).getBewerber()));
 *             System.out.println("---------------------------------------------------------------");
 *
 *         });
 *
 *         tView.getColumns().addAll(studiengang, bewerber);
 *         tView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
 *         tView.setItems(studiengaenge);
 *         bewerber.getTableView().getItems().addListener(new ListChangeListener<Studiengang>() {
 *             @Override
 *             public void onChanged(Change change) {
 *                 System.out.println("Got changed 2387r69287r");
 *             }
 *         });
 *
 *         vb.getChildren().add(tView);
 *         Scene scene = new Scene(vb, 400, 125);
 *         this.setScene(scene);
 *         this.show();
 *     }
 *     public void print_stud(){
 *         for(Studiengang s: sg.getSg()){
 *             System.out.println(s.getBewerber() + " | " + s.getName());
 *         }
 *     }
 * }
 */
