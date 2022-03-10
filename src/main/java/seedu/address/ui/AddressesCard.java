package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Address;

import java.util.Map;
import java.util.logging.Logger;


public class AddressesCard extends UiPart<Region> {
    private static final String FXML = "AddressesCard.fxml";
    private final Logger logger = LogsCenter.getLogger(AddressesCard.class);

    @FXML
    private VBox addressesContainer;

    /**
     * Creates a {@code PersonListPanel} with the given {@code ObservableList}.
     */
    public AddressesCard(Map<String, Address> addresses) {
        super(FXML);
        for (Map.Entry<String, Address> address : addresses.entrySet()) {
            addressesContainer.getChildren().add(new InfoBox(address.getKey(), address.getValue().value).getRoot());
        }
    }
}