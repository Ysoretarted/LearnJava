package main.com.zju.Ysoretarted.ResponsibilityDemo;

/**
 * @author zcz
 * @CreateTime 2020/5/15 21:40
 */
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}
