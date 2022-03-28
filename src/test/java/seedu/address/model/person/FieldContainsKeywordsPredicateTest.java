package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.PersonBuilder;

public class FieldContainsKeywordsPredicateTest {

    @Test
    public void equals() {
        List<String> firstPredicateKeywordList = Collections.singletonList("first");
        List<String> secondPredicateKeywordList = Arrays.asList("first", "second");

        FieldContainsKeywordsPredicate firstPredicate = new FieldContainsKeywordsPredicate(firstPredicateKeywordList, "all");
        FieldContainsKeywordsPredicate secondPredicate = new FieldContainsKeywordsPredicate(secondPredicateKeywordList, "all");

        // same object -> returns true
        assertTrue(firstPredicate.equals(firstPredicate));

        // same values -> returns true
        FieldContainsKeywordsPredicate firstPredicateCopy = new FieldContainsKeywordsPredicate(firstPredicateKeywordList, "all");
        assertTrue(firstPredicate.equals(firstPredicateCopy));

        // different types -> returns false
        assertFalse(firstPredicate.equals(1));

        // null -> returns false
        assertFalse(firstPredicate.equals(null));

        // different person -> returns false
        assertFalse(firstPredicate.equals(secondPredicate));
    }

    @Test
    public void test_nameContainsKeywords_returnsTrue() {
        // One keyword
        FieldContainsKeywordsPredicate predicate = new FieldContainsKeywordsPredicate(Collections.singletonList("Alice"), "n");
        assertTrue(predicate.test(new PersonBuilder().withName("Alice Bob").build()));

        // Multiple keywords
        predicate = new FieldContainsKeywordsPredicate(Arrays.asList("Alice", "Bob"), "n");
        assertTrue(predicate.test(new PersonBuilder().withName("Alice Bob").build()));

        // Only one matching keyword
        predicate = new FieldContainsKeywordsPredicate(Arrays.asList("Bob", "Carol"), "n");
        assertTrue(predicate.test(new PersonBuilder().withName("Alice Carol").build()));

        // Mixed-case keywords
        predicate = new FieldContainsKeywordsPredicate(Arrays.asList("aLIce", "bOB"), "n");
        assertTrue(predicate.test(new PersonBuilder().withName("Alice Bob").build()));
    }

    @Test
    public void test_companyContainsKeywords_returnsTrue() {
        // One keyword
        FieldContainsKeywordsPredicate predicate = new FieldContainsKeywordsPredicate(Collections.singletonList("Tesla"), "c");
        assertTrue(predicate.test(new PersonBuilder().withCompany("Tesla").build()));

        // Multiple keywords
        predicate = new FieldContainsKeywordsPredicate(Arrays.asList("Tesla", "Dell", "Alpha"), "c");
        assertTrue(predicate.test(new PersonBuilder().withCompany("Dell").build()));

        // Only one matching keyword
        predicate = new FieldContainsKeywordsPredicate(Arrays.asList("Tesla", "Alpha"), "c");
        assertTrue(predicate.test(new PersonBuilder().withCompany("Alpha Tech").build()));

        // Mixed-case keywords
        predicate = new FieldContainsKeywordsPredicate(Arrays.asList("dElL", "AlPhA"), "c");
        assertTrue(predicate.test(new PersonBuilder().withCompany("Alpha").build()));

    }

    /**
    @Test
    public void test_jobContainsKeywords_returnsTrue() {

    }

    @Test
    public void test_tagContainsKeywords_returnsTrue() {

    }

    @Test
    public void test_phoneContainsKeywords_returnsTrue() {

    }

    @Test
    public void test_emailContainsKeywords_returnsTrue() {

    }

    @Test
    public void test_addressContainsKeywords_returnsTrue() {

    }**/
}
