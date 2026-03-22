package seedu.address.model.person;

/**
 * Represents a student's attendance status for a single week.
 */
public class Week implements WeeklyAttendance {
    public static final String MESSAGE_CONSTRAINTS = "Week status must be Y or N";
    public static final int WEEK_DIFFERENCE = 2;

    private final int weekNo;
    private boolean isAttended;

    /**
     * Constructs a {@code Week} with the specified week number.
     *
     * @param weekNo The week number (must be positive and not exceed {@code WeekList.NUMBER_OF_WEEKS})
     */
    public Week(int weekNo) {
        assert weekNo > 0 : "Invalid week number";
        assert weekNo <= WeekList.NUMBER_OF_WEEKS : "Week number exceeded maximum allowed";
        this.weekNo = weekNo;
        this.isAttended = false;
    }

    @Override
    public void markAsAttended() throws IllegalStateException {
        if (isAttended) {
            throw new IllegalStateException("Week attendance has already been marked as attended");
        }
        isAttended = true;
    }

    @Override
    public void markAsAbsent() {
        if (!isAttended) {
            throw new IllegalStateException("Week attendance has already been marked as absent");
        }
        isAttended = false;
    }

    @Override
    public boolean isAttended() {
        return isAttended;
    }

    @Override
    public int getWeek() {
        return weekNo;
    }

    /**
     * Returns:
     * Y = attended
     * A = absent
     */
    public String getStatus() {
        return isAttended ? "Y" : "A";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof Week)) {
            return false;
        }

        Week otherWeek = (Week) other;
        return this.isAttended == otherWeek.isAttended
                && this.weekNo == otherWeek.weekNo;
    }

    @Override
    public String toString() {
        return String.format("W%d: %s", weekNo, getStatus());
    }
}
