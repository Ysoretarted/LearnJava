package main.com.zju.Ysoretarted.ResponsibilityDemo;

/**
 * @author zcz
 * @CreateTime 2020/5/15 21:40
 */
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}