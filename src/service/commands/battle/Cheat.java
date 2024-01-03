package service.commands.battle;

import entity.Pokemon;
import service.Battle;
import service.commands.Command;

/**
 * Kills the enemy instantly
 * FOR TESTING ONLY
 */
public class Cheat extends Command {
  private Battle battle;

    public Cheat(Battle battle) {
      super("uuddlrlrba", "Instantly defeat the enemy.", false);
      this.battle = battle;
    }

    /**
     * Executes the cheat command.
     */
    @Override
    public void execute() {
        Pokemon attackingPokemon = battle.getOwnPokemon();
        Pokemon attackedPokemon = battle.getEnemyPokemon();
        int attackingPokemonAttack = Integer.MAX_VALUE;

        attackedPokemon.isAttacked(attackingPokemonAttack);
        System.out.println(attackingPokemon.getName() + " did " + attackingPokemonAttack + " damage to " + attackedPokemon.getName() + "!");
    }
}
