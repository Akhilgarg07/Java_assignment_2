package com.nagarro.secondAssignment.input;

import com.nagarro.secondAssignment.constants.Constants;
import com.nagarro.secondAssignment.entity.UserInput;
import com.nagarro.secondAssignment.validate.UserInputValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class InputAccept  implements Constants {
    public static UserInput enterInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String source;
        String destination;
        String flightClass;
        int outputPreference;
        Date flightDate = null;

        System.out.println("Departure Location: ");
        while ((source = UserInputValidator.validateSource(br.readLine())) == null)
            continue;
        System.out.println("Arrival Location: ");
        while ((destination = UserInputValidator.validateDestination(br.readLine())) == null)
            continue;
        System.out.println("Flight Class: ");
        while ((flightClass = UserInputValidator.validateFlightClass(br.readLine())) == null) {
            continue;
        }

        System.out.println("Enter Date DD-MM-YYYY: ");
        while ((flightDate = UserInputValidator.validateDate(br.readLine())) == null) {
            continue;
        }
        System.out.print("Output preference(Sort by Fare/Duration)):\n(Enter 1/2): ");
        while ((outputPreference = UserInputValidator
                .validateOutputPreference(Integer.parseInt(br.readLine()))) == 0) {
            continue;
        }
        return new UserInput(source, destination, flightDate,
                flightClass, outputPreference);

    }
}
