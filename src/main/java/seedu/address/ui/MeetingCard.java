package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import seedu.address.model.meeting.Meeting;

/**
 * An UI component that displays information of a {@code Meeting}.
 */
public class MeetingCard extends UiPart<Region> {

    private static final String FXML = "MeetingListCard.fxml";

    public final Meeting meeting;

    @FXML
    private VBox cardPane;

    /**
     * Creates a {@code MeetingCard} with the given {@code Meeting} and index to display.
     */
    public MeetingCard(Meeting meeting, int displayedIndex) {
        super(FXML);
        this.meeting = meeting;
    }
}
