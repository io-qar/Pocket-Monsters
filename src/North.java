public class North extends Command {
    public North() {
        super("north");
    }

    @Override
    public void execute(Player player, Map map, Game game) {
        player.move(0, 1, map);
    }
}
