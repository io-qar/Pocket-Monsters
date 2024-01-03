package service.commands.battle;

import entity.Pokemon;
import service.Battle;
import service.commands.Command;

public class Attack extends Command {
    private Battle battle;

    /**
     * true if my attack, false if enemy attack
     */
    private boolean myAttack;

    public Attack(Battle battle, boolean myAttack) {
        super("attack", "Attack the enemy Pokémon.", false);
        this.battle = battle;
        this.myAttack = myAttack;
    }

    /**
     * Executes the attack command. An attacking pokemon and an attacked one are being swapped each turn.
     */
    @Override
    public void execute() {
        Pokemon attackingPokemon;
        Pokemon attackedPokemon;

        if (myAttack) {
            attackingPokemon = battle.getOwnPokemon();
            attackedPokemon = battle.getEnemyPokemon();
        } else {
            attackingPokemon = battle.getEnemyPokemon();
            attackedPokemon = battle.getOwnPokemon();
        }

        int attackingPokemonAttack = attackingPokemon.getAttack();
        attackedPokemon.isAttacked(attackingPokemonAttack);
        System.out.println(attackingPokemon.getName() + " did " + attackingPokemonAttack + " damage to " + attackedPokemon.getName() + "!");
    }
}
