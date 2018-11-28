package com.dragon.refactor.sprint2;

/**
 * @author huangzhibo
 * @date 28/07/2017
 */
public class NewReleasePrice extends Price{

    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    double getCharge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    int getFrequentRenterPoints(int daysRented) {
        return (daysRented > 1) ? 2 : 1;
    }
}
