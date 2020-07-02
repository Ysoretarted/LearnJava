package main.com.zju.Ysoretarted.Offer;

import java.util.concurrent.*;

/**
 * @author zcz
 * @CreateTime 2020/3/19 1:13
 */
public class ThreadPoolDemo {
    private static final int COUNT_BITS = Integer.SIZE - 3;     // 29
    private static final int CAPACITY = (1 << COUNT_BITS) - 1;   //2^29 - 1 约5亿

    // runState is stored in the high-order bits
    private static final int test = -1 >>> 31;
    private static final int RUNNING = -1 << COUNT_BITS;
    private static final int SHUTDOWN = 0 << COUNT_BITS;
    private static final int STOP = 1 << COUNT_BITS;
    private static final int TIDYING = 2 << COUNT_BITS;
    private static final int TERMINATED = 3 << COUNT_BITS;

    public static void main(String[] args) {
        /*ExecutorService threadPool = new ThreadPoolExecutor(3,5,2,
                TimeUnit.SECONDS,new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.DiscardOldestPolicy());


        for(int i = 0; i < 10; ++i){
            final int tmp = i;
            threadPool.execute(()->{
                System.out.println(Thread.currentThread().getName() +"\t" +tmp);

            });
        }*/
        int row = 0;
        int col = 0;
        int n = 10;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n - i + 1; ++j) {
                row = i - 1;
                int ans = (1 + i + j - 2) * (i + j - 2) / 2 + j;
                System.out.print(ans + " ");
            }
            System.out.println();
        }
        System.out.println();

    }
}
