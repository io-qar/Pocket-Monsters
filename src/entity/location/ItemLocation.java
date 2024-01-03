package entity.location;

import entity.item.Item;

/**
 * Represents a {@see entity.location.Location Location} containing an Item.
 */
public class ItemLocation extends Location {
    private Item item;

    public ItemLocation(String name, String description, Item item) {
        super(name, description);
        this.item = item;
    }

    @Override
    public String lookAround() {
        if (item == null) {
            return super.lookAround();
        }
        return "Found a " + item.getName() + " on the ground!";
    }

    public void removeItem() {
        item = null;
    }

    public Item getItem() {
        return item;
    }
}
