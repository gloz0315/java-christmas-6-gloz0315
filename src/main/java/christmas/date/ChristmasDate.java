package christmas.date;

import christmas.util.Util;
import christmas.invalidate.DayInvalidate;

public class ChristmasDate {
    private final int date;

    public ChristmasDate(String date) {
        DayInvalidate dayInvalidate = new DayInvalidate();
        dayInvalidate.invalidateDay(date);
        dayInvalidate.isZero(date);
        dayInvalidate.checkRange(date);
        this.date = Integer.parseInt(date);
    }

    public boolean isDiscountDay() {
        return Util.CHRISTMAS >= date;
    }

    public int day() {
        return date;
    }

    public boolean isWeekend() {
        return (date % Util.SEVEN == Util.FIRST) || (date % Util.SEVEN == Util.SECOND);
    }

    public boolean isStarDay() {
        return (date % Util.SEVEN == Util.THIRD) || (date == Util.CHRISTMAS);
    }
}
