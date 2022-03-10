package seedu.address.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.parser.ParserUtil.MESSAGE_INVALID_INDEX;
import static seedu.address.logic.parser.ParserUtil.parseLabel;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Address;
import seedu.address.model.person.Company;
import seedu.address.model.person.Email;
import seedu.address.model.person.JobTitle;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Pronoun;
import seedu.address.model.tag.Tag;

public class ParserUtilTest {
    private static final String INVALID_NAME = "R@chel";
    private static final String INVALID_PHONE = "+651234";
    private static final String INVALID_PRONOUN = " ";
    private static final String INVALID_ADDRESS = " ";
    private static final String INVALID_EMAIL = "example.com";
    private static final String INVALID_TAG = "#friend";
    private static final String INVALID_COMPANY = " ";
    private static final String INVALID_JOBTITLE = " ";
    private static final String INVALID_JOBTITLE_2 = "PizzaHut\nWorker";
    private static final String INVALID_JOBTITLE_3 = "        ";

    private static final String INVALID_PHONE_LABEL = "123456l/ home";
    private static final String INVALID_PHONE_LABEL_2 = "123456 l/home";
    private static final String INVALID_PHONE_LABEL_3 = "123456l/home";

    private static final String INVALID_ADDRESS_WITH_LABEL_1 = "l/home";
    private static final String INVALID_ADDRESS_WITH_LABEL_2 = "123 Main Street #0505l/home";

    private static final String INVALID_ADDRESS_WITH_LABEL_3 = "23 Main Street #0505l/ home";
    private static final String INVALID_EMAIL_WITH_LABEL_1 = "rachel@example.com l/home";
    private static final String INVALID_EMAIL_WITH_LABEL_2 = "rachel@example.coml/home";
    private static final String INVALID_EMAIL_WITH_LABEL_3 = "rachel@example.coml/ home";

    private static final String VALID_NAME = "Rachel Walker";
    private static final String VALID_COMPANY = "Microhard";
    private static final String VALID_PHONE = "123456";
    private static final String VALID_PRONOUN = "they";
    private static final String VALID_PRONOUN_2 = "she";
    private static final String VALID_ADDRESS = "123 Main Street #0505";
    private static final String VALID_EMAIL = "rachel@example.com";
    private static final String VALID_JOBTITLE = "Head Chef";
    private static final String VALID_TAG_1 = "friend";
    private static final String VALID_TAG_2 = "neighbour";

    private static final String VALID_ADDRESS_WITH_LABEL = "123 Main Street #0505 l/ home";
    private static final String VALID_EMAIL_WITH_LABEL = "rachel@example.com l/ friend";
    private static final String VALID_PHONE_WITH_LABEL = "123456 l/ home";


    private static final String WHITESPACE = " \t\r\n";

