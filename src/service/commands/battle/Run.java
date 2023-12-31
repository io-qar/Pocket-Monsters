package service.commands.battle;

import service.Battle;
import service.commands.Command;

public class Run extends Command {
    Battle battle;
    public Run(Battle battle) {
        super("run", "Run from the battle.", false);
        this.battle = battle;
    }

    @Override
    public void execute() {
        battle.stop();
    }
}
