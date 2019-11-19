package main.com.zju.Ysoretarted.keywords;

/**
 * @author zcz
 * @CreateTime 2019/11/19 10:25
 */
public class finalTest {
    private final String name = "Ysoretarted";
    private final int num = 123;
    final private Integer num1 = 123;
    public String job;


    public finalTest() {//  final  不能修饰构造方法
        System.out.println("这是finalTest 的构造方法");
    }

    public void method() {
        System.out.println("这是一个普通方法");
    }

    public final void print() {
        System.out.println("这是一个final 的打印方法");
    }


    public void changeNum() {
        // num1 = new Integer(12345);
        //num1 =  num1.valueOf(12345);
        //num = 124;   //不能改变num的值
        System.out.println("num1 改变后的值为" + num1);
    }
}
