package com.dragon.copyOnWrite;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author huangzhibo
 * @date 12/06/2017
 */
public class CopyOnWriteMap<K, V> implements Map<K, V>, Cloneable {

    /**
     * 已经实现的CopyOnWrite容器有：
     * CopyOnWriteArrayList  CopyOnWriteArraySet
     * 机制：
     * CopyOnWrite容器即写时复制的容器。
     * 通俗的理解是当我们往一个容器添加元素的时候，不直接往当前容器添加，而是先将当前容器进行Copy，
     * 复制出一个新的容器，然后新的容器里添加元素，添加完元素之后，再将原容器的引用指向新的容器。
     * 这样做的好处是我们可以对CopyOnWrite容器进行并发的读，而不需要加锁，因为当前容器不会添加任何元素。
     * 所以CopyOnWrite容器也是一种读写分离的思想，读和写不同的容器。
     */


    /**
     * 场景：
     * CopyOnWrite并发容器用于读多写少的并发场景。
     * 比如白名单，黑名单，商品类目的访问和更新场景，假如我们有一个搜索网站，用户在这个网站的搜索框中，
     * 输入关键字搜索内容，但是某些关键字不允许被搜索。这些不能被搜索的关键字会被放在一个黑名单当中，
     * 黑名单每天晚上更新一次。当用户搜索时，会检查当前关键字在不在黑名单当中，如果在，则提示不能搜索。
     */

    /**
     * 存在问题：
     * 内存占用问题和数据一致性
     * 因为CopyOnWrite的写时复制机制，所以在进行写操作的时候，内存里会同时驻扎两个对象的内存
     * CopyOnWrite容器只能保证数据的最终一致性，不能保证数据的实时一致性。
     */
    private volatile Map<K, V> internalMap;

    public CopyOnWriteMap(){
        internalMap = new HashMap<>();
    }

    public CopyOnWriteMap(int var1){
        internalMap = new HashMap<>(var1);
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        return internalMap.get(key);
    }

    @Override
    public V put(K key, V value) {

        synchronized (this){
            Map<K, V> newMap = new HashMap<>(internalMap);
            V val = newMap.put(key, value);
            internalMap = newMap;
            return val;
        }
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        synchronized (this) {
            Map<K, V> newMap = new HashMap<>(internalMap);
            newMap.putAll(m);
            internalMap = newMap;
        }
    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }



}
