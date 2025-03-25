package calculators.calculator2.calculator3;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArithmeticCalculator {
    enum Operation {
        addition {
            public double apply(double x, double y) {
                return x + y;
            }
        },
        subtraction {
            public double apply(double x, double y) {
                return x - y;
            }
        },
        multiply {
            public double apply(double x, double y) {
                return x * y;
            }
        },
        division {
            public double apply(double x, double y) {
                return x / y;
            }
        };

        public abstract double apply(double x, double y);
    }


    public class calculate {
        private static ArrayList<Double> resultmemory = new ArrayList<>();

        public double add(double[] nums) {
            Operation addition = Operation.addition;
            double num1 = nums[0];
            double num2 = nums[1];
            resultmemory.add(addition.apply(num1, num2));
            return addition.apply(num1, num2);
        }

        public double sub(double[] nums) {
            Operation subtraction = Operation.subtraction;
            double num1 = nums[0];
            double num2 = nums[1];
            resultmemory.add(subtraction.apply(num1, num2));
            return subtraction.apply(num1, num2);
        }

        public double mul(double[] nums) {
            Operation multiply = Operation.multiply;
            double num1 = nums[0];
            double num2 = nums[1];
            resultmemory.add(multiply.apply(num1, num2));
            return multiply.apply(num1, num2);
        }

        public double div(double[] nums) {
            Operation division = Operation.division;
            double num1 = nums[0];
            double num2 = nums[1];
            resultmemory.add(division.apply(num1, num2));
            return division.apply(num1, num2);
        }


        public void getResultMemory() {
            System.out.println(resultmemory);
        }

        public void Resultcall() {
            System.out.println("계산결과 : " + resultmemory.getLast());
        }

        public void deleteFirstResult() {
            resultmemory.removeFirst();
        }

        public static void searchMemory(double baseline) {
            ArrayList<Double> searchResult = (ArrayList<Double>) resultmemory.stream().filter(num -> (num - baseline) > 0).collect(Collectors.toList());
            System.out.println("검색결과 : " + searchResult);
        }

    }

    class box {
        Object[] nums = new Object[3];
        GenericInput<Double> doubleBox = new GenericInput();
        GenericInput<String> StringBox = new GenericInput();
        String operator;

        public Object[] Input() {
            Scanner sc3 = new Scanner(System.in);
            for (int i = 0; i < 2; i++) {
                System.out.println((i + 1) + "번째 숫자를 입력해주십시오 : ");
                nums[i] = doubleBox.Generics();
            }
            System.out.println("연산기호를 입력하십시오 : + - * /");
            operator = sc3.nextLine();
            switch (operator) {
                case "+" -> nums[2] = "1";
                case "-" -> nums[2] = "2";
                case "*" -> nums[2] = "3";
                case "/" -> nums[2] = "4";
                default -> {
                    nums[2] = 0;
                    System.out.println("연산기호가 아닙니다.\n프로그램을 재시작합니다.\n");
                }
            }
            return nums;
        }
    }
}
