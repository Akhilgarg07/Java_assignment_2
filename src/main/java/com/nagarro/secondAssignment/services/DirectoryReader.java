package com.nagarro.secondAssignment.services;

import com.nagarro.secondAssignment.constants.Constants;
import com.nagarro.secondAssignment.entity.Flight;
import com.nagarro.secondAssignment.main.Main;

import java.io.*;
import java.text.ParseException;
import java.util.*;

public class DirectoryReader implements Constants {

    public static HashSet<Flight> readFile(File file) {
        BufferedReader reader = null;
        HashSet<Flight> flight_Set = new HashSet<Flight>();
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            line = reader.readLine();

            while (line != null) {
                Flight f = manipulateLine(line);
                line = reader.readLine();
                flight_Set.add(f);
            }
        } catch (Exception e) {
            System.err.println("Could Not Read the File");
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    System.err.println("Could Not Close the File");
                }
            }
        }
        return flight_Set;
    }

    private static Flight manipulateLine(String line) {

        StringTokenizer st = new StringTokenizer(line, "|");

        String flightNo = st.nextToken();
        String depLoc = st.nextToken();
        String arrLoc = st.nextToken();

        String validTillDate = st.nextToken();
        Date validTill = new Date();
        try {
            validTill = dateformat.parse(validTillDate);
        } catch (ParseException e) {
            System.err.print("Date not in appropriate(dd-MM-yyyy) format");
        }

        String flightTime = st.nextToken();
        Double flightDuration = Double.parseDouble(st.nextToken());
        int fare = Integer.parseInt(st.nextToken());

        String avail = st.nextToken();
        Boolean seatAvailability;
        seatAvailability = avail.charAt(0) == 'Y';

        String flightType = st.nextToken();

        return new Flight(flightNo, depLoc, arrLoc, fare, validTill,
                flightTime, flightDuration, seatAvailability, flightType);
    }
}




