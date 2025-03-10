package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's job title in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidJobTitle(String)}
 */
public class JobTitle implements Comparable<JobTitle> {

    public static final String MESSAGE_CONSTRAINTS =
            "Job title should start with an alphabet, can take any alphanumeric values with spaces, "
                    + "and it should not be blank";

    /*
     * The first character of the job title must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */

    public static final String VALIDATION_REGEX = "[^\\p{javaSpaceChar}\\d\\p{Punct}][A-Za-z\\d\\s]*$";

    public final String jobTitle;

    /**
     * Constructs an {@code JobTitle}.
     *
     * @param jobTitle A valid job title.
     */
    public JobTitle(String jobTitle) {
        requireNonNull(jobTitle);
        checkArgument(isValidJobTitle(jobTitle), MESSAGE_CONSTRAINTS);
        this.jobTitle = jobTitle;
    }

    /**
     * Returns true if a given string is a valid job title.
     */
    public static boolean isValidJobTitle(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return jobTitle;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof JobTitle // instanceof handles nulls
                && jobTitle.equals(((JobTitle) other).jobTitle)); // state check
    }

    @Override
    public int hashCode() {
        return jobTitle.hashCode();
    }

    @Override
    public int compareTo(JobTitle o) {
        return this.jobTitle.compareTo(o.jobTitle);
    }
}
