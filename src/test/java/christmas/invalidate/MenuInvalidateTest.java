package christmas.invalidate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MenuInvalidateTest {

    private MenuInvalidate menuInvalidate;
    @BeforeEach
    void setUp() {
        menuInvalidate = new MenuInvalidate();
    }

    @Test
    void 메뉴_예외처리1() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> menuInvalidate.invalidateMenu("티본스테이크123"));

    }

    @Test
    void 메뉴_예외처리2() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> menuInvalidate.invalidateMenu("티본스테이크-1-3"));

    }

    @Test
    void 메뉴_예외처리3() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> menuInvalidate.invalidateMenu("티본스테이크-01"));
    }


    @Test
    void 주문갯수_예외처리() {
        List<Integer> menuCount = new ArrayList<>();
        menuCount.add(1);
        menuCount.add(10);
        menuCount.add(20);

        Assertions.assertThrows(IllegalArgumentException.class,
                ()->menuInvalidate.invalidateCount(menuCount));
    }

    @Test
    void 음식존재_확인() {
        String name = "꼼양꿍";
        Map<String,Integer> menu = new HashMap<>();
        menu.put("티본스테이크", 55000);
        menu.put("바비큐립", 54000);
        menu.put("해산물파스타", 35000);
        menu.put("크리스마스파스타", 25000);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> menuInvalidate.existMenuName(name,menu));

    }

}