package com.dragon.classes.enumType;

/**
 * Created by huangzhibo on 30/03/2017.
 */
public class EnumOrdinal {
    public static void main(String[] args) {

        System.out.println("CellPhone List:");
        for (Mobile m : Mobile.values()) {
            System.out.println(m + " costs " + m.showPrice() + " dollars");
        }
        Mobile ret = Mobile.Samsung;
        System.out.println("The ordinal is = " + ret.ordinal());
        System.out.println("MobileName = " + ret.name());
    }
}

enum Mobile {

    Samsung(400), Nokia(250), Motorola(325);

    int price;
    Mobile(int p) {
        price = p;
    }
    int showPrice(){
        return price;
    }
}
