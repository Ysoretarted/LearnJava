package main.com.zju.Ysoretarted.keywords;

/**
 * @author zcz
 * @CreateTime 2019/11/19 8:33
 */
public class staticTest {
    public static int a = -1;
    private int b;
    private static int c = -1;

    private static void print() {
        // TODO   前提在static方法里面
        /**System.out.println(b);     //不能访问b  不能访问非static属性
         * getB();  //不能访问非static方法
         * */

        staticMethod();       //可以访问static方法
        System.out.println(c);    //s可以访问static属性
        System.out.println("This is static method");
    }

    static {
        System.out.println("这个类被使用了");
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public static void staticMethod() {
        System.out.println("This is another static method");
    }

    public static void main(String[] args) {
        staticTest test = new staticTest();
        test.a = 12;    //test.a  IDEA不会主动提示，  但打完整是没编译问题的

        test.setB(1024);
        staticTest test1 = new staticTest();
        System.out.println(test.a + "  " + test1.a);
        //打印 12   12
        //只打印了一次    这个类被使用了

        print();
        print();
    }
}
