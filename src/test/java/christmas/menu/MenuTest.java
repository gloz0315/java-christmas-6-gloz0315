package christmas.menu;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MenuTest {
    private Menu menu;

    @Test
    void 메뉴_주문_개수_예외처리() {
        menu = new Menu(new String[]{"티본스테이크-1","아이스크림-23"});
        menu.saveFoodInformation();

        assertThrows(IllegalArgumentException.class ,
                () ->
            menu.invalidateMenuCount());
    }

    @Test
    void 주문_예외처리() {
        menu = new Menu(new String[]{"티본스테이크1","아이스크림3"});

        assertThrows(IllegalArgumentException.class,
                () -> menu.saveFoodInformation());

    }

    @Test
    void 메인메뉴_개수_확인() {
        menu = new Menu(new String[]{"티본스테이크-1","해산물파스타-1","아이스크림-2","제로콜라-3"});
        menu.saveFoodInformation();;

        Assertions.assertThat(menu.mainCount()).isEqualTo(2);
    }

    @Test
    void 디저트메뉴_개수_확인() {
        menu = new Menu(new String[]{"티본스테이크-1","해산물파스타-1","아이스크림-5","제로콜라-3"});
        menu.saveFoodInformation();;

        Assertions.assertThat(menu.dessertCount()).isEqualTo(5);
    }

    @Test
    void 메뉴_계산() {
        menu = new Menu(new String[]{"티본스테이크-1","양송이수프-1"});
        menu.saveFoodInformation();
        menu.calculatePrice();

        Assertions.assertThat(menu.getTotalPrice()).isEqualTo(61000);
    }
}