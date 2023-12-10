public abstract class Command {
    private String name;

    public Command(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void execute(Player player, Map map, Game game) {
        // default execution of command if not overwritten
        // maybe make method abstract instead...
        System.out.println(this.name);
    }

}
