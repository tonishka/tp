package seedu.address.model.meeting;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Iterator;

import static java.util.Objects.requireNonNull;

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

    @Override
    public Iterator<Meeting> iterator() {
        return internalList.iterator();
    }
}
