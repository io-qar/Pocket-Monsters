package internal.entity;

import java.util.Scanner;

import internal.service.SyntaxChecker;

public class Console {
	private Scanner scanner;
	private SyntaxChecker syntaxChecker;

	public Console() {
		scanner = new Scanner(System.in);
		syntaxChecker = new SyntaxChecker();
	}

	public String processCmd(String initMsg, String func) {
		System.out.print(initMsg);
		String input = scanner.nextLine();

		do {
			switch (func) {
				case "name":
					if (!syntaxChecker.isRightName(input)) {
						System.out.println("oops, check your command's syntax");
					} else {
						return input;
					}
					input = scanner.nextLine();	

					break;
				default:
					return "testName";
			}

		} while (input == "\n");

		return "test";
	}

}
