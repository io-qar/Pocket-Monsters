package service.commands;

import service.Game;

public class Exit extends Command {
    private Game game;
    public Exit(Game game) {
        super("exit", "Exit the current game.", false);
        this.game = game;
    }

    @Override
    public void execute() {
        game.stop();
    }
}
