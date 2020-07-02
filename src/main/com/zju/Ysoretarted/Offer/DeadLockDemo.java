package main.com.zju.Ysoretarted.Offer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zcz
 * @CreateTime 2020/3/18 10:18
 */

class MyDemo {
    final String lockA;
    final String lockB;

    public MyDemo(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }
    public void A() throws InterruptedException {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "持有锁" + lockA + "尝试获得锁：" + lockB);
            Thread.sleep(2000);
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "持有锁" + lockB);
            }
        }
    }
}
public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        MyDemo demo1 = new MyDemo(lockA,lockB);
        MyDemo demo2 = new MyDemo(lockB,lockA);
        new Thread(() -> {
            try {
                demo1.A();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "ThreadAAA").start();

        new Thread(() -> {
            try {
                demo2.A();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "ThreadBBB").start();
    }
}
