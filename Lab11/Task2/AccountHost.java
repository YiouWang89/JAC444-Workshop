/**********************************************
 *  Workshop 11
 *  Course:<JAC444> - Semester
 *  Last Name:<Wang>
 *  First Name:<Yiou(Anna)>
 *  ID:<151558194>
 *  Section:<NBB>
 *  This assignment represents my own work in accordance with Seneca Academic Policy. Signature
 *  Date:<2022-04-20>
 * **********************************************/
package Task2;

public class AccountHost {
    private String username;
    private String password;
    private String accountNo;
    private float   accountBalance;

    public float getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(float accountBalance) {
        this.accountBalance = accountBalance;
    }

    public AccountHost(String username, String password, String accountNo, float accountBalance) {
        this.username = username;
        this.password = password;
        this.accountNo = accountNo;
        this.accountBalance = accountBalance;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAccountNo() {
        return accountNo;
    }
}
