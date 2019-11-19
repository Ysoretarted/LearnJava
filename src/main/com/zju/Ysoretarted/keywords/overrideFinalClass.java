package main.com.zju.Ysoretarted.keywords;

/**
 * @author zcz
 * @CreateTime 2019/11/19 10:27
 *
 * finalTest  如果用final修饰的话  就不能被继承
 */
public class overrideFinalClass extends finalTest {
    public  overrideFinalClass(){
        this.job = job;
        System.out.println("这是子类的构造方法");
    }

    @Override
    public void method() {
        System.out.println("这是子类的方法");
    }
    /**
     * 可以看到  父类的final方法不能被继承
     */

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
       overrideFinalClass test = new overrideFinalClass();
        /**
         *   可以看到调用子类的构造方法  会调用父类的构造方法
         * */


        test.method();
    }
}
