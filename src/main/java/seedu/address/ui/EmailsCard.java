package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Email;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Card containing the emails associated with a person.
 */
public class EmailsCard extends UiPart<Region> {
    private static final String FXML = "EmailsCard.fxml";
    private final Logger logger = LogsCenter.getLogger(EmailsCard.class);

    @FXML
    private VBox emailsContainer;

    /**
     * Creates an {@code EmailsCard} with the given {@code Map} of emails and their associated labels.
     */
    public EmailsCard(Map<String, Email> emails) {
        super(FXML);
        for (Map.Entry<String, Email> email : emails.entrySet()) {
            emailsContainer.getChildren().add(new InfoBox(email.getKey(), email.getValue().email).getRoot());
        }
    }
}
