package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Address;
import seedu.address.model.person.Company;
import seedu.address.model.person.Email;
import seedu.address.model.person.JobTitle;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Pronoun;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Parses a {@code String name} into a {@code Name}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static Name parseName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!Name.isValidName(trimmedName)) {
            throw new ParseException(Name.MESSAGE_CONSTRAINTS);
        }
        return new Name(trimmedName);
    }

    /**
     * Parses a {@code String company} into a {@code Company}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code company} is invalid.
     */
    public static Company parseCompany(String company) throws ParseException {
        requireNonNull(company);
        String trimmedCompany = company.trim();
        if (!Company.isValidCompany(trimmedCompany)) {
            throw new ParseException(Name.MESSAGE_CONSTRAINTS);
        }
        return new Company(trimmedCompany);
    }

    /**
     * Parses a {@code String jobtitle} into a {@code JobTitle}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code jobtitle} is invalid.
     */
    public static JobTitle parseJobTitle(String jobTitle) throws ParseException {
        requireNonNull(jobTitle);
        String trimmedJobTitle = jobTitle.trim();
        if (!JobTitle.isValidJobTitle(trimmedJobTitle)) {
            throw new ParseException(Name.MESSAGE_CONSTRAINTS);
        }
        return new JobTitle(trimmedJobTitle);
    }

    /**
     * Parses a {@code String phone} into a {@code HashMap<String,Phone> phone}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code phone} is invalid.
     */
    public static HashMap<String, Phone> parsePhone(String phone) throws ParseException {
        /*requireNonNull(phone);
        String trimmedPhone = phone.trim();
        if (!Phone.isValidPhone(trimmedPhone)) {
            throw new ParseException(Phone.MESSAGE_CONSTRAINTS);
        }
        return new Phone(trimmedPhone);*/

        requireNonNull(phone); //-> multiple phone numbers with or without labels
        String trimmedPhone = phone.trim();
        if (!Phone.isValidPhone(trimmedPhone)) {
            throw new ParseException(Phone.MESSAGE_CONSTRAINTS);
        }
        HashMap<String, Phone> result = new HashMap<>();
        if (!trimmedPhone.contains(";")) {//means it is a single phone no
            if (trimmedPhone.contains(" l/")) {//means no label
                result.put("", new Phone(trimmedPhone));
            } else {
                String[] numberWithTag = trimmedPhone.split(" l/");
                result.put(numberWithTag[1], new Phone(numberWithTag[0]));
            }
        } else {//multiple numbers
            String[] numbers = trimmedPhone.split(";");
            for (String phoneNumber: numbers) {
                if (phoneNumber.contains(" l/")) {//means no label
                    result.put("", new Phone(phoneNumber));
                } else {
                    String[] numberWithTag = phoneNumber.split(" l/");
                    result.put(numberWithTag[1], new Phone(numberWithTag[0]));
                }
            }
        }
        return result;
    }

    /**
     * Parses a {@code String address} into an {@code HashMap<String,Address> address}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code address} is invalid.
     */
    public static HashMap<String, Address> parseAddress(String address) throws ParseException {
        requireNonNull(address); //-> multiple addresses with or without labels
        String trimmedAddress = address.trim();
        if (!Address.isValidAddress(trimmedAddress)) {
            throw new ParseException(Address.MESSAGE_CONSTRAINTS);
        }
        HashMap<String, Address> result = new HashMap<>();
        if (!trimmedAddress.contains(";")) {//means it is a single address
            if (trimmedAddress.contains(" l/")) {//means no label
                result.put("", new Address(trimmedAddress));
            } else {
                String[] addressWithTag = trimmedAddress.split(" l/");
                result.put(addressWithTag[1], new Address(addressWithTag[0]));
            }
        } else {//multiple addresses
            String[] numbers = trimmedAddress.split(";");
            for (String addressNo: numbers) {
                if (trimmedAddress.contains(" l/")) {//means no label
                    result.put("", new Address(addressNo));
                } else {
                    String[] addressWithTag = addressNo.split(" l/");
                    result.put(addressWithTag[1], new Address(addressWithTag[0]));
                }
            }
        }
        return result;
    }

    /**
     * Parses a {@code String email} into an {@code HashMap<String, Email> email}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code email} is invalid.
     */
    public static HashMap<String, Email> parseEmail(String email) throws ParseException {
        requireNonNull(email);
        String trimmedEmail = email.trim();
        if (!Email.isValidEmail(trimmedEmail)) {
            throw new ParseException(Email.MESSAGE_CONSTRAINTS);
        }
        HashMap<String, Email> result = new HashMap<>();
        if (!trimmedEmail.contains(";")) {//means it is a single email
            if (trimmedEmail.contains(" l/")) {//means no label
                result.put("", new Email(trimmedEmail));
            } else {
                String[] emailWithTag = trimmedEmail.split(" l/");
                result.put(emailWithTag[1], new Email(emailWithTag[0]));
            }
        } else {//multiple emails
            String[] numbers = trimmedEmail.split(";");
            for (String emailNo: numbers) {
                if (emailNo.contains(" l/")) {//means no label
                    result.put("", new Email(emailNo));
                } else {
                    String[] emailWithTag = emailNo.split(" l/");
                    result.put(emailWithTag[1], new Email(emailWithTag[0]));
                }
            }
        }
        return result;
    }



    /**
     * Parses a {@code String tag} into a {@code Tag}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code tag} is invalid.
     */
    public static Tag parseTag(String tag) throws ParseException {
        requireNonNull(tag);
        String trimmedTag = tag.trim();
        if (!Tag.isValidTagName(trimmedTag)) {
            throw new ParseException(Tag.MESSAGE_CONSTRAINTS);
        }
        return new Tag(trimmedTag);
    }

    /**
     * Parses {@code Collection<String> tags} into a {@code Set<Tag>}.
     */
    public static Set<Tag> parseTags(Collection<String> tags) throws ParseException {
        requireNonNull(tags);
        final Set<Tag> tagSet = new HashSet<>();
        for (String tagName : tags) {
            tagSet.add(parseTag(tagName));
        }
        return tagSet;
    }


    /**
     * Parses a {@code String pronoun} into a {@code Pronoun}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code pronoun} is invalid.
     */
    public static Pronoun parsePronoun(String pronoun) throws ParseException {
        requireNonNull(pronoun);
        String trimmedPronoun = pronoun.trim();
        if (!Pronoun.isValidPronoun(trimmedPronoun)) {
            throw new ParseException(Pronoun.MESSAGE_CONSTRAINTS);
        }
        return new Pronoun(trimmedPronoun);
    }

    /**
     * Parses {@code Collection<String> pronouns} into a {@code Set<Pronoun>}.
     */
    public static Set<Pronoun> parsePronouns(Collection<String> pronouns) throws ParseException {
        requireNonNull(pronouns);
        final Set<Pronoun> pronounSet = new HashSet<>();
        for (String pronoun : pronouns) {
            pronounSet.add(parsePronoun(pronoun));
        }
        return pronounSet;
    }
}
