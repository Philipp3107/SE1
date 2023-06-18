package com.example.se1sl.Controller;

import com.example.se1sl.View.BarChartView;
import com.example.se1sl.Model.Fakultaet;
import com.example.se1sl.View.InputView;
import com.example.se1sl.View.PieChartView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
     * Fügt in die Liste des Datenmodells die Einträge der Fakultät hinzu die dann zur Verarbeitung bei allen com.example.se1sl.View benutzt wird.
     */
    private void set_up_sga(){
        String[] sg = {"B. Sc. Informatik", "B. Sc. Wirtschafts Informatik", "B. Sc. Cyber Security", "B. Sc. Medizininformatik", "M. SC. Medical Data Science"};
        for(String s: sg){
            Fakultaet fakultaet = new Fakultaet(s, 1);
            fakultaet.getStudiengangProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                    System.out.printf("[%s] [%s] [%s]\n", observableValue, s, t1);
                    third.updatePieChartStudiengang(t1, index);
                    second.updateBarChartStudiengang(t1, index);
                }
            });
            fakultaet.getBewerberProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                    System.out.printf("[%s] [%s] [%s]\n", observableValue, number, t1);
                    second.updateBarChartBewerber((Integer) t1, index);
                    third.updatePieChartBewerber((Integer) t1, index);
                }
            });

            this.sga.add(fakultaet);
        }
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
     * @hidden wird aufgerufen aus {@link InputView#setup_columns()}
     * @param index Integer
     * @param new_value String
     */
    public void change_name(int index, String new_value){
        this.index = index;
        this.sga.get(index).change_name(new_value);
    }

    /**
     * Ändert die Bewerber des Eintrags in der Fakultätsliste auf den neuen Wert und sendet dann den Eintrag an das Balken- bzw. Kreisdiagramm.
     * @hidden wird aufgerufen aus {@link InputView#setup_columns()}
     * @param index Integer
     * @param new_value Integer
     */
    public void change_bewerber(int index, Integer new_value){
        this.index = index;
        this.sga.get(index).change_bewerber(new_value);

    }


}
