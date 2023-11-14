package christmas.invalidate;

import christmas.util.Util;
import java.util.List;
import java.util.Map;

public class MenuInvalidate {

    private final String ERROR_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private final int MENU_COUNT = 20;
    private final int MENU_LENGTH = 2;
    private final char ZERO = '0';

    public void invalidateMenu(String menuInformation) {
        String[] menuItems = menuInformation.split("-");

        if (menuItems.length != MENU_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        if (menuItems[Util.FIRST].charAt(Util.ZERO) == ZERO || !menuItems[Util.FIRST].chars()
                .allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public void invalidateDuplicateOrder() {
        throw new IllegalArgumentException(ERROR_MESSAGE);
    }

    public void invalidateCount(List<Integer> menuCount) {
        int total = Util.ZERO;

        for (Integer integer : menuCount) {
            total += integer;
        }

        if (total > MENU_COUNT) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public void existMenuName(String name, Map<String, Integer> menuInformation) {
        if (!menuInformation.containsKey(name)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public void onlyDrink() {
        throw new IllegalArgumentException(ERROR_MESSAGE);
    }
}
