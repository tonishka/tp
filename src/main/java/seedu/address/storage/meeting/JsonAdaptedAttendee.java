package seedu.address.storage.meeting;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.exceptions.IllegalValueException;

/**
 * Jackson-friendly version of {@link Id}.
 */
class JsonAdaptedAttendee {

    private final int attendeeId;

    /**
     * Constructs a {@code JsonAdaptedTag} with the given {@code tagName}.
     */
    @JsonCreator
    public JsonAdaptedAttendee(int attendeeId) {
        this.attendeeId = attendeeId;
    }

    /**
     * Converts a given {@code Tag} into this class for Jackson use.
     */
    public JsonAdaptedAttendee(Index source) {
        this.attendeeId = source.getOneBased();
    }

    @JsonValue
    public Integer getAttendeeId() {
        return attendeeId;
    }

    /**
     * Converts this Jackson-friendly adapted tag object into the model's {@code Tag} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted tag.
     */
    public Index toModelType() throws IllegalValueException {
//        if (!Index.isValidIndex(attendeeId)) {
//            throw new IllegalValueException(Index.MESSAGE_CONSTRAINTS);
//        }
        return Index.fromZeroBased(attendeeId);
    }

    @Override
    public String toString() {
        return "JsonAdaptedAttendee: " + attendeeId;
    }
}
