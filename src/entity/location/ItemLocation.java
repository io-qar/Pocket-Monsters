package entity.location;

import entity.item.Item;

public class ItemLocation extends Location {
    private Item item;

    public ItemLocation(int y, int x, String name, String description, Item item) {
        super(y, x, name, description);
        this.item = item;
    }

    @Override
    public String lookAround() {
        if (item == null) {
            return super.lookAround();
        } else {
            return "Found a " + item.getName() + " on the ground!";
        }
    }

    public void removeItem() {
        item = null;
    }

    public Item getItem() {
        return item;
    }
}
