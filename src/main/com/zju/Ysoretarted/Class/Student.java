package main.com.zju.Ysoretarted.Class;

/**
 * @author zcz
 * @CreateTime 2019/11/22 8:59
 */
public class Student extends Person {
    private int ID;


    public  void study(){
        System.out.println("学生正在学习");
    }
    @Override
    public void eat() {
        System.out.println("学生在吃饭");
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
