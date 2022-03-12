package seedu.address.model.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
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
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[]{
            new Person(
                    new Name("Alex Yeoh"),
                    new HashMap<>() {{
                        put("Personal", new Phone("87438807"));
                        put("Work", new Phone("82165492"));
                    }},
                    new HashMap<>() {{
                        put("Personal", new Email("alexyeoh@example.com"));
                        put("Work", new Email("alex_y@company.com"));
                    }},
                    new HashMap<>() {{
                        put("Home", new Address("Blk 30 Geylang Street 29, #06-40"));
                        put("Office", new Address("123 Raffles Business Tower"));
                    }},
                    new Company("Monsters Inc"),
                    new JobTitle("Scarer"),
                    new HashSet<>(Arrays.asList(new Pronoun("he"), new Pronoun("him"))),
                    new HashSet<>(Arrays.asList(new Tag("friend")))
            ),
            new Person(
                    new Name("Bernice Yu"),
                    new HashMap<>() {{
                        put("Personal", new Phone("99272758"));
                        put("Work", new Phone("93210283"));
                    }},
                    new HashMap<>() {{
                        put("Personal", new Email("berniceyu@example.com"));
                        put("Work", new Email("bernice_y@company.com"));
                    }},
                    new HashMap<>() {{
                        put("Home", new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"));
                        put("Office", new Address("1725 Slough Avenue, Scranton PA"));
                    }},
                    new Company("Dunder Mifflin"),
                    new JobTitle("Salesperson"),
                    new HashSet<>(Arrays.asList(new Pronoun("she"), new Pronoun("her"))),
                    new HashSet<>(Arrays.asList(new Tag("colleague"), new Tag("friend")))
            ),
            new Person(
                    new Name("David Li"),
                    new HashMap<>() {{
                        put("Personal", new Phone("91031282"));
                        put("Work", new Phone("92492021"));
                    }},
                    new HashMap<>() {{
                        put("Personal", new Email("lidavid@example.com"));
                        put("Work", new Email("david_li@company.com"));
                    }},
                    new HashMap<>() {{
                        put("Home", new Address("Blk 436 Serangoon Gardens Street 26, #16-43"));
                        put("Office", new Address("43 Springfield Avenue, Greendale County"));
                    }},
                    new Company("Greendale College"),
                    new JobTitle("Spanish Professor"),
                    new HashSet<>(Arrays.asList(new Pronoun("he"), new Pronoun("him"))),
                    new HashSet<>(Arrays.asList(new Tag("family")))
            )
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

    /**
     * Returns a pronoun set containing the list of strings given.
     */
    public static Set<Pronoun> getPronounSet(String... strings) {
        return Arrays.stream(strings)
                .map(Pronoun::new)
                .collect(Collectors.toSet());
    }

    /**
     * Returns a address map containing the list of strings given.
     */
    public static Map<String, Address> getAddressMap(String... strings) {
        return Arrays.stream(strings)
                .map(addressLabelPair -> addressLabelPair.split(" l/"))
                .collect(Collectors.toMap(addressLabelPair -> addressLabelPair.length == 1 ? "" : addressLabelPair[1],
                    addressLabelPair -> new Address(addressLabelPair[0])));
    }

    /**
     * Returns a email map containing the list of strings given.
     */
    public static Map<String, Email> getEmailMap(String... strings) {
        return Arrays.stream(strings)
                .map(emailLabelPair -> emailLabelPair.split(" l/"))
                .collect(Collectors.toMap(emailLabelPair -> emailLabelPair.length == 1 ? "" : emailLabelPair[1],
                    emailLabelPair -> new Email(emailLabelPair[0])));
    }

    /**
     * Returns a phone map containing the list of strings given.
     */
    public static Map<String, Phone> getPhoneMap(String... strings) {
        return Arrays.stream(strings)
                .map(phoneLabelPair -> phoneLabelPair.split(" l/"))
                .collect(Collectors.toMap(phoneLabelPair -> phoneLabelPair.length == 1 ? "" : phoneLabelPair[1],
                    phoneLabelPair -> new Phone(phoneLabelPair[0])));
    }

    /**
     * Drives sample data util.
     *
     * @param s parameter
     */
    public static void main(String[] s) {
        Map<String, Address> map = getAddressMap("Blk 30 Geylang Street 29, #06-40", "Blk 30 Geylang l/ home");
        for (Map.Entry<String, Address> entry : map.entrySet()) {
            String key = entry.getKey();
            Address tab = entry.getValue();
            System.out.print("Label: " + key + ", ");
            System.out.println("Address: " + tab);
        }
    }
}
