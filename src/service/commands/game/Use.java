package service.commands.game;

import entity.Player;
import entity.Pokemon;
import entity.item.HealthPotion;
import entity.item.Item;
import entity.item.PokeBall;
import entity.item.Revive;
import service.Battle;
import service.commands.Command;

import java.util.List;

public class Use extends Command {
    private Player player;

    /**
     * if null, we are not in battle context
     */
    private Pokemon enemyPokemon = null;

    /**
     * if null, we are not in battle context
     */
    private Battle battle = null;

    /**
     * if false, it's a normal pokemon battle. If true, it's a gym battle
     */
    private boolean isGymBattle;

    /**
     * In general game context
     */
    public Use(Player player) {
        super("use", "Use an item using 'use [item name]'", true);
        this.player = player;
        this.enemyPokemon = null;
        this.battle = null;
    }

    /**
     * In battle context (includes pokeballs)
     */
    public Use(Player player, Pokemon enemyPokemon, Battle battle, boolean isGymBattle) {
        super("use", "Use an item using 'use [item name]'", true);
        this.player = player;
        this.enemyPokemon = enemyPokemon;
        this.battle = battle;
        this.isGymBattle = isGymBattle;
    }

    /**
     * Executes the game command
     */
    @Override
    public void execute() {
        executedSuccessfully = false;
        List<Item> inventory = player.getInventory();
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            boolean itemFound = false;
            for (Item item : inventory) {
                // check if the argument user provided exists in the inventory
                if (argument.equalsIgnoreCase(item.getName())) {
                    // if item was found, check which type of item it is and use it if possible
                    if (item.getClass() == PokeBall.class && battle == null) {
                        // trying to use pokeball outside of battle context
                        System.out.println("You can only use Pokéballs in battle!");
                    } else if (item.getClass() == PokeBall.class && isGymBattle) {
                        System.out.println("You can't use Pokéballs in a gym battle!");
                    } else if (item.getClass() == PokeBall.class) {
                        // using pokeball in battle
                        ((PokeBall) item).use(player, enemyPokemon, battle);
                        executedSuccessfully = true;
                    }  else if (item.getClass() == Revive.class && battle != null) {
                        // trying to use a revive in battle context
                        System.out.println("Can't use revives in battle!");
                    } else if (item.getClass() == Revive.class) {
                        executedSuccessfully = ((Revive) item).use(player);
                    } else {
                        // it's a health potion
                        executedSuccessfully = ((HealthPotion) item).use(player);
                    }
                    itemFound = true;
                    break;
                }
            }
            if (!itemFound) {
                System.out.println("No \"" + argument + "\" found in your inventory...");
            }
        }
    }
}
