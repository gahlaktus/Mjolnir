package com.dragon.pattern;

/**
 * Created by huangzhibo on 06/04/2017.
 */
public class Client {

    public static void main(String[] args) {
        BankTemplateMethod btm = new DrawMoney();
        btm.process();
    }
}

class DrawMoney extends BankTemplateMethod {
    @Override
    public void transact() {
        System.out.println("take money!!!");
    }
}