package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Deletes the specified field from the contact being displayed.
 */
public class DeleteFieldCommand extends Command {

    public static final String COMMAND_WORD = "del";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the specified field from the contact being displayed."
            + "If a label is provided, deletes information for only that label.\n"
            + "Parameters: FIELD LABEL\n"
            + "Example: " + COMMAND_WORD + " c/\n"
            + "Example: " + COMMAND_WORD + " ph/ personal";

    public static final String MESSAGE_DELETE_FIELD_SUCCESS = "Person after Field Delete: %1$s";


    public DeleteFieldCommand() {

    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        return null;
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }
        // instanceof handles nulls
        if (!(other instanceof DeleteFieldCommand)) {
            return false;
        }

        return false;
    }
}
