package christmas.discount;

import christmas.date.ChristmasDate;
import christmas.menu.Menu;
import christmas.util.Util;

public class MenuDiscount {
    private final Menu menu;
    private final ChristmasDate christmasDate;
    private int discountMenuTotal = 0;

    public MenuDiscount(Menu menu, ChristmasDate christmasDate) {
        this.menu = menu;
        this.christmasDate = christmasDate;
    }

    public void menuTotalDiscount() {
        if (christmasDate.isWeekend()) {
            discountMenuTotal = menu.mainCount() * Util.MENU_DISCOUNT_PRICE;
            return;
        }

        discountMenuTotal = menu.dessertCount() * Util.MENU_DISCOUNT_PRICE;
    }

    public int menuDiscount() {
        return discountMenuTotal;
    }
}
