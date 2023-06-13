package com.example.se1sl.Controller;

import com.example.se1sl.Model.Fakultaet;

import com.example.se1sl.VIEW.BarChartView;
import com.example.se1sl.VIEW.InputView;
import com.example.se1sl.VIEW.PieChartView;

import java.util.ArrayList;
import java.util.List;

public class AppController{
    private BarChartView second;
    private PieChartView third;
    private final List<Fakultaet> sga = new ArrayList<>();
    private int index;
    public AppController(){
        set_up_sga();
        setup();
    }

    /**
     * Öffnet bei Aufruf das Balken- und Kreisdiagramm
     */
    private void setup(){
        this.second = new BarChartView(this.sga);
        this.third = new PieChartView(this.sga);
    }

    /**
     * schließt bei Aufruf das Balken- und Kreisdiagramm
     * <p><see>{@link InputView#init()}</see></p>
     */
    public void close_other_stage(){
        second.close();
        third.close();
    }

    /**
     * Fügt in die Liste des Datenmodells die Einträge der Fakultät hinzu die dann zur Verarbeitung bei allen View benutzt wird.
     */
    private void set_up_sga(){
        Fakultaet s1 = new Fakultaet("Informatik", 0);
        this.sga.add(s1);
        Fakultaet s2 = new Fakultaet("Wirtschafts Informatik", 0);
        this.sga.add(s2);
        Fakultaet s3 = new Fakultaet("Cyber Security", 0);
        this.sga.add(s3);
        Fakultaet s4 = new Fakultaet("Medizinische Informatik", 0);
        this.sga.add(s4);
        Fakultaet s5 = new Fakultaet("anderer Studiengang", 0);
        this.sga.add(s5);
    }

    /**
     * Gibt die gesamre Liste der Fakultätsobjekten zurück
     * @return Liste mit Fakultätsobjekten
     */
    public List<Fakultaet> getOm() {
        return this.sga;
    }

    /**
     * Ändert den Namen des Eintrags in der Fakultätsliste auf den neuen Wert und sendet dann den Eintrag an das Balken- bzw. Kreisdiagramm.
     * {@link #send_update()}
     * @hidden wird aufgerufen aus {@link InputView#setup_columns()}
     * @param index Integer
     * @param new_value String
     */
    public void change_name(int index, String new_value){
        this.index = index;
        this.sga.get(index).change_name(new_value);
        send_update();
    }

    /**
     * Ändert die Bewerber des Eintrags in der Fakultätsliste auf den neuen Wert und sendet dann den Eintrag an das Balken- bzw. Kreisdiagramm.
     * {@link #send_update()}
     * @hidden wird aufgerufen aus {@link InputView#setup_columns()}
     * @param index Integer
     * @param new_value Integer
     */
    public void change_bewerber(int index, Integer new_value){
        this.index = index;
        this.sga.get(index).change_bewerber(new_value);
        send_update();
    }

    /**
     * Sendet Fakultätsliste an das Balken- bzw. Kreisdiagramm.
     * <p>{@link #change_name(int, String)} & {@link #change_bewerber(int, Integer)}</p>
     */
    public void send_update(){
        second.updateBarChart(sga, this.index);
        third.updatePieChart(sga, this.index);
    }
}
