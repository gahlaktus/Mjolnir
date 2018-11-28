package com.mjolnir.interview.lintcode;

import java.util.HashMap;

/**
 * @author huangzhibo
 * @date 27/02/2018
 */
public class SimpleLRUCache {

    private class CacheNode {
        CacheNode pre, next;
        int key, value;

        public CacheNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.pre = null;
            this.next = null;
        }
    }

    private int capacity;
    private HashMap<Integer, CacheNode> cache = new HashMap<>();
    private CacheNode head = new CacheNode(-1, -1);
    private CacheNode tail = new CacheNode(-1, -1);

    private void moveToTail(CacheNode target) {
        if (tail.pre != target) {
            target.pre = tail.pre;
            tail.pre = target;
            target.pre.next = target;
            target.next = tail;
        }

    }

    public SimpleLRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        CacheNode target = cache.get(key);
        // remove current CacheNode;
        target.pre.next = target.next;
        target.next.pre = target.pre;
        // move target CacheNode to tail;
        moveToTail(target);
        return target.value;
    }

    public void set(int key, int value) {
        if (get(key) != -1) {
            cache.get(key).value = value;
            return;
        }
        if (cache.size() == capacity) {
            cache.remove(head.next.key);
            CacheNode expireNode = head.next;
            head.next = head.next.next;
            head.next.pre = head;
            expireNode.pre = null;
            expireNode.next = null;
        }
        CacheNode newNode = new CacheNode(key, value);
        cache.put(key, newNode);
        moveToTail(newNode);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        cache.forEach((key, value) -> sb.append(key).append(":").append(value.value).append('\n'));
        return sb.toString();
    }

    public static void main(String[] args) {
        SimpleLRUCache testCache = new SimpleLRUCache(3);
        testCache.set(1, 22);
        System.out.println(testCache);
        testCache.set(2, 33);
        System.out.println(testCache);
        testCache.set(3, 44);
        System.out.println(testCache);
        testCache.set(4, 55);
        System.out.println(testCache);
        testCache.set(2, 66);
        System.out.println(testCache);
        testCache.set(5, 77);
        System.out.println(testCache);
    }

}
