package main.com.zju.Ysoretarted.keywords.overridePackage;

import main.com.zju.Ysoretarted.keywords.abstractTest;

/**
 * @author zcz
 * @CreateTime 2019/11/19 20:23
 */
public class overridAbstractTest extends abstractTest {
    //只有重写了   被继承的抽象函数才不会报错
    @Override
    public void print() {
        System.out.println("这是  子类的print");
    }
}
