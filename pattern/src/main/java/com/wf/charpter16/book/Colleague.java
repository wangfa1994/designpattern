package com.wf.charpter16.book;

/**
 * @Author: wangfa
 * @Date: 2020/3/5 14:08
 * @Description: 定义组员的接口API
 *
 *向仲裁者进行报告的组员的接口，具体的组员会实现这个接口
 */
public interface Colleague {

    /**
     *告知组员，我是仲裁者，有事向我汇报，
     * 传递的仲裁者实例，在后续需要向仲裁者报告的时候(Mediator的colleagueChanged方法)，会用到该实例
     */
    void setMediator(Mediator mediator);

    /**
     * 告诉组员仲裁者的下达指令
     */
    void setColleagueEnabled(boolean enabled);


    /**
     * 对于Mediator和Colleague类中需要定义那些方法，是根据需求不同而不同的。
     * 在示例程序中，在Mediator中定义了colleagueChanged，在Colleague中定义了setColleagueEnabled。
     * 如果需要让Mediator和Colleague角色之间进行更详细的通信，还需要定义更多的方法。
     * 也就是说，即使两段程序都使用了Mediator模式，但他们实际定义的方法可能会不同
     */
}
