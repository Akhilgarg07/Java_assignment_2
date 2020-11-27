package com.nagarro.secondAssignment.main;

import com.nagarro.secondAssignment.comparator.FlightPriceComparator;
import com.nagarro.secondAssignment.entity.Flight;
import com.nagarro.secondAssignment.entity.UserInput;
import com.nagarro.secondAssignment.input.InputAccept;
import com.nagarro.secondAssignment.services.Watcher;

import java.io.*;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    public static HashMap<String, HashSet<Flight>> flights = new HashMap<>();

    //services --> watcher
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Flight> result = new ArrayList<>();
        String choice = null;
        UserInput userInput;

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(new Watcher(), 0, 3, TimeUnit.SECONDS);


        do {
            userInput = InputAccept.enterInput();
            result.clear();
            synchronized (Main.flights) {
                for (HashSet<Flight> set : flights.values()) {
                    for (Flight f : set) {
                        if ((f.getArrLoc().equalsIgnoreCase(userInput.getArrLoc()))
                                && (f.getDepLoc().equalsIgnoreCase((userInput.getDepLoc())))
                                && (f.getFlightType().equalsIgnoreCase(userInput.getFlightClass()))
                                && (userInput.getFlightDate().compareTo(f.getDate()) <= 0)
                                && (f.isSeatAvailable())) {
                            result.add(f);
                        }


                    }
                }
            }
            if (userInput.getOutputPreference() == 1) {
                Collections.sort(result, new FlightPriceComparator());
            } else {
                Collections.sort(result, new FlightPriceComparator());
            }
            System.out.println("\nResult:");
            for (Flight f : result) {
                System.out.println(f);
            }
            System.out.print("\nWant to Exit (Enter Y/N)");
            while (!((choice = br.readLine()).equalsIgnoreCase("y") || choice.equalsIgnoreCase("n")))
                System.out.print("I could not Understand Enter Again:");
        } while (choice.equalsIgnoreCase("n"));
        service.shutdown();

    }
}
