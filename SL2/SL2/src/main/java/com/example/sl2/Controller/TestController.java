package com.example.sl2.Controller;


import com.example.sl2.Model.TestModel;
import com.example.sl2.View.PiePart;
import javafx.collections.MapChangeListener;
import javafx.scene.control.ListView;

public class TestController{
    TestModel model;
    private ListView<String> list;
    public TestController(TestModel model){
        this.model = model;
        model.data.addListener(new MapChangeListener<String, Integer>() {
            @Override
            public void onChanged(Change<? extends String, ? extends Integer> change) {
                System.out.println("Changes lol in TestController \"onchanged\"");
            }
        });

    }

    public void changeModel(String sg, Integer count){
        model.addToList(sg, count);
    }

    public PiePart[] getValues(){
       return model.getPieChartValues();
    }


}
