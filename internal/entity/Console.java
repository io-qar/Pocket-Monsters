package internal.entity;

import java.util.Scanner;

import internal.service.Set;

public class Console {
	private String command;
	private Scanner scanner;
	private Set wordsSet;

	public Console() {
		scanner = new Scanner(System.in);
		wordsSet = new Set();
	}

	public void processCmd() {
		System.out.print("Enter your command: ");
		String input = scanner.nextLine();

		do {
			if (isRightSyntax(input))	{
				System.out.println("doing sth");
			} else System.out.println("oops, check your command's syntax");

			input = scanner.nextLine();
		} while (input == "\n");		
	}

	public boolean isRightSyntax(String command) {
		String[] words = {};
		words = command.split(" ");

		// checking right commannd syntax: a verb + a noun...
		if (!(wordsSet.verbSet.contains(words[0]) || wordsSet.nounsSet.contains(words[1]))) {
			return false;
		}

		return true;
	}
}
