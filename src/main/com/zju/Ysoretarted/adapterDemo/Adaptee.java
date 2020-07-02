package main.com.zju.Ysoretarted.adapterDemo;

/**
 * @author zcz
 * @CreateTime 2020/5/15 20:53
 */
// 要被适配的类，  网线
public class Adaptee {
    public void request(){
        System.out.println("连接网线上网");
    }
}
