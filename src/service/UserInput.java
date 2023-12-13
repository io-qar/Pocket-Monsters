package service;

import java.util.Map;
import java.util.Scanner;

import entity.Player;
import service.commands.*;

public class UserInput {
    private Scanner scanner;

    public UserInput() {
        this.scanner = new Scanner(System.in);
    }

    // examples of how to use this class
    public static void main(String[] args) {
        UserInput ui = new UserInput();
        int restrictedAge = ui.constrainedInteger("Please provide age (80 - 90):", "Please provide int between 80 and 90", 80, 90);
        System.out.println("Your age is: " + restrictedAge);
        int myAge = ui.integer("Please provide your age: ", "Please provide an int");
        System.out.println("your age is " + myAge);
    }

    public int constrainedInteger(String userInformation, String errorInformation, int min, int max) {
        int constrainedIntegerInput = integer(userInformation, errorInformation);
        while((constrainedIntegerInput < min) || (constrainedIntegerInput > max)) {
            constrainedIntegerInput = integer(userInformation, errorInformation);
        }
        return constrainedIntegerInput;
    }

    public int integer(String userInformation, String errorInformation) {
        System.out.println(userInformation);
        while(!scanner.hasNextInt()) {
            System.out.println(errorInformation);
            // skip entire line
            this.scanner.nextLine();
        }
        return this.scanner.nextInt();
    }

    public String string(String userInformation, String errorInformation) {
        if (!userInformation.isEmpty()) {
            System.out.println(userInformation);
        }
        while(!scanner.hasNext()) {
            System.out.println(errorInformation);
            // skip entire line
            this.scanner.nextLine();
        }
        return this.scanner.next();
    }

    public Command command(Player player, Map<String, Command> commands) {
        System.out.printf("%s@%s: ", player.getName(), player.getLocationName());
        String userInput = string("", "Please enter a valid command.");
        while (!commands.containsKey(userInput)) {
            System.out.printf("\"%s\" is not a valid command. Please try again.\n", userInput);
            return null;
        }

        // return requested command
        return commands.getOrDefault(userInput, null);
    }
}