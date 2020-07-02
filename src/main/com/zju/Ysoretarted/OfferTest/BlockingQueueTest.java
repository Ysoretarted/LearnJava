package main.com.zju.Ysoretarted.OfferTest;

import main.com.zju.Ysoretarted.Offer.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author zcz
 * @CreateTime 2020/6/4 14:09
 */
public class BlockingQueueTest {
    public static void main(String[] args) throws Exception {
        BlockingQueue<Integer> queue = new BlockingQueue<>(6);
        Runnable producer = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        queue.put(i);
                        //System.out.println("生产者生产啦" + i);
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        for (int i = 0; i < 1; ++i) {
            Thread thread = new Thread(producer);
            thread.setName("生产者" + i);
            thread.start();

        }
        Runnable consumer = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Integer ans = queue.take();
                        //System.out.println("消费者消费啦" + ans);
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        for (int i = 0; i < 1; ++i) {
            Thread thread = new Thread(consumer);
            thread.setName("消费者" + i);
            thread.start();
        }
    }
}
