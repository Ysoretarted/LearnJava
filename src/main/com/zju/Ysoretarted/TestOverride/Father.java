package main.com.zju.Ysoretarted.TestOverride;

/**
 * @author zcz
 * @CreateTime 2019/11/20 10:29
 */
public class Father {
    private String name;
    private int age;

    public Father(){
        System.out.println("这是Father类的  无参构造函数");
    }
    public Father(String name, int age) {
        System.out.println("这是Father类的  两个构造函数");
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
