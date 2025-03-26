package kiosk.v4;

public class Main {
    public static void main(String[] args){
        Kiosk kiosk= new Kiosk();
        kiosk.start();
    }
}
//lv3완, 2~5+2까지
//제출기한 : 3.14 14:00
//lv2완   2. MenuItem 클래스에 List 로 메뉴 탐색 및 관리.
//lv3완   3. Main 을 start()로, Kiosk 가 나머지 클래스를 구동시키는 중심클래스로.
//lv4완   4. Menu 클래스로 MenuItem 클래스 관리. 카테고리별 메뉴아이템 구현. <- 3.10
//todo :  5. 캡슐화 -> getter, setter 메서드로 필드간 직접접근 방지.
//todo : +1.장바구니 구현(담은 메뉴, 가격계산, 취소기능 및 담은메뉴 빼기, 주문시 초기화)  <- 3.11
//todo : +2.enum 람다 스트림 활용 주문 및 장바구니 관리, 할인율제시(사용자유형) <- 3.13