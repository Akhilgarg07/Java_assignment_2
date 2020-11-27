package com.nagarro.secondAssignment.comparator;

import com.nagarro.secondAssignment.entity.Flight;

import java.util.Comparator;

public class FlightPriceComparator implements Comparator<Flight> {
    public int compare(Flight arg0, Flight arg1) {
        return arg0.getFare() - arg1.getFare();
    }
}
