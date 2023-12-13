package service.commands;

import entity.Map;
import entity.Player;
import service.Game;
import service.commands.Command;

public class Exit extends Command {
    public Exit() {
        super("exit");
    }

    @Override
    public void execute(Player player, Map map, Game game) {
        game.stop();
    }
}
