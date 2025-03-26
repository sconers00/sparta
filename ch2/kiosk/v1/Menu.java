package kiosk.v1;

import java.util.Scanner;

public class Menu {
    //기본 메뉴판 : 이름 - 가격 - 설명
    String[][] burger={{"데리버거","4.2","데리소스 기반 햄버거","8","0","9"},
            {"통새우버거","5.7","통새우 패티가 가득","9","0","8"},
            {"핫 크리스피 버거","5.3","치킨패티와 핫소스의 만남","10","0","10"},
            {"블랙 스파이스 버거","6.4","흑밀빵과 향신료의 조화","11","0","9"}};
    public void MenuSelect(){//임시, 선택기능과 합산만 첨가함
        int selector;
        int count =0;

        Scanner sc3=new Scanner(System.in);
        System.out.println("번호 | 이름                     | 가격              |설명");
        while (true){//공백순서바꾸기, 한글 1자=공백2개
            for(int i =0;i<4;i++){
                System.out.print((i+1)+".  |");
                for(int j=0;j<3;j++){
                    System.out.printf("%-15s",burger[i][j]);
                    while (count<12-Integer.parseInt(burger[i][j+3])){
                        System.out.print(" ");
                        count++;
                    }
                    count=0;
                    System.out.printf("%-2s","|");
                   if(j==2) {System.out.print("\n");}
                }
            }
            System.out.println("원하시는 메뉴를 골라주세요. 0:종료");
            selector= sc3.nextInt();
            if (selector<5&&selector>0){
                System.out.println("고르신 메뉴의 가격은 :"+ Double.parseDouble(burger[selector-1][1])*1000 +"입니다.");
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
