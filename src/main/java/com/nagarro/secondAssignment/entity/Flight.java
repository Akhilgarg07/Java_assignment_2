package com.nagarro.secondAssignment.entity;

import com.nagarro.secondAssignment.constants.Constants;

import java.util.Date;

public class Flight  implements Constants{




    public String getFlightNo() {
        return flightNo;
    }

    public String getDepLoc() {
        return depLoc;
    }

    public String getArrLoc() {
        return arrLoc;
    }

    public Date getDate() {
        return date;
    }

    public String getFlightTime() {
        return flightTime;
    }

    public double getFlightDur() {
        return flightDuration;
    }

    public int getFare() {
        return fare;
    }

    public boolean isSeatAvailable() {
        return seatAvailable;
    }

    public String getFlightType() {
        return flightType;
    }

    private String flightNo;
    private String depLoc;
    private String arrLoc;
    private Date date;
    private String flightTime;
    private double flightDuration;
    private int fare;
    private boolean seatAvailable;
    private String flightType;

    public Flight(String flightNo, String depLoc, String arrLoc, int fare,
                  Date date, String flightTime, Double flightDuration,
                  boolean seatAvailable, String flightType) {
        super();
        this.flightNo = flightNo;
        this.depLoc = depLoc;
        this.arrLoc = arrLoc;
        this.date = date;
        this.flightTime = flightTime;
        this.flightDuration = flightDuration;
        this.seatAvailable = seatAvailable;
        this.flightType = flightType;
        if (flightType.equalsIgnoreCase("EB"))
            fare = 140 * fare / 100;
        this.fare = fare;
    }

    @Override
    public String toString() {
        return "flightNo=" + flightNo + ", depLoc=" + depLoc
                + ", arrLoc=" + arrLoc + ", validTill=" + dateformat.format(date)
                + ", flightTime=" + flightTime + ", flightDuration="
                + String.format("%.2f", flightDuration) + ", fare=" + fare + ", seatAvailability="
                + seatAvailable + ", flightClass=" + flightType;
    }


}

