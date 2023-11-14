package christmas.discount;

import static org.junit.jupiter.api.Assertions.*;

import christmas.date.ChristmasDate;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DayDiscountTest {
    private DayDiscount discount;

    @Test
    void 할인가격_확인() {
        ChristmasDate christmasDate = new ChristmasDate("20");
        discount = new DayDiscount();

        Assertions.assertThat(discount.christmasDiscountDay(christmasDate))
                .isEqualTo(2900);
    }

}