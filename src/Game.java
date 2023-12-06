import java.util.Scanner;

public class Game {
    private boolean inProgress = false;
    // might need map and player as instance variables? maybe not?
    private Scanner scanner = new Scanner(System.in);
    private Map map;
    private Player player;

    public void create() {
        // create game
        // could ask user for size of map. could randomize locations...
        Map map = new Map(4, 4);
        giveIntroduction();

    }
    public void start() {
        inProgress = true;
        while (inProgress) {


            // if player has 0 pokemons -> inProgress = false
            // if player chooses exit -> inProgress = false
        }
    }

    public void stop() {
        // may need to be static if want to call from anywhere?
        // may not need this method actually...
        inProgress = false;
    }

    public void giveIntroduction() {
        // credit: https://www.asciiart.eu/video-games/pokemon
        /*System.out.println("                                  ,'\\\n" +
                "    _.----.        ____         ,'  _\\   ___    ___     ____\n" +
                "_,-'       `.     |    |  /`.   \\,-'    |   \\  /   |   |    \\  |`.\n" +
                "\\      __    \\    '-.  | /   `.  ___    |    \\/    |   '-.   \\ |  |\n" +
                " \\.    \\ \\   |  __  |  |/    ,','_  `.  |          | __  |    \\|  |\n" +
                "   \\    \\/   /,' _`.|      ,' / / / /   |          ,' _`.|     |  |\n" +
                "    \\     ,-'/  /   \\    ,'   | \\/ / ,`.|         /  /   \\  |     |\n" +
                "     \\    \\ |   \\_/  |   `-.  \\    `'  /|  |    ||   \\_/  | |\\    |\n" +
                "      \\    \\ \\      /       `-.`.___,-' |  |\\  /| \\      /  | |   |\n" +
                "       \\    \\ `.__,'|  |`-._    `|      |__| \\/ |  `.__,'|  | |   |\n" +
                "        \\_.-'       |__|    `-._ |              '-.|     '-.| |   |\n" +
                "                                `'                            '-._|");*/
        System.out.println("Welcome to Pallet Town! My name is Professor Oak. What's yours?");
        while (!scanner.hasNext()) {
            System.out.println("Please enter a valid name.");
            scanner.nextLine();
        }
        String name = scanner.next();
        this.player = new Player(name);
        System.out.printf("Hi %s!\n", name);
        scanner.nextLine();
        System.out.print("To begin your adventure you will need at least one Pokémon.");
        scanner.nextLine();
        System.out.println("Please choose one of the follow Pokémon:\n1) Bulbasaur\n2) Charmander\n3) Squirtle");
        while (!scanner.hasNextInt()) {
                System.out.println("Please enter a number between 1 and 3.");
                scanner.nextLine();
        }
        int choice = scanner.nextInt();
        String pokemonName = "";
        switch (choice) {
            case 1:
                pokemonName = "Bulbasaur";
                break;
            case 2:
                pokemonName = "Charmander";
                break;
            case 3:
                pokemonName = "Squirtle";
                break;
        }

        // add pokemon to inventory here
        System.out.printf("You picked %s.\n", pokemonName);
        System.out.println("Great choice! Now go out there and explore the world! \nIf at any point you are unsure what to do, simply call the \"help\" command.");
    }
}
