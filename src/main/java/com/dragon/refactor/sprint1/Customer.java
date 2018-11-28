package com.dragon.refactor.sprint1;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 表示顾客，拥有数据和相应的访问函数
 * @author huangzhibo
 * @date 19/07/2017
 */
public class Customer {

    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String get_name() {
        return _name;
    }

    public String statement() {
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + get_name() + "\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            //show figures for this rental
            result += "\t" + each.get_movie().get_title()+ "\t" +
                    String.valueOf(each.getCharge()) + "\n";
        }
        // add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints())+
                " frequent renter points";
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;

        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()){
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()){
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
       return result;
    }


}
