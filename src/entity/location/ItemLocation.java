package entity.location;

import entity.Item;

public class ItemLocation extends Location {
    private Item item;

    public ItemLocation(int x, int y, String location, String description, Item item) {
        super(x, y, location, description);
        this.item = item;
    }
}
