package main.com.zju.Ysoretarted.Offer;

/**
 * @author zcz
 * @CreateTime 2020/3/17 16:00
 */

class ShareDate {
    private int number = 0;
    private String lock = "lock";

    public void increment() throws InterruptedException {
        synchronized (lock) {
            //System.out.println(Thread.currentThread().getName() + "\t" + "进来了");
            while(number >=5) {
                lock.wait();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            lock.notifyAll();
        }
    }

    public void decrement() throws InterruptedException {
        synchronized (lock){
            //System.out.println(Thread.currentThread().getName() + "\t" + "进来了");
            while(number == 0) {
                lock.wait();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            lock.notifyAll();
        }
    }
}

public class ProducerConsumerDemo1 {
    public static void main(String[] args) {
        ShareDate shareDate = new ShareDate();
        for (int i = 1; i <= 10; ++i) {
            new Thread(() -> {
                try {
                    shareDate.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "AAA" + i).start();
        }

        for (int i = 1; i <= 10; ++i) {
            new Thread(() -> {
                try {
                    shareDate.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "BBB" + i).start();
        }
    }
}
