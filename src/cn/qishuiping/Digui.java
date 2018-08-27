package cn.qishuiping;

import java.util.Scanner;
public class Digui {
    static int num2=0;//喝道的饮料数
    public static void main(String[] args){
        int[] num1 = new int[10];//空瓶子数
        int count = 0, temp;
        Scanner sc = new Scanner(System.in);
        while(count<10){
            temp = sc.nextInt();
            if(temp==0)	break;
            num1[count] = temp;
            count++;
        }

        for(int i=0;i<count;i++){
            num2 = 0;
            fun(num1[i]);
            System.out.println(num2);
        }
    }

    public static void fun(int n){
        if(n==1){
            return;
        }if(n==2){
            num2++;
            return;
        }else if(n>=3){
            num2 = num2+n/3;
            fun(n/3+n%3);
        }
    }
}


