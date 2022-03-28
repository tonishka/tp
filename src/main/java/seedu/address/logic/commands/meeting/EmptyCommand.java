package seedu.address.logic.commands.meeting;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.Model;

public class EmptyCommand extends Command {
    public static final String COMMAND_WORD = "empty";
    public static final String MESSAGE_SUCCESS = "Opened clearing of meetings confirmation window";


    @Override
    public CommandResult execute(Model model) {
        return new CommandResult(MESSAGE_SUCCESS, false, false, true, false,
                false, true, null);
    }

}
