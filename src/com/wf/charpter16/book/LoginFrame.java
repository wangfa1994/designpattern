package com.wf.charpter16.book;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author: wangfa
 * @Date: 2020/3/5 14:10
 * @Description: 表示登陆对话框的类 (仲裁者)
 */
public class LoginFrame extends Frame implements Mediator,ActionListener{

    private ColleagueCheckbox checkGuest;
    private ColleagueCheckbox checkLogin;

    private ColleagueTextField textUser;
    private ColleagueTextField textPass;


    private ColleagueButton buttonOk;
    private ColleagueButton buttonCancel;

    public LoginFrame(String title) throws HeadlessException {
        super(title);
        setBackground(Color.lightGray);
        setLayout(new GridLayout(4,2));

        // 生成各个colleague
        createColleagues();

        //配置
        add(checkGuest);
        add(checkLogin);
        add(new Label("UserName:"));
        add(textUser);
        add(new Label("Password:"));
        add(textPass);
        add(buttonOk);
        add(buttonCancel);

        // 设置初始的状态（启用和禁用）
        colleagueChanged();

        pack();
        show();
    }

    /**
     * 生成各个Colleague
     */
    @Override
    public void createColleagues() {
        // 生成
        CheckboxGroup g = new CheckboxGroup();
        checkGuest= new ColleagueCheckbox("Guest", g, true);
        checkLogin  = new ColleagueCheckbox("Login",g,false);
        textUser = new ColleagueTextField("",10);
        textPass = new ColleagueTextField("",10);
        textPass.setEchoChar('*');
        buttonOk = new ColleagueButton("OK");
        buttonCancel = new ColleagueButton("Cancel");
        // 设置Mediator
        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        textPass.setMediator(this);
        textUser.setMediator(this);
        buttonCancel.setMediator(this);
        buttonOk.setMediator(this);

        //设置Listener
        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);
        textUser.addTextListener(textUser);
        textPass.addTextListener(textPass);
        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);
    }

    /**
     * 接收来自Colleague的通知，然后判断各个Colleague的启用/禁用
     */
    @Override
    public void colleagueChanged() {

        if (checkGuest.getState()){
            //Guest模式
            textUser.setColleagueEnabled(false);
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(true);
        }else{
            //Login 模式
            textUser.setColleagueEnabled(true);
            userpassChanged();
        }
    }

    /**
     * 当textUser和textPass文本框文本发生改变时，判断各个Colleague的禁用启用状态
     */
    private void userpassChanged(){

            if (textUser.getText().length()>0)
            {
                textPass.setColleagueEnabled(true);
                if (textPass.getText().length()>0){
                    buttonOk.setColleagueEnabled(true);
                }else{
                    buttonOk.setColleagueEnabled(false);
                }
            }else {
                textPass.setColleagueEnabled(false);
                buttonOk.setColleagueEnabled(false);
            }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.printf(e.toString());
        System.exit(0);
    }
}
