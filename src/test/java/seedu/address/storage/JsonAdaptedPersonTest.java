package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.storage.JsonAdaptedPerson.MISSING_FIELD_MESSAGE_FORMAT;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalPersons.BENSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;

public class JsonAdaptedPersonTest {
    private static final String INVALID_NAME = "R@chel";
    private static final String INVALID_PHONE = "+651234";
    private static final String INVALID_ADDRESS = " ";
    private static final String INVALID_EMAIL = "example.com";
    private static final String INVALID_TAG = "#friend";

    private static final String VALID_NAME = BENSON.getName().toString();
    private static final String VALID_PHONE = "98765432";
    private static final String VALID_EMAIL = BENSON.getEmails().toString();
    private static final String VALID_ADDRESS = "123 Monty Carl, 326459";
    private static final List<JsonAdaptedTag> VALID_TAGS = BENSON.getTags().stream()
            .map(JsonAdaptedTag::new)
            .collect(Collectors.toList());


    @Test
    public void toModelType_validPersonDetails_returnsPerson() throws Exception {
        JsonAdaptedPerson person = new JsonAdaptedPerson(BENSON);
        assertEquals(BENSON, person.toModelType());
    }

    @Test
    public void toModelType_invalidName_throwsIllegalValueException() {
        HashMap<String, JsonAdaptedAddress> validAddresses = new HashMap<>();
        validAddresses.put("address#1", new JsonAdaptedAddress(VALID_ADDRESS));

        HashMap<String, JsonAdaptedPhone> validNumbers = new HashMap<>();
        validNumbers.put("phone#1", new JsonAdaptedPhone(VALID_PHONE));

        JsonAdaptedPerson person =
                new JsonAdaptedPerson(INVALID_NAME, validNumbers, VALID_EMAIL, validAddresses, VALID_TAGS);
        String expectedMessage = Name.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullName_throwsIllegalValueException() {
        HashMap<String, JsonAdaptedAddress> validAddresses = new HashMap<>();
        validAddresses.put("address#1", new JsonAdaptedAddress(VALID_ADDRESS));

        HashMap<String, JsonAdaptedPhone> validNumbers = new HashMap<>();
        validNumbers.put("phone#1", new JsonAdaptedPhone(VALID_PHONE));

        JsonAdaptedPerson person = new JsonAdaptedPerson(null, validNumbers, VALID_EMAIL,
                validAddresses, VALID_TAGS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidPhone_throwsIllegalValueException() {
        HashMap<String, JsonAdaptedAddress> validAddresses = new HashMap<>();
        validAddresses.put("address#1", new JsonAdaptedAddress(VALID_ADDRESS));

        HashMap<String, JsonAdaptedPhone> invalidNumbers = new HashMap<>();
        invalidNumbers.put("phone#1", new JsonAdaptedPhone(INVALID_PHONE));

        JsonAdaptedPerson person =
                new JsonAdaptedPerson(VALID_NAME, invalidNumbers, VALID_EMAIL, validAddresses, VALID_TAGS);
        String expectedMessage = Phone.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

/*
 In Reache, phone numbers are not mandatory fields
    @Test
    public void toModelType_nullPhone_throwsIllegalValueException() {
        JsonAdaptedPerson person = new JsonAdaptedPerson(VALID_NAME, null, VALID_EMAIL, VALID_ADDRESS, VALID_TAGS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Phone.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }
*/

    @Test
    public void toModelType_invalidEmail_throwsIllegalValueException() {
        HashMap<String, JsonAdaptedAddress> validAddresses = new HashMap<>();
        validAddresses.put("address#1", new JsonAdaptedAddress(VALID_ADDRESS));

        HashMap<String, JsonAdaptedPhone> validNumbers = new HashMap<>();
        validNumbers.put("phone#1", new JsonAdaptedPhone(VALID_PHONE));

        JsonAdaptedPerson person =
                new JsonAdaptedPerson(VALID_NAME, validNumbers, INVALID_EMAIL, validAddresses, VALID_TAGS);
        String expectedMessage = Email.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

/*
 In Reache, emails are not mandatory fields
    @Test
    public void toModelType_nullEmail_throwsIllegalValueException() {
        JsonAdaptedPerson person = new JsonAdaptedPerson(VALID_NAME, VALID_PHONE, null, VALID_ADDRESS, VALID_TAGS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Email.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }
*/

    @Test
    public void toModelType_invalidAddress_throwsIllegalValueException() {
        HashMap<String, JsonAdaptedAddress> invalidAddresses = new HashMap<>();
        invalidAddresses.put("address#1", new JsonAdaptedAddress(INVALID_ADDRESS));

        HashMap<String, JsonAdaptedPhone> validNumbers = new HashMap<>();
        validNumbers.put("phone#1", new JsonAdaptedPhone(VALID_PHONE));

        JsonAdaptedPerson person =
                new JsonAdaptedPerson(VALID_NAME, validNumbers, VALID_EMAIL, invalidAddresses, VALID_TAGS);
        System.out.println(person);
        String expectedMessage = Address.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

/*
 In Reache, addresses are not mandatory fields
    @Test
    public void toModelType_nullAddress_throwsIllegalValueException() {
        JsonAdaptedPerson person = new JsonAdaptedPerson(VALID_NAME, VALID_PHONE, VALID_EMAIL, null, VALID_TAGS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Address.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }
*/

    @Test
    public void toModelType_invalidTags_throwsIllegalValueException() {
        List<JsonAdaptedTag> invalidTags = new ArrayList<>(VALID_TAGS);
        invalidTags.add(new JsonAdaptedTag(INVALID_TAG));

        HashMap<String, JsonAdaptedAddress> validAddresses = new HashMap<>();
        validAddresses.put("address#1", new JsonAdaptedAddress(VALID_ADDRESS));

        HashMap<String, JsonAdaptedPhone> validNumbers = new HashMap<>();
        validNumbers.put("phone#1", new JsonAdaptedPhone(VALID_PHONE));

        JsonAdaptedPerson person =
                new JsonAdaptedPerson(VALID_NAME, validNumbers, VALID_EMAIL, validAddresses, invalidTags);
        assertThrows(IllegalValueException.class, person::toModelType);
    }

}
