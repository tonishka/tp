package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.tag.Tag;

/**
 * Represents a Person in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Person {

    // Identity fields
    private final Name name;

    // Data fields
    private final Map<String, Phone> numbers;
    private final Map<String, Email> emails;
    private final Map<String, Address> addresses;
    private final Company company;
    private final JobTitle jobTitle;
    private final HashSet<Pronoun> pronouns = new HashSet<>();
    private final HashSet<Tag> tags = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public Person(Name name, Map<String, Phone> numbers, Map<String, Email> emails,
                  Map<String, Address> addresses, Company company, JobTitle jobTitle, Set<Pronoun> pronouns,
                  Set<Tag> tags) {
        requireAllNonNull(name, pronouns, tags);
        this.name = name;
        this.numbers = numbers;
        this.emails = emails;
        this.addresses = addresses;
        this.company = company;
        this.jobTitle = jobTitle;
        this.pronouns.addAll(pronouns);
        this.tags.addAll(tags);
    }

    public Name getName() {
        return name;
    }

    public Map<String, Phone> getNumbers() {
        return numbers;
    }

    public Map<String, Email> getEmails() {
        return emails;
    }

    public Map<String, Address> getAddresses() {
        return addresses;
    }

    public Company getCompany() {
        return company;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public Set<Pronoun> getPronouns() {
        return Collections.unmodifiableSet(pronouns);
    }

    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    public HashSet<Tag> getTagSet() {
        return this.tags;
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
                && otherPerson.getPronouns().equals(getPronouns())
                && otherPerson.getTags().equals(getTags());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, numbers, emails, addresses, company, jobTitle, pronouns, tags);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Name: ")
                .append(getName())
                .append("; Company: ")
                .append(getCompany())
                .append("; Job Title: ")
                .append(getJobTitle());

        Set<Pronoun> pronouns = getPronouns();
        if (!pronouns.isEmpty()) {
            builder.append("; Pronouns: ");
            pronouns.forEach(builder::append);
        }

        Set<Tag> tags = getTags();
        if (!tags.isEmpty()) {
            builder.append("; Tags: ");
            tags.forEach(tag -> builder.append(tag.prettyString()));
        }

        Map<String, Phone> numbers = getNumbers();
        if (!numbers.isEmpty()) {
            builder.append("; Numbers: ");
            numbers.forEach((label, number) -> builder.append(number.phone + " l/" + label + " "));
        }

        Map<String, Address> addresses = getAddresses();
        if (!addresses.isEmpty()) {
            builder.append("; Addresses: ");
            addresses.forEach((label, address) -> builder.append(address.address + " l/" + label + " "));
        }

        Map<String, Email> emails = getEmails();
        if (!emails.isEmpty()) {
            builder.append("; Emails: ");
            emails.forEach((label, email) -> builder.append(email.email + " l/" + label + " "));
        }

        return builder.toString();
    }

}
