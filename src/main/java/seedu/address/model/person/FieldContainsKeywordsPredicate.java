package seedu.address.model.person;

import seedu.address.commons.util.StringUtil;

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
        if (field.equals("c")) {
            return testCompany(person);
        } else if (field.equals("j")) {
            return testJob(person);
        } else if (field.equals("t")) {
            return testTag(person);
        } else {
            return testName(person);
        }
    }

    public boolean testCompany(Person person) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(person.getCompany().toString(), keyword));
    }

    public boolean testName(Person person) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(person.getName().fullName, keyword));
    }

    public boolean testJob(Person person) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(person.getJobTitle().jobTitle, keyword));
    }

    public boolean testTag(Person person) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCaseInSet(person.getTagSet(), keyword));
    }
}
