package com.example.se1sl.Controller;

import com.example.se1sl.Model.Fakultaet;

import com.example.se1sl.VIEW.BarChartView;
import com.example.se1sl.VIEW.PieChartView;

import java.util.ArrayList;
import java.util.List;

public class AppController{
    private BarChartView second;
    private PieChartView third;
    private List<Fakultaet> sga = new ArrayList<>();
    private Integer index;
    public AppController(){
        set_up_sga();
        setup();
    }

    private void setup(){
        this.second = new BarChartView(this.sga);
        this.third = new PieChartView(this.sga);
    }
    public void close_other_stage(){
        second.close();
        third.close();
    }

    private void set_up_sga(){
        List<Fakultaet> sg = new ArrayList<>();
        Fakultaet s1 = new Fakultaet("Informatik", 4);
        sg.add(s1);
        Fakultaet s2 = new Fakultaet("Wirtschafts Informatik", 4);
        sg.add(s2);
        Fakultaet s3 = new Fakultaet("Cyber Security", 4);
        sg.add(s3);
        Fakultaet s4 = new Fakultaet("Medizinische Informatik", 4);
        sg.add(s4);
        Fakultaet s5 = new Fakultaet("anderer Studiengang", 4);
        sg.add(s5);
        this.sga = sg;
    }

    public List<Fakultaet> getOm() {
        return this.sga;
    }

    public void change_name(Integer index, String old_value, String new_value){
        this.index = index;
        this.sga.get(index).change_name(new_value);
        send_update();
    }

    public void change_bewerber(Integer index, Integer odl_value, Integer new_value){
        this.index = index;
        this.sga.get(index).change_bewerber(new_value);
        send_update();
    }
    public void send_update(){
        second.updateBarChart(sga, this.index);
        third.updatePieChart(this.index, sga);
    }
}
