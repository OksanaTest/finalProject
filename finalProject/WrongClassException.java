package com.goit.finalProject;


public class WrongClassException extends Exception{
    public WrongClassException() {
        System.out.println("The class you trying to implement cannot be found.");
    }
}
