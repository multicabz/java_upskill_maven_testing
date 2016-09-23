package com.up.skill.models;

/**
 * Created by Multi Cabz on 9/22/2016.
 */
public class MyClass {
    private String myView;
    private String setByConstructor = "Default value!";

    public MyClass(String setByConstructor) {
        this.setByConstructor = setByConstructor;
    }

    public MyClass(int i, String setMyView){
        this.myView = setMyView;
    }
    public String getMyView(){
        return myView;
    }

    public void setMyView(String myView){
        this.myView = myView;
    }
}
