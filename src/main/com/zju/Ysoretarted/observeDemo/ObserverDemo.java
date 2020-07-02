package main.com.zju.Ysoretarted.observeDemo;

/**
 * @author zcz
 * @CreateTime 2020/5/15 21:55
 */
public class ObserverDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();
        AObserver aObserver = new AObserver();
        BObserver bObserver = new BObserver();
        subject.addObservers(aObserver);
        subject.addObservers(bObserver);

        subject.setState(2);
    }
}
