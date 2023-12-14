package service.commands;

import entity.Map;
import entity.Player;
import service.Game;

import java.util.HashMap;

public class Exit extends Command {
    private Game game;
    public Exit(Game game) {
        super("exit", "Exit the current game.");
        this.game = game;
    }

    @Override
    public void execute() {
        game.stop();
    }
}
