package service.commands;

import entity.Item;
import entity.Player;
import entity.location.ItemLocation;

public class Take extends Command {
    private Player player;
    public Take(Player player) {
        super("take", "Pick up an item using 'take [item_name]'", true);
        this.player = player;
    }

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
                System.out.println(item.getName() + " added to inventory!");
            }
        } else {
            System.out.println("There is no \"" + argument + "\" here...");
        }
    }
}
