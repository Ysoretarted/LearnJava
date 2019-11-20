package main.com.zju.Ysoretarted.TestOverride;

/**
 * @author zcz
 * @CreateTime 2019/11/20 10:30
 */
public class Son extends Father {
    private double height;

    public Son(String name, int age, double height) {
        super(name, age);             //吧这句话注释掉  会提示标错  因为会默认调用父类的无参构造函数（然而父类并没有)
        System.out.println("这是Son类的  三个参数的构造函数");
        this.height = height;
    }

    public Son(String name, int age){

    }
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public static void main(String[] args) {
        Son son = new Son("Ysoretarted",22,1.7);
    }
}
