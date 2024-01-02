package service.commands.game;

import service.Game;
import service.commands.Command;

public class Exit extends Command {
    private Game game;

    public Exit(Game game) {
        super("exit", "Exit the current game.", false);
        this.game = game;
    }

    /**
     * Executes the exit command
     */
    @Override
    public void execute() {
        game.stop(false);
    }
}
