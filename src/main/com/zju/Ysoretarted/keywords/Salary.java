package main.com.zju.Ysoretarted.keywords;

/**
 * @author zcz
 * @CreateTime 2019/11/19 20:13
 */
public class Salary extends Employee
{
    private double salary; //Annual salary
    public Salary(String name, String address, int number, double
            salary)
    {
        super(name, address, number);  //这句话   还得是第一条  不然提示Call to super() must be first
        // statement in constructor body
        System.out.println("这是  Salary的构造方法");
        setSalary(salary);
    }
    public void mailCheck()
    {
        //int  a = super.test; //可以访问
        System.out.println("Within mailCheck of Salary class ");
        System.out.println("Mailing check to " + getName()
                + " with salary " + salary);
    }
    public double getSalary()
    {
        return salary;
    }
    public void setSalary(double newSalary)
    {
        if(newSalary >= 0.0)
        {
            salary = newSalary;
        }
    }
    public double computePay()
    {
        System.out.println("Computing salary pay for " + getName());
        return salary/52;
    }
}
