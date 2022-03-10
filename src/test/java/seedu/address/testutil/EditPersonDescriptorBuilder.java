package seedu.address.testutil;

import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.logic.commands.EditCommand.EditPersonDescriptor;
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
 * A utility class to help with building EditPersonDescriptor objects.
 */
public class EditPersonDescriptorBuilder {

    private EditPersonDescriptor descriptor;

    public EditPersonDescriptorBuilder() {
        descriptor = new EditPersonDescriptor();
    }

    public EditPersonDescriptorBuilder(EditPersonDescriptor descriptor) {
        this.descriptor = new EditPersonDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditPersonDescriptor} with fields containing {@code person}'s details
     */
    public EditPersonDescriptorBuilder(Person person) {
        descriptor = new EditPersonDescriptor();

        descriptor.setName(person.getName());
        descriptor.setCompany(person.getCompany());
        descriptor.setJobTitle(person.getJobTitle());
        descriptor.setNumbers(person.getNumbers());
        descriptor.setEmails(person.getEmails());
        descriptor.setAddresses(person.getAddresses());
        descriptor.setPronouns(person.getPronouns());
        descriptor.setTags(person.getTags());
    }

    /**
     * Sets the {@code Name} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withName(String name) {
        descriptor.setName(new Name(name));
        return this;
    }

    /**
     * Sets the {@code Company} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withCompany(String company) {
        descriptor.setCompany(new Company(company));
        return this;
    }

    /**
     * Sets the {@code JobTitle} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withJobTitle(String jobTitle) {
        descriptor.setJobTitle(new JobTitle(jobTitle));
        return this;
    }


    /**
     * Sets the {@code Phone} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withPhone(String phone) {
        HashMap<String, Phone> numbers = new HashMap<>();
        String[] phoneWithTag = phone.split(" l/");
        if (phoneWithTag.length == 1) {
            numbers.put("", new Phone(phone));
        } else {
            numbers.put(phoneWithTag[1], new Phone(phoneWithTag[0]));
        }
        descriptor.setNumbers(numbers);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withEmail(String email) {
        HashMap<String, Email> emails = new HashMap<>();
        String[] emailWithTag = email.split(" l/");
        if (emailWithTag.length == 1) {
            emails.put("", new Email(email));
        } else {
            emails.put(emailWithTag[1], new Email(emailWithTag[0]));
        }
        descriptor.setEmails(emails);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withAddress(String address) {
        HashMap<String, Address> addresses = new HashMap<>();
        String[] addressWithTag = address.split(" l/");
        if (addressWithTag.length == 1) {
            addresses.put("", new Address(address));
        } else {
            addresses.put(addressWithTag[1], new Address(addressWithTag[0]));
        }
        descriptor.setAddresses(addresses);
        return this;
    }

    /**
     * Parses the {@code pronouns} into a {@code Set<Pronouns>} and set it to the {@code EditPersonDescriptor}
     * that we are building.
     */
    public EditPersonDescriptorBuilder withPronouns(String... pronouns) {
        Set<Pronoun> pronounSet = Stream.of(pronouns).map(Pronoun::new).collect(Collectors.toSet());
        descriptor.setPronouns(pronounSet);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code EditPersonDescriptor}
     * that we are building.
     */
    public EditPersonDescriptorBuilder withTags(String... tags) {
        Set<Tag> tagSet = Stream.of(tags).map(Tag::new).collect(Collectors.toSet());
        descriptor.setTags(tagSet);
        return this;
    }

    public EditPersonDescriptor build() {
        return descriptor;
    }
}
