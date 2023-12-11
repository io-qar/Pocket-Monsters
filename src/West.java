public class West extends Command {
    public West() {
        super("west");
    }

    @Override
    public void execute(Player player, Map map, Game game) {
        player.move(-1, 0, map);
    }
}
