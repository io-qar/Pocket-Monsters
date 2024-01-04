package entity;

/**
 * Represents a Pokemon entity
 */
public class Pokemon {
    /**
     * A name of the pokémon
     */
    private String name;

    /**
     * The maximum health of a Pokémon
     */
    private final int MAXHEALTH;

    /**
     * A current amount of a pokemon's health points
     */
    private int healthPoints;

    /**
     * Amount of damage done by a Pokémon in an attack
     */
    private int attack;

    public Pokemon(String name, int healthPoints, int attack) {
        this.name = name;
        this.MAXHEALTH = healthPoints;
        this.healthPoints = healthPoints;
        this.attack = attack;
    }

    public String getName() {
        return name;
    }

    public int getMAXHEALTH() {
        return MAXHEALTH;
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
        if (newHealth >= MAXHEALTH) {
            healthPoints = MAXHEALTH;
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
        return getName() + " (" + healthPoints + "/" + MAXHEALTH + " hp)";
    }
}
