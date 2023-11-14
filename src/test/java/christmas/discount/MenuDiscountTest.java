package christmas.discount;

import christmas.date.ChristmasDate;
import christmas.menu.Menu;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MenuDiscountTest {
    private Menu menu;
    private ChristmasDate christmasDate;
    private MenuDiscount menuDiscount;

    @Test
    void 할인가격_테스트() {
        menu = new Menu(new String[]{"양송이수프-10"});
        christmasDate = new ChristmasDate("20");
        menuDiscount = new MenuDiscount(menu,christmasDate);
        menuDiscount.menuTotalDiscount();

        Assertions.assertThat(menuDiscount.menuDiscount()).isEqualTo(0);
    }

    @Test
    void 할인가격_테스트1() {
        String[] menuList = {"초코케이크-3"};
        menu = new Menu(menuList);
        christmasDate = new ChristmasDate("20");
        menuDiscount = new MenuDiscount(menu,christmasDate);
        menu.saveFoodInformation();
        menu.invalidateDrinkOnly();
        menu.calculatePrice();
        menu.invalidateMenuCount();
        menuDiscount.menuTotalDiscount();


        Assertions.assertThat(menuDiscount.menuDiscount()).isEqualTo(2023*3);
    }
}