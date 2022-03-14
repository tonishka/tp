package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Arrays;

import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.FieldContainsKeywordsPredicate;

/**
 * Parses input arguments and creates a new FindCommand object
 */
public class FindCommandParser implements Parser<FindCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the FindCommand
     * and returns a FindCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public FindCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
        }

        String field = "all"; // If field is not provided or not a valid field, all fields are searched
        String fieldKeywords[] = trimmedArgs.split(" ");
        String[] tempArr = trimmedArgs.split(" ");
        final String STARTS_WITH_FIELD_REGEX = "^[a-z]{1,2}[/](.|\\n)*";

        if (trimmedArgs.matches(STARTS_WITH_FIELD_REGEX)) {
            tempArr = trimmedArgs.split("/", 2);
            field = tempArr[0];
        }
        if (!field.equals("all") && tempArr[1].trim().isEmpty()) {
            // Field provided but no keywords
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
        }
        if (!field.equals("all") && !tempArr[1].trim().isEmpty()) {
            // Field provided and keywords are given
            fieldKeywords = tempArr[1].trim().split("\\s+");
        }

        return new FindCommand(new FieldContainsKeywordsPredicate(Arrays.asList(fieldKeywords), field));
    }

}

