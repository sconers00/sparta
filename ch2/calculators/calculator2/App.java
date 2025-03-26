package calculators.calculator2;
//이것은 작업용 백업파일. 파일명과 메인 클래스 명 App으로 바꾸기

import java.util.Scanner;

import static java.lang.Integer.parseInt;


public class App {
    public static void main(String[] args) {
        Scanner sc0=new Scanner(System.in);
        processor process1 = new processor();
        String select;
        while (true) {
            System.out.println("무엇을 하시겠습니까?\n 1 : 계산기 사용\n 2 : 계산기록검색\n 그 외 : 종료");
            select=sc0.nextLine();
            if(select.equals("1")){
                process1.process();
            } else if(select.equals("2")){
                System.out.println("입력값보다 큰 계산결과들을 불러옵니다 : ");
                select=sc0.nextLine();
                Calculator.searchMemory(parseInt(select));
                //기록검색기
            } else {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }
}

