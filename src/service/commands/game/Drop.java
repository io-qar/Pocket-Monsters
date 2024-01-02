package service.commands.game;

import entity.Player;
import entity.item.Item;
import service.commands.Command;

import java.util.List;

public class Drop extends Command {
    private Player player;
    public Drop(Player player) {
        super("drop", "Drop an item using 'drop [item name]'", true);
        this.player = player;
    }

    @Override
    public void execute() {
        List<Item> inventory = player.getInventory();
        boolean itemFound = false;
        for (Item item : inventory) {
            if (argument.equalsIgnoreCase(item.getName())) {
                player.removeItem(item, true);
                itemFound = true;
                break;
            }
        }
        if (!itemFound) {
            System.out.println("No \"" + argument + "\" found in your inventory...");
        }
    }
}
