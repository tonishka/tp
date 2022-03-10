package seedu.address.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;

import java.util.Map;
import java.util.logging.Logger;


public class NumbersCard extends UiPart<Region> {
    private static final String FXML = "NumbersCard.fxml";
    private final Logger logger = LogsCenter.getLogger(NumbersCard.class);

    @FXML
    private ListView<Map.Entry<String, Phone>> numbersView;

    /**
     * Creates a {@code PersonListPanel} with the given {@code ObservableList}.
     */
    public NumbersCard(Map<String, Phone> numbers) {
        super(FXML);
        ObservableList<Map.Entry<String, Phone>> numbersList = FXCollections.observableArrayList(numbers.entrySet());
        numbersView.setItems(numbersList);
        numbersView.setCellFactory(listView -> new NumbersListViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Person} using a {@code PersonCard}.
     */
    class NumbersListViewCell extends ListCell<Map.Entry<String, Phone>> {
        @Override
        protected void updateItem(Map.Entry<String, Phone> number, boolean empty) {
            super.updateItem(number, empty);

            if (empty || number == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new InfoBox(number.getKey(), number.getValue().value).getRoot());
            }
        }
    }
}
