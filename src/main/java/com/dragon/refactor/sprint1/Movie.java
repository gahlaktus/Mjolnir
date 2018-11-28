package com.dragon.refactor.sprint1;

/**
 * 纯数据类
 * 类似javaBean
 * @author huangzhibo
 * @date 19/07/2017
 */
public class Movie {

    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    private int _priceCode;

    public Movie(String title, int priceCode){
        _title = title;
        _priceCode = priceCode;
    }

    double getCharge(int daysRented) {
        double result = 0;
        switch (get_priceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (daysRented > 2)
                    result += (daysRented - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                result += daysRented * 3;
                break;
            case Movie.CHILDRENS:
                result += 1.5;
                if (daysRented > 3)
                    result += (daysRented - 3) * 1.5;
                break;
        }
        return result;
    }

    int getFrequentRenterPoints(int daysRented) {
        if ((get_priceCode() == Movie.NEW_RELEASE) &&
                daysRented > 1) return 2;
        else
            return 1;
    }

    public String get_title() {
        return _title;
    }

    public int get_priceCode() {
        return _priceCode;
    }

    public void set_priceCode(int _priceCode) {
        this._priceCode = _priceCode;
    }
}
