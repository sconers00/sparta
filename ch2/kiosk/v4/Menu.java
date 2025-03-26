package kiosk.v4;


import java.util.Objects;
import java.util.Scanner;

public class Menu {
    //기본 메뉴판 : 이름 - 가격 - 설명
    MenuItem itemCase = new MenuItem();
    Scanner sc1 = new Scanner(System.in);
    int selectMenu; //private 대상
    public void menuList(int selectorIn){
        while(true) {
        System.out.println("번호 | 이름            | 가격   |설명");
            itemCase.board(selectorIn);
            System.out.println("원하시는 메뉴를 골라주십시오. 0 : 메뉴로 돌아가기");
            selectMenu=sc1.nextInt();
            sc1.nextLine();
            if (selectMenu>0&&selectMenu<=5){
                if (Objects.equals(itemCase.priceList(selectorIn, selectMenu), "0")) {
                    System.out.println("잘못된 입력입니다. 다시 입력해 주십시오.");
                    continue;
                }
                System.out.println("고르신 메뉴의 가격은 :" + itemCase.priceList(selectorIn,selectMenu) + "입니다.");//todo : get/set 연결
            } else if (selectMenu==0){
                break;
            } else{
                System.out.println("잘못된 입력입니다. 다시 입력해 주십시오.");
            }
        }
    }



}
