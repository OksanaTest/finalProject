package com.goit.finalProject.parser;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Parser {
    public Map<String, Long> boeingPlanOrderPrepare() throws Exception {
        try {
            JSONParser parser = new JSONParser();
            Object object = parser.parse(new FileReader("AirCraftOrder.json"));
            JSONArray jsonArray = (JSONArray) object;
            Map<String, Long> boeingPlanOrder = new HashMap<String, Long>();
            try {
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                    String name = (String) jsonObject.get("vendorName");
                    JSONArray order = (JSONArray) jsonObject.get("order");
                    if (name.equalsIgnoreCase("Boeing")) {
                        for (int j = 0; j < order.size(); j++) {
                            JSONObject jsonObject1 = (JSONObject) order.get(j);
                            if (((String) jsonObject1.get("aircraftType")).equalsIgnoreCase("Plane")) {
                                boeingPlanOrder.put((String) jsonObject1.get("aircraftName"),
                                        (Long) jsonObject1.get("quantity"));
                            }
                        }
                    }
                }
            } catch (IllegalArgumentException e) {
                System.err.println("The name you entered is not in the file.");
            }
            return boeingPlanOrder;
        } catch (IOException e) {
            System.err.println("The file you entered does not exost.");
        }
        return boeingPlanOrderPrepare();
    }

    public Map<String, Long> boeingHelicopterOrderPrepare() throws Exception {
        try {
            JSONParser parser = new JSONParser();
            Object object = parser.parse(new FileReader("AirCraftOrder.json"));
            JSONArray jsonArray = (JSONArray) object;
            Map<String, Long> boeingHelicopterOrder = new HashMap<String, Long>();
            try {
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                    String name = (String) jsonObject.get("vendorName");
                    JSONArray order = (JSONArray) jsonObject.get("order");
                    if (name.equalsIgnoreCase("Boeing")) {
                        for (int j = 0; j < order.size(); j++) {
                            JSONObject jsonObject1 = (JSONObject) order.get(j);
                            if (((String) jsonObject1.get("aircraftType")).equalsIgnoreCase("Helicopter")) {
                                boeingHelicopterOrder.put((String) jsonObject1.get("aircraftName"),
                                        (Long) jsonObject1.get("quantity"));
                            }
                        }
                    }
                }
            } catch (IllegalArgumentException e) {
                System.err.println("The name you entered is not in the file.");
            }
            return boeingHelicopterOrder;
        } catch (IOException e) {
            System.err.println("The file you entered does not exost.");
        }
        return boeingHelicopterOrderPrepare();
    }

    public Map<String, Long> boeingAerostatOrderPrepare() throws Exception {
        try {
            JSONParser parser = new JSONParser();
            Object object = parser.parse(new FileReader("AirCraftOrder.json"));
            JSONArray jsonArray = (JSONArray) object;
            Map<String, Long> boeingAerostatOrder = new HashMap<String, Long>();
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                String name = (String) jsonObject.get("vendorName");
                JSONArray order = (JSONArray) jsonObject.get("order");
                if (name.equalsIgnoreCase("Boeing")) {
                    for (int j = 0; j < order.size(); j++) {
                        JSONObject jsonObject1 = (JSONObject) order.get(j);
                        if (((String) jsonObject1.get("aircraftType")).equalsIgnoreCase("Aerostat")) {
                            boeingAerostatOrder.put((String) jsonObject1.get("aircraftName"),
                                    (Long) jsonObject1.get("quantity"));
                        }
                    }
                }
            }
            return boeingAerostatOrder;
        } catch (IOException e) {
            System.err.println("The file you entered does not exost.");
        }
        return boeingAerostatOrderPrepare();
    }

    public Map<String, Long> sikorskyPlanOrderPrepare() throws Exception {
        try {
            JSONParser parser = new JSONParser();
            Object object = parser.parse(new FileReader("AirCraftOrder.json"));
            JSONArray jsonArray = (JSONArray) object;
            Map<String, Long> sikorskyPlanOrder = new HashMap<String, Long>();
            try {
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                    String name = (String) jsonObject.get("vendorName");
                    JSONArray order = (JSONArray) jsonObject.get("order");
                    if (name.equalsIgnoreCase("Sikorsky")) {
                        for (int j = 0; j < order.size(); j++) {
                            JSONObject jsonObject1 = (JSONObject) order.get(j);
                            if (((String) jsonObject1.get("aircraftType")).equalsIgnoreCase("Plane")) {
                                sikorskyPlanOrder.put((String) jsonObject1.get("aircraftName"),
                                        (Long) jsonObject1.get("quantity"));
                            }
                        }
                    }
                }
            } catch (IllegalArgumentException e) {
                System.err.println("The name you entered is not in the file.");
            }
            return sikorskyPlanOrder;
        } catch (IOException e) {
            System.err.println("The file you entered does not exost.");
        }
        return sikorskyPlanOrderPrepare();
    }

    public Map<String, Long> sikorskyHelicopterOrderPrepare() throws Exception {
        try {
            JSONParser parser = new JSONParser();
            Object object = parser.parse(new FileReader("AirCraftOrder.json"));
            JSONArray jsonArray = (JSONArray) object;

            Map<String, Long> sikorskyHelicopterOrder = new HashMap<String, Long>();
            try {
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                    String name = (String) jsonObject.get("vendorName");
                    JSONArray order = (JSONArray) jsonObject.get("order");
                    if (name.equalsIgnoreCase("Sikorsky")) {
                        for (int j = 0; j < order.size(); j++) {
                            JSONObject jsonObject1 = (JSONObject) order.get(j);
                            if (((String) jsonObject1.get("aircraftType")).equalsIgnoreCase("Helicopter")) {
                                sikorskyHelicopterOrder.put((String) jsonObject1.get("aircraftName"),
                                        (Long) jsonObject1.get("quantity"));
                            }
                        }
                    }
                }
            } catch (IllegalArgumentException e) {
                System.err.println("The name you entered is not in the file.");
            }
            return sikorskyHelicopterOrder;
        } catch (IOException e) {
            System.err.println("The file you entered does not exost.");
        }
        return sikorskyHelicopterOrderPrepare();
    }
}