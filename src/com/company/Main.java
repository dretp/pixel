package com.company;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here

        String data = "NCHS_-_Death_rates_and_life_expectancy_at_birth.csv";

        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader reader = new BufferedReader(new FileReader(data))) {
            Map<String, List<String>> map = new TreeMap<String, List<String>>();
            String space = reader.readLine();//read header

            while ((line = reader.readLine()) != null) {

                String key = getField(space); // space gets the header of the field and you can use that header to Organize the data
                List<String> l = map.get(key);
                // use comma as separator
                String[] category = line.split(cvsSplitBy);

                System.out.println("Year [year= " + category[0] + " , Race=" + category[1] + "]" + "Sex [Sex= " + category[2] + " , avgLife=" + category[3] + "]" + " , deathRate=" + category[4] + "]");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }



        }
    private static String getField(String lines) {
        return lines.split(",")[0];// extract value you want to sort on
    }
    }


