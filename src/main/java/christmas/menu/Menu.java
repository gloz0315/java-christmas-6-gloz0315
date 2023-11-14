package christmas.menu;

import christmas.invalidate.MenuInvalidate;
import christmas.util.Util;
import java.util.HashMap;
import java.util.Map;

public class Menu {
    private final String[] inputMenu;
    private final MenuInvalidate menuInvalidate;
    private final MenuBoard menuBoard;
    private final Map<String, Integer> menuInformation = new HashMap<>();
    private int totalPrice = Util.ZERO;

    public Menu(String[] inputMenu) {
        this.inputMenu = inputMenu;
        menuInvalidate = new MenuInvalidate();
        menuBoard = new MenuBoard();
        menuBoard.initMenuBoard();
    }

    public void invalidateMenu(String menuInfo) {
        String[] menuItems = menuInfo.split("-");
        menuInvalidate.invalidateMenu(menuInfo);
        menuBoard.invalidateMenu(menuItems[Util.ZERO]);

    }

    public void invalidateDrinkOnly() {
        if (foodDrinkOnly()) {
            menuInvalidate.onlyDrink();
        }
    }

    public void invalidateMenuCount() {
        menuInvalidate.invalidateCount(menuInformation.values().stream().toList());
    }

    public void saveFoodInformation() {
        for (String menuInfo : inputMenu) {
            String[] menu = menuInfo.split("-");

            invalidateMenu(menuInfo);
            insertMenu(menu[Util.ZERO], Integer.parseInt(menu[Util.FIRST]));
        }
    }

    public void calculatePrice() {
        for (Map.Entry<String, Integer> menu : menuInformation.entrySet()) {
            totalPrice += menuBoard.menuPrice(menu.getKey(), menu.getValue());
        }
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public Map<String, Integer> menuInformation() {
        return menuInformation;
    }

    public int mainCount() {
        int count = Util.ZERO;

        String[] mainMenu = {"티본스테이크", "해산물파스타", "바비큐립", "크리스마스파스타"};

        for (String targetMenu : mainMenu) {
            if (menuInformation.containsKey(targetMenu)) {
                count += menuInformation.get(targetMenu);
            }
        }
        return count;
    }

    public int dessertCount() {
        int count = Util.ZERO;

        String[] dessertMenu = {"초코케이크", "아이스크림"};

        for (String targetMenu : dessertMenu) {
            if (menuInformation.containsKey(targetMenu)) {
                count += menuInformation.get(targetMenu);
            }
        }

        return count;
    }

    private boolean foodDrinkOnly() {
        for (String menuName : menuInformation.keySet()) {
            if (menuBoard.drinkOnly(menuName)) {
                continue;
            }
            return false;
        }

        initEveryThing();
        return true;
    }

    private void initEveryThing() {
        menuInformation.clear();
        totalPrice = Util.ZERO;
    }

    private void insertMenu(String menuName, int count) {
        if (checkDuplicateOrder(menuName)) {
            menuInvalidate.invalidateDuplicateOrder();
            return;
        }

        menuInformation.put(menuName, count);
    }

    private boolean checkDuplicateOrder(String menuName) {
        return menuInformation.containsKey(menuName);
    }
}
