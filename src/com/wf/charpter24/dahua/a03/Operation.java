package com.wf.charpter24.dahua.a03;

public class Operation {
    public static double getResult(double numberA, 
        double numberB, String operate) {
        double result = 0d;
        switch (operate) {
            case "+":
                result = numberA + numberB;
                break;
            case "-":
                result = numberA - numberB;
                break;
            case "*":
                result = numberA * numberB;
                break;
            case "/":
                result = numberA / numberB;
                break;
            case "pow":
                result= Math.pow(numberA,numberB);
                break;
        }
        return result;
    }

    // 将业务进行抽象，抽象出来相关功能独立的类
}
