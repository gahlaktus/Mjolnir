package com.mjolnir.interview.stack;

/**
 *
 *  符号匹配
    中缀表达式转换为后缀表达式
    计算后缀表达式
    实现函数的嵌套调用
    HTML和XML文件中的标签匹配
    网页浏览器中已访问页面的历史记录
 * @author huangzhibo
 * @date 28/03/2018
 */
public interface Stack<T> {

    boolean isEmpty();

    void push(T data);

    T peek();

    T pop();

}
