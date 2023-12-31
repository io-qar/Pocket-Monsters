package service.commands.game;

import entity.Player;
import service.commands.Command;

public class Inventory extends Command {
    private Player player;

    public Inventory(Player player) {
        super("inventory", "Display your inventory.", false);
        this.player = player;
    }

    /**
     * Executes the inventory command
     */
    @Override
    public void execute() {
        player.displayInventory();
    }
}
