package main.com.zju.Ysoretarted.Offer;


import sun.reflect.generics.tree.Tree;

import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

import static java.lang.Math.max;

/**
 * @author zcz
 * @CreateTime 2020/3/12 9:51
 */
public class Solution {
    public static int minIncrementForUnique(int[] A) {
        int len = A.length;
        int cnt = 0;
        int ans = 0;
        Arrays.sort(A);
        int mx = A[len - 1];
        boolean[] vis = new boolean[mx + 1];
        int tmp;
        int nind = -1;
        for(int i = 0; i < len; ++i){
            tmp = A[i];
            if(!vis[tmp]){
                if(tmp == mx)
                    cnt++;
                vis[tmp] = true;
                nind = max(nind, tmp +1);
            }else{
                tmp = max(tmp,nind);
                while(tmp < mx && vis[tmp]){
                    ans++;
                    tmp++;
                }
                nind = max(nind,tmp +1);
                if(tmp == mx)
                    cnt++;
                vis[tmp] = true;
            }
        }
        ans += (cnt - 1)* cnt /2;
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {3,2,1,2,1,7};
        /*int[] a = {1,2,2};*/
        System.out.println(minIncrementForUnique(a));
    }
}