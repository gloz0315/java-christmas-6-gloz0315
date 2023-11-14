package christmas.detail;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.date.ChristmasDate;
import christmas.menu.Menu;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BenefitDetailTest {
    private Menu menu;
    private ChristmasDate christmasDate;
    private BenefitDetail benefitDetail;

    @Test
    void 할인이되는지_확인() {
        menu = new Menu(new String[]{"양송이수프-1,타파스-1,티본스테이크-2"});
        christmasDate = new ChristmasDate("25");
        benefitDetail = new BenefitDetail(menu,christmasDate);

        benefitDetail.initDiscount();

        assertThat(benefitDetail.
                givingGiftEvent(benefitDetail.totalDiscountPrice())).isFalse();
    }

    @Test
    void 증정샴페인_가격_확인() {
        menu = new Menu(new String[]{"양송이수프-1,타파스-1,티본스테이크-2"});
        christmasDate = new ChristmasDate("25");
        benefitDetail = new BenefitDetail(menu,christmasDate);

        benefitDetail.initDiscount();
        benefitDetail.executeDetailDiscount();

        assertThat(benefitDetail.champagnePrice()).isEqualTo(25000);
    }

    @Test
    void 음료수_예외처리() {
        menu = new Menu(new String[]{"제로콜라-2"});
        christmasDate = new ChristmasDate("10");
        benefitDetail = new BenefitDetail(menu,christmasDate);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> menu.invalidateDrinkOnly());
    }
}