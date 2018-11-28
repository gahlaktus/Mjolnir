package com.mjolnir.practise.equals;

import java.awt.*;

/**
 * @author huangzhibo
 * @date 2018/10/16
 */
public class ColorPoint extends Point{

    private final Color color;

    public ColorPoint (int x, int y, Color color){
        super(x, y);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    // 如果不重写equals方法，ColorPoint直接继承Point中的equals方法，因而在比较的时候颜色信息就会被忽略，这显然是合理的。


   /* @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ColorPoint)) {
            return false;
        }
        return super.equals(obj) && ((ColorPoint) obj).color == color;
    }*/
    // 这样重写后，在比较Point与ColorPoint的时候，可能会出现不同的结果。Point中的equals比较忽略颜色，后一种比较总是返回false。


    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point)){
            return false;
        }
        if (!(obj instanceof ColorPoint)){
            return obj.equals(this);
        }
        return super.equals(obj) && ((ColorPoint) obj).color == color;
    }
    // 如此重写后，提供了对称性，但是缺少传递性。


}
