package cn.qishuiping;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * //找出输入字符串中的重复字符，再根据ascii把重复的字符从小到大排序
 * 遍历一遍字符串数组，建立一个辅助的TreeMap,里面key=字符 value=字符个数,
 * 排序就是TreeMap会默认按键的ascii从小到大排列，
 * 省去排序的部分，最后就把value>1的输出就完事了，O(N)=n。
 */

public class Main {
    public static void Repatstr(String str){
        if(str==null||str.length()==0){
            System.out.println(" 请输入正确的");
        }
        char[] chars = str.toCharArray();
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for (int i=0;i<chars.length;i++){
            if(!map.containsKey(chars[i])){
                map.put(chars[i],1);
            } else{
               int  count = map.get(chars[i]);
               map.put(chars[i],count+1);
            }
            Iterator<Character> iterator = map.keySet().iterator();
            Character key;
            while (iterator.hasNext()){}
            key = iterator.next();
            if (map.get(key)>1){
                System.out.println(key);
            }
        }


    }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String st=input.nextLine();
        Repatstr(st) ;
        input.close();
    }
}

