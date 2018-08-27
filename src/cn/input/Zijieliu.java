package cn.input;

import java.io.*;

public class Zijieliu {

    public static void main(String[] args) throws IOException {
        /*
         * 1,需求：将键盘录入的数据写入到一个文件中。
         *
         * 2,需求：将一个文本文件内容显示在控制台上。
         *
         * 3,需求：将一个文件文件中的内容复制到的另一个文件中。
         */
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new
                FileOutputStream("b.txt")));
        String line = null;
        while((line=bufr.readLine())!=null){
            if("over".equals(line))
                break;
            bufw.write(line.toUpperCase());
            bufw.newLine();
            bufw.flush();
        }
    }
}

