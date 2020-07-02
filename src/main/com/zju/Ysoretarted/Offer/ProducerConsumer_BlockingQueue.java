package main.com.zju.Ysoretarted.Offer;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zcz
 * @CreateTime 2020/3/17 23:38
 */
class MyResource {
    private volatile boolean FLAG = true;
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void produce() throws InterruptedException {
        Integer result = null;
        boolean retValue;
        while (FLAG) {
            result = atomicInteger.incrementAndGet();
//            retValue = blockingQueue.offer("" + result,2,TimeUnit.SECONDS);
            retValue = blockingQueue.offer("" + result); //不管有没有都会插入失败
            if(retValue){
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + result + "成功");
            }else{
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + result + "失败");
            }
            Thread.sleep(1000);
        }
        System.out.println(Thread.currentThread().getName() + "大老板喊停了");
    }

    public void consume() throws InterruptedException {
        String ret = null;
        while (FLAG) {
            Thread.sleep(6000);
            ret = blockingQueue.poll(2, TimeUnit.SECONDS);
            if (null == ret) {
                System.out.println(Thread.currentThread().getName() + "\t  取出元素超时");
                FLAG = false;
                return ;
            }
            System.out.println(Thread.currentThread().getName() + "\t   取出元素" + ret);
        }

    }

    public void stop(){
        FLAG = false;
    }
}

public class ProducerConsumer_BlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        MyResource resource = new MyResource(new ArrayBlockingQueue<String>(3));

        new Thread(()->{
            System.out.println("生产者进程开始");
            try {
                resource.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();

        new Thread(()->{
            System.out.println("消费者进程开始");
            try {
                resource.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"B").start();


       /* Thread.sleep(5000);
        resource.stop();*/

    }
}
