package seedu.address.ui;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Address;
import seedu.address.model.person.Company;
import seedu.address.model.person.Email;
import seedu.address.model.person.JobTitle;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Pronoun;
import seedu.address.model.tag.Tag;

public class ContactDetailsPanel extends UiPart<Region> {
    private static final String FXML = "ContactDetailsPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(ContactDetailsPanel.class);

    private final ParticularsCard particularsCard;
    private final NumbersCard numbersCard;
    private final EmailsCard emailsCard;
    private final AddressesCard addressesCard;

    @FXML
    private StackPane particularsCardPlaceholder;

    @FXML
    private StackPane numbersCardPlaceholder;

    @FXML
    private StackPane emailsCardPlaceholder;

    @FXML
    private StackPane addressesCardPlaceholder;

    //Temporary, until we connect this to the rest of the app
    private Person person = new Person(
            new Name("Alex Yeoh"),
            new HashMap<>() {{
                put("Personal", new Phone("87438807"));
                put("Work", new Phone("82165492"));
            }},
            new HashMap<>() {{
                put("Personal", new Email("alexyeoh@example.com"));
                put("Work", new Email("alex_y@company.com"));
            }},
            new HashMap<>() {{
                put("Home", new Address("Blk 30 Geylang Street 29, #06-40"));
                put("Office", new Address("123 Raffles Business Tower"));
            }},
            new Company("Monsters Inc"),
            new JobTitle("Scarer"),
            new HashSet<>(Arrays.asList(new Pronoun("he"), new Pronoun("him"))),
            new HashSet<>(Arrays.asList(new Tag("friend"), new Tag("family")))
    );

    /**
     * Creates a {@code PersonListPanel} with the given {@code ObservableList}.
     */
    public ContactDetailsPanel() {
        super(FXML);
        particularsCard = new ParticularsCard(person.getName(), person.getPronouns(), person.getTags(),
                person.getJobTitle().orElse(null), person.getCompany().orElse(null));
        particularsCardPlaceholder.getChildren().add(particularsCard.getRoot());

        numbersCard = new NumbersCard(person.getNumbers());
        numbersCardPlaceholder.getChildren().add(numbersCard.getRoot());

        emailsCard = new EmailsCard(person.getEmails());
        emailsCardPlaceholder.getChildren().add(emailsCard.getRoot());

        addressesCard = new AddressesCard(person.getAddresses());
        addressesCardPlaceholder.getChildren().add(addressesCard.getRoot());
    }

    public Person getPerson() {
        return person;
    }
}

