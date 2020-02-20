package com.wf.charpter13.book;


import com.wf.charpter13.book.composite.Directory;
import com.wf.charpter13.book.composite.File;
import com.wf.charpter13.book.composite.FileTreatementException;

/**
 * @Author: wangfa
 * @Date: 2020/2/12 15:21
 * @Description: 访问者模式
 *
 * Visitor模式 ---->访问数据结构并处理数据
 *
 * 圣诞节，即将生产的玛利亚在丈夫约瑟夫的陪伴下来到伯利恒，这里有很多住宿，然后他们以此敲门......
 *
 * 在数据结构中保存着许多元素，我们会对这些元素进行处理，这时，处理的代码会将他们放在对应的表示数据结构的类中，
 * 但是，如果处理许多种呢，每增加一种处理，我们就不得不去修改表示数据结构的类。
 *
 * 在visitor模式中，数据结构与处理被分离开来，我们编写一个访问者的类来访问数据结构中的元素，并把对应的各个元素的处理交给访问者，
 * 当我们需要增加新的处理时，我们只需要编写新的访问者，，然后让数据结构可以接受访问者的访问即可。
 *
 *
 *
 */
public class Main {


    /**
     * 使用Composite模式中的文件和文件夹的例子作为访问者要访问的数据结构，
     * 访问者会访问由文件和文件夹构成的数据结构，然后显示出文件和文件夹的一览
     *
     * 在Composite模式中，我们调用printList方法来显示文件夹中的内容，改方法已经在Directory类(表示数据结构的类)中被实现了，
     * 在Visitor模式中是在访问者中显示文件夹中的内容，这是因为显示文件夹中的内容也是属于对数据结构中的各个元素进行的处理，
     *
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

            //rootdir.printList();
            rootdir.accept(new ListVisitor());
            //bindir.accept(new ListVisitor());

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

            //rootdir.printList();
            rootdir.accept(new ListVisitor());

        }catch (FileTreatementException e){
            e.printStackTrace();
        }


    }
}
