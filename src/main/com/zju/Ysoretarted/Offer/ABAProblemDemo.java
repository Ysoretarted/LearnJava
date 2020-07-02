package main.com.zju.Ysoretarted.Offer;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zcz
 * @CreateTime 2020/3/19 18:07
 */
public class ABAProblemDemo {
    private static AtomicInteger share = new AtomicInteger(16);

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "线程进来了");
            System.out.print("现在share的值是"  + share.get());
            share.compareAndSet(16,19);
            System.out.print(" --->现在share的值是" + share.get());
            share.compareAndSet(19,16);
            System.out.println(" --->现在share的值是" + share.get());
        },"A").start();

        new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "线程进来了");
            System.out.print("现在share的值为 " + share.get());
            share.compareAndSet(16,25);
            System.out.println(" --->现在share的值为 " + share.get());
        },"B").start();
        Thread.sleep(5000);
        System.out.println(share.get());
        //ThreadLocal
    }
}
