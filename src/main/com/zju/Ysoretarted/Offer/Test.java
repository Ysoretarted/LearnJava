package main.com.zju.Ysoretarted.Offer;

import java.util.concurrent.ThreadFactory;

/**
 * @author zcz
 * @CreateTime 2020/3/19 15:02
 */
public class Test implements Runnable {
    private Thread myThread;

    public Test(){
        this.myThread = new Thread(this);
    }

    @Override
    public void run() {
        System.out.println("AAA");
    }

    public static void main(String[] args) {
        Test test = new Test();
        Thread t= test.myThread;
        t.start();
    }
}
