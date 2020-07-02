package main.com.zju.Ysoretarted.adapterDemo;

/**
 * @author zcz
 * @CreateTime 2020/5/15 20:54
 */
// 客户端类：  想上网，网线接口不适合
public class Computer {

    //我们的电脑需要连接上转接器 才可以上网
    public void net(NetToUsb adapter){
        // 上网的具体实现， 找一个转接头
        adapter.handleRequest();
    }

    public static void main(String[] args) {
        Computer computer = new Computer();
        Adaptee adaptee = new Adaptee();
        Adapter adapter = new Adapter(adaptee);
        computer.net(adapter);
    }
}
