package com.wf.charpter14.book;

/**
 * @Author: wangfa
 * @Date: 2020/2/19 17:44
 * @Description:  chain of Responsibility
 * 责任链模式----->推卸责任
 *
 * 当外部请求程序进行某个处理时，但程序暂时无法直接决定由哪个对象负责处理时，就需要推卸责任，
 * 这种情况下，我们可以考虑将多个对象组成一条责任链，然后按照他们的职责链上的顺序一个一个的找出来到底应该谁来负责处理。
 * 使用责任链可以弱化"请求方"和"处理方"之间的关联关系。让双方各自都称为可独立复用的组件。
 * 此外，程序还可以对应其他需求，如根据情况不同，负责处理的对象也会发生变化的这种需求。
 *
 * 当一个人被要求做什么事情时，如果他可以自己做就自己做，如果不可以就将"要求"转给另外一个人，下一个人如果可以自己处理，就自己做，
 * 如果也不能自己处理，就再转给另外一个人......这就是责任链模式
 *
 */
public class Main {


    /**
     * 生成Alice到Fred等六个解决问题的实例，虽然此处定义的变量都是Support类型的，但是实际上保存的变量却是NoSupport等各个类的实例
     *
     * Main调用setNext方法将Alice至Fred这6个实例串联在职责链上，之后，main类逐个生成问题，并将他们传递给alice,然后显示最终谁解决了该问题。
     * 注意，编号是从0开始，步进33，
     *
      */


    public static void main(String[] args) {

        Support alice = new NoSupport("Alice");
        Support bob = new LimitSupport("Bob", 100);
        Support charlie = new SpecialSupport("Charlie", 429);
        Support diana = new LimitSupport("Diana", 200);
        Support elmo = new OddSupport("Elmo");
        Support fred = new LimitSupport("Fred", 300);

        alice.setNext(bob).setNext(charlie).setNext(diana).setNext(elmo).setNext(fred);
        for (int i = 0; i < 500; i += 33) {
            alice.support(new Trouble(i));
        }
    }
}

