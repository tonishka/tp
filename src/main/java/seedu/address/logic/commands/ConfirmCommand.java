package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

public class ConfirmCommand extends Command {

    public static final String CONFIRMATION_MESSAGE = "Are you sure you want to proceed? (yes/no)";

    @Override
    public CommandResult execute(Model model) throws CommandException {
        return new CommandResult(CONFIRMATION_MESSAGE, false, false,
                true, false, true, null);
    }
}
