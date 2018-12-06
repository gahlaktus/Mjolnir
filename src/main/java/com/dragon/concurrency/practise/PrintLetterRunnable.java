package com.dragon.concurrency.practise;

/**
 * @author huangzhibo
 * @date 2018/11/28
 */
public class PrintLetterRunnable implements Runnable {

    private SyncObj syncObj;

    private char letter;

    public PrintLetterRunnable(SyncObj syncObj, char letter){
        this.syncObj = syncObj;
        this.letter = letter;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            synchronized (syncObj) {
                while (letter != syncObj.getLetter()){
                    try {
                        syncObj.wait();
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                System.out.print(letter);

                syncObj.nextLetter();

                syncObj.notifyAll();
            }
        }

    }
}
