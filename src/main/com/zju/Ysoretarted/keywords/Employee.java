package main.com.zju.Ysoretarted.keywords;

/**
 * @author zcz
 * @CreateTime 2019/11/19 20:13
 */
public abstract class Employee
{
    private String name;
    private String address;
    private int number;
    public int test;
    public Employee(String name, String address, int number)
    {

        System.out.println("Constructing an Employee");
        this.name = name;
        this.address = address;
        this.number = number;
        /*this.setAddress(address);
        this.setName(name);
        this.setNumber(number);*/
    }
    public double computePay()
    {
        System.out.println("Inside Employee computePay");
        return 0.0;
    }
    public void mailCheck()
    {
        System.out.println("Mailing a check to " + this.name
                + " " + this.address);
    }
    public String toString()
    {
        return name + " " + address + " " + number;
    }
    public String getName()
    {
        return name;
    }
    public String getAddress()
    {
        return address;
    }
    public void setAddress(String newAddress)
    {
        address = newAddress;
    }
    public int getNumber()
    {
        return number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
