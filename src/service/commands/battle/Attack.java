package service.commands.battle;

import entity.Pokemon;
import service.commands.Command;

public class Attack extends Command {
    private Pokemon attackingPokemon;
    private Pokemon attackedPokemon;
    public Attack(Pokemon attackingPokemon, Pokemon attackedPokemon) {
        super("attack", "Attack the enemy Pokémon.", false);
        this.attackingPokemon = attackingPokemon;
        this.attackedPokemon = attackedPokemon;
    }

    @Override
    public void execute() {
        int attackingPokemonAttack = attackingPokemon.getAttack();
        attackedPokemon.isAttacked(attackingPokemonAttack);
        System.out.println(attackingPokemon.getName() + " did " + attackingPokemonAttack + " damage to " + attackedPokemon.getName() + "!");
    }
}
