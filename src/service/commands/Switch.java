package service.commands;

import entity.Player;

public class Switch extends Command {
    private Player player;

    public Switch(Player player) {
        super("switch", "switch your current pokemon with another one", false);
        this.player = player;
    }

    @Override
    public void execute() {
        player.changeCurrentPokemon();
        return;
    }
}
