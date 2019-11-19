package main.com.zju.Ysoretarted.keywords;

/**
 * @author zcz
 * @CreateTime 2019/11/19 8:34
 */
public class mainActivity {
    public static void main(String[] args) {
        /*finalTest test = new finalTest();
        test.changeNum();
        System.out.println(test.toString());*/



        //abstractTest test = new abstractTest();  //报错，不能被实例化

//        Salary s = new Salary("Mohd Mohtashim", "Ambehta, UP", 3, 3600.00);
//        Employee e = new Salary("John Adams", "Boston, MA", 2, 2400.00);


        overridAbstractTest test = new overridAbstractTest();
        test.print();
    }
}
