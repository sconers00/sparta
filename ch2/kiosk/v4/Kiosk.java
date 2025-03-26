package kiosk.v4;

import java.util.Scanner;

public class Kiosk {
    public void start() {
        //임시, 선택기능과 합산만 첨가함
        Menu menu = new Menu();
        int selector;
        Scanner sc = new Scanner(System.in);

        while (true) {//공백순서바꾸기, 한글 1자=공백2개
            //     매뉴종류 받도록 바꿀것
            System.out.println("원하시는 메뉴를 골라주세요.\n 1: 햄버거\n 2: 음료\n 3: 디저트\n 0: 종료");
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
