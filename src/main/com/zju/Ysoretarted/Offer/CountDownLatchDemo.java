package main.com.zju.Ysoretarted.Offer;

import java.util.concurrent.CountDownLatch;

/**
 * @author zcz
 * @CreateTime 2020/3/16 21:47
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(6);
        for(int i = 0; i < 6; ++i){
            final int tmp = i;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "第" +tmp +"个人走了" );
                    countDownLatch.countDown();
                }
            });
            thread.setName("thread -" + i);
            thread.start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "班长把门锁了");
    }
}
