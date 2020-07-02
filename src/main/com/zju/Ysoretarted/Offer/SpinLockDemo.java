package main.com.zju.Ysoretarted.Offer;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author zcz
 * @CreateTime 2020/3/16 19:42
 */
public class SpinLockDemo {
    private  AtomicReference<Thread> atomicReference = new AtomicReference<>();
    public  void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "  我进来了");
        while(!atomicReference.compareAndSet(null,thread)){

        }
    }
    public  void unMyLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "  我要释放锁了");
        atomicReference.compareAndSet(thread,null);
    }

    public static void main(String[] args) throws InterruptedException {
        final SpinLockDemo spinLockDemo = new SpinLockDemo();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                spinLockDemo.myLock();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                spinLockDemo.unMyLock();
            }
        });
        thread1.setName("t1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                spinLockDemo.myLock();
                spinLockDemo.unMyLock();
            }
        });
        thread2.setName("t2");
        thread1.start();
        Thread.sleep(1000);
        thread2.start();
    }
}
