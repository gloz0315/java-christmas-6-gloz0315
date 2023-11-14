package christmas.invalidate;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DayInvalidateTest {

    private DayInvalidate dayInvalidate;

    @Test
    void 날짜_예외처리1() {
        dayInvalidate = new DayInvalidate();

        Assertions.assertThrows(IllegalArgumentException.class,
                ()-> dayInvalidate.invalidateDay("s12"));
    }

    @Test
    void 날짜_예외처리2() {
        dayInvalidate = new DayInvalidate();

        Assertions.assertThrows(IllegalArgumentException.class,
                ()-> dayInvalidate.invalidateDay("2 3"));
    }

    @Test
    void 날짜_예외처리3() {
        dayInvalidate = new DayInvalidate();

        Assertions.assertThrows(IllegalArgumentException.class,
                ()-> dayInvalidate.checkRange("32"));
    }

    @Test
    void 날짜_예외처리4() {
        dayInvalidate = new DayInvalidate();

        Assertions.assertThrows(IllegalArgumentException.class,
                ()-> dayInvalidate.checkRange("0"));
    }

    @Test
    void 날짜_예외처리5() {
        dayInvalidate = new DayInvalidate();

        Assertions.assertThrows(IllegalArgumentException.class,
                ()-> dayInvalidate.checkRange("-100"));
    }

    @Test
    void 날짜_예외처리6() {
        dayInvalidate = new DayInvalidate();

        Assertions.assertThrows(IllegalArgumentException.class,
                ()-> dayInvalidate.isZero("01"));
    }
}