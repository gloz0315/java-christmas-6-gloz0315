package christmas.view;

import christmas.date.ChristmasDate;
import christmas.discount.MenuDiscount;
import christmas.fix.BadgePrice;
import christmas.fix.DiscountView;
import christmas.fix.UnitView;
import christmas.menu.Menu;
import christmas.util.Util;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Map.Entry;

public class OutputView {

    private final ChristmasDate christmasDate;
    private final String MENU = "<주문 메뉴>";
    private final String BEFORE_DISCOUNT = "<할인 전 총주문 금액>";
    private final String GIFT_MENU = "<증정 메뉴>";
    private final String BENEFIT_DETAIL = "<혜택 내역>";
    private final String FINAL_BENEFIT_PRICE = "<총혜택 금액>";
    private final String AFTER_DISCOUNT_PRICE = "<할인 후 예상 결제 금액>";
    private final String SHOW_BADGE = "<12월 이벤트 배지>";
    private final String NOTHING = "없음";
    private final String CHAMPAGNE_ONE = "샴페인 1개";
    private final DecimalFormat formatter = new DecimalFormat("###,###");

    public OutputView(ChristmasDate christmasDate) {
        this.christmasDate = christmasDate;
    }

    public void printOrderMenu(Map<String, Integer> menu) {
        System.out.println(MENU);

        for (Entry<String, Integer> entrySet : menu.entrySet()) {
            System.out.println(entrySet.getKey() + " " + entrySet.getValue() + UnitView.NUMBER.message());
        }
    }

    public void beforeDiscountPrice(int beforeDiscount) {
        System.out.println(BEFORE_DISCOUNT);
        System.out.println(formatter.format(beforeDiscount) + UnitView.WON.message());
    }

    public void giftMenu(int prize) {
        System.out.println(GIFT_MENU);

        if (prize >= Util.GIFT_BENEFIT_PRICE) {
            System.out.println(CHAMPAGNE_ONE);
            return;
        }

        System.out.println(NOTHING);
    }

    public void benefitInformation() {
        System.out.println(BENEFIT_DETAIL);
    }

    public void getRewardInformation(int money) {
        if (christmasDate.isDiscountDay()) {
            System.out.println(
                    DiscountView.CHRISTMAS_DAY_DISCOUNT.message() + formatter.format(money) + UnitView.WON.message());
        }
    }

    public void menuDiscount(MenuDiscount menuDiscount) {
        if (menuDiscount.menuDiscount() != Util.ZERO) {
            if (christmasDate.isWeekend()) {
                System.out.println(
                        DiscountView.WEEKEND_DISCOUNT.message() + formatter.format(menuDiscount.menuDiscount())
                                + UnitView.WON.message());
                return;
            }

            System.out.println(DiscountView.WEEKDAY_DISCOUNT.message() + formatter.format(menuDiscount.menuDiscount())
                    + UnitView.WON.message());
        }
    }

    public int specialDiscount() {
        if (christmasDate.isStarDay()) {
            System.out.println(
                    DiscountView.SPECIAL_DISCOUNT.message() + formatter.format(Util.DISCOUNT_PRICE)
                            + UnitView.WON.message());
            return Util.DISCOUNT_PRICE;
        }

        return Util.ZERO;
    }

    public int rewardEvent(boolean giftEvent) {
        if (giftEvent) {
            System.out.println(
                    DiscountView.GIFT_EVENT.message() + formatter.format(Util.CHAMPAGNE) + UnitView.WON.message());
            return Util.CHAMPAGNE;
        }

        return Util.ZERO;
    }

    public void showBenefitTotal() {
        System.out.println(FINAL_BENEFIT_PRICE);
    }

    public int benefitTotalPrice(int discountPrice) {
        if (discountPrice != Util.ZERO) {
            System.out.println("-" + formatter.format(discountPrice) + UnitView.WON.message());
            return discountPrice;
        }

        System.out.println(formatter.format(discountPrice) + UnitView.WON.message());
        return discountPrice;
    }

    public void AfterDiscount(int price) {
        System.out.println(AFTER_DISCOUNT_PRICE);
        System.out.println(formatter.format(price) + UnitView.WON.message());
    }

    public void showBadge() {
        System.out.println(SHOW_BADGE);
    }

    public void badge(int price) {
        if (price >= BadgePrice.SANTA.price()) {
            System.out.print(BadgePrice.SANTA.message());
            return;
        } else if (price >= BadgePrice.TREE.price()) {
            System.out.print(BadgePrice.TREE.message());
            return;
        } else if (price >= BadgePrice.STAR.price()) {
            System.out.print(BadgePrice.STAR.message());
            return;
        }

        System.out.print(NOTHING);
    }

    public void benefitPrice(int price, boolean canDiscount) {
        if (price == Util.ZERO || !canDiscount) {
            System.out.println(NOTHING);
        }
    }

    public int giftCutLine() {
        return Util.GIFT_BENEFIT_PRICE;
    }

    public int champagnePrice() {
        return Util.CHAMPAGNE;
    }
}
