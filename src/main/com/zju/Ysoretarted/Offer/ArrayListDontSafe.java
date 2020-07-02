package main.com.zju.Ysoretarted.Offer;

import javax.print.DocFlavor;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author zcz
 * @CreateTime 2020/3/16 10:16
 */
public class ArrayListDontSafe {
    private static ArrayList<String> arrayList = new ArrayList<>();
    /*private static List<String> arrayList = new Vector<>();*/
//    private static List<String> arrayList = Collections.synchronizedList(new ArrayList<String>());
    /*private static List<String> arrayList = new CopyOnWriteArrayList<>();*/

    public static void main(final String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                arrayList.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(arrayList);
            }
        };
        for(int i= 0; i < 30; ++i){
            new Thread(runnable).start();
        }

        Thread.sleep(2000);
        System.out.println(arrayList);
    }
}
