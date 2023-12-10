public class Exit extends Command{
    public Exit() {
        super("exit");
    }

    @Override
    public void execute(Player player, Map map, Game game) {
        game.stop();
    }
}
