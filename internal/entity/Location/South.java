package internal.entity.Location;

import internal.Game;
import internal.entity.Map;
import internal.entity.Player;
import internal.service.Command;

public class South extends Command {
    public South() {
        super("south");
    }

    @Override
    public void execute(Player player, Map map, Game game) {
        player.move(0, -1, map);
    }
}
