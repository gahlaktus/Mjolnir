package com.dragon.refactor.sprint2;

/**
 * @author huangzhibo
 * @date 28/07/2017
 */
public class RegularPrice extends Price{

    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    double getCharge(int daysRented) {
        double result = 2;
        if (daysRented > 2){
            result += (daysRented -2) * 1.5;
        }
        return result;
    }
}
