package kiosk.v6;

import java.util.Scanner;

public class Kiosk {
    Menu menu = new Menu();
    Order order = new Order();
    public void start() {
        int selector;
        Scanner sc = new Scanner(System.in);
        while (true) {
            if (menu.orderCheck()) {
                System.out.println("원하시는 카테고리를 골라주세요.\n 1: 햄버거\n 2: 음료\n 3: 디저트\n 4: 주문\n 5: 주문취소 \n0: 종료");
                selector = sc.nextInt();
                sc.nextLine();
                if (selector < 4 && selector > 0) {
                    menu.menuList(selector);
                } else if (selector == 0) {
                    System.out.println("종료합니다.");
                    break;
                } else if(selector==4){
                    //주문실행
                    order.orderDisplayer();
                    System.out.println("주문하시겠습니까? 1: 주문하기 0: 돌아가기");
                    selector=sc.nextInt();
                    sc.nextLine();
                    if (selector==1){
                        order.sumDisplay();
                        System.out.println(" 원 결제되었습니다.");
                        order.resetOrder();
                    }

                } else if(selector==5){
                    System.out.println("주문을 취소합니다.");
                    menu.orderReset();
                    order.resetOrder();
                } else {
                    System.out.println("잘못된입력입니다.");
                    continue;
                }
                System.out.println("이용해주셔서 감사합니다.");
            } else{
                System.out.println("원하시는 카테고리를 골라주세요.\n 1: 햄버거\n 2: 음료\n 3: 디저트\n 0: 종료");
                selector = sc.nextInt();
                if (selector < 4 && selector > 0) {
                    menu.menuList(selector);
                } else if (selector == 0) {
                    System.out.println("종료합니다.");
                    break;
                } else {
                    System.out.println("잘못된입력입니다.");
                    continue;
                }
                System.out.println("이용해주셔서 감사합니다.");
            }
        }
    }
}
