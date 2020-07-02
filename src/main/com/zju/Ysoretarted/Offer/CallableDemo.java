package main.com.zju.Ysoretarted.Offer;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author zcz
 * @CreateTime 2020/3/18 9:44
 */

class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("Callable  线程开启");
        return 1024;
    }
}
public class CallableDemo {
    public static void main(String[] args) {
        FutureTask futureTask = new FutureTask<>(new MyThread());
        new Thread(futureTask,"AA").start();
        new Thread(futureTask,"BB").start();;
       /* while(!futureTask.isDone())
        thread.start();*/
        //futureTask.run();
    }
}
