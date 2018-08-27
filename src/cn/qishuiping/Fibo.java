package cn.qishuiping;

import java.util.Scanner;

public class Fibo {
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
        for(int i=1;i<=10;i++){
            System.out.println(getFibo(num1[i]));
        }
    }

    public static int getFibo(int n){
        if(n==1) return 1;
        else if(n==2) return 1;
        else return (getFibo(n-1)+getFibo(n-2));
    }

}
