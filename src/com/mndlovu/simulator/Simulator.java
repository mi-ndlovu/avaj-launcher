package com.mndlovu.simulator;

import com.mndlovu.exception.InvalidFileFormatException;
import com.mndlovu.vehicles.AircraftFactory;
import com.mndlovu.vehicles.Flyable;

import java.io.*;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author mndlovu
 * @since 13-06-2018
 */

public class Simulator {

    private final static File fileName = createAFile("simulation.txt");

    public static File getFileName() {
        return fileName;
    }

    /** clear a text inside a file */
    private static void clearAFile(File file) {
            try (BufferedWriter output = new BufferedWriter(new FileWriter(file))) {
                output.write("");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
    }

    /** write a message to a given fine */
    public static void writeToAFile(String message, File file) {
        try (BufferedWriter output = new BufferedWriter(new FileWriter(file, true))) {
            output.write(message);
            output.newLine();
        } catch( IOException e) {
            System.out.printf("Failed to write to [ %s ] file\n", file);
        }
    }

    /**
     * reads a file.
     * @throws InvalidFileFormatException - bonus part.
     */
    private static void readAFile(String file) throws InvalidFileFormatException {
        AircraftFactory aircraftFactory = new AircraftFactory();
        WeatherTower weatherTower = new WeatherTower() ;
        int i = 0;
        int num = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String getAline;
            /* checks whether a file is empty or not.*/
            if (!br.ready())
                System.out.println("The file you provided is empty");
            while((getAline = br.readLine()) != null) {
                if (i == 0) {
                    try {
                        num = Integer.parseInt(getAline);
                    } catch (NumberFormatException e) {
                        System.out.println(String.format("[%s] - is not a number. [%s]", getAline, file));
                    }
                    i++;
                } else {
                    String[] line = getAline.split(" ");
                    if (line.length == 5) {
                        try {
                            Flyable flyable = aircraftFactory.newAircraft(line[0], line[1],Integer.parseInt(line[2]),
                                Integer.parseInt(line[3]), Integer.parseInt(line[4]));
                            flyable.registerTower(weatherTower);
                        } catch(NumberFormatException e) {
                            System.out.println(e.getMessage());
                        }
                        
                    } else
                        throw new InvalidFileFormatException(" - Has invalid Format.");
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        for (int j = 0; j < num; j++)
            weatherTower.changeWeather();
    }

    /** Create a single file. */
    private static File createAFile(String filename) {
        File file = new File(filename);
        clearAFile(file);
        return file;
    }

    public static void main(String[] args) {

       if (args.length != 1) {
           System.out.println("Please provide a single file as an argument.");
           System.exit(0);
       }
       try {
           readAFile(args[0]);
       } catch (InvalidFileFormatException e) {
           System.out.println(args[0] + e.getMessage());
       }
    }
}
