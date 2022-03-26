package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Cancels a meeting identified using it's displayed index.
 */
public class CancelCommand extends Command {

    public static final String COMMAND_WORD = "cancel";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Cancels the meeting identified by the index number used in the displayed meetings list.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 2";

    public static final String MESSAGE_CANCEL_MEETING_SUCCESS = "Cancelled meeting: %1$s";

    private final Index targetIndex;

    public CancelCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        return new CommandResult(String.format(MESSAGE_CANCEL_MEETING_SUCCESS, null));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        // instanceof handles nulls
        if (!(other instanceof CancelCommand)) {
            return false;
        }

        // state check
        return targetIndex.equals(((CancelCommand) other).targetIndex);

    }
}

