package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_VIEW;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_COMPANY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_JOBTITLE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PRONOUN;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import seedu.address.logic.commands.DeleteFieldCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Person;


public class DeleteFieldCommandParser implements Parser<DeleteFieldCommand> {
    @Override
    public DeleteFieldCommand parse(String userInput) throws ParseException {
        throw new ParseException(MESSAGE_INVALID_VIEW);
    }

    public DeleteFieldCommand parse(String args, Person personToEdit) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_NAME, PREFIX_COMPANY, PREFIX_JOBTITLE,
                        PREFIX_PRONOUN, PREFIX_PHONE, PREFIX_EMAIL, PREFIX_ADDRESS, PREFIX_TAG);

        System.out.println(argMultimap);

        return new DeleteFieldCommand();
    }
}
