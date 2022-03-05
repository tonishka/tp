package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.HashMap;
import java.util.Objects;

import seedu.address.model.tag.Tag;

/**
 * Represents a Person in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Person {

    // Identity fields
    private final Name name;

    // Data fields
    private final HashMap<String, Phone> numbers;
    private final HashMap<String, Email> emails;
    private final HashMap<String, Address> addresses;
    private final Company company;
    private final JobTitle jobTitle;
    private final Pronoun pronoun;
    private final HashMap<String, Tag> tags;

    /**
     * Every field must be present and not null.
     */
    public Person(Name name, HashMap<String, Phone> numbers, HashMap<String, Email> emails,
                  HashMap<String, Address> addresses, Company company, JobTitle jobTitle, Pronoun pronoun, HashMap<String, Tag> tags) {
        requireAllNonNull(name, numbers, emails, addresses, company, jobTitle, pronoun, tags);
        this.name = name;
        this.numbers = numbers;
        this.emails = emails;
        this.addresses = addresses;
        this.company = company;
        this.jobTitle = jobTitle;
        this.pronoun = pronoun;
        this.tags = tags;
    }

    public Name getName() {
        return name;
    }

    public HashMap<String, Phone> getNumbers() {
        return numbers;
    }

    public HashMap<String, Email> getEmails() {
        return emails;
    }

    public HashMap<String, Address> getAddresses() {
        return addresses;
    }

    public Company getCompany() {
        return company;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public Pronoun getPronoun() {
        return pronoun;
    }

    public HashMap<String, Tag> getTags() {
        return tags;
    }

    /**
     * Returns true if both persons have the same name.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSamePerson(Person otherPerson) {
        if (otherPerson == this) {
            return true;
        }

        return otherPerson != null
                && otherPerson.getName().equals(getName());
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Person)) {
            return false;
        }

        Person otherPerson = (Person) other;
        return otherPerson.getName().equals(getName())
                && otherPerson.getNumbers().equals(getNumbers())
                && otherPerson.getEmails().equals(getEmails())
                && otherPerson.getAddresses().equals(getAddresses())
                && otherPerson.getCompany().equals(getCompany())
                && otherPerson.getJobTitle().equals(getJobTitle())
                && otherPerson.getPronoun().equals(getPronoun())
                && otherPerson.getTags().equals(getTags());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, numbers, emails, addresses, company, jobTitle, pronoun, tags);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append("; Numbers: ")
                .append(getNumbers())
                .append("; Emails: ")
                .append(getEmails())
                .append("; Addresses: ")
                .append(getAddresses())
                .append("; Company: ")
                .append(getCompany())
                .append("; Job Title: ")
                .append(getJobTitle())
                .append("; Pronouns: ")
                .append(getPronoun())
                .append("; Tags: ")
                .append(getTags());

        return builder.toString();
    }

}
