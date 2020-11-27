package com.nagarro.secondAssignment.comparator;

import com.nagarro.secondAssignment.entity.Flight;

import java.util.Comparator;

public class FlightDurationComparator implements Comparator<Flight> {

    public int compare(Flight arg0, Flight arg1) {
        double x = arg0.getFlightDur() - arg1.getFlightDur();
        if (x < 0) {
            return -1;
        } else if (x > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
