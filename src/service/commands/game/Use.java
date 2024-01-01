package service.commands.game;

import entity.Player;
import entity.Pokemon;
import entity.item.HealthPotion;
import entity.item.Item;
import entity.item.PokeBall;
import service.Battle;
import service.commands.Command;

import java.util.List;

public class Use extends Command {
    private Player player;
    private Pokemon enemyPokemon = null; // if null, we are not in battle context
    private Battle battle = null; // if null, we are not in battle context

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
    public Use(Player player, Pokemon enemyPokemon, Battle battle) {
        super("use", "Use an item using 'use [item_name]'", true);
        this.player = player;
        this.enemyPokemon = enemyPokemon;
        this.battle = battle;
    }

    @Override
    public void execute() {
        executedSuccessfully = false;
        List<Item> inventory = player.getInventory();
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            boolean itemFound = false;
            for (Item item : inventory) {
                if (argument.equalsIgnoreCase(item.getName())) {
                    if (item.getClass() == PokeBall.class && enemyPokemon == null) {
                        // trying to use pokeball outside of battle context
                        System.out.println("You can only use Pokéballs in battle!");
                    } else if (item.getClass() == PokeBall.class) {
                        // using pokeball in battle
                        ((PokeBall) item).use(player, enemyPokemon, battle);
                        executedSuccessfully = true;
                    } else {
                        // it's a health potion (we only have pokeballs and healthpotions, but this could easily be extended to more items)
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
