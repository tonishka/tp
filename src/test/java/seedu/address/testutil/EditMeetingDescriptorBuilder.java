package seedu.address.testutil;

import seedu.address.model.meeting.Agenda;
import seedu.address.model.meeting.EditMeetingDescriptor;
import seedu.address.model.meeting.Meeting;
import seedu.address.model.meeting.MeetingTime;

/**
 * A utility class to help with building EditMeetingDescriptor objects.
 */
public class EditMeetingDescriptorBuilder {

    private EditMeetingDescriptor descriptor;

    public EditMeetingDescriptorBuilder() {
        descriptor = new EditMeetingDescriptor();
    }

    public EditMeetingDescriptorBuilder(EditMeetingDescriptor descriptor) {
        this.descriptor = new EditMeetingDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditMeetingDescriptor} with fields containing {@code meeting}'s details
     */
    public EditMeetingDescriptorBuilder(Meeting meeting) {
        descriptor = new EditMeetingDescriptor();

        descriptor.setAgenda(meeting.getAgenda());
        descriptor.setMeetingTime(meeting.getTime());
        descriptor.setMeetingPlace(meeting.getPlace());
        descriptor.setAttendees(meeting.getIndexes());
    }

    /**
     * Sets the {@code Agenda} of the {@code EditPMeetingDescriptor} that we are building.
     */
    public EditMeetingDescriptorBuilder withAgenda(String agenda) {
        descriptor.setAgenda(new Agenda(agenda));
        return this;
    }
}
