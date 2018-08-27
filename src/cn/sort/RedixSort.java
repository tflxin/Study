package cn.sort;


import java.util.ArrayList;
import java.util.LinkedList;

public class RedixSort {

    public static int[] redixSort(int[] A, int n) {
        int PosCount=0;
        for(int i=0;i<n;i++){
            if(A[i]>=0){
                PosCount++;
            }
        }
        int[] arrPos=new int[PosCount];
        int[] arrNeg=new int[n-PosCount];
        int pos=0;
        int neg=0;
        for(int i=0;i<n;i++){
            if(A[i]>=0){
                arrPos[pos++]=A[i];
            }else{
                arrNeg[neg++]=-A[i];
            }
        }
        radixSortPos(arrPos);
        radixSortPos(arrNeg);
        int index=0;
        for(int i=arrNeg.length-1;i>=0;i--){
            A[index++]=-arrNeg[i];
        }
        for(int i=0;i<arrPos.length;i++){
            A[index++]=arrPos[i];
        }
        return A;
    }
    private static void radixSortPos(int[] A){
        ArrayList<LinkedList> arr1=new ArrayList<>();//左边的<>必须有类型
        ArrayList<LinkedList> arr2=new ArrayList<>();
        for(int i=0;i<10;i++){
            arr1.add(new LinkedList());
            arr2.add(new LinkedList());
        }
        for(int i=0;i<A.length;i++){
            arr1.get(A[i]%10).offer(A[i]);
        }
        long base=10;
        while(base<=Integer.MAX_VALUE){
            for(int i=0;i<10;i++){
                LinkedList queue=arr1.get(i);
                while(!queue.isEmpty()){
                    int value=(int)queue.poll();
                    arr2.get((int)(value/base)%10).offer(value);
                }
            }
            ArrayList<LinkedList> temp=arr2;
            arr2=arr1;
            arr1=temp;
            base*=10;
        }
        int index=0;
        for(int i=0;i<10;i++){
            LinkedList queue=arr1.get(i);
            while(!queue.isEmpty()){
                A[index++]=(int)queue.poll();
            }
        }
    }
    public static int[] generateArray(int len, int range) {
        if (len < 1) {
            return null;
        }
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * range) - 500000000;
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(int[] arr) {
        if (arr == null || arr.length < 2) {
            return true;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int len = 10;
        int range = Integer.MAX_VALUE;
        int testTimes = 50000;
        for (int i = 0; i < testTimes; i++) {
            int[] arr = generateArray(len, range);
            redixSort(arr,len);
            if (!isSorted(arr)) {
                System.out.println("Wrong Case:");
                printArray(arr);
                break;
            }
        }
    }
}
