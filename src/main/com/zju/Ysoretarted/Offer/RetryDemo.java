package main.com.zju.Ysoretarted.Offer;

/**
 * @author zcz
 * @CreateTime 2020/3/19 12:48
 */
public class RetryDemo {
    public static void main(String[] args) {
        retry:
        for(int i= 1; i <= 3; ++i){
            for(int j = 1; j <= 5; ++j){
                System.out.println(i + "  " + j);
                if(j ==3)
                    continue retry;
            }
        }
        System.out.println("分割线=================");

        abc:
        for(int i= 1; i <= 3; ++i){
            for(int j = 1; j <= i; ++j){
                System.out.println(i + "  " + j);
                if(j ==3)
                    break abc;
            }
        }
        System.out.println("分割线============");

        retry:

        for(int  i = 0;;) {
            System.out.println("start");
            for(;;) {
                i++;
                if (i == 3)
                    continue retry;
                System.out.println("end   " + i);
                if (i == 4)
                    break retry;
            }
        }

    }
}
