package com.ironman.iterate;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @author huangzhibo
 * @date 2018/11/5
 */
public class IterableDemo {

    public static void main(String[] args) {

    }

    class MyString implements Iterable<Character> {

        private int length = 0;
        private String ineers = null;

        public MyString (String str){
            this.ineers = str;
            this.length = str.length();
        }

        @Override
        public Iterator<Character> iterator() {

            class Iter implements Iterator<Character> { //方法内部类

                private int cur = 0;

                @Override
                public boolean hasNext() {
                    return cur != length;
                }

                @Override
                public Character next() {
                    Character c = ineers.charAt(cur);
                    cur ++;
                    return c;
                }

                @Override
                public void remove() {
                    // do nothing
                }
            }

            return new Iter();
        }
    }

}
