package service.commands.battle;

import service.Battle;
import service.commands.Command;

public class Run extends Command {
    private Battle battle;
    private boolean isGymBattle;
    public Run(Battle battle, boolean isGymBattle) {
        super("run", "Run from the battle.", false);
        this.battle = battle;
        this.isGymBattle = isGymBattle;
    }

    @Override
    public void execute() {
        if (isGymBattle) {
            System.out.println("Cannot run from a gym battle!");
            executedSuccessfully = false;
        } else {
            battle.stop();
            executedSuccessfully = true;
        }

    }
}
