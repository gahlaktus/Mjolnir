package com.dragon.refactor.sprint2;

/**
 * 表示某个顾客租了一部电影
 *
 * @author huangzhibo
 * @date 19/07/2017
 */
public class Rental {

    private Movie _movie;
    private int _dayRented;

    public Rental(Movie movie, int dayRented) {
        _movie = movie;
        _dayRented = dayRented;
    }

    double getCharge() {
       return _movie.getCharge(_dayRented);
    }

    int getFrequentRenterPoints() {
        return _movie.getFrequentRenterPoints(_dayRented);
    }

    public Movie get_movie() {
        return _movie;
    }

    public int get_dayRented() {
        return _dayRented;
    }
}
