package com.mjolnir.datastructure.list;

import java.util.HashMap;

/**
 * 1、如何判断是否存在环？
 * 2、如何知道环的长度？
 * 3、如何找出环的连接点在哪里？
 * 4、带环链表的长度是多少？
 * @author huangzhibo
 * @date 21/03/2018
 */
public class LinkLoop {

    /**
     * 追赶法
     * @param node
     * @return
     */
    public static boolean hasLoop(Node node){

        Node pointer1 = node;
        Node pointer2 = node.next;

        while (pointer2 != null){
            int val1 = pointer1.val;
            int val2 = pointer2.val;

            if (val1 == val2){
                return true;
            }

            pointer1 = pointer1.next;
            pointer2 = pointer2.next.next;

        }

        return true;

    }

    public static boolean hasLoop2(Node node){

        Node p1 = node;

        HashMap<Node, Node> ns = new HashMap<>();
        while (node != null){
            if (ns.get(p1) != null){
                return true;
            }
            else {
                ns.put(p1, p1);
                p1 = p1.next;
                if (p1 == null){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n1;

        System.out.println(hasLoop(n1));
    }

}
