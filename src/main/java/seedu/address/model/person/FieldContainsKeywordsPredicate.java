package seedu.address.model.person;

import seedu.address.commons.util.StringUtil;

import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

public class FieldContainsKeywordsPredicate implements Predicate<Person> {
    private final List<String> keywords;
    private final String field;

    public FieldContainsKeywordsPredicate(List<String> keywords, String field) {
        this.keywords = keywords;
        this.field = field;
    }

    @Override
    public boolean test(Person person) {
        switch (field) {
            case "c":
                return testCompany(person);
            case "j":
                return testJob(person);
            case "t":
                return testTag(person);
            case "p":
                return testPhone(person);
            case "e":
                return testEmail(person);
            case "a":
                return testAddress(person);
            default:
                return testName(person);
        }
    }

    private boolean testCompany(Person person) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(person.getCompany().toString(), keyword));
    }

    private boolean testName(Person person) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(person.getName().fullName, keyword));
    }

    private boolean testJob(Person person) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(person.getJobTitle().jobTitle, keyword));
    }

    private boolean testTag(Person person) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCaseInSet(person.getTagSet(), keyword));
    }

    private boolean testPhone(Person person) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCaseInMap((HashMap<String, ? extends Object>)
                        person.getNumbers(), keyword));
    }

    private boolean testEmail(Person person) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCaseInMap((HashMap<String, ? extends Object>)
                        person.getEmails(), keyword));
    }

    private boolean testAddress(Person person) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCaseInMap((HashMap<String, ? extends Object>)
                        person.getAddresses(), keyword));
    }
}
