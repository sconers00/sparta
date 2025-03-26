package calculators.calculator2.calculator3;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

class processor {
    public void process() {
        String num1, num2, num3;
        String question;
        double[] arr=new double[3];
        Scanner sc1 = new Scanner(System.in);
        ArithmeticCalculator receiver = new ArithmeticCalculator();
        ArithmeticCalculator.box reception = receiver.new box();
        ArithmeticCalculator.calculate cal = receiver.new calculate();
        st:
        while (true) {
            //입력기
            Object[] midarr = reception.Input();
            num1= (String) midarr[0];
            num2= (String) midarr[1];
            num3= (String) midarr[2];
            arr[0]= Double.parseDouble(num1);
            arr[1]= Double.parseDouble(num2);
            arr[2]= Double.parseDouble(num3);
            //계산결과종합기
            switch((int) arr[2]){
                case 1-> cal.add(arr);
                case 2-> cal.sub(arr);
                case 3-> cal.mul(arr);
                case 4-> cal.div(arr);
                default -> {
                    continue;
                }
            }
            cal.Resultcall();
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
                            cal.getResultMemory();
                            continue;
                        case 2:
                            cal.deleteFirstResult();
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
