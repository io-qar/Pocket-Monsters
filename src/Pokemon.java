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

    public void heal(int amount) {
        healthPoints += amount;
    }
}
