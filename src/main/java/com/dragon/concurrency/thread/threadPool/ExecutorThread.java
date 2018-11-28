package main.java.com.thread.threadPool;

/**
 * @author huangzhibo
 * @date 28/08/2017
 */
public class ExecutorThread implements Runnable{

    private final String name;
    private final int delay;

    public ExecutorThread(String name, int delay){
        this.name = name;
        this.delay = delay;
    }

    @Override
    public void run() {
        System.out.println("启动：" + name);
        try{
            Thread.sleep(delay);
        }catch (InterruptedException e){}
        System.out.println("完成：" + name);
    }
}
