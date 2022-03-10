package seedu.address.storage;

import java.util.*;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Address;
import seedu.address.model.person.Company;
import seedu.address.model.person.Email;
import seedu.address.model.person.JobTitle;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.Tag;

/**
 * Jackson-friendly version of {@link Person}.
 */
class JsonAdaptedPerson {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Person's %s field is missing!";

    private final String name;
    private final String phone;
    private final String email;
    private final HashMap<String, JsonAdaptedAddress> addresses;
    private final List<JsonAdaptedTag> tagged = new ArrayList<>();

    /**
     * Constructs a {@code JsonAdaptedPerson} with the given person details.
     */
    @JsonCreator
    public JsonAdaptedPerson(@JsonProperty("name") String name, @JsonProperty("phone") String phone,
            @JsonProperty("email") String email, @JsonProperty("addresses") HashMap<String, JsonAdaptedAddress> addresses,
            @JsonProperty("tagged") List<JsonAdaptedTag> tagged) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.addresses = addresses;

        if (tagged != null) {
            this.tagged.addAll(tagged);
        }
    }

    /**
     * Converts a given {@code Person} into this class for Jackson use.
     */
    public JsonAdaptedPerson(Person source) {
        name = source.getName().fullName;
        phone = source.getNumbers().toString();
        email = source.getEmails().toString();
        HashMap<String, JsonAdaptedAddress> ret = new HashMap<String, JsonAdaptedAddress>();
        for (String key : source.getAddresses().keySet()) {
            ret.put(key, new JsonAdaptedAddress(source.getAddresses().get(key)));
        }
        addresses = ret;

        tagged.addAll(source.getTags().stream()
                .map(JsonAdaptedTag::new)
                .collect(Collectors.toList()));
    }

    /**
     * Converts this Jackson-friendly adapted person object into the model's {@code Person} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person.
     */
    public Person toModelType() throws IllegalValueException {
        final List<Tag> personTags = new ArrayList<>();
        for (JsonAdaptedTag tag : tagged) {
            personTags.add(tag.toModelType());
        }

        HashMap<String, Address> modelAddresses = new HashMap<String, Address>();
        for (Map.Entry<String, JsonAdaptedAddress> mapElement : addresses.entrySet()) {
            String key = mapElement.getKey();
            modelAddresses.put(key, mapElement.getValue().toModelType());
        }

        if (name == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        if (!Name.isValidName(name)) {
            throw new IllegalValueException(Name.MESSAGE_CONSTRAINTS);
        }
        final Name modelName = new Name(name);

//        if (phone == null) {
//            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Phone.class.getSimpleName()));
//        }
//        if (!Phone.isValidPhone(phone)) {
//            throw new IllegalValueException(Phone.MESSAGE_CONSTRAINTS);
//        }
//        final Phone modelPhone = new Phone(phone);
//
//        if (email == null) {
//            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Email.class.getSimpleName()));
//        }
//        if (!Email.isValidEmail(email)) {
//            throw new IllegalValueException(Email.MESSAGE_CONSTRAINTS);
//        }
//        final Email modelEmail = new Email(email);

        final Set<Tag> modelTags = new HashSet<Tag>(personTags);

        return new Person(modelName, new HashMap<>(), new HashMap<>(), modelAddresses,
                new Company("Placeholder"), new JobTitle("Placeholder"), new HashSet<>(), modelTags);
    }

    @Override
    public String toString() {
        return "JsonAdaptedPerson{"
                + "name='" + name + '\''
                + ", phone='" + phone + '\''
                + ", email='" + email + '\''
                + ", addresses='" + addresses + '\''
                + ", tagged=" + tagged +
                + '}';
    }
}
