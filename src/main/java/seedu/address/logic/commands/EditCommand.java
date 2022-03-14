package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import seedu.address.commons.util.CollectionUtil;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Address;
import seedu.address.model.person.Company;
import seedu.address.model.person.Email;
import seedu.address.model.person.JobTitle;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Pronoun;
import seedu.address.model.tag.Tag;

/**
 * Edits the details of an existing person in the address book.
 */
public class EditCommand extends Command {

    public static final String COMMAND_WORD = "edit";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits the details of the person identified "
            + "by the index number used in the displayed person list. "
            + "Existing values will be overwritten by the input values.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + "[" + PREFIX_NAME + "NAME] "
            + "[" + PREFIX_PHONE + "PHONE] "
            + "[" + PREFIX_EMAIL + "EMAIL] "
            + "[" + PREFIX_ADDRESS + "ADDRESS] "
            + "[" + PREFIX_TAG + "TAG]...\n"
            + "Example: " + COMMAND_WORD + " 1 "
            + PREFIX_PHONE + "91234567 "
            + PREFIX_EMAIL + "johndoe@example.com";

    public static final String MESSAGE_EDIT_PERSON_SUCCESS = "Edited Person: %1$s";
    public static final String MESSAGE_NOT_EDITED = "At least one field to edit must be provided.";
    public static final String MESSAGE_DUPLICATE_PERSON = "This person already exists in the address book.";

    private final EditPersonDescriptor editPersonDescriptor;
    private final Person personToEdit;

    /**
     * @param editPersonDescriptor details to edit the person with
     * @param personToEdit the target person
     */
    public EditCommand(EditPersonDescriptor editPersonDescriptor, Person personToEdit) {
        requireNonNull(editPersonDescriptor);
        requireNonNull(personToEdit);
        this.personToEdit = personToEdit;
        this.editPersonDescriptor = new EditPersonDescriptor(editPersonDescriptor);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        Person personToEdit = this.personToEdit;
        Person editedPerson = createUpdatedPerson(personToEdit, editPersonDescriptor);

        if (!personToEdit.isSamePerson(editedPerson) && model.hasPerson(editedPerson)) {
            throw new CommandException(MESSAGE_DUPLICATE_PERSON);
        }

        model.setPerson(personToEdit, editedPerson);
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        return new CommandResult(String.format(MESSAGE_EDIT_PERSON_SUCCESS, editedPerson), false, false,
                false, true,
                editedPerson);
    }

