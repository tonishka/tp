package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_VIEW;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_COMPANY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_JOBTITLE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PRONOUN;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import seedu.address.commons.util.CollectionUtil;
import seedu.address.logic.commands.DeleteFieldCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.label.Label;
import seedu.address.model.person.Address;
import seedu.address.model.person.EditPersonDescriptor;
import seedu.address.model.person.Email;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Pronoun;
import seedu.address.model.tag.Tag;

public class DeleteFieldCommandParser implements Parser<DeleteFieldCommand> {
    @Override
    public DeleteFieldCommand parse(String userInput) throws ParseException {
        throw new ParseException(MESSAGE_INVALID_VIEW);
    }

    /**
     * Parses the user input to delete desired fields.
     *
     * @param args User input.
     * @param personToDeleteField Person being edited.
     * @return Command to delete fields of a person.
     * @throws ParseException For invalid user input.
     */
    public DeleteFieldCommand parse(String args, Person personToDeleteField) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_NAME, PREFIX_COMPANY, PREFIX_JOBTITLE,
                        PREFIX_PRONOUN, PREFIX_PHONE, PREFIX_EMAIL, PREFIX_ADDRESS, PREFIX_TAG);

        if (!argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    DeleteFieldCommand.MESSAGE_USAGE));
        }

        EditPersonDescriptor deleteFieldDescriptor = new EditPersonDescriptor(personToDeleteField);

        if (argMultimap.getValue(PREFIX_NAME).isPresent()) {
            throw new ParseException(MESSAGE_INVALID_VIEW + "\n"
                    + DeleteFieldCommand.MESSAGE_DELETE_NAME_FAILURE);
        }

        if (argMultimap.getValue(PREFIX_COMPANY).isPresent()) {
            deleteFieldDescriptor.setCompany(null);
        }

        if (argMultimap.getValue(PREFIX_JOBTITLE).isPresent()) {
            deleteFieldDescriptor.setJobTitle(null);
        }

        if (deleteFieldDescriptor.getNumbers().isPresent()) {
            Collection<String> numbersToBeDeleted = argMultimap.getAllValues(PREFIX_PHONE);

            requireNonNull(numbersToBeDeleted);

            if (CollectionUtil.hasEmptyString(numbersToBeDeleted)) {
                deleteFieldDescriptor.setNumbers(new HashMap<>());
            } else {
                Map<Label, Phone> numbers = new HashMap<>(deleteFieldDescriptor.getNumbers().orElse(new HashMap<>()));

                for (String number : numbersToBeDeleted) {
                    if (!Label.isValidLabel(number)) {
                        throw new ParseException(Label.MESSAGE_CONSTRAINTS);
                    }
                    numbers.remove(new Label(number, false));
                }
                deleteFieldDescriptor.setNumbers(numbers);
            }
        }

        if (deleteFieldDescriptor.getEmails().isPresent()) {
            Collection<String> emailsToBeDeleted = argMultimap.getAllValues(PREFIX_EMAIL);

            requireNonNull(emailsToBeDeleted);

            if (CollectionUtil.hasEmptyString(emailsToBeDeleted)) {
                deleteFieldDescriptor.setEmails(new HashMap<>());
            } else {
                Map<Label, Email> emails = new HashMap<>(deleteFieldDescriptor.getEmails().orElse(new HashMap<>()));

                for (String email : emailsToBeDeleted) {
                    if (!Label.isValidLabel(email)) {
                        throw new ParseException(Label.MESSAGE_CONSTRAINTS);
                    }
                    emails.remove(new Label(email, false));
                }
                deleteFieldDescriptor.setEmails(emails);
            }
        }

        if (deleteFieldDescriptor.getAddresses().isPresent()) {
            Collection<String> addressesToBeDeleted = argMultimap.getAllValues(PREFIX_ADDRESS);

            requireNonNull(addressesToBeDeleted);

            if (CollectionUtil.hasEmptyString(addressesToBeDeleted)) {
                deleteFieldDescriptor.setAddresses(new HashMap<>());
            } else {
                Map<Label, Address> addresses =
                        new HashMap<>(deleteFieldDescriptor.getAddresses().orElse(new HashMap<>()));

                for (String address : addressesToBeDeleted) {
                    if (!Label.isValidLabel(address)) {
                        throw new ParseException(Label.MESSAGE_CONSTRAINTS);
                    }
                    addresses.remove(new Label(address, false));
                }
                deleteFieldDescriptor.setAddresses(addresses);
            }
        }

        if (deleteFieldDescriptor.getTags().isPresent()) {
            Collection<String> tagsToBeDeleted = argMultimap.getAllValues(PREFIX_TAG);

            requireNonNull(tagsToBeDeleted);

            if (CollectionUtil.hasEmptyString(tagsToBeDeleted)) {
                deleteFieldDescriptor.setTags(new HashSet<>());
            } else {
                Set<Tag> tags = new HashSet<>(deleteFieldDescriptor.getTags().orElse(new HashSet<>()));
                tagsToBeDeleted.forEach(tag -> tags.remove(new Tag(tag)));
                deleteFieldDescriptor.setTags(tags);
            }
        }

        if (deleteFieldDescriptor.getPronouns().isPresent()) {
            Collection<String> pronounsToBeDeleted = argMultimap.getAllValues(PREFIX_PRONOUN);

            requireNonNull(pronounsToBeDeleted);

            if (CollectionUtil.hasEmptyString(pronounsToBeDeleted)) {
                deleteFieldDescriptor.setPronouns(new HashSet<>());
            } else {
                Set<Pronoun> pronouns = new HashSet<>(deleteFieldDescriptor.getPronouns().orElse(new HashSet<>()));
                pronounsToBeDeleted.forEach(pronoun -> pronouns.remove(new Pronoun(pronoun)));
                deleteFieldDescriptor.setPronouns(pronouns);
            }
        }

        if (!deleteFieldDescriptor.isAnyFieldDeleted()) {
            throw new ParseException(DeleteFieldCommand.MESSAGE_NOT_DELETED_FIELD);
        }

        return new DeleteFieldCommand(deleteFieldDescriptor, personToDeleteField);
    }
}
