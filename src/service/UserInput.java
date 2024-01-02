package service;

import entity.Player;
import service.commands.Command;

import java.util.Map;
import java.util.Scanner;

/**
 * {@code UserInput} class owns commands input functionality
 */
public class UserInput {
    private Scanner scanner;

    public UserInput() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Prompts the user to enter an integer using the numbered list from {@code min} to {@code max}
     * @param userInformation An input message
     * @param errorInformation An error message in case of the incorrect entry
     * @param min A lower limit of the selected command in the list
     * @param max A higher limit of the selected command in the list
     * @return The number of the selected command
     */
    public int readConstrainedInteger(String userInformation, String errorInformation, int min, int max) {
        int constrainedIntegerInput = readInteger(userInformation, errorInformation);
        while ((constrainedIntegerInput < min) || (constrainedIntegerInput > max)) {
            constrainedIntegerInput = readInteger(userInformation, errorInformation);
        }
        return constrainedIntegerInput;
    }

    /**
     * Prompts the user to enter an integer
     * @param userInformation An input message
     * @param errorInformation An error message in case of the incorrect entry
     * @return An integer
     */
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
     * Prompts the user to enter a single word
     * @param userInformation An input message
     * @param errorInformation An error message in case of the incorrect entry
     * @return The first word entered by the user
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
     * Prompts the user to enter a string
     * @param userInformation An input message
     * @param errorInformation An error message in case of the incorrect entry
     * @return The string entered by the user
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

    /**
     * Checks if the entered command is correct
     * @param player An instance of a player
     * @param commands A map of game commands
     * @return Requested command
     */
    public Command command(Player player, Map<String, Command> commands) {
        System.out.printf("%s@%s: ", player.getName(), player.getCurrentLocation().getName());
        String userInput = readLine("", "Please enter a valid command.");
        String[] words = userInput.split(" ", 2);
        if (!commands.containsKey(words[0].toLowerCase())) {
            System.out.printf("\"%s\" is not a valid command. Please try again.\n", words[0]);
            return command(player, commands);
        }
        Command requestedCommand = commands.get(words[0].toLowerCase());

        // check if command requires an argument (e.g. take)
        if (requestedCommand.isRequiresArgument()) {
            if (words.length <= 1) {
                System.out.println("Correct syntax is: \""+ requestedCommand.getName() + " [name]\". Please try again.");
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
        return requestedCommand;
    }
}