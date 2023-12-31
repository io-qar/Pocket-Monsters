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

    public int readConstrainedInteger(String userInformation, String errorInformation, int min, int max) {
        int constrainedIntegerInput = readInteger(userInformation, errorInformation);
        while ((constrainedIntegerInput < min) || (constrainedIntegerInput > max)) {
            constrainedIntegerInput = readInteger(userInformation, errorInformation);
        }
        return constrainedIntegerInput;
    }

    public int readInteger(String userInformation, String errorInformation) {
        System.out.println(userInformation);
        while (!scanner.hasNextInt()) {
            System.out.println(errorInformation);
            // skip entire line
            this.scanner.nextLine();
        }
        int providedInt = this.scanner.nextInt();
        // skip rest of line
        this.scanner.nextLine();
        return providedInt;
    }

    /**
     * @param userInformation
     * @param errorInformation
     * @return the first word the user provided
     */
    public String readWord(String userInformation, String errorInformation) {
        if (!userInformation.isEmpty()) {
            System.out.println(userInformation);
        }
        while (!scanner.hasNext()) {
            System.out.println(errorInformation);
            // skip entire line
            this.scanner.nextLine();
        }
        String word = this.scanner.next();
        // skip rest of line
        this.scanner.nextLine();
        // return only the first word
        return word;
    }

    /**
     * @param userInformation
     * @param errorInformation
     * @return the whole line
     */
    public String readLine(String userInformation, String errorInformation) {
        if (!userInformation.isEmpty()) {
            System.out.println(userInformation);
        }
        while (!scanner.hasNext()) {
            System.out.println(errorInformation);
            // skip entire line
            this.scanner.nextLine();
        }
        return this.scanner.nextLine();
    }

    public Command command(Player player, Map<String, Command> commands) {
        System.out.printf("%s@%s: ", player.getName(), player.getCurrentLocation().getName());
        String userInput = readLine("", "Please enter a valid command.");
        String[] words = userInput.split(" ");
        if (!commands.containsKey(words[0].toLowerCase())) {
            System.out.printf("\"%s\" is not a valid command. Please try again.\n", words[0]);
            return command(player, commands);
        }
        Command requestedCommand = commands.get(words[0].toLowerCase());

        // check if command requires an argument (e.g. take)
        if (requestedCommand.isRequiresArgument()) {
            if (words.length <= 1) {
                System.out.println("Correct syntax is: \""+ requestedCommand.getName() + " [argument]\". Please try again.");
                return command(player, commands);
            } else {
                String argument = words[1];
                requestedCommand.setArgument(argument);
                // return requested command
                return requestedCommand;
            }
        }
        // command doesn't need any extra arguments
        if (words.length > 1) {
            System.out.println("\"" + requestedCommand.getName() + "\" doesn't require any arguments");
            return command(player, commands);
        }
        // return requested command
        return requestedCommand;
    }
}