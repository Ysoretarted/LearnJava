package main.com.zju.Ysoretarted.observeDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zcz
 * @CreateTime 2020/5/15 21:47
 */

// 公众号一样
public class Subject {
    private List<Observer> observers = new ArrayList<>();

    private int state; // 好比公众号的内容

    public int getState(){
        return state;
    }

    // 更新公众号的内容，并推送所有的订阅者
    public void setState(int state){
        this.state = state;
        notifyAllObservers();
    }
    // 添加订阅者
    public void addObservers(Observer observer){
        observers.add(observer);
    }
    //通知所有的订阅者
    public void notifyAllObservers(){
        for(Observer observer : observers){
            observer.update();
        }
    }
}
