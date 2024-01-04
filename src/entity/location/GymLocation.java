package entity.location;

import entity.Pokemon;

/**
 * Represents a {@see entity.location.Location Location} containing a final location with a Gym Trainer.
 */
public class GymLocation extends Location {
    private Pokemon pokemon;
    String gymTrainer;

    public GymLocation(String name, String description, String gymTrainer, Pokemon pokemon) {
        super(name, description);
        this.pokemon = pokemon;
        this.gymTrainer = gymTrainer;
    }

    @Override
    public String lookAround() {
        if (pokemon == null) {
            return super.lookAround();
        } else {
            return gymTrainer + ": \"Welcome, young trainer. Strength lies in the rock-solid foundation of unwavering determination. Show me that resilience in battle!\"";
        }
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public String getGymTrainer() {
        return gymTrainer;
    }
}
