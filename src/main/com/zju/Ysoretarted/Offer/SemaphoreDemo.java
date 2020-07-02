package main.com.zju.Ysoretarted.Offer;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author zcz
 * @CreateTime 2020/3/16 23:00
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        /*ThreadPoolExecutor*/
        Semaphore semaphore = new Semaphore(3);//模拟三个停车位
        for (int i = 1; i <= 6; ++i){
            final int tmp = i;
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "第" + tmp + "辆车进来停车");
                    Thread.sleep(300);
                    System.out.println(Thread.currentThread().getName() + "第" + tmp + "停3s后走了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            },"" +i).start();
        }
    }
}
