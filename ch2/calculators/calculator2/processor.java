package calculators.calculator2;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

class processor {
    public void process() {
        double result;
        String question;
        int[] arr = new int[3];
        Scanner sc1 = new Scanner(System.in);
        Calculator receiver = new Calculator();
        st:
        while (true) {
            //입력기
            arr = receiver.getinput(arr);
            if (arr[2] == 0) {  //기호입력 잘못됫을때 재시작용
                continue;
            }
            System.out.println("arr : " + arr[0] + " " + arr[1] + " " + arr[2]);
            //계산결과종합기
            arr = receiver.calculate(arr);
            System.out.println("arr : " + arr[0] + " " + arr[1] + " " + arr[2]);
            if ((arr[2] == 4) && (arr[1] != 0)) {
                result = (double) (arr[0] * arr[2] + arr[1]) / arr[2];
            } else {
                result = arr[0];
            }
            receiver.addResultMemory(result);
            System.out.println("계산 종료를 원하시면 exit 을 입력해 주십시오.\n계산결과 기록을 보시려면 memory 를 입력해주십시오.\n다른 계산을 원하시면 아무값이나 입력해주십시오.");
            question = sc1.nextLine();
            if (question.equals("exit")) {
                break;
            } else if (question.equals("memory")) {
                while (true) {
                    System.out.println("작업을 선택하여 주십시오.\n 1 : 계산 기록 열람\n 2 : 가장 오래된 기록 제거\n 3 : 계산기로 돌아가기\n 4 : 메뉴로 돌아가기");
                    question = sc1.nextLine();
                    switch (parseInt(question)) {
                        case 1:
                            receiver.getResultMemory();
                            continue;
                        case 2:
                            receiver.deleteFirstResult();
                            continue;
                        case 3:
                            continue st;
                        case 4:
                            break st;
                    }
                }
            } else {
                System.out.println("재기동합니다\n");
            }
        }
    }


}
