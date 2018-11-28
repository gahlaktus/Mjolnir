package com.dragon.reflect;

import java.util.List;

public class OrderObj
{
    public Order order ;
    public List<OrderDetail> orderDetail ;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<OrderDetail> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(List<OrderDetail> orderDetail) {
        this.orderDetail = orderDetail;
    }
}