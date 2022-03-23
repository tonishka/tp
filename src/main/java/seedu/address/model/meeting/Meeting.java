package seedu.address.model.meeting;

import java.util.HashSet;

import seedu.address.model.person.Person;

/**
 * Represents a meeting of which the user is a part.
 */
public class Meeting implements Comparable<Meeting> {
    private final Agenda agenda;
    private final MeetingPlace place;
    private final MeetingTime time;
    private final HashSet<Person> attendees;

    /**
     * Constructs a new meeting with the given parameters
     * @param agenda Agenda of the meeting
     * @param place Meeting place
     * @param time Meeting time and date
     * @param attendees Other attendees of the meeting
     */
    public Meeting (Agenda agenda, MeetingPlace place, MeetingTime time, HashSet<Person> attendees) {
        this.agenda = agenda;
        this.place = place;
        this.time = time;
        this.attendees = attendees;
    }

    public Agenda getAgenda() {
        return this.agenda;
    }

    public MeetingPlace getPlace() {
        return this.place;
    }

    public MeetingTime getTime() {
        return this.time;
    }

    public HashSet<Person> getAttendees() {
        return this.attendees;
    }

    /**
     * Returns true if both meetings have the same agenda, time, place and attendees.
     */
    public boolean isSameMeeting(Meeting otherMeeting) {
        if (otherMeeting == this) {
            return true;
        }

        return otherMeeting != null
                && otherMeeting.getAgenda().equals(getAgenda())
                && otherMeeting.getTime().equals(getTime())
                && otherMeeting.getPlace().equals(getPlace())
                && otherMeeting.getAttendees().equals(getAttendees());
    }

    @Override
    /**
     * Chronological order is enforced on meetings
     */
    public int compareTo(Meeting other) {
        return getTime().dateTime.compareTo((other.getTime().dateTime));
    }
}
