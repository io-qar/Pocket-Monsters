package service.commands.game;

import entity.Player;
import entity.item.Item;
import entity.location.ItemLocation;
import service.commands.Command;

public class Take extends Command {
    private Player player;

    public Take(Player player) {
        super("take", "Pick up an item using 'take [item name]'", true);
        this.player = player;
    }

    /**
     * Executes the take command
     */
    @Override
    public void execute() {
        // check if current location is an itemLocation
        if (player.getCurrentLocation().getClass() == ItemLocation.class) {
            // cast the location to an itemLocation
            ItemLocation currentLoc = (ItemLocation) player.getCurrentLocation();
            // retrieve the item in current location
            Item item = currentLoc.getItem();
            if (item == null || !argument.equalsIgnoreCase(item.getName())) {
                System.out.println("There is no \"" + argument + "\" here...");
            } else {
                currentLoc.removeItem();
                player.addItem(item);
            }
        } else {
            System.out.println("There is no \"" + argument + "\" here...");
        }
    }
}
