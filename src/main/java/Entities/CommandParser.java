package Entities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CommandParser {

    String filePath;
    boolean isFirstCommand;
    private List<String> commandsAllowed;
    Apartment apt;

    public CommandParser(String path) {
        this.filePath = path;
        isFirstCommand = true;
        commandsAllowed = new ArrayList<>();
        commandsAllowed.addAll(Arrays.asList("ALLOT_WATER", "ADD_GUESTS", "BILL"));
    }

    private boolean isValidFirstCommand(String cmd){
        if(isFirstCommand && cmd.equals("ALLOT_WATER")){
            isFirstCommand = false;
            return true;
        }
        return false;
    }

    private boolean isLastCommand(String cmd){
        return cmd.equals("BILL");
    }

    private boolean checkIfValidCommand(String cmd) {
        if(isFirstCommand && !isValidFirstCommand(cmd)){
            System.out.println("First command Should be ALLOT_WATER." +
                    "Please Enter Valid Command");
            return false;
        }
        if(!commandsAllowed.contains(cmd)) {
            System.out.println("Incorrect Command. Please Enter Valid Command");
            return false;
        }
        return true;
    }

    private String getCommand(String line){
        String words[] = line.split(" ");
        return words[0];
    }

    private void checkAndAllotWater(String line){
        String words[] = line.split(" ");
        if(words.length != 3){
            System.out.println("Invalid ALLOT_WATER Command");
            return;
        }
        else {
            ApartmentType aptType = words[1].equals("2") ? ApartmentType.TWO_BHK :
                    ApartmentType.THREE_BHK;
            String ratios[] = words[2].split(":");
            apt = Apartment.getInstance(aptType,Integer.parseInt(ratios[0]),
                    Integer.parseInt(ratios[1]));
        }
    }

    private void checkAndAllotGuests(String line) {
        String words[] = line.split(" ");
        if(words.length != 2 || apt == null) {
            System.out.println("Invalid ALLOT_GUESTS command");
            return;
        }
        apt.addGuests(Integer.parseInt(words[1]));
    }

    public void generateApartmentBill() throws FileNotFoundException {
        Scanner sc = new Scanner(new File(filePath));
        String line = sc.nextLine();
        while(!isLastCommand(getCommand(line))) {
            String cmd = getCommand(line);
            if(checkIfValidCommand(cmd)) {
                switch(cmd) {
                    case "ALLOT_WATER" :
                        checkAndAllotWater(line);
                        break;
                    case "ADD_GUESTS" :
                        checkAndAllotGuests(line);
                        break;
                }
            }
            line = sc.nextLine();
        }
        if(apt != null) {
            apt.generateBill();
        } else {
            System.out.println("Wrong input! Please allot water first!");
        }
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Apartment getApt() {
        return apt;
    }

    public void setApt(Apartment apt) {
        this.apt = apt;
    }
}
