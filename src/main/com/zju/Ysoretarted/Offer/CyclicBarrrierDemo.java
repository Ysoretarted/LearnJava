package main.com.zju.Ysoretarted.Offer;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author zcz
 * @CreateTime 2020/3/16 22:15
 */
public class CyclicBarrrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("召唤神龙");
        });

        for(int i = 0; i <= 7; i++){
            final int tmp = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "集齐第" + tmp +"个龙珠");
                try {
                    cyclicBarrier.await();
                    System.out.println("AAAA" + tmp);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(tmp);//  这里的输出在  召唤神龙之后
            },String.valueOf(i)).start();
        }
    }
}
