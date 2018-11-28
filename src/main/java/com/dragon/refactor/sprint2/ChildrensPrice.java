package com.dragon.refactor.sprint2;

/**
 * @author huangzhibo
 * @date 28/07/2017
 */
public class ChildrensPrice extends Price{

    @Override
    int getPriceCode() {
        return Movie.CHILDRENS;
    }

    @Override
    double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3){
            result += (daysRented - 3) * 1.5;
        }
        return result;
    }
}
