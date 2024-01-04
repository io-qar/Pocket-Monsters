package entity.item;

import entity.Player;
import entity.Pokemon;
import service.UserInput;

import java.util.List;

public class HealthPotion extends Item {
    private int healthPoints;
    private UserInput ui = new UserInput();

    public HealthPotion(String name, int healthPoints) {
        super(name);
        this.healthPoints = healthPoints;
    }

    /**
     * @return {#code True} if a pokemon got healed and potion was used. {@code False} if potion wasn't used.
     */
    public boolean use(Player player) {
        List<Pokemon> pokemons = player.getPokemons();
        int numberOfPokemons = pokemons.size();
        int countNotHealable = 0;
        for (Pokemon p : pokemons) {
            if (!pokemonCanBeHealed(p, false)) countNotHealable++;
        }
        if (countNotHealable == numberOfPokemons) {
            System.out.println("None of your pokémon can be healed right now! Try again later.");
            return false;
        }

        player.displayPokemons();
        int newPokemonChoice = ui.readConstrainedInteger("Which Pokémon would you like to heal? Pick a number.", "Please select a number between 1 and " + numberOfPokemons, 1, numberOfPokemons);

        Pokemon selectedPokemon = pokemons.get(newPokemonChoice - 1);
        if (pokemonCanBeHealed(selectedPokemon, true)) {
            selectedPokemon.heal(healthPoints);
            // remove revive item from inventory after use
            player.removeItem(this, false);
            return true;
        }
        return false;
    }

    private boolean pokemonCanBeHealed(Pokemon p, boolean displayMessages) {
        if (p.hasFainted()) {
            if (displayMessages) System.out.println("Cannot heal a fainted Pokémon!");
            return false;
        }
        if (p.getHealthPoints() == p.getMAXHEALTH()) {
            if (displayMessages) System.out.println(p.getName() + " is already full HP!");
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name + " (" + healthPoints + " hp)";
    }
}