    /*
     * Creates and returns a {@code Person} with the details of {@code personToEdit}
     * edited with {@code editPersonDescriptor}.Note that this is different from createEditedPerson as
     * createEditedPerson replaces all HashMaps and HashSet components of Person with that of the editPersonDescriptor
     * while this adds the values of the HashMaps and HashSet components of Person with that of the
     * editedPersonDescriptor.
     */
    public static Person createUpdatedPerson(Person personToEdit, EditPersonDescriptor editPersonDescriptor) {
        requireNonNull(personToEdit != null);

        Name updatedName = editPersonDescriptor.getName().orElse(personToEdit.getName());
        Company updatedCompany = editPersonDescriptor.getCompany().orElse(personToEdit.getCompany());
        JobTitle updatedJobTitle = editPersonDescriptor.getJobTitle().orElse(personToEdit.getJobTitle());

        //New HashMaps are created to remove Unmodifiable Map's limitation
        Map<String, Phone> updatedPhones = new HashMap<>(personToEdit.getNumbers());
        updatedPhones.putAll(editPersonDescriptor.getNumbers().orElse(new HashMap<>()));

        Map<String, Email> updatedEmails = new HashMap<>(personToEdit.getEmails());
        updatedEmails.putAll(editPersonDescriptor.getEmails().orElse(new HashMap<>()));

        Map<String, Address> updatedAddresses = new HashMap<>(personToEdit.getAddresses());
        updatedAddresses.putAll(editPersonDescriptor.getAddresses().orElse(new HashMap<>()));

        Set<Pronoun> updatedPronouns = new HashSet<>(personToEdit.getPronouns());
        updatedPronouns.addAll(editPersonDescriptor.getPronouns().orElse(new HashSet<>()));

        Set<Tag> updatedTags = new HashSet<>(personToEdit.getTags());
        updatedTags.addAll(editPersonDescriptor.getTags().orElse(new HashSet<>()));

        return new Person(updatedName, updatedPhones, updatedEmails, updatedAddresses,
                updatedCompany, updatedJobTitle, updatedPronouns, updatedTags);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof EditCommand)) {
            return false;
        }

        // state check
        EditCommand e = (EditCommand) other;
        return personToEdit.equals(e.personToEdit)
                && editPersonDescriptor.equals(e.editPersonDescriptor);
    }

    @Override
    public String toString() {
        return "Edit " + personToEdit + ": " + editPersonDescriptor;
    }

    /**
     * Stores the details to edit the person with. Each non-empty field value will replace the
     * corresponding field value of the person.
     */
    public static class EditPersonDescriptor {
        private Name name;
        private HashMap<String, Phone> numbers;
        private HashMap<String, Email> emails;
        private HashMap<String, Address> addresses;
        private Company company;
        private JobTitle jobTitle;
        private HashSet<Pronoun> pronouns;
        private HashSet<Tag> tags;

        public EditPersonDescriptor() {
        }

        /**
         * Copy constructor.
         * A defensive copy of {@code tags} is used internally.
         */
        public EditPersonDescriptor(EditPersonDescriptor toCopy) {
            setName(toCopy.name);
            setNumbers(toCopy.numbers);
            setEmails(toCopy.emails);
            setAddresses(toCopy.addresses);
            setTags(toCopy.tags);
            setCompany(toCopy.company);
            setJobTitle(toCopy.jobTitle);
            setPronouns(toCopy.pronouns);
        }

        /**
         * Returns true if at least one field is edited.
         */
        public boolean isAnyFieldEdited() {
            return CollectionUtil.isAnyNonNull(name, numbers, emails, addresses, tags, company, pronouns, jobTitle);
        }

        //----Single data fields----
        //Company
        public void setCompany(Company company) {
            this.company = company;
        }

        public Optional<Company> getCompany() {
            return Optional.ofNullable(company);
        }

        //JobTitle
        public void setJobTitle(JobTitle jobTitle) {
            this.jobTitle = jobTitle;
        }

        public Optional<JobTitle> getJobTitle() {
            return Optional.ofNullable(jobTitle);
        }

        //Name
        public void setName(Name name) {
            this.name = name;
        }

        public Optional<Name> getName() {
            return Optional.ofNullable(name);
        }

        //-----Multiple data fields----
        //Phone
        public void setNumbers(Map<String, Phone> numbers) {
            this.numbers = (numbers != null) ? new HashMap<String, Phone>(numbers) : null;
        }

        public Optional<Map<String, Phone>> getNumbers() {
            return (numbers != null) ? Optional.of(Collections.unmodifiableMap(numbers)) : Optional.empty();
        }

        //Email
        public void setEmails(Map<String, Email> emails) {
            this.emails = (emails != null) ? new HashMap<String, Email>(emails) : null;
        }

        public Optional<Map<String, Email>> getEmails() {
            return (emails != null) ? Optional.of(Collections.unmodifiableMap(emails)) : Optional.empty();
        }

        //Address
        public void setAddresses(Map<String, Address> addresses) {
            this.addresses = (addresses != null) ? new HashMap<String, Address>(addresses) : null;
        }

        public Optional<Map<String, Address>> getAddresses() {
            return (addresses != null) ? Optional.of(Collections.unmodifiableMap(addresses)) : Optional.empty();
        }

        //Tags

        /**
         * Sets {@code tags} to this object's {@code tags}.
         * A defensive copy of {@code tags} is used internally.
         */
        public void setTags(Set<Tag> tags) {
            this.tags = (tags != null) ? new HashSet<>(tags) : null;
        }

        /**
         * Returns an unmodifiable tag set, which throws {@code UnsupportedOperationException}
         * if modification is attempted.
         * Returns {@code Optional#empty()} if {@code tags} is null.
         */
        public Optional<Set<Tag>> getTags() {
            return (tags != null) ? Optional.of(Collections.unmodifiableSet(tags)) : Optional.empty();
        }

        //Pronouns

        /**
         * Sets {@code pronouns} to this object's {@code pronouns}.
         * A defensive copy of {@code pronouns} is used internally.
         */
        public void setPronouns(Set<Pronoun> pronouns) {
            this.pronouns = (pronouns != null) ? new HashSet<>(pronouns) : null;
        }

        /**
         * Returns an unmodifiable pronouns set, which throws {@code UnsupportedOperationException}
         * if modification is attempted.
         * Returns {@code Optional#empty()} if {@code pronouns} is null.
         */
        public Optional<Set<Pronoun>> getPronouns() {
            return (pronouns != null) ? Optional.of(Collections.unmodifiableSet(pronouns)) : Optional.empty();
        }
        //

        @Override
        public boolean equals(Object other) {
            // short circuit if same object
            if (other == this) {
                return true;
            }

            // instanceof handles nulls
            if (!(other instanceof EditPersonDescriptor)) {
                return false;
            }

            // state check
            EditPersonDescriptor e = (EditPersonDescriptor) other;

            return getName().equals(e.getName())
                    && getNumbers().equals(e.getNumbers())
                    && getEmails().equals(e.getEmails())
                    && getAddresses().equals(e.getAddresses())
                    && getTags().equals(e.getTags());
        }

        @Override
        public String toString() {
            final StringBuilder builder = new StringBuilder();
            builder.append("EditPersonDescriptor: [");
            builder.append("Name: ")
                    .append(getName())
                    .append("; Company: ")
                    .append(getCompany())
                    .append("; Job Title: ")
                    .append(getJobTitle());

            Set<Pronoun> pronouns = getPronouns().get();
            if (!pronouns.isEmpty()) {
                builder.append("; Pronouns: ");
                pronouns.forEach(builder::append);
            }

            Set<Tag> tags = getTags().get();
            if (!tags.isEmpty()) {
                builder.append("; Tags: ");
                tags.forEach(builder::append);
            }

            Map<String, Phone> numbers = getNumbers().get();
            if (!numbers.isEmpty()) {
                builder.append("; Numbers: ");
                numbers.forEach((label, number) -> builder.append(number.phone + " l/" + label + " "));
            }

            Map<String, Address> addresses = getAddresses().get();
            if (!addresses.isEmpty()) {
                builder.append("; Addresses: ");
                addresses.forEach((label, address) -> builder.append(address.address + " l/" + label + " "));
            }

            Map<String, Email> emails = getEmails().get();
            if (!emails.isEmpty()) {
                builder.append("; Emails: ");
                emails.forEach((label, email) -> builder.append(email.email + " l/" + label + " "));
            }
            builder.append("]");
            return builder.toString();
        }
    }
}
