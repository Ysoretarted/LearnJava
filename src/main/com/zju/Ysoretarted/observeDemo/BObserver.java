package main.com.zju.Ysoretarted.observeDemo;

/**
 * @author zcz
 * @CreateTime 2020/5/15 21:54
 */
public class BObserver extends  Observer {
    @Override
    void update() {
        System.out.println("B 已经知道公众号的内容发生变化");
    }
}
