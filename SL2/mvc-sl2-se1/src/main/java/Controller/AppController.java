package Controller;

import Model.Studiengang;
import View.BarChartView;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class AppController{
    private BarChartView second;
    private List<Studiengang> sga;
    private ObservableList<Studiengang> om;
    private Integer index;
    private boolean changed;
    public AppController(){
        set_up_sga();
        this.om = FXCollections.<Studiengang>observableArrayList(this.sga);
        this.om.addListener(new ListChangeListener<Studiengang>() {
            @Override
            public void onChanged(Change<? extends Studiengang> change) {
                while(change.next()){
                    if(change.wasRemoved()){
                        System.out.println("added element");
                        System.out.println(changed);
                        second.update_view(changed, om, index);
                    }
                }
            }
        });
        setup();
    }

    private void setup(){
        this.second = new BarChartView(this.getOm());
    }
    public void close_other_stage(){
        second.close();
    }

    private void set_up_sga(){
        List<Studiengang> sg = new ArrayList<>();
        Studiengang s1 = new Studiengang("Informatik", 4);
        sg.add(s1);
        Studiengang s2 = new Studiengang("Wirtschafts Informatik", 4);
        sg.add(s2);
        Studiengang s3 = new Studiengang("Cyber Security", 4);
        sg.add(s3);
        Studiengang s4 = new Studiengang("Medizinische Informatik", 4);
        sg.add(s4);
        this.sga = sg;
    }

    public ObservableList<Studiengang> getOm() {
        return this.om;
    }

    public void change_name(Integer index, String old_value, String new_value){
        Studiengang changed = sga.get(index);
        Studiengang new_sg = new Studiengang(new_value, changed.getBewerber());
        this.changed = false;
        this.index = index;
        om.add(index, new_sg);
        om.remove(index+1);

    }

    public void change_bewerber(Integer index, Integer odl_value, Integer new_value){
        Studiengang changed = om.get(index);
        Studiengang new_sg = new Studiengang(changed.getName(), new_value);
        this.index = index;
        this.changed = true;
        om.add(index, new_sg);
        om.remove(index+1);
//        for(Studiengang sg: om){
//            System.out.println("Name: " + sg.getName() + "; Anzahl: " + sg.getBewerber());
//        }

    }

    public ObservableList<Studiengang> update_views(){
        return om;
    }
}
