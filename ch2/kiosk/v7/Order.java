package kiosk.v7;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Order {//할인율
    private static int[] orderNum = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private List<String> data = new ArrayList<>();
    private int sum;
    MenuItem menuitem = new MenuItem();

    private enum type {
        adult {
            public int apply(int x) {
                return x;
            }
        },
        student {
            public int apply(int x) {
                return ((x * 9) / 10);
            }
        },
        elder {
            public int apply(int x) {
                return ((x * 8) / 10);
            }
        },
        soldier {
            public int apply(int x) {
                return ((x * 85) / 100);
            }
        };

        public abstract int apply(int x);
    }

    public int priceAdult(int sum) {
        type adult = type.adult;
        sum = adult.apply(sum);
        return sum;
    }

    public int priceStudent(int sum) {
        type student = type.student;
        sum = student.apply(sum);
        return sum;
    }

    public int priceElder(int sum) {
        type elder = type.elder;
        sum = elder.apply(sum);
        return sum;
    }

    public int priceSoldier(int sum) {
        type soldier = type.soldier;
        sum = soldier.apply(sum);
        return sum;
    }

    public int digitCut(int sum) {
        char[] nums = ("" + sum).toCharArray();
        nums[nums.length - 1] = '0';
        StringBuilder snum = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            snum.append(nums[i]);
        }
        sum = (Integer.parseInt(snum.toString()));
        return sum;
    }

    //convertOrder : 주문을 받아 번호조합 형태로 임시저장 [수량]
    public void convertOrder(int menuNo) {
        orderNum[menuNo]++;
    }

    //orderDisplayer : 주문을 조합하여 출력 및 제거 [제품명, 가격, 수량]+총액 : stream
    public void orderDisplayer() {
        sum = 0;
        System.out.println("품명                가격  수량");
        for (int i = 0; i < 12; i++) {
            if (orderNum[i] > 0) {//
                data = menuitem.dataDoner(i);
                data.add(orderNum[i] + "개");
                sum += ((Integer.parseInt(data.get(1))) * orderNum[i]);
                String result = data.stream().collect(Collectors.joining("  "));
                System.out.println(result);
                data.clear();
            }
        }
        System.out.println("주문 총액 : " + sum + " 원");
    }

    public void sumDisplay(int type) {//enum 적용기
        switch (type) {
            case 1: {
                sum = priceAdult(sum);
            }
            break;
            case 2: {
                sum = priceStudent(sum);
            }
            break;
            case 3: {
                sum = priceElder(sum);
            }
            break;
            case 4: {
                sum = priceSoldier(sum);
            }
            break;
        }
        sum = digitCut(sum);
        System.out.print(sum);
    }

    public void resetOrder() {// 리 셋 버 튼
        Arrays.fill(orderNum, 0);
        sum = 0;
    }
}
