package main.com.zju.Ysoretarted.FIle;

import java.io.File;

/**
 * @author zcz
 * @CreateTime 2019/11/22 9:55
 */
public class $ {
    private String name;
    public static void main(String[] args) {
        String path = "C:\\Users\\86177\\Desktop\\软院上课资料\\面向对象开发--尹可挺";
        test(path);
    }
    private static void test(String path){
       // System.out.println(name);  //static方法  不能访问name，（除非name用static修饰
        File f = new File(path);
        File[] fs = f.listFiles();
        if(fs == null){
            return ;
        }
        for(File file : fs){
            if(file.isFile()){
                System.out.println(file.getPath());
            }
            else{
                test(file.getPath());
            }
        }
    }
}
