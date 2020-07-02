package main.com.zju.Ysoretarted.adapterDemo;

/**
 * @author zcz
 * @CreateTime 2020/5/15 20:56
 */
//真正的适配器， 需要连接usb ，连接网线
public class Adapter implements NetToUsb{
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee){
        this.adaptee = adaptee;
    }
    @Override
    public void handleRequest() {
        adaptee.request();
    }
}