    @Test
    public void parseIndex_invalidInput_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseIndex("10 a"));
    }

    @Test
    public void parseIndex_outOfRangeInput_throwsParseException() {
        assertThrows(ParseException.class, MESSAGE_INVALID_INDEX, () -> ParserUtil
                .parseIndex(Long.toString(Integer.MAX_VALUE + 1)));
    }

    @Test
    public void parseIndex_validInput_success() throws Exception {
        // No whitespaces
        assertEquals(INDEX_FIRST_PERSON, ParserUtil.parseIndex("1"));

        // Leading and trailing whitespaces
        assertEquals(INDEX_FIRST_PERSON, ParserUtil.parseIndex("  1  "));
    }

    //------------------------------------------------------------------------------------------------------------------

    @Test
    public void parseName_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseName((String) null));
    }

    @Test
    public void parseName_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseName(INVALID_NAME));
    }

    @Test
    public void parseName_validValueWithoutWhitespace_returnsName() throws Exception {
        Name expectedName = new Name(VALID_NAME);
        assertEquals(expectedName, ParserUtil.parseName(VALID_NAME));
    }

    @Test
    public void parseName_validValueWithWhitespace_returnsTrimmedName() throws Exception {
        String nameWithWhitespace = WHITESPACE + VALID_NAME + WHITESPACE;
        Name expectedName = new Name(VALID_NAME);
        assertEquals(expectedName, ParserUtil.parseName(nameWithWhitespace));
    }

    //------------------------------------------------------------------------------------------------------------------
    @Test
    public void parseLabel_validValueWithoutLabel_returnsEmptyString() {
        String expectedString = "";
        String actualContent = parseLabel(VALID_ADDRESS).orElse("");
        assertEquals(expectedString, actualContent);
    }

    @Test
    public void parseLabel_validValueWithLabel_returnsLabel() {
        String expectedString = "home";
        String actualContent = parseLabel(VALID_ADDRESS_WITH_LABEL).orElse("");
        assertEquals(expectedString, actualContent);
    }

    //------------------------------------------------------------------------------------------------------------------

    //***PLEASE DOUBLE CHECK THIS***
    @Test
    public void parseJobTitle_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseJobTitle((String) null));
    }

    //***PLEASE DOUBLE CHECK THIS***
    @Test
    public void parseJobTitle_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseJobTitle(INVALID_JOBTITLE));
        assertThrows(ParseException.class, () -> ParserUtil.parseJobTitle(INVALID_JOBTITLE_2));
        assertThrows(ParseException.class, () -> ParserUtil.parseJobTitle(INVALID_JOBTITLE_3));
    }

    //***PLEASE DOUBLE CHECK THIS***
    @Test
    public void parseJobTitle_validValueWithoutWhitespace_returnsName() throws Exception {
        JobTitle expectedJobTitle = new JobTitle(VALID_JOBTITLE);
        assertEquals(expectedJobTitle, ParserUtil.parseJobTitle(VALID_JOBTITLE));
    }

    //***PLEASE DOUBLE CHECK THIS***
    @Test
    public void parseJobTitle_validValueWithWhitespace_returnsTrimmedName() throws Exception {
        String jobtitleWithWhitespace = WHITESPACE + VALID_JOBTITLE + WHITESPACE;
        JobTitle expectedJobTitle = new JobTitle(VALID_JOBTITLE);
        assertEquals(expectedJobTitle, ParserUtil.parseJobTitle(jobtitleWithWhitespace));
    }

    //------------------------------------------------------------------------------------------------------------------

    //***PLEASE DOUBLE CHECK THIS***
    @Test
    public void parseCompany_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseCompany((String) null));
    }

    //***PLEASE DOUBLE CHECK THIS***
    @Test
    public void parseCompany_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseCompany(INVALID_COMPANY));
    }

    //***PLEASE DOUBLE CHECK THIS***
    @Test
    public void parseCompany_validValueWithoutWhitespace_returnsName() throws Exception {
        Company expectedCompany = new Company(VALID_COMPANY);
        assertEquals(expectedCompany, ParserUtil.parseCompany(VALID_COMPANY));
    }

    //***PLEASE DOUBLE CHECK THIS***
    @Test
    public void parseCompany_validValueWithWhitespace_returnsTrimmedName() throws Exception {
        String companyWithWhitespace = WHITESPACE + VALID_COMPANY + WHITESPACE;
        Company expectedCompany = new Company(VALID_COMPANY);
        assertEquals(expectedCompany, ParserUtil.parseCompany(companyWithWhitespace));
    }

    //------------------------------------------------------------------------------------------------------------------

    //***PLEASE DOUBLE CHECK THIS****
    @Test
    public void parsePhone_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parsePhone((String) null));
    }

    //***PLEASE DOUBLE CHECK THIS****
    @Test
    public void parsePhone_invalidValueWithoutLabel_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parsePhone(INVALID_PHONE));
    }

    //***PLEASE DOUBLE CHECK THESE***
    @Test
    public void parsePhone_invalidValueWithLabel_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parsePhone(INVALID_PHONE_LABEL));
    }

    //***PLEASE DOUBLE CHECK THESE***
    @Test
    public void parsePhone_validValueWithoutLabelWithWhiteSpace_returnsPhone() throws Exception {
        String phoneWithWhiteSpace = WHITESPACE + VALID_PHONE + WHITESPACE;
        Phone parsedPhone = ParserUtil.parsePhone(phoneWithWhiteSpace);
        Phone expectedPhone = new Phone(VALID_PHONE);
        assertEquals(expectedPhone, parsedPhone);
    }

    //***PLEASE DOUBLE CHECK THESE***
    @Test
    public void parsePhone_validValueWithWhitespaceWithLabel_returnsPhone() throws Exception {
        String phoneWithWhiteSpace = WHITESPACE + VALID_PHONE_WITH_LABEL + WHITESPACE;
        Phone parsedPhone = ParserUtil.parsePhone(phoneWithWhiteSpace);
        Phone expectedPhone = new Phone(VALID_PHONE);
        assertEquals(expectedPhone, parsedPhone);
    }

    //***PLEASE DOUBLE CHECK THIS****
    @Test
    public void parseNumbers_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseNumbers(null));
    }

    //***PLEASE DOUBLE CHECK THIS****
    @Test
    public void parseNumbers_collectionWithInvalidNumbers_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil
                .parseNumbers(Arrays.asList(VALID_PHONE_WITH_LABEL, INVALID_PHONE)));
        assertThrows(ParseException.class, () -> ParserUtil.parseNumbers(Arrays.asList(VALID_PHONE, INVALID_PHONE)));
    }

    //***PLEASE DOUBLE CHECK THIS****
    @Test
    public void parseNumbers_collectionWithInvalidNumbersPlusLabel_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseNumbers(Arrays.asList(VALID_PHONE, INVALID_PHONE)));
        assertThrows(ParseException.class, () -> ParserUtil
                .parseNumbers(Arrays.asList(VALID_PHONE, INVALID_PHONE_LABEL_2)));
        assertThrows(ParseException.class, () -> ParserUtil
                .parseNumbers(Arrays.asList(VALID_PHONE, INVALID_PHONE_LABEL_3)));
    }

    //***PLEASE DOUBLE CHECK THIS****
    @Test
    public void parseNumbers_emptyCollection_returnsEmptySet() throws Exception {
        assertTrue(ParserUtil.parseNumbers(Collections.emptyList()).isEmpty());
    }

    //***PLEASE DOUBLE CHECK THIS****
    @Test
    public void parseNumbers_collectionWithValidNumbers_returnsNumberMap() throws Exception {
        HashMap<String, Phone> actualNumbersMap = ParserUtil
                .parseNumbers(Arrays.asList(VALID_PHONE, VALID_PHONE_WITH_LABEL));
        HashMap<String, Phone> expectedNumbersMap = new HashMap<String, Phone>();
        expectedNumbersMap.put("", new Phone(VALID_PHONE));
        expectedNumbersMap.put("home", new Phone(VALID_PHONE));
        assertEquals(expectedNumbersMap, actualNumbersMap);
    }

    //------------------------------------------------------------------------------------------------------------------

    //***PLEASE DOUBLE CHECK THIS****
    @Test
    public void parseAddress_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseAddress((String) null));
    }

    //***PLEASE DOUBLE CHECK THIS****
    @Test
    public void parseAddress_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseAddress(INVALID_ADDRESS));
    }

    //***PLEASE DOUBLE CHECK THESE***
    @Test
    public void parseAddress_validValueWithoutLabelWithWhiteSpace_returnsAddress() throws Exception {
        String addressWithWhiteSpace = WHITESPACE + VALID_ADDRESS + WHITESPACE;
        Address parsedAddress = ParserUtil.parseAddress(addressWithWhiteSpace);
        Address expectedAddressContent = new Address(VALID_ADDRESS);
        assertEquals(expectedAddressContent, parsedAddress);
    }

    //***PLEASE DOUBLE CHECK THESE***
    @Test
    public void parseAddress_validValueWithWhitespaceWithLabel_returnaAddress() throws Exception {
        String addressWithWhiteSpace = WHITESPACE + VALID_ADDRESS_WITH_LABEL + WHITESPACE;
        Address parsedAddress = ParserUtil.parseAddress(addressWithWhiteSpace);
        Address expectedAddressContent = new Address(VALID_ADDRESS);
        assertEquals(expectedAddressContent, parsedAddress);
    }

    //***PLEASE DOUBLE CHECK THIS****
    @Test
    public void parseAddresses_collectionWithValidAddresses_returnsAddressesMap() throws Exception {
        HashMap<String, Address> actualAddressesMap = ParserUtil
                .parseAddresses(Arrays.asList(VALID_ADDRESS, VALID_ADDRESS_WITH_LABEL));
        HashMap<String, Address> expectedAddressesMap = new HashMap<String, Address>();
        expectedAddressesMap.put("", new Address(VALID_ADDRESS));
        expectedAddressesMap.put("home", new Address(VALID_ADDRESS));
        assertEquals(expectedAddressesMap, actualAddressesMap);
    }

    //***PLEASE DOUBLE CHECK THIS****
    @Test
    public void parseAddresses_collectionWithInvalidAddressesPlusLabel_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil
                .parseAddresses(Arrays.asList(VALID_ADDRESS, INVALID_ADDRESS)));
        assertThrows(ParseException.class, () -> ParserUtil
                .parseAddresses(Arrays.asList(VALID_ADDRESS, INVALID_ADDRESS_WITH_LABEL_1)));
        assertThrows(ParseException.class, () -> ParserUtil
                .parseAddresses(Arrays.asList(VALID_ADDRESS, INVALID_ADDRESS_WITH_LABEL_2)));
        assertThrows(ParseException.class, () -> ParserUtil
                .parseAddresses(Arrays.asList(VALID_ADDRESS, INVALID_ADDRESS_WITH_LABEL_3)));
    }

    //------------------------------------------------------------------------------------------------------------------

    //***PLEASE DOUBLE CHECK THESE***
    @Test
    public void parseEmail_null_throwsNullPointerException() {
        HashMap<String, Email> testEmailMap = new HashMap<>();
        assertThrows(NullPointerException.class, () -> ParserUtil.parseEmail((String) null));
    }

    //***PLEASE DOUBLE CHECK THESE***
    @Test
    public void parseEmail_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseEmail(INVALID_EMAIL));
    }

    //***PLEASE DOUBLE CHECK THESE***
    @Test
    public void parseEmail_validValueWithoutLabel_returnsEmail() throws Exception {
        Email parsedEmail = ParserUtil.parseEmail(VALID_EMAIL);
        Email expectedEmailContent = new Email(VALID_EMAIL);
        assertEquals(expectedEmailContent, parsedEmail);
    }

    //***PLEASE DOUBLE CHECK THESE***
    @Test
    public void parseEmail_validValueWithLabel_returnsEmail() throws Exception {
        Email parsedEmail = ParserUtil.parseEmail(VALID_EMAIL_WITH_LABEL);
        Email expectedEmailContent = new Email(VALID_EMAIL);
        assertEquals(expectedEmailContent, parsedEmail);
    }

    //***PLEASE DOUBLE CHECK THESE***
    @Test
    public void parseEmail_validValueWithWhitespace_returnsEmail() throws Exception {
        String emailWithWhiteSpace = WHITESPACE + VALID_EMAIL + WHITESPACE;
        Email parsedEmail = ParserUtil.parseEmail(emailWithWhiteSpace);
        Email expectedEmailContent = new Email(VALID_EMAIL);
        assertEquals(expectedEmailContent, parsedEmail);
    }

    //***PLEASE DOUBLE CHECK THESE***
    @Test
    public void parseEmail_validValueWithWhitespaceWithLabel_returnsEmail() throws Exception {
        String emailWithWhiteSpace = WHITESPACE + VALID_EMAIL_WITH_LABEL + WHITESPACE;
        Email parsedEmail = ParserUtil.parseEmail(emailWithWhiteSpace);
        Email expectedEmailContent = new Email(VALID_EMAIL);
        assertEquals(expectedEmailContent, parsedEmail);
    }

    //***PLEASE DOUBLE CHECK THIS****
    @Test
    public void parseEmails_collectionWithValidEmails_returnsEmailsMap() throws Exception {
        HashMap<String, Email> actualEmailsMap = ParserUtil
                .parseEmails(Arrays.asList(VALID_EMAIL, VALID_EMAIL_WITH_LABEL));
        HashMap<String, Email> expectedEmailsMap = new HashMap<String, Email>();
        expectedEmailsMap.put("", new Email(VALID_EMAIL));
        expectedEmailsMap.put("friend", new Email(VALID_EMAIL));
        assertEquals(expectedEmailsMap, actualEmailsMap);
    }

    //***PLEASE DOUBLE CHECK THIS****
    @Test
    public void parseEmails_collectionWithInvalidEmailsPlusLabel_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseEmails(Arrays.asList(VALID_EMAIL, INVALID_EMAIL)));
        assertThrows(ParseException.class, () -> ParserUtil
                .parseEmails(Arrays.asList(VALID_EMAIL, INVALID_EMAIL_WITH_LABEL_1)));
        assertThrows(ParseException.class, () -> ParserUtil
                .parseEmails(Arrays.asList(VALID_EMAIL, INVALID_EMAIL_WITH_LABEL_2)));
    }

    //------------------------------------------------------------------------------------------------------------------

    @Test
    public void parseTag_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseTag(null));
    }

    @Test
    public void parseTag_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseTag(INVALID_TAG));
    }

    @Test
    public void parseTag_validValueWithoutWhitespace_returnsTag() throws Exception {
        Tag expectedTag = new Tag(VALID_TAG_1);
        assertEquals(expectedTag, ParserUtil.parseTag(VALID_TAG_1));
    }

    @Test
    public void parseTag_validValueWithWhitespace_returnsTrimmedTag() throws Exception {
        String tagWithWhitespace = WHITESPACE + VALID_TAG_1 + WHITESPACE;
        Tag expectedTag = new Tag(VALID_TAG_1);
        assertEquals(expectedTag, ParserUtil.parseTag(tagWithWhitespace));
    }

    @Test
    public void parseTags_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseTags(null));
    }

    @Test
    public void parseTags_collectionWithInvalidTags_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseTags(Arrays.asList(VALID_TAG_1, INVALID_TAG)));
    }

    @Test
    public void parseTags_emptyCollection_returnsEmptySet() throws Exception {
        assertTrue(ParserUtil.parseTags(Collections.emptyList()).isEmpty());
    }

    @Test
    public void parseTags_collectionWithValidTags_returnsTagSet() throws Exception {
        Set<Tag> actualTagSet = ParserUtil.parseTags(Arrays.asList(VALID_TAG_1, VALID_TAG_2));
        Set<Tag> expectedTagSet = new HashSet<Tag>(Arrays.asList(new Tag(VALID_TAG_1), new Tag(VALID_TAG_2)));

        assertEquals(expectedTagSet, actualTagSet);
    }

    //-------------------------------------------------------------------------------------------------------
    //***PLEASE DOUBLE CHECK THIS****
    @Test
    public void parsePronoun_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parsePronoun(null));
    }

    //***PLEASE DOUBLE CHECK THIS****
    @Test
    public void parsePronoun_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parsePronoun(INVALID_PRONOUN));
    }

    //***PLEASE DOUBLE CHECK THIS****
    @Test
    public void parsePronoun_validValueWithoutWhitespace_returnsPronoun() throws Exception {
        Pronoun expectedPronoun = new Pronoun(VALID_PRONOUN);
        assertEquals(expectedPronoun, ParserUtil.parsePronoun(VALID_PRONOUN));
    }

    //***PLEASE DOUBLE CHECK THIS****
    @Test
    public void parsePronoun_validValueWithWhitespace_returnsTrimmedPronoun() throws Exception {
        String pronounWithWhitespace = WHITESPACE + VALID_PRONOUN + WHITESPACE;
        Pronoun expectedPronoun = new Pronoun(VALID_PRONOUN);
        assertEquals(expectedPronoun, ParserUtil.parsePronoun(pronounWithWhitespace));
    }

    //***PLEASE DOUBLE CHECK THIS****
    @Test
    public void parsePronouns_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parsePronouns(null));
    }

    //***PLEASE DOUBLE CHECK THIS****
    @Test
    public void parsePronouns_collectionWithInvalidPronouns_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil
                .parsePronouns(Arrays.asList(VALID_PRONOUN, INVALID_PRONOUN)));
    }

    //***PLEASE DOUBLE CHECK THIS****
    @Test
    public void parsePronouns_emptyCollection_returnsEmptySet() throws Exception {
        assertTrue(ParserUtil.parsePronouns(Collections.emptyList()).isEmpty());
    }

    //***PLEASE DOUBLE CHECK THIS****
    @Test
    public void parsePronouns_collectionWithValidPronouns_returnsPronounSet() throws Exception {
        Set<Pronoun> actualPronounSet = ParserUtil.parsePronouns(Arrays.asList(VALID_PRONOUN, VALID_PRONOUN_2));
        Set<Pronoun> expectedPronounSet = new HashSet<>(Arrays
                .asList(new Pronoun(VALID_PRONOUN), new Pronoun(VALID_PRONOUN_2)));

        assertEquals(expectedPronounSet, actualPronounSet);
    }
}
