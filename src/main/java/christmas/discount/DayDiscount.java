package christmas.discount;

import christmas.date.ChristmasDate;
import christmas.util.Util;

public class DayDiscount {

    public int christmasDiscountDay(ChristmasDate christmasDate) {
        return Util.DISCOUNT_PRICE + (christmasDate.day() - Util.FIRST) * Util.HUNDRED;
    }
}
