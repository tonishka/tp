package seedu.address.ui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.Logic;
import seedu.address.logic.LogicManager;


/**
 * Controller for a clear confirmation
 */
public class MeetingClearConfirmWindow extends UiPart<Stage> {

    public static final String CONFIRM_MESSAGE = "Are you sure you want to proceed? Deleted data cannot be recovered.\n"
            + "All meetings will be deleted.";

    private static final Logger logger = LogsCenter.getLogger(MeetingClearConfirmWindow.class);
    private static final String FXML = "MeetingClearConfirmWindow.fxml";
    private LogicManager logic;

    @FXML
    private Button confirm;

    @FXML
    private Label confirmMessage;

    /**
     * Creates a new MeetingClearConfirmWindow.
     *
     * @param root Stage to use as the root of the HelpWindow.
     */
    public MeetingClearConfirmWindow(Stage root) {
        super(FXML, root);
        confirmMessage.setText(CONFIRM_MESSAGE);
    }

    /**
     * Creates a new MeetingClearConfirmWindow.
     */
    public MeetingClearConfirmWindow(Logic logic) {
        this(new Stage());
        this.logic = (LogicManager) logic;
    }


    /**
     * Shows the confirm window.
     * @throws IllegalStateException
     * <ul>
     *     <li>
     *         if this method is called on a thread other than the JavaFX Application Thread.
     *     </li>
     *     <li>
     *         if this method is called during animation or layout processing.
     *     </li>
     *     <li>
     *         if this method is called on the primary stage.
     *     </li>
     *     <li>
     *         if {@code dialogStage} is already showing.
     *     </li>
     * </ul>
     */
    public void show() {
        logger.fine("Asking for user confirmation.");
        getRoot().show();
        getRoot().centerOnScreen();
    }

    /**
     * Returns true if the confirm window is currently being shown.
     */
    public boolean isShowing() {
        return getRoot().isShowing();
    }

    /**
     * Hides the confirm window.
     */
    public void hide() {
        getRoot().hide();
    }

    /**
     * Focuses on the confirm window.
     */
    public void focus() {
        getRoot().requestFocus();
    }

    /**
     * Returns confirmation.
     */
    @FXML
    private void confirm() {
        logic.clearMeetingBook();
        hide();
    }
}
