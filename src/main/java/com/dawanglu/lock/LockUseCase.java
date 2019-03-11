package com.dawanglu.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huangzhibo
 * @date 2019/3/6
 */
public class LockUseCase {

   public void showLockUseCase(){
       Lock lock = new ReentrantLock();
       lock.lock();
       try {
           // do somethings......
       } finally {
           lock.unlock();
       }
   }
}
