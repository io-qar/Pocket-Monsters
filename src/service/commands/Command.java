package service.commands;

public abstract class Command {
    private String name;
    private String description;
    /**
     * Defines whether a command requires an argument (a string) whenever called.
     * If ever commands are needed that need more than 1 argument, this can be replaced by
     * an int argumentsRequired (0, 1, 2...) which specifies how many arguments are required.
     */
    private boolean requiresArgument;
    /**
     * This stores the argument when a command is called that needs an argument.
     * For extending to commands that need more than 1 argument, this can be replaced by
     * a String[] arguments.
     */
    protected String argument;

    public Command(String name, String description, boolean requiresArgument) {
        this.name = name;
        this.description = description;
        this.requiresArgument = requiresArgument;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public boolean isRequiresArgument() {
        return requiresArgument;
    }

    public void setArgument(String argument) {
        if (this.requiresArgument) {
            this.argument = argument;
        }
    }

    public abstract void execute();
}
