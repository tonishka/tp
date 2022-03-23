package seedu.address.model.label;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Label in the address book.
 * Guarantees: immutable; name is valid as declared in {@link #isValidLabel(String)}
 */
public class Label {

    public static final String MESSAGE_CONSTRAINTS = "Label names should be alphanumeric";
    public static final String VALIDATION_REGEX = "[\\p{Alnum}\\s]+";

    public final String label;
    public final boolean isPlaceholder;

    /**
     * Constructs a {@code Label}.
     *
     * @param label A valid label name.
     */
    public Label(String label, boolean isPlaceholder) {
        requireNonNull(label);
        checkArgument(isValidLabel(label), MESSAGE_CONSTRAINTS);
        this.label = label;
        this.isPlaceholder = isPlaceholder;
    }

    /**
     * Returns true if a given string is a valid label name.
     */
    public static boolean isValidLabel(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Label // instanceof handles nulls
                && label.equals(((Label) other).label)); // state check
    }

    @Override
    public int hashCode() {
        return label.hashCode();
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        return label;
    }
}
