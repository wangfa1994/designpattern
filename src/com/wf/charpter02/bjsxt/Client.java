package com.wf.charpter02.bjsxt;

/**
 * @Author: wangfa
 * @Date: 2019/5/1 16:50
 * @Description: 适配器模式
 * 将一个类的接口转换成客户希望的另外一个接口。使得原本由于接口不兼容不能在一起工作的类在一起工作
 *
 *
 *
 *
 *
 * 目标接口(target): 客户所需要的接口
 * 需要适配的类(adaptee): 我们本身的类
 * 适配器(adapter): (实现客户所需要的接口 以及组合我们本身的类)
 *
 *
 *
 * java.io.InputStreamReader(InputStream)
 * java.io.OutputStreamWrite(OutputStream)
 * https://www.iteye.com/blog/lbwahoo-1989579
 */
public class Client {


    public void testAdapter(Target t){
        t.handleReq();

    }



    // 客户调用我们的目标接口，在目标接口的实现类中做适配
    public static void main(String[] args) {


        Client client = new Client();


        Target t = new Adapter();

        client.testAdapter(t);

    }

}
