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

    /**
     * For some commands (e.g. use), it's useful to know whether the command actually did something after execution or not
     * (e.g. an item was actually used).
     * False by default
     */
    protected boolean executedSuccessfully;

    public Command(String name, String description, boolean requiresArgument) {
        this.name = name;
        this.description = description;
        this.requiresArgument = requiresArgument;
    }

    /**
     * @return The name of the command
     */
    public String getName() {
        return name;
    }

    /**
     * @return The description of the command
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return true if the command was successfully executed
     */
    public boolean isExecutedSuccessfully() {
        return executedSuccessfully;
    }

    /**
     * @return true if the command requiers an argument. e.g {@code command arg1}
     */
    public boolean isRequiresArgument() {
        return requiresArgument;
    }

    /**
     * @param argument an argument which will be used by the command
     */
    public void setArgument(String argument) {
        if (this.requiresArgument) {
            this.argument = argument;
        }
    }

    public abstract void execute();
}
