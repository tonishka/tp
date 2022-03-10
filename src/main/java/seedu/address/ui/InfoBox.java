package seedu.address.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Phone;

import java.util.logging.Logger;

public class InfoBox extends UiPart<Region> {
    private static final String FXML = "InfoBox.fxml";
    private final Logger logger = LogsCenter.getLogger(InfoBox.class);

    @FXML
    private Label label;

    @FXML
    private Label value;

    /**
     * Creates a {@code PersonListPanel} with the given {@code ObservableList}.
     */
    public InfoBox(String label, String value) {
        super(FXML);
        this.label.setText(label);
        this.value.setText(value);
    }
}
