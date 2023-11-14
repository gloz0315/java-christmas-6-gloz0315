package christmas.menu;

import christmas.invalidate.MenuInvalidate;
import java.util.HashMap;
import java.util.Map;

public class MenuBoard {
    private final Map<String, Integer> menuBoard;
    private final MenuInvalidate menuInvalidate;

    public MenuBoard() {
        menuBoard = new HashMap<>();
        menuInvalidate = new MenuInvalidate();
    }

    // 메뉴판에 대한 정보 초기화
    public void initMenuBoard() {
        insertAppetizer();
        insertMain();
        insertDessert();
        insertDrink();
    }

    public int menuPrice(String menuInfo, int count) {
        return menuBoard.get(menuInfo) * count;
    }

    public void invalidateMenu(String menuInfo) {
        menuInvalidate.existMenuName(menuInfo, menuBoard);
    }

    public boolean drinkOnly(String menuInfo) {
        return menuInfo.equals("제로콜라") || menuInfo.equals("레드와인") || menuInfo.equals("샴페인");
    }

    private void insertAppetizer() {
        menuBoard.put("양송이수프", 6000);
        menuBoard.put("타파스", 5500);
        menuBoard.put("시저샐러드", 8000);
    }

    private void insertMain() {
        menuBoard.put("티본스테이크", 55000);
        menuBoard.put("바비큐립", 54000);
        menuBoard.put("해산물파스타", 35000);
        menuBoard.put("크리스마스파스타", 25000);
    }

    private void insertDessert() {
        menuBoard.put("초코케이크", 15000);
        menuBoard.put("아이스크림", 5000);
    }

    private void insertDrink() {
        menuBoard.put("제로콜라", 3000);
        menuBoard.put("레드와인", 60000);
        menuBoard.put("샴페인", 25000);
    }
}
