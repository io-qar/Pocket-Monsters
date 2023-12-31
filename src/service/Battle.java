package service;

import entity.Player;
import entity.Pokemon;
import service.commands.*;
import service.commands.battle.Attack;
import service.commands.battle.Run;
import service.commands.game.Help;
import service.commands.game.Inventory;
import service.commands.game.Pokemons;
import service.commands.game.Switch;

import java.util.HashMap;

public class Battle {
    HashMap<String, Command> commands;
    private UserInput ui = new UserInput();
    private Player player;
    private Pokemon enemyPokemon; // the Pokémon you are fighting against

    private boolean inProgress = false;

    public Battle(Player player, Pokemon enemy) {
        this.player = player;
        this.enemyPokemon = enemy;

        commands = new HashMap<>();
        // add battle commands here!
        addCommand(new Attack(player.getActivePokemon(), enemyPokemon));
        addCommand(new Switch(player));
        addCommand(new Run(this));
        addCommand(new Help(commands));
        addCommand(new Pokemons(player));
        addCommand(new Inventory(player));
    }

    public void start() {
        System.out.println("Starting a battle with the enemy " + enemyPokemon.getName() + "...");
        inProgress = true;
        while (inProgress) {
            // general flow of the battle
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

    private void ownMove() {
        // display Pokemon health clearly in a nice box
        String boxText = (player.getActivePokemon() + " vs " + enemyPokemon);
        int boxHorizontalLength = boxText.length() * 2;
        System.out.println("-".repeat(boxHorizontalLength));
        System.out.println("|" + " ".repeat(boxHorizontalLength / 4 - 1) + boxText + " ".repeat(boxHorizontalLength / 4 - 1) + "|");
        System.out.println("-".repeat(boxHorizontalLength));


        System.out.println("What is your next move? (Type \"help\" for a list of commands)");
        Command cmd = ui.command(this.player, this.commands);
        cmd.execute();
        if (cmd.getName() == "switch" || cmd.getName() == "help") {
            // after above commands, the user can do another move
            ownMove();
        }
        checkBattleStatus();
    }

    private void enemyMove() {
        Attack enemyAttack = new Attack(enemyPokemon, player.getActivePokemon());
        enemyAttack.execute();
        checkBattleStatus();
    }

    private void checkBattleStatus() {
        if (enemyPokemon.hasFainted()) {
            System.out.println("You have defeated " + enemyPokemon.getName() + "!");
            stop();
        } else if (player.getActivePokemon().hasFainted()) {
            System.out.println(player.getActivePokemon().getName() + " has fainted!");
            if (player.hasPokemonsAlive()) {
                // Player has to switch to a new Pokémon
                Switch s = new Switch(player);
                s.execute();
            } else {
                // all players' Pokémon have fainted
                System.out.println("All your Pokémon have fainted!");
                stop();
            }
        }
    }
}
