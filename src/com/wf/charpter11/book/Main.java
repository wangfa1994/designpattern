package com.wf.charpter11.book;

/**
 * @Author: Mr.Wangf
 * @Date: 2020/2/5 17:50
 * @Description: Composite模式
 *
 * 组合模式----->容器与内容一致性
 *
 * 在文件夹中，可以存放文件和文件夹，虽然文件和文件夹属于不同类型的对象，但是都可以被放入文件夹中，
 * 文件和文件夹有时也被称为"目录条目",在目录条目中，文件和文件夹都可以当做一种对象看待(一致性)
 *
 * Composite模式用于创造出类似的结构的模式。
 * 能够使容器与内容一致性创造出递归结构的模式就是Composite模式。
 */
public class Main {

    /**
     * 列出文件和文件件的一览
     */


    public static void main(String[] args) {

        try {
            System.out.println("Making root entries...");
            Directory rootdir =  new Directory("root");
            Directory bindir =  new Directory("bin");
            Directory tmpdir =  new Directory("tmp");
            Directory usrdir =  new Directory("usr");

            rootdir.add(bindir);
            rootdir.add(tmpdir);
            rootdir.add(usrdir);
            bindir.add(new File("vi",10000));
            bindir.add(new File("latex",20000));
            rootdir.printList();

            System.out.println("");
            System.out.println("Making user entries...");
            Directory yuki  = new Directory("yuki");
            Directory hanako  = new Directory("hanako");
            Directory tomura  = new Directory("tomura");
            usrdir.add(yuki);
            usrdir.add(hanako);
            usrdir.add(tomura);

            yuki.add(new File("diary.html",100));
            yuki.add(new File("Composite.java",200));
            hanako.add(new File("memo.tex",300));
            tomura.add(new File("game.doc",400));
            tomura.add(new File("junk.mail",500));

            rootdir.printList();






        }catch (FileTreatementException e){
            e.printStackTrace();
        }


    }
}
