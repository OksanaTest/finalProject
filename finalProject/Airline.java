package com.goit.finalProject;


import java.util.ArrayList;
import java.util.List;

public class Airline {
    private List<Fleet> aircraftList = new ArrayList<Fleet>();

    private void airline() throws Exception {
        try {
            Fleet fleet = new Fleet();
            fleet.commonFleet();
        } catch (WrongClassException e) {
            e.getMessage();
        }
    }
}