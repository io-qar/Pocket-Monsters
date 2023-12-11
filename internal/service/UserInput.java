package internal.service;

import java.util.ArrayList;
import java.util.Scanner;

import internal.entity.Player;
import internal.entity.Location.East;
import internal.entity.Location.North;
import internal.entity.Location.South;
import internal.entity.Location.West;

import java.util.List;

public class UserInput {
    private Scanner scanner;

    List<Command> commands;

    public UserInput() {
        this.scanner = new Scanner(System.in);
        this.commands = new ArrayList<>();
        // add commands here!
        addCommand(new North());
        addCommand(new Exit());
        addCommand(new East());
        addCommand(new South());
        addCommand(new West());
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

    public Command command(Player player) {
        System.out.printf("%s@PalletTown: ", player.getName());
        String userInput = string("", "Please enter a valid command.");
        String finalUserInput = userInput;
        while (this.commands.stream().noneMatch(cmd -> cmd.getName().equals(finalUserInput))) {
            System.out.printf("%s@PalletTown: ", player.getName());
            userInput = string("", "Please enter a valid command.");
        }
        // return requested command
        String finalUserInput1 = userInput;
        return this.commands.stream().filter(cmd -> cmd.getName().equals(finalUserInput1)).findFirst().orElse(null);
    }

    public void addCommand(Command command) {
        this.commands.add(command);
    }

}