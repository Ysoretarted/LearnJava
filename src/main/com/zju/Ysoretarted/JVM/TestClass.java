package main.com.zju.Ysoretarted.JVM;

import main.com.zju.Ysoretarted.Offer.Test;

import java.net.HttpURLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ExecutionException;

/**
 * @author zcz
 * @CreateTime 2020/6/6 11:47
 */
public class TestClass {
    public int minArray(int[] numbers) {
        int len = numbers.length;
        if(len == 0)
            return -1;
        int L = 0;
        int R = len - 1;
        int ans = len - 1;
        while(L <= R){
            int mid = (R - L) / 2 + L;
            if(numbers[mid] <= numbers[0]){
                ans = Math.min(ans, mid);
                R = mid - 1;
            }else{
                L = mid +1;
            }
        }
        return numbers[ans];
    }

    public static void main(String[] args) throws ParseException {

        /*Date date = new Date();
        System.out.println(date.getTime());
        System.out.println(date);
        Date date1 = new Date(date.getTime() + 3600L * 1000 * 24 * 180);
        System.out.println(date1);


        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm.SSS");
        String strNow = df.format(date);
        String expireTime = df.format(date1);

        System.out.println(strNow);
        System.out.println(expireTime);*/
        TestClass test = new TestClass();
        test.deleteHead();
        test.appendTail(5);
        test.appendTail(2);
        test.deleteHead();
        test.deleteHead();

    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
