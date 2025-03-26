package kiosk.v1;

public class Main {
    public static void main(String[] args){
        Menu call = new Menu();
        call.MenuSelect();
    }
}
//lv1완, 2~5+2까지
//제출기한 : 3.14 14:00
//todo : 2. MenuItem클래스에 List로 메뉴 탐색 및 관리.
//todo : 3. Main을 start()로, Kiosk가 나머지 클래스를 구동시키는 중심클래스로.
//todo : 4. Menu클래스로 MenuItem클래스 관리. 카테고리별 메뉴아이템 구현.
//todo : 5. 캡슐화 -> getter, setter 메서드로 필드간 직접접근 방지.
//todo : +1.장바구니 구현(담은 메뉴, 가격계산, 취소기능 및 담은메뉴 빼기, 주문시 초기화)
//todo : +2.enum 람다 스트림 활용 주문 및 장바구니 관리, 할인율제시(사용자유형)