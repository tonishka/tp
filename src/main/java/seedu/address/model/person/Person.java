package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashMap;
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
    private Name name;

    // Data fields
    private Map<String, Phone> numbers;
    private Map<String, Email> emails;
    private Map<String, Address> addresses;
    private Company company;
    private JobTitle jobTitle;
    private HashSet<Pronoun> pronouns = new HashSet<>();
    private HashSet<Tag> tags = new HashSet<>();

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

    /**
     * Returns an empty person with nothing values.
     *
     * @return an empty person with nothing values
     */
    public static Person getEmptyPerson() {
        return new Person(new Name("No name"), new HashMap<>(), new HashMap<>(), new HashMap<>(),
                new Company("No Company"), new JobTitle("No JobTitle"), new HashSet<>(), new HashSet<>());
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Map<String, Phone> getNumbers() {
        return Collections.unmodifiableMap(numbers);
    }

    public void setNumbers(Map<String, Phone> numbers) {
        this.numbers = (numbers != null) ? new HashMap<String, Phone>(numbers) : null;
    }

    public Map<String, Email> getEmails() {
        return Collections.unmodifiableMap(emails);
    }

    public void setEmails(Map<String, Email> emails) {
        this.emails = (emails != null) ? new HashMap<String, Email>(emails) : null;
    }

    public Map<String, Address> getAddresses() {
        return Collections.unmodifiableMap(addresses);
    }

    public void setAddresses(Map<String, Address> addresses) {
        this.addresses = (addresses != null) ? new HashMap<String, Address>(addresses) : null;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Set<Pronoun> getPronouns() {
        return Collections.unmodifiableSet(pronouns);
    }

    public void setPronouns(Set<Pronoun> pronouns) {
        this.pronouns = (pronouns != null) ? new HashSet<>(pronouns) : null;
    }

    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    public void setTags(Set<Tag> tags) {
        this.tags = (tags != null) ? new HashSet<>(tags) : null;
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
            pronouns.stream().limit(1).forEach(builder::append);
            pronouns.stream().skip(1).forEach(pronoun -> builder.append("/" + pronoun));

        }

        Set<Tag> tags = getTags();
        if (!tags.isEmpty()) {
            builder.append("; Tags: ");
            tags.forEach(tag -> builder.append("[" + tag + "]"));
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
