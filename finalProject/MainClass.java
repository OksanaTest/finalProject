package com.goit.finalProject;

public class MainClass {
    public static void main(String[] args) throws Exception {
       try {
           Controller controller = new Controller();
           controller.controller();
       } catch (WrongClassException e){
           e.getMessage();
       }
    }
}

