package main.com.zju.Ysoretarted.Offer;

/**
 * @author zcz
 * @CreateTime 2020/6/2 13:17
 */
public class Single {
    private volatile static Single instance;

    public Single getInstance(){
        if(instance == null){
                synchronized (Single.class){
                    if(instance == null){
                        instance = new Single();
                }
            }
        }
        return instance;
    }
}
