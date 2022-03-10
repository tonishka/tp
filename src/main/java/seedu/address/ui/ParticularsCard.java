package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Name;
import seedu.address.model.person.Pronoun;

import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;

public class ParticularsCard extends UiPart<Region> {
    private static final String FXML = "ParticularsCard.fxml";
    private final Logger logger = LogsCenter.getLogger(ParticularsCard.class);

    @FXML
    private Label name;

    @FXML
    private Label pronouns;

    /**
     * Creates a {@code PersonListPanel} with the given {@code ObservableList}.
     */
    public ParticularsCard(Name name, Set<Pronoun> pronouns) {
        super(FXML);
        this.name.setText(name.toString());
        this.pronouns.setText(pronounsToString(pronouns));
    }

    public String pronounsToString(Set<Pronoun> pronouns) {
        if (!pronouns.isEmpty()) {
            StringBuilder pronounsBuilder = new StringBuilder().append("(");
            Iterator<Pronoun> iterator = pronouns.iterator();
            while (iterator.hasNext()) {
                Pronoun p = iterator.next();

                if (iterator.hasNext()) {
                    pronounsBuilder.append(p + "/");
                } else {
                    pronounsBuilder.append(p + ")");
                }
            }
            return pronounsBuilder.toString();
        } else {
            return "";
        }
    }
}
