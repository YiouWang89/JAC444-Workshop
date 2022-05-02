import java.util.Scanner;

public class Customer {
    private String customerName;
    private String phone;

    Scanner input = new Scanner(System.in);


    public Customer (){}
    public Customer(String customerName, String phone) {
        this.customerName = customerName;
        this.phone = phone;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void askCustomerInfo(){
        System.out.println("Please input Customer Name: ");
        setCustomerName(input.nextLine());
        System.out.println("Please input phone number: ");
        setPhone(input.nextLine());
    }
}
