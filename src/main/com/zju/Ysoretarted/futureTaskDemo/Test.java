package main.com.zju.Ysoretarted.futureTaskDemo;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author zcz
 * @CreateTime 2020/5/16 8:26
 */
public class Test {
    public static void main(String[] args) {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("callable 运行啦");
                Thread.sleep(5000);
                return 5;
            }
        };

        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        futureTask.run();
        try{
            System.out.println(futureTask.get());
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
