package main.com.zju.Ysoretarted.observeDemo;

/**
 * @author zcz
 * @CreateTime 2020/5/15 21:53
 */
public class AObserver  extends  Observer{
    @Override
    void update() {
        System.out.println("A 已经知道内容发生变化");
    }
}
