package main.com.zju.Ysoretarted.ResponsibilityDemo;

/**
 * @author zcz
 * @CreateTime 2020/5/15 21:40
 */
public class FileLogger extends AbstractLogger {

    public FileLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}
