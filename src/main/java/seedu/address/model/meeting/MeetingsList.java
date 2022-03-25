package seedu.address.model.meeting;

import static java.util.Objects.requireNonNull;

import java.util.Iterator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * TODO update javadoc
 * A list of meetings that enforces uniqueness between its elements and does not allow nulls.
 * A meeting is considered unique by comparing using {@code Meeting#isSameMeeting(Meeting)}. As such, adding and updating of
 * meetings uses Meeting#isSameMeeting(Meeting) for equality so as to ensure that the meeting being added or updated is
 * unique in terms of identity in the MeetingsList. However, the removal of a meeting uses Meeting#equals(Object) so
 * as to ensure that the meeting with ..... will be removed.
 *
 * Supports a minimal set of list operations.
 *
 * @see Meeting#isSameMeeting(Meeting)
 */
public class MeetingsList implements Iterable<Meeting> {
    private final ObservableList<Meeting> internalList = FXCollections.observableArrayList();
    private final ObservableList<Meeting> internalUnmodifiableList =
            FXCollections.unmodifiableObservableList(internalList);

    /**
     * Returns true if the list contains an equivalent person as the given argument.
     */
    public boolean contains(Meeting toCheck) {
        requireNonNull(toCheck);
        return internalList.stream().anyMatch(toCheck::isSameMeeting);
    }

    /**
     * Adds a meeting to the list.
     * The meeting must not already exist in the list.
     */
    public void add(Meeting toAdd) {
        requireNonNull(toAdd);
        if (contains(toAdd)) {
            // TODO: throw duplicate meeting exception
        }
        internalList.add(toAdd);
    }

    /*
    TODO: Add more methods if applicable
     */

    @Override
    public Iterator<Meeting> iterator() {
        return internalList.iterator();
    }
}
