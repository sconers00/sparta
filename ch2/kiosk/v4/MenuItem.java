package kiosk.v4;

import java.util.ArrayList;
import java.util.List;

public class MenuItem {//메뉴목록들 private 로
    String[] name = {"Teriyaki Burger", "Shrimp Burger", "Hot Crispy Burger", "Black Spice Burger","Coca Cola","Sprite", "Fanta orange", "Americano", "Cafe Latte","Plain Muffin", "Fired Potato", "Soft Serve"};
    String[] price = {"4200", "5700", "5300", "6400","2500","2500","3000","2000","3000","3000", "2500", "2000"};
    String[] desc = {"데리소스 기반 햄버거", "통새우 패티가 가득", "치킨패티와 핫소스의 만남", "흑밀빵과 향신료의 조화","255ml 콜라캔","255ml 사이다캔","280ml 환타 오랜지맛","300ml 아메리카노","330ml 카페라떼","갓 구운 머핀","감자튀김","소프트 아이스크림 바닐라향"};
    String[] spacer= {"    ","      ","  "," ","        ","           ","     ","        ","       ","     ","     ","       "};

    public int[] indexer(int a){
        int indexer = -1;
        int limit = -1;
        int[] numIndex=new int [2];
        switch (a) {
            case 1 -> {
                indexer = 0;
                limit = 4;
            }
            case 2 -> {
                indexer = 4;//버거 수
                limit = 5;
            }
            case 3 -> {
                indexer = 9;//버거 수+음료 수
                limit = 3;
            }
            default->{indexer=-2; limit=-2;}
        }
        numIndex[0]=indexer;
        numIndex[1]=limit;
        return numIndex;
    }

    public String priceList(int a, int b) {
        String selectedPrice;
        int[] numIndex;
        numIndex=indexer(a);
        if (numIndex[0] > -1&&b<=numIndex[1]&&b>0) {
            selectedPrice = price[numIndex[0] + b-1];//가격반환
        } else
            selectedPrice="0";
        return selectedPrice;
    }

    public void board(int selection){// 종류별 수량 : 4-5-3
        List<String> menuItems = new ArrayList<>();
        int[] numIndex;
        numIndex=indexer(selection);
        if (numIndex[1] > -1) {
            for (int i = numIndex[0]; i < (numIndex[0] + numIndex[1]); i++) {//메뉴 생성기
                menuItems.add(name[i]);
                menuItems.add(spacer[i]);
                menuItems.add(price[i]);
                menuItems.add(spacer[2 + numIndex[0]]);
                menuItems.add(desc[i]);
                System.out.print(i+1-numIndex[0] + ".   ");
                for (int j = 0; j < 5; j++) {
                    System.out.print(menuItems.get(j));//메뉴 출력
                }
                menuItems.clear();//리스트 비우기
                System.out.println();//줄 넘기기(없으면 한줄로 모든 메뉴 출력하는 참사 발생)
            }
        }
    }
}
