package entity.item;

import java.util.List;

import entity.Player;
import entity.Pokemon;
import service.UserInput;

/**
 * Represents an item that resurrects a fainted Pokémon and restores its maximum health.
 */
public class Revive extends Item {
  private UserInput ui = new UserInput();

  public Revive(String name) {
    super(name);
  }

  public boolean use(Player player) {
    List<Pokemon> pokemons = player.getPokemons();
    int numberOfPokemons = pokemons.size();
    int countNotHealable = 0;

    for (Pokemon p : pokemons) {
      if (!pokemonCanBeHealed(p, false)) countNotHealable++;
    }
    if (countNotHealable == numberOfPokemons) {
      System.out.println("All of your pokemons have full health!");
      return false;
    }

    player.displayPokemons();
    // let user pick a number between 1 and (nr. of Pokemons)
    int newPokemonChoice = ui.readConstrainedInteger("Which Pokémon would you like to revive? Pick a number.", "Please select a number between " + 1 + " and " + numberOfPokemons, 1, numberOfPokemons);

    Pokemon selectedPokemon = pokemons.get(newPokemonChoice - 1);
    if (pokemonCanBeHealed(selectedPokemon, true)) {
        int pokemonMaxHealth = selectedPokemon.getMAXHEALTH();
        selectedPokemon.heal(pokemonMaxHealth);
        // remove healthpotion from inventory after use
        player.removeItem(this, false);
        return true;
    }
    return false;
  }

  private boolean pokemonCanBeHealed(Pokemon p, boolean displayMessages) {
    if (p.getHealthPoints() == p.getMAXHEALTH()) {
      if (displayMessages) System.out.println(p.getName() + " is already full HP!");
      return false;
    }
    return true;
  }
}
