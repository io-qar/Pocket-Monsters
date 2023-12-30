package service.commands;

import entity.Player;

public class Run extends Command {
    private Player player;
    private String direction;
    
    public Run(Player player, String direction) {
        super("run", "If you don't wanna fight, just run away", true);
        this.player = player;
        this.direction = direction;
    }

    @Override
    public void execute() {
        switch (direction) {
            case "east":
                East eastDir = new East(player);
                eastDir.execute();
                break;
            case "north":
                North northDir = new North(player);
                northDir.execute();
                break;
            case "south":
                South southDir = new South(player);
                southDir.execute();
                break;
            case "west":
                West westDir = new West(player);
                westDir.execute();
                break;
            default:
                System.out.println("incorrect direction");
                break;
        }
    }
}
