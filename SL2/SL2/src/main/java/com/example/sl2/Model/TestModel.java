package com.example.sl2.Model;


import com.example.sl2.View.Console;
import com.example.sl2.View.PiePart;
import javafx.collections.*;

import java.util.HashMap;
import java.util.Map;

public class TestModel {

    public final ObservableMap<String, Integer> data;
    public TestModel(){
        data = FXCollections.observableMap(new HashMap<>());
        data.addListener(new MapChangeListener<String, Integer>() {
            @Override
            public void onChanged(Change<? extends String, ? extends Integer> change) {
                Console.log("changed " + change);
            }
        });

    }

    public void addToList(String msg, Integer count){
        if(data.containsKey(msg)){
            data.replace(msg, count);
            Console.log("changed existing data");
        }else{
            data.put(msg, count);
            Console.log("made new data");
        }
    }


    public String[] getKeys(){
        String[] keys = {};
        int i = 0;
        for(Map.Entry<String, Integer> entry: data.entrySet()){
            String key = entry.getKey();
            keys[i] = key;
            i++;
        }
        return keys;
    }
    public Integer[] getValues(){
        Integer[] values = {};
        int i = 0;
        for(Map.Entry<String, Integer> entry: data.entrySet()){
            Integer value = entry.getValue();
            values[i] = value;
            i++;
        }
        return values;
    }

    public PiePart[] getPieChartValues(){
        String [] keys = getKeys();
        Integer[] values = getValues();
        PiePart[] pie = {};
        for(int i = 0; i < keys.length; i++){
            pie[i] = new PiePart(keys[i],values[i]);
        }
        return pie;
    }

}
