package main.com.zju.Ysoretarted.Offer;


/**
 * @author zcz
 * @CreateTime 2020/3/15 21:44
 */
public class SinglePattern {
    private SinglePattern(){

    }
    /*private static SinglePattern INSTANCE = new SinglePatern();

    public static SinglePatern getInstance(){
        return instance;
    }*/

    private static SinglePattern instance;

    public static SinglePattern getInstance() throws Exception{
        if(instance == null){
            Thread.sleep(5000);
            if(instance == null)
                instance = new SinglePattern();
        }
        return instance;
    }
}
