package kiosk.v6;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Order {
    private static int[] orderNum={0,0,0,0,0,0,0,0,0,0,0,0};
    private List<String> data= new ArrayList<>();
    private int sum;
    MenuItem menuitem = new MenuItem();

    //convertOrder : 주문을 받아 번호조합 형태로 임시저장 [수량]
    public void convertOrder(int menuNo){
        orderNum[menuNo]++;
    }
    //orderDisplayer : 주문을 조합하여 출력 및 제거 [제품명, 가격, 수량]+총액 : stream
    public void orderDisplayer(){
        sum=0;
        System.out.println("품명              : 수량");
        for(int i=0;i<12;i++){
            if(orderNum[i]>0) {
                data= menuitem.dataDoner(i);
                data.add(String.valueOf(orderNum[i]));
                sum+=((Integer.parseInt(data.get(1)))*orderNum[i]);
                System.out.println(data);
                data.clear();
            }
        }
        System.out.println("주문 총액 : "+sum+" 원");
    }
    public void sumDisplay(){
        System.out.print(sum);
    }
    public void resetOrder(){
        Arrays.fill(orderNum,0);
        sum=0;
    }
}
