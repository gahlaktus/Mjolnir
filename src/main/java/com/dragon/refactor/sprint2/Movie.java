package com.dragon.refactor.sprint2;

/**
 * 纯数据类
 * 类似javaBean
 *
 * @author huangzhibo
 * @date 19/07/2017
 */
public class Movie {

    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    private Price _price;

    public Movie(String title, int priceCode) {
        _title = title;
        set_priceCode(priceCode);
    }

    double getCharge(int daysRented) {
        return _price.getCharge(daysRented);
    }

    int getFrequentRenterPoints(int daysRented) {
        return _price.getFrequentRenterPoints(daysRented);
    }

    public String get_title() {
        return _title;
    }

    public int get_priceCode() {
        return _price.getPriceCode();
    }

    public void set_priceCode(int arg) {
        switch (arg) {
            case REGULAR:
                _price = new RegularPrice();
                break;
            case CHILDRENS:
                _price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                _price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }
}
