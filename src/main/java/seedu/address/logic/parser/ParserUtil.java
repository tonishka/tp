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

    public static void parseAddress(String address, HashMap<String,Address> addresses) throws ParseException {
        requireNonNull(address);
        String trimmedAddress = address.trim();
        if (!Address.isValidAddress(trimmedAddress)) {
            throw new ParseException(Address.MESSAGE_CONSTRAINTS);
        }

        if (address.contains("l/")) {
            String[] addressWithTag = address.split(" l/ ");
            addresses.put(addressWithTag[1], new Address(addressWithTag[1]));
        } else {
            addresses.put("", new Address(address));
        }
    }

    public static HashMap<String,Address> parseAddressess(Collection<String> addresses) throws ParseException {
        requireNonNull(addresses);
        final HashMap<String, Address> addressesMap = new HashMap<>();
        for (String address : addresses) {
            parseAddress(address, addressesMap);
        }
        return addressesMap;
    }

    public static void parsePhone(String phone, HashMap<String,Phone> numbers) throws ParseException {
        requireNonNull(phone);
        String trimmedPhone = phone.trim();
        if (!Phone.isValidPhone(trimmedPhone)) {
            throw new ParseException(Phone.MESSAGE_CONSTRAINTS);
        }

        if (phone.contains("l/")) {
            String[] phoneWithTag = phone.split(" l/ ");
            numbers.put(phoneWithTag[1], new Phone(phoneWithTag[1]));
        } else {
            numbers.put("", new Phone(phone));
        }
    }

    public static HashMap<String,Phone> parseNumbers(Collection<String> numbers) throws ParseException {
        requireNonNull(numbers);
        final HashMap<String, Phone> numbersMap = new HashMap<>();
        for (String phone : numbers) {
            parsePhone(phone, numbersMap);
        }
        return numbersMap;
    }

    public static void parseEmail(String email, HashMap<String,Email> emails) throws ParseException {
        requireNonNull(email);
        String trimmedEmail = email.trim();
        if (!Email.isValidEmail(trimmedEmail)) {
            throw new ParseException(Email.MESSAGE_CONSTRAINTS);
        }
        if (email.contains("l/")) {
            String[] emailWithTag = email.split(" l/ ");
            emails.put(emailWithTag[1], new Email(emailWithTag[1]));
        } else {
            emails.put("", new Email(email));
        }
    }

    public static HashMap<String,Email> parseEmails(Collection<String> emails) throws ParseException {
        requireNonNull(emails);
        final HashMap<String, Email> emailMap = new HashMap<>();
        for (String email : emails) {
            parseEmail(email, emailMap);
        }
        return emailMap;
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
