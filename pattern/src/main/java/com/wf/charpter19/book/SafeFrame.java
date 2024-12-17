package com.wf.charpter19.book;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author: wangfa
 * @Date: 2020/3/12 10:40
 * @Description: 实现类context接口，在他的内部持有按钮和画面显示等UI信息
 *
 *
 */
public class SafeFrame extends Frame implements ActionListener,Context {

    private TextField textClock  = new TextField(60);
    private TextArea textScreen = new TextArea(10,60);
    private Button buttonUse = new Button("使用金库");
    private Button buttonAlarm = new Button("按下警铃");
    private Button buttonPhone = new Button("正常通话");
    private Button buttonExit = new Button("结束");

    private  State state = DayState.getInstance();

    public SafeFrame(String title) {
        super(title);
        setBackground(Color.lightGray);
        setLayout(new BorderLayout());
        add(textClock,BorderLayout.NORTH);
        textClock.setEditable(false);
        //配置textScreen
        add(textScreen,BorderLayout.CENTER);
        textScreen.setEditable(false);
        //为界面添加按钮
        Panel panel = new Panel();
        panel.add(buttonUse);
        panel.add(buttonAlarm);
        panel.add(buttonPhone);
        panel.add(buttonExit);
        //配置界面
        add(panel,BorderLayout.SOUTH);
        pack();
        show();
        //设置监听器
        buttonUse.addActionListener(this);
        buttonAlarm.addActionListener(this);
        buttonPhone.addActionListener(this);
        buttonExit.addActionListener(this);
    }

    /**
     *  按下按钮，该方法会被调用
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        if(e.getSource()==buttonUse){
            state.doUser(this);
        }else if(e.getSource() ==buttonAlarm){
            state.doAlarm(this);
        }else if(e.getSource() == buttonPhone){
            state.doPhone(this);
        }else if(e.getSource() == buttonExit){
            System.exit(0);
        }else {
            System.out.println("?");
        }

    }

    /**
     * 设置时间
     */
    @Override
    public void setClock(int hour) {
        String clockString ="现在的时间是:";
        if (hour<10){
            clockString+="0"+hour+":00";
        }else{
            clockString+=hour+":00";
        }
        System.out.println(clockString);
        textClock.setText(clockString);
        state.doLock(this,hour);
    }

    /**
     * 改变状态
     *
     */
    @Override
    public void changeState(State state) {
        System.out.printf("从"+this.state+"转换到"+state+"状态");
        this.state = state;
    }

    /**
     * 联系报警中心
     *
     */
    @Override
    public void callSecurityCenter(String msg) {
        textScreen.append("联系报警中心:"+msg+"\n");
    }

    /**
     * 在报警中心留下记录
     *
     */
    @Override
    public void recording(String msg) {
        textScreen.append("联系报警中心留言记录:"+msg+"\n");

    }
}
