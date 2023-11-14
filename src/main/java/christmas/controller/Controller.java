package christmas.controller;

import christmas.date.ChristmasDate;
import christmas.detail.BenefitDetail;
import christmas.menu.Menu;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Controller {
    private Menu menu;
    private ChristmasDate christmasDate;
    private BenefitDetail benefitDetail;
    private final InputView inputView = new InputView();
    private OutputView outputView;

    public void startChristmas() {
        insertMenuDate();
        initOutputView(christmasDate);
        printResult();
    }

    public void initOutputView(ChristmasDate christmasDate) {
        outputView = new OutputView(christmasDate);
    }

    public void insertMenuDate() {
        inputView.showPlanner();
        insertDay();
        insertMenu();
        inputView.previewEvent(christmasDate.day());
        breakingLine();
    }

    public void printResult() {
        printOrderMenu();   // 주문 메뉴 출력
        printBeforeDiscount();  // 할인 전 총 주문 금액 출력
        printGiftMenu();    // 증정 메뉴 출력
        int discountPrice = printBenefitDetails();      // 혜택 내역에 관한 내용
        int totalBenefitPrice = printTotalBenefitPrice(discountPrice);  // 총 혜택 금액
        breakingLine();
        printExpectPrice(discountPrice);        // 할인 후 예상 결제 금액
        printEventBadge(totalBenefitPrice);     // 이벤트 배지 출력
    }

    private void insertDay() {
        inputView.checkVisitedDay();

        while (true) {
            try {
                christmasDate = new ChristmasDate(inputView.input());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void insertMenu() {
        inputView.orderMenu();

        while (true) {
            try {
                String[] menuList = inputView.input().split(",");
                menu = new Menu(menuList);
                controlMenu();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void controlMenu() {
        menu.saveFoodInformation();
        menu.invalidateDrinkOnly();
        menu.calculatePrice();
        menu.invalidateMenuCount();
    }

    private void printOrderMenu() {
        outputView.printOrderMenu(menu.menuInformation()); // 주문메뉴
        breakingLine();
    }

    private void printBeforeDiscount() {
        outputView.beforeDiscountPrice(menu.getTotalPrice());   // 할인 전 총 주문금액
        breakingLine();
    }

    private void printGiftMenu() {
        outputView.giftMenu(menu.getTotalPrice());   // 증정 메뉴
        breakingLine();
    }

    private int printBenefitDetails() {
        benefitDetail = new BenefitDetail(menu, christmasDate);     // 혜택 내역
        outputView.benefitInformation();
        benefitDetail.initDiscount();
        benefitDetail.executeDetailDiscount();
        breakingLine();

        return benefitDetail.totalDiscountPrice();
    }

    private int printTotalBenefitPrice(int discountPrice) {
        outputView.showBenefitTotal();
        return outputView.benefitTotalPrice(discountPrice);
    }

    private void printExpectPrice(int discountPrice) {
        if (benefitDetail.givingGiftEvent(menu.getTotalPrice())) {
            outputView.AfterDiscount(menu.getTotalPrice() - discountPrice + benefitDetail.champagnePrice());
            breakingLine();
            return;
        }

        outputView.AfterDiscount(menu.getTotalPrice() - discountPrice);
        breakingLine();
    }

    private void printEventBadge(int totalBenefitPrice) {
        outputView.showBadge();
        outputView.badge(totalBenefitPrice);
    }

    private void breakingLine() {
        System.out.println();
    }
}
