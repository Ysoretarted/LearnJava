package main.com.zju.Ysoretarted.keywords;

/**
 * @author zcz
 * @CreateTime 2019/11/20 9:29
 * 简单的写一下  可变形参 的例子
 */
public class vargsTest {
     public static int sum(String name,int... num){
         System.out.println(name);
         int res = 0;
         for(int a :num){
             res +=a;
         }
         return res;
     }

    public static void main(String[] args) {
        System.out.println(vargsTest.sum("Ysoretarted",1, 2, 3, 4, 5));
        System.out.println(vargsTest.sum("Y"));
        //this.notify();  this 关键字不能出现在static方法中。
    }
}
