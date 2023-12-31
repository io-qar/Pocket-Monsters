package entity.item;

import entity.item.Item;

public class HealthPotion extends Item {
    private int healthPoints;
    public HealthPotion(int healthPoints) {
        super("potion");
        this.healthPoints = healthPoints;
    }

    public void use(String[] args) {
        // implementation...
    }
}
