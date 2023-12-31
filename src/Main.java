import service.Game;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		Game game;

		do {
			displayMenu();
			if (scanner.hasNextInt()) {
				game = new Game();
				switch (scanner.nextInt()) {
				case 1:
					System.out.println("You picked option \"Start a game\". Starting a new game...");
					game.start();
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

		scanner.close();
		System.out.println("Exited");
	}

	private static void displayMenu() {
		System.out.println("1) Start a game!\n2) Exit the game.\n");
	}
}
