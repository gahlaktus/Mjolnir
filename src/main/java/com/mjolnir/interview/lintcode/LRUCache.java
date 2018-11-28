package com.mjolnir.interview.lintcode;

import java.util.HashMap;

/**
 * LRU(least recently used)缓存设计
 * @author huangzhibo
 * @date 27/02/2018
 */
public class LRUCache {

    private class CacheNode {
        int key, value;
        CacheNode pre, next;
        CacheNode(int key, int value){
            this.key = key;
            this.value = value;
            this.pre = null;
            this.next = null;
        }
    }

    private HashMap<Integer, CacheNode> map;
    private int capacity;
    private CacheNode head = new CacheNode(-1, -1);
    private CacheNode tail = new CacheNode(-1, -1);

    private void moveToTail(CacheNode target, boolean isNew){
        if (target != tail.next){
            if (!isNew){
                target.pre.next = target.next;
                target.next.pre = target.pre;
            }
            tail.next.next = target;
            target.pre = tail.next;
            tail.next = target;
        }
    }

    public LRUCache(int capacity) {

        this.map = new HashMap<>();
        this.capacity = capacity;

    }

    public int get(int key) {
        // write your code here

        if (map.containsKey(key)){
            CacheNode target = map.get(key);
            moveToTail(target, false);
            tail.next.next = null;
            return target.value;
        }
        return -1;
    }

    /**
     * @param key: An integer
     * @param value: An integer
     */
    public void set(int key, int value) {
        if (map.containsKey(key)){
            CacheNode target = map.get(key);
            target.value = value;
            map.put(key, target);
            moveToTail(target, false);
        }
        else if (map.size() < capacity){
            CacheNode newNode = new CacheNode(key, value);
            map.put(key, newNode);
            if (head.next == null){
                head.next = newNode;
                newNode.pre = head;
                tail.next = newNode;
            }
            else {
                moveToTail(newNode, true);
            }
        }
        else {
            CacheNode newNode = new CacheNode(key, value);
            map.remove(head.next.key);
            map.put(key, newNode);
            if (head.next == tail.next){
                head.next = newNode;
                tail.next = newNode;
            }
            else {
                head.next.next.pre = head;
                head.next = head.next.next;
                moveToTail(newNode, true);
            }
        }
    }

}
