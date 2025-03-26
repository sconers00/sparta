package kiosk.v2;

import java.util.Scanner;

public class Menu {
    //기본 메뉴판 : 이름 - 가격 - 설명
    MenuItem menuI=new MenuItem();
    public void MenuSelect(){//임시, 선택기능과 합산만 첨가함
        int selector;

        Scanner sc3=new Scanner(System.in);
        System.out.println("번호 | 이름                     | 가격              |설명");
        while (true){//공백순서바꾸기, 한글 1자=공백2개
            menuI.menuboard();
            System.out.println("원하시는 메뉴를 골라주세요. 0:종료");
            selector= sc3.nextInt();
            if (selector<5&&selector>0){
                System.out.println("고르신 메뉴의 가격은 :"+ Double.parseDouble(menuI.price[selector-1])+"입니다.");
            } else if (selector==0){
                System.out.println("종료합니다.");
                break;
            } else{
                System.out.println("잘못된입력입니다.");
                continue;
            }
            System.out.println("이용해주셔서 감사합니다.");

        }
    }
}
