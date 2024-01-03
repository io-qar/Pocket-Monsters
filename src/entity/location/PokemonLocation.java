package entity.location;

import entity.Pokemon;

/**
 * Represents a {@see entity.location.Location Location} containing a Pokemon.
 */
public class PokemonLocation extends Location {
    private Pokemon pokemon;

    public PokemonLocation(String name, String description, Pokemon pokemon) {
        super(name, description);
        this.pokemon = pokemon;
    }

    @Override
    public String lookAround() {
        if (pokemon == null) {
            return super.lookAround();
        }
        return "Encountered a wild " + pokemon.getName() + "!";
    }

    public void removePokemon() {
       pokemon = null;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }
}
