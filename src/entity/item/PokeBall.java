package entity.item;

import entity.Player;
import entity.Pokemon;
import entity.location.PokemonLocation;
import service.Battle;

public class PokeBall extends Item {
    /**
     * Catch rate of the pokéball, between 0 and 1
     */
    private double ballCatchRate;

    /**
     * A number that's added to the {@link #ballCatchRate catch rate} (higher = easier to catch pokemon)
     */
    private static final double catchConstant = 0.2;

    public PokeBall(String name, double ballCatchRate) {
        super(name);
        this.ballCatchRate = ballCatchRate;
    }

    /**
     * The weaker the pokémon, the higher the chance of catching it. Added one, so you have a chance of catching a full HP pokemon and so the chance of catching a 1 HP pokémon is maximal.
     * @param player Current player
     * @param enemyPokemon
     * @param battle
     */
    public void use(Player player, Pokemon enemyPokemon, Battle battle) {
        double pokemonCatchRate = ((double) enemyPokemon.getMAXHEALTH() - enemyPokemon.getHealthPoints() + 1) / enemyPokemon.getMAXHEALTH(); // between 0 and 1
        double catchRate = ballCatchRate * pokemonCatchRate + catchConstant;

        // for this, I used ChatGPT to have a quick way to generate a random boolean with a specific probability
        boolean caught = Math.random() < catchRate;

        if (caught) {
            System.out.println("Gotcha!");
            enemyPokemon.setHealthPoints(enemyPokemon.getMAXHEALTH()); // restore pokémon to full HP
            player.addPokemon(enemyPokemon); // add pokemon to player's pokeomn
            PokemonLocation currentLoc = (PokemonLocation) player.getCurrentLocation();
            currentLoc.removePokemon(); // remove pokemon from location
            battle.stop(); // end the battle
        } else {
            System.out.println(enemyPokemon.getName() + " broke free from the " + this.getName() + "!");
        }

        // remove pokeball from inventory after use
        player.removeItem(this, false);
    }
}
