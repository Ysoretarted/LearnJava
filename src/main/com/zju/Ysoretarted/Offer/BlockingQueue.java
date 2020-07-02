package main.com.zju.Ysoretarted.Offer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zcz
 * @CreateTime 2020/6/4 13:51
 */
public class BlockingQueue<V> {
    private Object[] table;
    private int count;
    private ReentrantLock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();
    private int takeIndex;
    private int putIndex;
    public BlockingQueue(int capacity){
        count = 0;// 初始化队列 数量 0
        table = new Object[capacity];
        takeIndex = 0;
        putIndex = 0;
    }

    public void put(V v)  {
        lock.lock();
        while(count == table.length) {
            try {
                notFull.await();
                System.out.println(Thread.currentThread().getName() +"在等待生产");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        table[putIndex++] = v;
        if(putIndex == table.length){
            putIndex = 0;
        }
        count++;
        notEmpty.signal();
        System.out.println(Thread.currentThread().getName() + "生产了" + v);
        lock.unlock();
    }

    public V take(){
        lock.lock();
        while(count == 0) {
            try {
                notEmpty.await();
                System.out.println(Thread.currentThread().getName() + "在等待消费");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        V res = (V)table[takeIndex++];
        if(takeIndex == table.length)
            takeIndex = 0;
        System.out.println(Thread.currentThread().getName() + "消费了" + res);
        count--;
        notFull.signal();
        lock.unlock();
        return res;
    }
}
