package service;

import entity.Player;
import entity.Pokemon;
import service.commands.Command;
import service.commands.battle.Attack;
import service.commands.battle.Cheat;
import service.commands.battle.Run;
import service.commands.game.*;

import java.util.HashMap;

public class Battle {
    /**
     * Represents commands which are used during the battle
     */
    HashMap<String, Command> commands;
    private UserInput ui = new UserInput();
    private Player player;

    /**
     * Represents the current Player's Pokémon
     */
    private Pokemon ownPokemon;

    /**
     * the Pokémon you are fighting against
     */
    private Pokemon enemyPokemon;
    private boolean inProgress = false;

    public Battle(Player player, Pokemon enemy, boolean isGymBattle) {
        this.player = player;
        this.ownPokemon = player.getActivePokemon();
        this.enemyPokemon = enemy;

        commands = new HashMap<>();
        // add battle commands here!
        addCommand(new Attack(this, true));
        addCommand(new Switch(player, this));
        addCommand(new Run(this, isGymBattle)); // could also not add run cmd based on isGymBattle
        addCommand(new Help(commands, true));
        addCommand(new Pokemons(player));
        addCommand(new Inventory(player));
        addCommand(new Use(player, enemyPokemon, this, isGymBattle));
        // cheat command which lets you instantly defeat the enemy
        // addCommand(new Cheat(this));
    }

    public Pokemon getOwnPokemon() {
        return ownPokemon;
    }

    public Pokemon getEnemyPokemon() {
        return enemyPokemon;
    }

    public void setOwnPokemon(Pokemon newActivePokemon) {
        this.ownPokemon = newActivePokemon;
    }

    public void start() {
        System.out.println("Starting a battle with the enemy " + enemyPokemon.getName() + "...");
        inProgress = true;
        while (inProgress) {
            // general flow of the battle
            displayBattleStatus();
            ownMove();
            if (inProgress) { // battle could end after own move
                enemyMove();
            }
        }
    }

    public void stop() {
        System.out.println("Battle ended.");
        inProgress = false;
    }

    private void addCommand(Command command) {
        this.commands.put(command.getName(), command);
    }

    /**
     * Represents the Player's move during the battle
     */
    private void ownMove() {
        System.out.println("What is your next move? (Type \"help\" for a list of battle commands)");
        Command cmd = ui.command(this.player, this.commands);
        cmd.execute();
        if (cmd.getName() == "switch" || cmd.getName() == "help" || cmd.getName() == "inventory" || cmd.getName() == "pokemons" || (cmd.getName() == "use" && !cmd.isExecutedSuccessfully()) || (cmd.getName() == "run" && !cmd.isExecutedSuccessfully())) {
            // after above commands, the user can do another move
            ownMove();
        }
        checkBattleStatus();
    }

    /**
     * Represents the enemy's move during the battle
     */
    private void enemyMove() {
        Attack enemyAttack = new Attack(this, false);
        enemyAttack.execute();
        checkBattleStatus();
    }

    private void checkBattleStatus() {
        if (enemyPokemon.hasFainted()) {
            System.out.println("You have defeated " + enemyPokemon.getName() + "!");
            stop();
        } else if (ownPokemon.hasFainted()) {
            System.out.println(ownPokemon.getName() + " has fainted!");
            if (player.hasPokemonsAlive()) {
                // Player has to switch to a new Pokémon
                Switch s = new Switch(player, this);
                s.execute();
            } else {
                // all players' Pokémon have fainted
                System.out.println("All your Pokémon have fainted!");
                stop();
            }
        }
    }

    /**
     * Displays names and health of both Pokémon during the battle
     */
    private void displayBattleStatus() {
        String boxText = (ownPokemon + " vs " + enemyPokemon);
        int boxHorizontalLength = boxText.length() * 2;
        System.out.println("-".repeat(boxHorizontalLength));
        System.out.println("|" + " ".repeat(boxHorizontalLength / 4 - 1) + boxText + " ".repeat(boxHorizontalLength / 4 - 1) + "|");
        System.out.println("-".repeat(boxHorizontalLength));
    }
}
