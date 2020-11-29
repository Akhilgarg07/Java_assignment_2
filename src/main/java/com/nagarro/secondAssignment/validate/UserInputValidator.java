package com.nagarro.secondAssignment.validate;

import com.nagarro.secondAssignment.constants.Constants;
import com.nagarro.secondAssignment.entity.Flight;
import com.nagarro.secondAssignment.main.Main;

import java.text.ParseException;
import java.util.*;

public class UserInputValidator implements Constants {
    public static Date validateDate(String str) {
        dateformat.setLenient(false);
        Date date = null;
        try {
            date = dateformat.parse(str);
        } catch (ParseException e) {
            System.err.println("Date not in (dd-MM-yyyy)");
        }
        return date;
    }

    public static String validateSource(String src) {

        synchronized (Main.flights) {
            for (HashSet<Flight> flightSet : Main.flights.values()) {
                for (Flight f : flightSet) {
                    if (f.getDepLoc().equalsIgnoreCase(src))
                        return f.getDepLoc();
                }
            }
        }
        System.err.print("Flights from no such stations found, Kindly Enter Again: ");
        return null;
    }

    public static String validateDestination(String destination) {
        synchronized (Main.flights) {
            for (HashSet<Flight> flightSet : Main.flights.values()) {
                for (Flight f : flightSet) {
                    if (f.getArrLoc().equalsIgnoreCase(destination))
                        return f.getArrLoc();
                }
            }
        }
        System.err.print("Flights to no such stations found, Kindly Enter Again: ");
        return null;
    }

    public static String validateFlightClass(String str) {
        if (str.equalsIgnoreCase("E") || str.equalsIgnoreCase("EB")) {
            return str.toUpperCase();
        } else {
            System.err.println("flight class entered wrong: ");
            return null;
        }
    }

    public static int validateOutputPreference(int i) {
        if ((i == 1) || (i == 2))
            return i;
        else {
            System.err.print("Output preference entered Inappropriately, Enter Again : ");
            return 0;
        }
    }
}
