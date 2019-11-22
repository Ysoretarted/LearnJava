package main.com.zju.Ysoretarted.Class;

/**
 * @author zcz
 * @CreateTime 2019/11/22 9:02
 */
public class main {
    public static void main(String[] args) {
        Person person = new Student();    //默认加了（Student）强转
        person.eat();   //打印  学生在吃饭
        //person.study();   //这里就调用不了学生专有的方法

        // TODO   运行报错   ClassCastException
        //Student student = (Student) new Person();  //要加个强转

        Person person1 = new Person();
        Student student = (Student)person1;
    }
}
