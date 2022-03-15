package seedu.address.model.person;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import seedu.address.commons.util.CollectionUtil;
import seedu.address.model.tag.Tag;


/**
 * Stores the details to edit the person with. Each non-empty field value will replace the
 * corresponding field value of the person.
 */
public class EditPersonDescriptor {
    private Name name;
    private HashMap<String, Phone> numbers;
    private HashMap<String, Email> emails;
    private HashMap<String, Address> addresses;
    private Company company;
    private JobTitle jobTitle;
    private HashSet<Pronoun> pronouns;
    private HashSet<Tag> tags;

    public EditPersonDescriptor() {}

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
     * Person constructor.
     */
    public EditPersonDescriptor(Person toCopy) {
        setName(toCopy.getName());
        setNumbers(toCopy.getNumbers());
        setEmails(toCopy.getEmails());
        setAddresses(toCopy.getAddresses());
        setTags(toCopy.getTags());
        setCompany(toCopy.getCompany().get());
        setJobTitle(toCopy.getJobTitle().get());
        setPronouns(toCopy.getPronouns());
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
