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
    private final HashMap<String, JsonAdaptedPhone> numbers;
    private final String email;
    private final HashMap<String, JsonAdaptedAddress> addresses;
    private final List<JsonAdaptedTag> tagged = new ArrayList<>();

    /**
     * Constructs a {@code JsonAdaptedPerson} with the given person details.
     */
    @JsonCreator
    public JsonAdaptedPerson(@JsonProperty("name") String name,
            @JsonProperty("numbers") HashMap<String, JsonAdaptedPhone> numbers,
            @JsonProperty("email") String email,
            @JsonProperty("addresses") HashMap<String, JsonAdaptedAddress> addresses,
            @JsonProperty("tagged") List<JsonAdaptedTag> tagged) {
        this.name = name;
        this.numbers = numbers;
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
        email = source.getEmails().toString();

        HashMap<String, JsonAdaptedPhone> numbersMap = new HashMap<String, JsonAdaptedPhone>();
        for (String key : source.getNumbers().keySet()) {
            numbersMap.put(key, new JsonAdaptedPhone(source.getNumbers().get(key)));
        }
        numbers = numbersMap;

        HashMap<String, JsonAdaptedAddress> addressesMap = new HashMap<String, JsonAdaptedAddress>();
        for (String key : source.getAddresses().keySet()) {
            addressesMap.put(key, new JsonAdaptedAddress(source.getAddresses().get(key)));
        }
        addresses = addressesMap;

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

        HashMap<String, Phone> modelNumbers = new HashMap<String, Phone>();
        if (numbers != null) {
            for (Map.Entry<String, JsonAdaptedPhone> mapElement : numbers.entrySet()) {
                String key = mapElement.getKey();
                modelNumbers.put(key, mapElement.getValue().toModelType());
            }
        }

        HashMap<String, Address> modelAddresses = new HashMap<String, Address>();
        if (addresses != null) {
            for (Map.Entry<String, JsonAdaptedAddress> mapElement : addresses.entrySet()) {
                String key = mapElement.getKey();
                modelAddresses.put(key, mapElement.getValue().toModelType());
            }
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

        return new Person(modelName, modelNumbers, new HashMap<>(), modelAddresses,
                new Company("Placeholder"), new JobTitle("Placeholder"), new HashSet<>(), modelTags);
    }

    @Override
    public String toString() {
        return "JsonAdaptedPerson{"
                + "name='" + name + '\''
                + ", phone='" + numbers + '\''
                + ", email='" + email + '\''
                + ", addresses='" + addresses + '\''
                + ", tagged=" + tagged +
                + '}';
    }
}
