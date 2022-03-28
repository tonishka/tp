package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import seedu.address.model.meeting.Meeting;
import seedu.address.model.person.Id;

import java.util.HashSet;

/**
 * An UI component that displays information of a {@code Meeting}.
 */
public class MeetingCard extends UiPart<Region> {

    private static final String FXML = "MeetingListCard.fxml";

    public final Meeting meeting;

    @FXML
    private VBox cardPane;

    @FXML
    private Label index;

    @FXML
    private Label agenda;

    @FXML
    private Label time;

    @FXML
    private Label place;

    @FXML
    private Label attendees;

    /**
     * Creates a {@code MeetingCard} with the given {@code Meeting} and index to display.
     */
    public MeetingCard(Meeting meeting, int displayedIndex) {
        super(FXML);
        this.meeting = meeting;
        this.index.setText(displayedIndex + ". ");
        this.agenda.setText(meeting.getAgenda().toString());
        this.time.setText(meeting.getTime().toString());
        this.place.setText(meeting.getPlace().toString());
        this.attendees.setText(attendeesToLabel(meeting.getAttendees()));
    }

    private String attendeesToLabel(HashSet<Id> attendees) {
        StringBuilder strBuilder = new StringBuilder();

        for (Id attendee : attendees) {
            strBuilder.append(attendee).append(", ");
        }

        return strBuilder.toString();
    }
}
