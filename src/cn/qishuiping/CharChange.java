package cn.qishuiping;

import java.util.Scanner;

/**
 * 输入任意个字符串，将其中的小写字母变为大写，大写字母变为小写，其他字符不用处理；
 * 输入描述:
 * 任意字符串：abcd12#%XYZ
 * 输出描述:
 * 输出字符串：ABCD12#%xyz
 */
public class CharChange {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入人一个字符串");
        String s1 = sc.nextLine();
        System.out.println(changeStr(s1));
    }

    private static String changeStr(String str) {
        str.toUpperCase();
        char[] ch = str.toCharArray();
        int a= 'A'-'a';//获取两者的差值
        for (int i= 0;i<ch.length;i++){
            if (ch[i]>='a'&&ch[i]<='z'){
                ch[i] = (char)(ch[i]+a);
            }else if('A'<=ch[i]&&ch[i]<='Z'){
                ch[i] = (char)(ch[i]-a);
            }
        }
        String s = new String(ch);
        return s;
    }
}
