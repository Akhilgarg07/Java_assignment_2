package com.nagarro.secondAssignment.entity;

import com.nagarro.secondAssignment.constants.Constants;


import java.util.Date;

public class UserInput implements Constants {
    String depLoc;
    String arrLoc;
    Date flightDate;
    String flightClass;
    int outputPreference;

    public UserInput(String depLoc, String arrLoc, Date flightDate, String flightClass, int outputPreference) {
        super();
        this.depLoc = depLoc;
        this.arrLoc = arrLoc;
        this.flightDate = flightDate;
        this.flightClass = flightClass;
        this.outputPreference = outputPreference;
    }

    public String getDepLoc() {
        return depLoc;
    }

    public String getArrLoc() {
        return arrLoc;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public String getFlightClass() {
        return flightClass;
    }

    public int getOutputPreference() {
        return outputPreference;
    }

}
