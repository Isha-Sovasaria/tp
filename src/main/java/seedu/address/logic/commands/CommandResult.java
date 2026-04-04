package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.Objects;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.person.Person;

/**
 * Represents the result of a command execution.
 */
public class CommandResult {

    private final String feedbackToUser;

    /** Help information should be shown to the user. */
    private final boolean showHelp;

    /** The application should exit. */
    private final boolean exit;

    /** The person to show in the view window. Null if no person should be shown. */
    private final Person personToView;

    /** Whether this command result is asking for user confirmation. */
    private final boolean requiresConfirmation;

    /** The command to execute if the user confirms. */
    private final Command commandToConfirm;

    /**
     * Constructs a {@code CommandResult} with the specified fields.
     */
    public CommandResult(String feedbackToUser, boolean showHelp, boolean exit) {
        this(feedbackToUser, null, showHelp, exit, false, null);
    }

    /**
     * Constructs a {@code CommandResult} for showing a person's details in the view window.
     */
    public CommandResult(String feedbackToUser, Person personToView) {
        this(feedbackToUser, personToView, false, false, false, null);
    }

    /**
     * Constructs a {@code CommandResult} with the specified fields.
     */
    public CommandResult(String feedbackToUser, Person personToView, boolean showHelp, boolean exit) {
        this(feedbackToUser, personToView, showHelp, exit, false, null);
    }

    /**
     * Constructs a {@code CommandResult} with all fields specified.
     */
    public CommandResult(String feedbackToUser, Person personToView, boolean showHelp, boolean exit,
                         boolean requiresConfirmation, Command commandToConfirm) {
        this.feedbackToUser = requireNonNull(feedbackToUser);
        this.personToView = personToView;
        this.showHelp = showHelp;
        this.exit = exit;
        this.requiresConfirmation = requiresConfirmation;
        this.commandToConfirm = commandToConfirm;
    }

    /**
     * Constructs a {@code CommandResult} with the specified {@code feedbackToUser},
     * and other fields set to their default value.
     */
    public CommandResult(String feedbackToUser) {
        this(feedbackToUser, null, false, false, false, null);
    }

    /**
     * Returns a {@code CommandResult} that requests confirmation before executing
     * the given command.
     */
    public static CommandResult withConfirmation(String feedbackToUser, Command commandToConfirm) {
        requireNonNull(feedbackToUser);
        requireNonNull(commandToConfirm);
        return new CommandResult(feedbackToUser, null, false, false, true, commandToConfirm);
    }

    public String getFeedbackToUser() {
        return feedbackToUser;
    }

    public boolean isShowHelp() {
        return showHelp;
    }

    public boolean isShowView() {
        return personToView != null;
    }

    public Person getPersonToView() {
        return personToView;
    }

    public boolean isExit() {
        return exit;
    }

    public boolean requiresConfirmation() {
        return requiresConfirmation;
    }

    public Command getCommandToConfirm() {
        return commandToConfirm;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof CommandResult)) {
            return false;
        }

        CommandResult otherCommandResult = (CommandResult) other;
        return feedbackToUser.equals(otherCommandResult.feedbackToUser)
                && showHelp == otherCommandResult.showHelp
                && exit == otherCommandResult.exit
                && Objects.equals(personToView, otherCommandResult.personToView)
                && requiresConfirmation == otherCommandResult.requiresConfirmation
                && Objects.equals(commandToConfirm, otherCommandResult.commandToConfirm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(feedbackToUser, showHelp, exit, personToView,
                requiresConfirmation, commandToConfirm);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("feedbackToUser", feedbackToUser)
                .add("showHelp", showHelp)
                .add("showView", isShowView())
                .add("personToView", personToView)
                .add("exit", exit)
                .add("requiresConfirmation", requiresConfirmation)
                .add("commandToConfirm", commandToConfirm)
                .toString();
    }
}