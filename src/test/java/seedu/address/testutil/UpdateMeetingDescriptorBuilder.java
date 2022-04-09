package seedu.address.testutil;

import seedu.address.model.meeting.Agenda;
import seedu.address.model.meeting.Meeting;
import seedu.address.model.meeting.MeetingPlace;
import seedu.address.model.meeting.MeetingTime;
import seedu.address.model.meeting.UpdateMeetingDescriptor;

/**
 * A utility class to help with building UpdateMeetingDescriptor objects.
 */
public class UpdateMeetingDescriptorBuilder {

    private UpdateMeetingDescriptor descriptor;

    public UpdateMeetingDescriptorBuilder() {
        descriptor = new UpdateMeetingDescriptor();
    }

    public UpdateMeetingDescriptorBuilder(UpdateMeetingDescriptor descriptor) {
        this.descriptor = new UpdateMeetingDescriptor(descriptor);
    }

    /**
     * Returns an {@code UpdateMeetingDescriptor} with fields containing {@code meeting}'s details
     */
    public UpdateMeetingDescriptorBuilder(Meeting meeting) {
        descriptor = new UpdateMeetingDescriptor();

        descriptor.setAgenda(meeting.getAgenda());
        descriptor.setMeetingTime(meeting.getTime());
        descriptor.setMeetingPlace(meeting.getPlace());
        descriptor.setAttendees(meeting.getIndexes());
    }

    /**
     * Sets the {@code Agenda} of the {@code EditPMeetingDescriptor} that we are building.
     */
    public UpdateMeetingDescriptorBuilder withAgenda(String agenda) {
        descriptor.setAgenda(new Agenda(agenda));
        return this;
    }

    /**
     * Sets the {@code MeetingTime} of the {@code EditPMeetingDescriptor} that we are building.
     */
    public UpdateMeetingDescriptorBuilder withTime(String meetingTime) {
        descriptor.setMeetingTime(new MeetingTime(meetingTime));
        return this;
    }

    /**
     * Sets the {@code MeetingPlace} of the {@code EditPMeetingDescriptor} that we are building.
     */
    public UpdateMeetingDescriptorBuilder withPlace(String meetingPlace) {
        descriptor.setMeetingPlace(new MeetingPlace(meetingPlace));
        return this;
    }

    public UpdateMeetingDescriptor build() {
        return descriptor;
    }
}
