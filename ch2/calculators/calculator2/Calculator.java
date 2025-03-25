package calculators.calculator2;

import java.util.ArrayList;
import java.util.Scanner;

class Calculator extends processor{
    public int[] getinput(int[] arr) {
        Scanner sc2 = new Scanner(System.in);
        String arithmetic;

        //오류발생가능-입력타입 불일치
        System.out.println("1번째 정수를 입력해 주세요 : ");
        arr[0] = sc2.nextInt();
        sc2.nextLine();
        System.out.println("2번째 정수를 입력해 주세요 : ");
        arr[1] = sc2.nextInt();
        sc2.nextLine();
        System.out.println("다음중 원하는 연산기호를 입력해 주세요 +, -, *, / : ");
        arithmetic = sc2.nextLine();
        switch (arithmetic) {
            case "+" -> arr[2] = 1;
            case "-" -> arr[2] = 2;
            case "*" -> arr[2] = 3;
            case "/" -> arr[2] = 4;
            default -> {
                arr[2] = 0;
                System.out.println("연산기호가 아닙니다.\n프로그램을 재시작합니다.\n");
            }
        }
        return arr;
    }
    public int[] calculate(int[] arr){
        int[] arrs=new int[3]; // result,rest,divider
        switch (arr[2]) {
            case 1:
                arrs[0] = arr[0] + arr[1];
                break;
            case 2:
                arrs[0] = arr[0] - arr[1];
                break;
            case 3:
                arrs[0] = arr[0] * arr[1];
                break;
            case 4: //오류발생가능 - div0산술오류 현제 if로 막아놓음, try-catch 으로 바꿔먹기
                if (arr[1] != 0) {
                    arrs[0] = arr[0] / arr[1];
                    arrs[1]= arr[0] % arr[1];
                    arrs[2]= arr[1];
                } else {
                    System.out.println("0으로 나눌 수 없습니다.");
                }
                break;
        }
        return arrs;
    }

    private static ArrayList<Double> resultmemory = new ArrayList<>();

    public void getResultMemory() {
        System.out.println(resultmemory);
    }

    public void addResultMemory(double result) {
        resultmemory.add(result);
        System.out.println("계산결과 : "+resultmemory.getLast());
    }
    public void deleteFirstResult(){
        resultmemory.removeFirst();
    }
    public static void searchMemory(int baseline){
        //람다-스트림 형식으로 구현할것!! 더블스트림? 람다는 비교연산 안되므로 함수인터페이스로 처리
        ArrayList<Double> searchResult= new ArrayList<>();
        for(Double num:resultmemory){
            if(num>baseline){
                searchResult.add(num);
            }
        }
        System.out.println("검색결과 : "+searchResult);
    }
}
