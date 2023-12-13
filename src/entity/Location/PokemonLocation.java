package entity.Location;

import entity.Pokemon;

public class PokemonLocation extends Location{
    private Pokemon pokemon;

    public PokemonLocation(int x, int y, String description, Pokemon pokemon) {
        super(x, y, description);
        this.pokemon = pokemon;
    }
}
