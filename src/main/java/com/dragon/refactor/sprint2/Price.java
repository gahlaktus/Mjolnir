package com.dragon.refactor.sprint2;

/**
 * @author huangzhibo
 * @date 28/07/2017
 */
public abstract class Price {

    abstract int getPriceCode();

    abstract double getCharge(int daysRented);

    int getFrequentRenterPoints(int daysRented) {
            return 1;
    }

}
