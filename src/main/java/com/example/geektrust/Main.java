package com.example.geektrust;

import Entities.CommandParser;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        CommandParser commandParser = new CommandParser(args[0]);
        commandParser.generateApartmentBill();
	}
}
