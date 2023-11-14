package christmas.date;

import static org.assertj.core.api.Assertions.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class ChristmasDateTest {

    @Test
    void 할인날짜인지_확인() {
        ChristmasDate christmasDate = new ChristmasDate("20");

        assertThat(christmasDate.isDiscountDay()).isTrue();
    }

    @Test
    void 입력값_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> {
            ChristmasDate christmasDate = new ChristmasDate("a");
        });
    }

    @Test
    void 날짜_반환_확인() {
        ChristmasDate christmasDate = new ChristmasDate("10");

        assertThat(christmasDate.day()).isEqualTo(10);
    }

    @Test
    void 주말_평일_확인() {
        ChristmasDate christmasDate1 = new ChristmasDate("10");
        ChristmasDate christmasDate2 = new ChristmasDate("15");

        assertThat(christmasDate1.isWeekend()).isFalse();
        assertThat(christmasDate2.isWeekend()).isTrue();
    }

    @Test
    void 특별할인날짜_확인() {
        ChristmasDate christmasDate1 = new ChristmasDate("10");
        ChristmasDate christmasDate2 = new ChristmasDate("11");

        assertThat(christmasDate1.isStarDay()).isTrue();
        assertThat(christmasDate2.isStarDay()).isFalse();
    }
}