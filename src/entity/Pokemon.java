package entity;

public class Pokemon {
    private String name; // name of the pokémon
    private int healthPoints; // amount of health points
    private int attack; // amount of damage done in an attack

    public Pokemon(String name, int healthPoints, int attack) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.attack = attack;
    }
    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void isAttacked(int damage) {
        if (healthPoints <= damage) {
            healthPoints = 0;
        } else {
            healthPoints -= damage;
        }
    }

    public void heal(int amount) {
        healthPoints += amount;
    }

    public boolean hasFainted() {
        return healthPoints == 0;
    }

    public String toString() {
        return getName() + " (" + getHealthPoints() + " hp)";
    }
}
