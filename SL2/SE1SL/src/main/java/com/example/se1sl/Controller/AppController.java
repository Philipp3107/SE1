package Controller;

import Model.Fakultaet;

import View.BarChartView;
import View.InputView;
import View.PieChartView;

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
        Fakultaet s1 = new Fakultaet("B. Sc. Informatik", 1);
        this.sga.add(s1);
        Fakultaet s2 = new Fakultaet("B. Sc. Wirtschafts Informatik", 1);
        this.sga.add(s2);
        Fakultaet s3 = new Fakultaet("B. Sc. Cyber Security", 1);
        this.sga.add(s3);
        Fakultaet s4 = new Fakultaet("B. Sc. Medizininformatik", 1);
        this.sga.add(s4);
        Fakultaet s5 = new Fakultaet("M. SC. Medical Data Science", 1);
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
