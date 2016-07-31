package com.goit.finalProject;

import com.goit.finalProject.parser.Parser;

import java.io.FileNotFoundException;
import java.util.*;

public class Fleet {
    private BoeingAircraftCreationFactory boeingAircraftCreationFactory;
    private SikorskyAircraftCreationFactory sikorskyAircraftCreationFactory;
    public  List<Plane>  createAllBoeingPlanOrder() throws Exception{
        boeingAircraftCreationFactory = new BoeingAircraftCreationFactory();
        List<Plane> planeList = new ArrayList<Plane>();
        try {
            Parser parserAgain = new Parser();

            for (Object o : parserAgain.boeingPlanOrderPrepare().entrySet()) {
                Map.Entry entry = (Map.Entry) o;
                planeList.addAll(boeingAircraftCreationFactory.createPlane
                        (entry.getKey().toString(), Integer.parseInt(entry.getValue().toString())));
            }//create List<List<Plane>> list of all boeing plan in the order
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
            return planeList;
    }
    public  List<Helicopter> createAllBoeingHelicopterOrder() throws Exception{

        boeingAircraftCreationFactory = new BoeingAircraftCreationFactory();
        List<Helicopter> helicopterList = new ArrayList<Helicopter>();

        try {
            Parser parserAgain = new Parser();
            for (Object o : parserAgain.boeingHelicopterOrderPrepare().entrySet()) {
                Map.Entry entry = (Map.Entry) o;
                helicopterList.addAll(boeingAircraftCreationFactory.
                        createHelicopter(entry.getKey().toString(), Integer.parseInt(entry.getValue().toString())));
            }
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
        return helicopterList;
    }
    public  List<Aerostat> createAllBoeingAerostat() throws Exception{

        boeingAircraftCreationFactory = new BoeingAircraftCreationFactory();
        List<Aerostat> aerostatList = new ArrayList<Aerostat>();

        try {
            Parser parserAgain = new Parser();
            for (Object o : parserAgain.boeingAerostatOrderPrepare().entrySet()) {
                Map.Entry entry = (Map.Entry) o;
                aerostatList.addAll(boeingAircraftCreationFactory.
                        crateAerostat(entry.getKey().toString(), Integer.parseInt(entry.getValue().toString())));
            }
        } catch (FileNotFoundException e){
            e.getMessage();
        }
        return aerostatList;
    }
    public  List<Plane> createAllSikorskyPlanOrder() throws Exception{

        sikorskyAircraftCreationFactory =
                new SikorskyAircraftCreationFactory();
        List<Plane> planeList = new ArrayList<Plane>();

        try {
            Parser parserAgain = new Parser();
            for (Object o : parserAgain.sikorskyPlanOrderPrepare().entrySet()) {
                Map.Entry entry = (Map.Entry) o;
                planeList.addAll(sikorskyAircraftCreationFactory.
                        createPlane(entry.getKey().toString(), Integer.parseInt(entry.getValue().toString())));
            }
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
        return planeList;
    }
    public  List<Helicopter> createAllSikorskyHelicopterOrder() throws Exception{

        sikorskyAircraftCreationFactory = new SikorskyAircraftCreationFactory();
        List<Helicopter> helicopterList= new ArrayList<Helicopter>();

        try {
            Parser parserAgain = new Parser();
            for (Object o : parserAgain.sikorskyHelicopterOrderPrepare().entrySet()) {
                Map.Entry entry = (Map.Entry) o;
                helicopterList.addAll(sikorskyAircraftCreationFactory.
                        createHelicopter(entry.getKey().toString(), Integer.parseInt(entry.getValue().toString())));
            }
        } catch (FileNotFoundException e){
            e.getMessage();
        }
        return helicopterList;
    }

    public  List<Aircraft> commonFleet() throws Exception{
        List<Plane> planeList, planeListSikorsky;
        List<Helicopter> boeingHelicopterList, sikorskyHelicopterList;
        List<Aerostat> boeingAerostatList;
        List<Aircraft> aircraftList = new ArrayList<Aircraft>();

        planeList = createAllBoeingPlanOrder();
        planeListSikorsky = createAllSikorskyPlanOrder();
        boeingHelicopterList = createAllBoeingHelicopterOrder();
        sikorskyHelicopterList = createAllSikorskyHelicopterOrder();
        boeingAerostatList = createAllBoeingAerostat();

        try {
            aircraftList.addAll(planeList);
            aircraftList.addAll(planeListSikorsky);
            aircraftList.addAll(boeingHelicopterList);
            aircraftList.addAll(boeingAerostatList);
            aircraftList.addAll(sikorskyHelicopterList);
        } catch (ArrayStoreException ex) {
            ex.getMessage();
        }
        return aircraftList;
    }
    public  List<Plane> allPlanes() throws Exception, ArrayStoreException {
        List<Plane> aircraftList = new ArrayList<Plane>();
            aircraftList.addAll(createAllBoeingPlanOrder());
            aircraftList.addAll(createAllSikorskyPlanOrder());
        return aircraftList;
    }
    public  List<Plane> planesSortedByFlyingRange() throws Exception{
        List<Plane> aircraftList = allPlanes();
        try {
            Collections.sort(aircraftList, new FleetComparator());
        } catch (ArrayStoreException ex) {
            ex.getMessage();
        }
        return aircraftList;
    }

    public  Integer summarySeatingCapacity() throws Exception{
        int summarySeatingCapacity = 0;
        try {
            for (int i = 0; i < commonFleet().size(); i++) {
                summarySeatingCapacity += commonFleet().get(i).getSeatingCapacity();
            }
        } catch (ComparatorException exe) {
            exe.getMessage();
        }
        return summarySeatingCapacity;
    }

    public  Integer summaryWeightLift() throws Exception{
        int summaryWeightLift = 0;
        try {
            for (int i = 0; i < commonFleet().size(); i++) {
                summaryWeightLift += commonFleet().get(i).getWeightLift();
            }
        } catch (ComparatorException exe) {
            exe.getMessage();
        }
        return summaryWeightLift;
    }

    public  List<Plane> findPlaneByFuelEndurance(int a, int b) throws Exception{
        List<Plane> planeList = allPlanes();
        List<Plane> planes = new ArrayList<Plane>();
        for (Plane aPlaneList : planeList) {
            if (aPlaneList.getFuelEndurance() > a && aPlaneList.getFuelEndurance() < b) {
                planes.add(aPlaneList);
            }
        }
        return planes;
    }
}