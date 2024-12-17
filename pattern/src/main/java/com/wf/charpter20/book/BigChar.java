package com.wf.charpter20.book;

import java.io.BufferedReader;
import java.io.FileReader;

public class BigChar {

    // 字符名称
    private String charname;

    // 大型字符对应的字符串(由#,-,\n 组成)
    private String fontData;


    public BigChar(String charname) {
        this.charname = charname;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("big" + charname + ".txt"));

            String line;
            StringBuilder buf = new StringBuilder();
            while ((line = reader.readLine())!=null){
                buf.append(line);
                buf.append("\n");
            }
            reader.close();
            this.fontData = buf.toString();
        }catch (Exception e){
            this.fontData = charname + "?";
        }

    }

    public void print(){
        System.out.println(fontData);
    }
}
