/**********************************************
 *  Workshop 1
 *  Course:<JAC444> - Semester
 *  Last Name:<Wang>
 *  First Name:<Yiou(Anna)>
 *  ID:<151558194>
 *  Section:<NBB>
 *  This assignment represents my own work in accordance with Seneca Academic Policy. Signature
 *  Date:<2022-01-25>
 * **********************************************/
import java.util.Scanner;
public class CreditLimitCalculator {
    private int accountNo = 0, balance, charged, credit, creditLimit;

    Scanner input = new Scanner(System.in);

    public void printMenu(){
        System.out.println("1. Calculate Balance\n");
        System.out.println("2. Display Details \n");
        System.out.println("3. Exit \n");
        System.out.println("Please enter your option:");
    }

    public void askDetail(CreditLimitCalculator cal){
        System.out.println("Customer accountNo:");
        cal.setAccountNo(input.nextInt());
        System.out.println("Beginning Balance:");
        cal.setBalance(input.nextInt());
        System.out.println("Item Charged:");
        cal.setCharged(input.nextInt());
        System.out.println("Credit for this month:");
        cal.setCredit(input.nextInt());
        System.out.println("Credit Limit:");
        cal.setCreditLimit(input.nextInt());
    }
    public void setAccountNo (int a){
        accountNo = a;
    }
    public int getAccountNo ( ){
        return accountNo;
    }

    public void setBalance (int b){
        balance = b;
    }
    public int getBalance ( ){
        return balance;
    }

    public void setCharged (int ch){
        charged = ch;
    }
    public int getCharged ( ){
        return charged;
    }

    public void setCredit (int c){
        credit = c;
    }
    public int getCredit(){
        return credit;
    }

    public void setCreditLimit (int cl){
        creditLimit= cl;
    }
    public int getCreditLimit ( ){
        return creditLimit;
    }

    public int calBalance(CreditLimitCalculator cal){
        return cal.getBalance() + cal.getCharged() - cal.getCredit();
    }

    public void isExceed(int balance, CreditLimitCalculator cal){
        if (balance <= cal.getCreditLimit()) {
            System.out.println("Customer accountNo: " + cal.getAccountNo() +
                    " new balance is " + balance + "\n");
        }else{
            System.out.println("Customer accountNo: " + cal.getAccountNo() +
                    " credit limit is exceeded.\n");
        }
    }

    public void displayDetail(CreditLimitCalculator cal){
        System.out.println("Customer accountNo: " + cal.getAccountNo() );
        System.out.println("Beginning Balance: " + cal.getBalance());
        System.out.println("Item Charged: " + cal.getCharged());
        System.out.println("Credit for this month:" + cal.getCredit());
        System.out.println("Credit Limit: " + cal.getCreditLimit() + "\n");
    }
}
