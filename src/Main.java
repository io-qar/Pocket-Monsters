import java.util.Scanner;

import internal.entity.Console;
import internal.service.Game;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		Game game = new Game();
		
		do {
			displayMenu();
			if (scanner.hasNextInt()) {
				switch (scanner.nextInt()) {
				case 1:
					System.out.println("You picked option \"Start a game\". Starting a new game...");
					
					game.create();
					game.start();

					Console console = new Console();
					console.processCmd();

					break;
				case 2:
					System.out.println("You picked option \"Exit the game.\". Exiting...");
					game.stop();
					flag = false;
					break;
				default:
					System.err.println("\nYou entered an unknown command. Please try again:");
					break;
				}
			} else {
				scanner.nextLine();
				System.err.println("\nYou entered an invalid command. Please try again:\n");
			}
		} while (flag);

		System.out.println("Exited");
	}

	public static void displayMenu() {
		System.out.println("1) Start a game!\n2) Exit the game.\n");
	}
}
