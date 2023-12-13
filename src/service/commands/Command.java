package service.commands;

import entity.Map;
import entity.Player;
import service.Game;

public abstract class Command {
    private String name;

    public Command(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void execute(Player player, Map map, Game game);
}
