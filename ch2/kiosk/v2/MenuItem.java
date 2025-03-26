package kiosk.v2;

import java.util.ArrayList;
import java.util.List;

public class MenuItem {
    String[] name = {"데리버거", "통새우버거", "핫 크리스피 버거", "블랙 스파이스 버거"};
    String[] price = {"4200", "5700", "5300", "6400"};
    String[] desc = {"데리소스 기반 햄버거", "통새우 패티가 가득", "치킨패티와 핫소스의 만남", "흑밀빵과 향신료의 조화"};
    List<String> menuItems = new ArrayList<>();
    int j=0;
    public void menuboard() {
        for (int i = 0; i < 4; i++) {
            menuItems.add(name[i]);
            menuItems.add(price[i]);
            menuItems.add(desc[i]);
            System.out.println(menuItems);
            menuItems.clear();
        }
    }
}
