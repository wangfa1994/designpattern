package com.wf.charpter16.book;

import java.awt.*;

/**
 * @Author: wangfa
 * @Date: 2020/3/5 14:09
 * @Description: 实现了Colleague接口，与Mediator(LoginFrame)共同工作
 */
public class ColleagueButton extends Button implements Colleague {

    private Mediator mediator;

    public ColleagueButton(String caption){
        super(caption);
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;

    }
    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);
    }


}
