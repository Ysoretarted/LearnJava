package main.com.zju.Ysoretarted.Offer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zcz
 * @CreateTime 2020/3/17 18:31
 */

class ShareData{
    private /*volatile */int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5() throws InterruptedException {
        lock.lock();
        /*while(number !=1){
            c1.await();
        }*/
        for(int i = 1; i <= 5; ++i){
            System.out.println(Thread.currentThread().getName() + "\t" + i);
        }
        number = 2;
        c2.signal();
        lock.unlock();
    }
    public void print10() throws InterruptedException {
        lock.lock();
        /*while(number !=2){
            c2.await();
        }*/
        for(int i = 1; i <= 10; ++i){
            System.out.println(Thread.currentThread().getName() + "\t" + i);
        }
        number = 3;
        c3.signal();
        lock.unlock();
    }
    public void print15() throws InterruptedException {
        lock.lock();
        /*while(number !=3){
            c3.await();
        }*/
        for(int i = 1; i <= 15; ++i){
            System.out.println(Thread.currentThread().getName() + "\t" + i);
        }
        number = 1;
        c1.signal();
        lock.unlock();
    }
}
public class ReentrantLockDemo {
    public static void main(String[] args) {
        ShareData  shareData =new ShareData();

        for(int i =1;i <=5; ++i){
            new Thread(()->{
                try {
                    shareData.print5();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"A").start();
        }

        for(int i =1;i <=5; ++i){
            new Thread(()->{
                try {
                    shareData.print10();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"B").start();
        }
        for(int i =1;i <=5; ++i){
            new Thread(()->{
                try {
                    shareData.print15();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"C").start();
        }

    }
}
