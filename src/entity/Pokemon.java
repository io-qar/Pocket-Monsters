package entity;

public class Pokemon {
    private String name; // name of the pokémon
    private final int maxHealth; // max health of the pokémon
    private int healthPoints; // current amount of health points
    private int attack; // amount of damage done in an attack

    public Pokemon(String name, int healthPoints, int attack) {
        this.name = name;
        this.maxHealth = healthPoints;
        this.healthPoints = healthPoints;
        this.attack = attack;
    }
    public String getName() {
        return name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getAttack() {
        return attack;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public void isAttacked(int damage) {
        if (healthPoints <= damage) {
            healthPoints = 0;
        } else {
            healthPoints -= damage;
        }
    }

    public void heal(int amount) {
        int newHealth = healthPoints + amount;
        if (newHealth >= maxHealth) {
            healthPoints = maxHealth;
            System.out.println(name + " was restored to full HP!");
        } else {
            healthPoints += amount;
            System.out.println(name + " gained " + amount + " HP!");
        }
    }

    public boolean hasFainted() {
        return healthPoints == 0;
    }

    public String toString() {
        return getName() + " (" + healthPoints + "/" + maxHealth + " hp)";
    }
}
