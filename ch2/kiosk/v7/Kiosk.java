package kiosk.v7;

import java.util.Scanner;

public class Kiosk {
    Menu menu = new Menu();
    Order order = new Order();

    public void start() {
        int selector;
        int type;
        Scanner sc = new Scanner(System.in);
        while (true) {//기본화면 및 결제기
            if (menu.orderCheck()) {
                System.out.println("원하시는 카테고리를 골라주세요.\n 1: 햄버거\n 2: 음료\n 3: 디저트\n 4: 주문\n 5: 주문취소 \n 0: 종료");
            } else {
                System.out.println("원하시는 카테고리를 골라주세요.\n 1: 햄버거\n 2: 음료\n 3: 디저트\n 0: 종료");
            }
            selector = sc.nextInt();
            switch (selector) {
                case 0: {
                    System.out.println("종료합니다.");
                    System.exit(0);
                }
                case 1:
                case 2:
                case 3: {
                    menu.menuList(selector);
                }
                break;
                case 4: {
                    if (menu.orderCheck()) {
                        order.orderDisplayer();
                        System.out.println("주문하시겠습니까? 1: 주문하기 0: 돌아가기");
                        selector = sc.nextInt();
                        sc.nextLine();
                        if (selector == 1) {
                            System.out.println("고객 유형을 입력해주십시오. \n 1 : 성인 \n 2 : 학생 10%할인 \n 3 : 60세이상 20%할인\n 4 : 군인 15%할인");
                            type = sc.nextInt();
                            sc.nextLine();
                            order.sumDisplay(type);
                            System.out.println(" 원 결제되었습니다.\n이용해주셔서 감사합니다.");
                            menu.orderReset();
                        } else {
                            System.out.println("잘못된입력입니다.");
                        }
                        break;
                    }
                }
                case 5: {
                    if (menu.orderCheck()) {
                        System.out.println("주문을 취소합니다.");
                        menu.orderReset();
                        order.resetOrder();
                    } else {
                        System.out.println("잘못된입력입니다.");
                        break;
                    }
                }
                default:
                    System.out.println("잘못된입력입니다.");
            }
        }
    }
}
