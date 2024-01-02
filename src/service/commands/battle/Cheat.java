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

    /**
     * true if my attack, false if enemy attack
     */
    private boolean myAttack;

    public Cheat(Battle battle, boolean myAttack) {
      super("uuddlrlrba", "Instantly defeat the enemy ", false);
      this.battle = battle;
      this.myAttack = myAttack;
    }

    /**
     * Executes the cheat command.
     */
    @Override
    public void execute() {
        Pokemon attackingPokemon;
        Pokemon attackedPokemon;
        int attackingPokemonAttack = 0;

        if (myAttack) {
            attackingPokemon = battle.getOwnPokemon();
            attackedPokemon = battle.getEnemyPokemon();
            attackingPokemonAttack = Integer.MAX_VALUE;
        } else {
            attackingPokemon = battle.getEnemyPokemon();
            attackedPokemon = battle.getOwnPokemon();
        }

        attackedPokemon.isAttacked(attackingPokemonAttack);
        System.out.println(attackingPokemon.getName() + " did " + attackingPokemonAttack + " damage to " + attackedPokemon.getName() + "!");
    }
}
