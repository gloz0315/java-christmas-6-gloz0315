package christmas.detail;

import christmas.date.ChristmasDate;
import christmas.discount.DayDiscount;
import christmas.discount.MenuDiscount;
import christmas.menu.Menu;
import christmas.util.Util;
import christmas.view.OutputView;

public class BenefitDetail {
    private final Menu menu;
    private final ChristmasDate christmasDate;
    private int discountPrice = Util.ZERO;
    private final OutputView outputView;
    private DayDiscount dayDiscount;
    private MenuDiscount menuDiscount;
    private int menuTotalPrice = Util.ZERO;

    public BenefitDetail(Menu menu, ChristmasDate christmasDate) {
        this.menu = menu;
        this.christmasDate = christmasDate;
        outputView = new OutputView(christmasDate);
    }

    public void initDiscount() {
        dayDiscount = new DayDiscount();
        menuDiscount = new MenuDiscount(menu, christmasDate);
        menuTotalPrice = menu.getTotalPrice();
    }

    public void executeDetailDiscount() {
        printChristmasDiscount(christmasDay());
        printNormalDiscount();
        printSpecialDiscount();
        printRewardDiscount(givingGiftEvent(menu.getTotalPrice()));
        outputView.benefitPrice(discountPrice,availableDiscount());
    }

    public boolean givingGiftEvent(int price) {
        return price >= outputView.giftCutLine();
    }

    public int totalDiscountPrice() {
        return discountPrice;
    }

    public int champagnePrice() {
        return outputView.champagnePrice();
    }

    private boolean christmasDay() {
        return christmasDate.isDiscountDay();
    }

    private void printChristmasDiscount(boolean christmasDay) {
        if (christmasDay && availableDiscount()) {
            outputView.getRewardInformation(dayDiscount.christmasDiscountDay(christmasDate));
            discountPrice += dayDiscount.christmasDiscountDay(christmasDate);
        }
    }

    private void printNormalDiscount() {
        if(availableDiscount()) {
            menuDiscount.menuTotalDiscount();
            discountPrice += menuDiscount.menuDiscount();
            outputView.menuDiscount(menuDiscount);
        }
    }

    private void printSpecialDiscount() {
        if(availableDiscount()) {
            discountPrice += outputView.specialDiscount();
        }
    }

    private void printRewardDiscount(boolean givingGiftEvent) {
        if(availableDiscount()) {
            discountPrice += outputView.rewardEvent(givingGiftEvent);
        }
    }

    private boolean availableDiscount() {
        return menuTotalPrice >= Util.CAN_DISCOUNT;
    }
}
