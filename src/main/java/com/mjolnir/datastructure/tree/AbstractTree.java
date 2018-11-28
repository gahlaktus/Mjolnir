package com.mjolnir.datastructure.tree;

/**
 * @author huangzhibo
 * @date 23/01/2018
 */
public abstract class AbstractTree<E> implements Tree<E>{

    @Override
    public boolean isInternal(Position<E> p) throws IllegalArgumentException {
        return numChildren(p) > 0;
    }

    @Override
    public boolean isExternal(Position<E> p) throws IllegalArgumentException {
        return numChildren(p) == 0;
    }

    @Override
    public boolean isRoot(Position<E> p) throws IllegalArgumentException {
        return p == root();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * @param p current Position
     * @return the number of levels separating Position p from the root.
     */
    public int depth(Position<E> p){
        if (isRoot(p)){
            return 0;
        }
        return 1 + depth(parent(p));
    }

    /**
     * @return the height of the tree.
     */
    private int heightBad(){
        int h = 0;
        for (Position<E> p : positions()){
            // Only consider leaf positions.
            if (isExternal(p)){
                h = Math.max(h, depth(p));
            }
        }
        return h;
    }

    public int height(Position<E> p){
        int h = 0;
        for (Position<E> c : children(p)){
            h = Math.max(h, 1 + height(c));
        }
        return h;
    }
}
