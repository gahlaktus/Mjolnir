package com.mjolnir.interview.lintcode;

/**
 * @author huangzhibo
 * @date 01/03/2018
 */
public class Rectangle {

    public double width;
    public double height;

    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }

    public double getArea(){
        return width * height;
    }

}
