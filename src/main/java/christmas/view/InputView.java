package christmas.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final String PLANNER = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private final String VISIT_DAY = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private final String WANT_MENU = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    private final String EVENT_PREVIEW = "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private final String EVENT_MONTH = "12월 ";


    public void showPlanner() {
        System.out.println(PLANNER);
    }

    public void checkVisitedDay() {
        System.out.println(VISIT_DAY);
    }

    public void orderMenu() {
        System.out.println(WANT_MENU);
    }

    public void previewEvent(int day) {
        System.out.println(EVENT_MONTH + day + EVENT_PREVIEW);
    }

    public String input() {
        return Console.readLine();
    }
}
