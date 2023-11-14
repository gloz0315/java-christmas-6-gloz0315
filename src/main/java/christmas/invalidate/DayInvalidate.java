package christmas.invalidate;

public class DayInvalidate {

    private final String ERROR_MESSAGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private final int FIRST_DAY = 1;
    private final int END_DAY = 31;
    private final char ZERO = '0';

    public void invalidateDay(String day) {
        if (!day.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public void checkRange(String day) {
        int date = Integer.parseInt(day);

        if (date < FIRST_DAY || date > END_DAY) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public void isZero(String day) {
        if (day.charAt(0) == ZERO) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
