package christmas.menu;

import java.util.HashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MenuBoardTest {
    private MenuBoard menuBoard;

    @BeforeEach
    void setUp() {
        menuBoard = new MenuBoard();
        menuBoard.initMenuBoard();
    }

    @Test
    void 메뉴_총가격_확인() {
        Map<String,Integer> menu = new HashMap<>();
        menu.put("양송이수프",1);
        menu.put("제로콜라",3);
        menu.put("티본스테이크",2);

        int total = 0;

        for(String key : menu.keySet())
            total += menuBoard.menuPrice(key,menu.get(key));

        Assertions.assertThat(total).isEqualTo(125000);
    }

    @Test
    void 음료수인지_확인() {
        Assertions.assertThat(menuBoard.drinkOnly("제로콜라")).isTrue();
        Assertions.assertThat(menuBoard.drinkOnly("해산물파스타")).isFalse();
    }
}