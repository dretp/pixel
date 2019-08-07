package com.company;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here

        String data = "C:/Users/drepr/Downloads/pixel/NCHS.csv";

        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(data))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] category = line.split(cvsSplitBy);

                System.out.println("Year [year= " + category[0] + " , Race=" + category[1] + "]" + "Sex [Sex= " + category[2] + " , avgLife=" + category[3] + "]" + " , deathRate=" + category[4] + "]");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        }
    }


