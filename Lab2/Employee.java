/**********************************************
 *  Workshop 2
 *  Course:<JAC444> - Semester
 *  Last Name:<Wang>
 *  First Name:<Yiou(Anna)>
 *  ID:<151558194>
 *  Section:<NBB>
 *  This assignment represents my own work in accordance with Seneca Academic Policy. Signature
 *  Date:<2022-02-10>
 * **********************************************/

public class Employee {
    private int employeeID;
    private String address, employeeType, maritalStatus,employeeDOB, joiningDate;
    private double basicSalary;
    private String employeeStatus;
    String employeeName;

    String[] empType = {"Daily Wages", "Permanent", "Commission"};
    String[] empMaritalStatus = {"Single", "Married", "Divorced"};
    String[] empStatus = {"Active", "On Leave", "Terminated"};

    public double calculateSalary(double basicSalary, long days){
        return basicSalary/365 * days;
    }

    public  double calculateSalary(double basicSalary, double allowance){
        return basicSalary + allowance;
    }

    public double calculateSalary(double basicSalary, int years){
        double commission;
        if(years < 5){
            commission = 0.1;
        }else if(years >=5 && years <= 10){
            commission = 0.25;
        }else{
            commission = 0.25 + (years - 10)/2 * 0.05;
        }
      return basicSalary +commission * years;
    }

    public int getEmployeeId(){
        return employeeID;
    }

    public void  setID(int id){
        this.employeeID = id;
    }

    public void setAddress(String ad){
        this.address = ad;
    }

    public String getAddress(){
        return address;
    }

    public void setSalary(double sal){
        this.basicSalary = sal;
    }

    public double getBasicSalary(){
        return basicSalary;
    }

    public String getEmployeeType(){
        return employeeType;
    }

    public void setEmployeeType(String empType){
        this.employeeType = empType;
    }

    public String getMaritalStatus(){
        return maritalStatus;
    }

    public void setMaritalStatus(String marStatus){
        this.maritalStatus = marStatus;
    }

    public String getEmpStatus(){
        return employeeStatus;
    }

    public void setEmpStatus(String empStatus){
        this.employeeStatus = empStatus;
    }

    public String getDOB(){
        return employeeDOB;
    }

    public void setDOB(String dob){
        this.employeeDOB = dob;
    }

    public String getJoinDate(){
        return joiningDate;
    }

    public void setJoiningDate(String joinDate){
        this.joiningDate = joinDate;
    }

    public Employee(){
    }

    public Employee(String name, String address, String DOB, String marStatus, String joDate, Double basSalary, String empType, String empStatus){
        this.employeeName = name;
        this.address = address;
        this.employeeDOB = DOB;
        this.maritalStatus = marStatus;
        this.joiningDate = joDate;
        this.basicSalary = basSalary;
        this.employeeType = empType;
        this.employeeStatus = empStatus;
    }

    public void printEmpType(){
        for (int i=0; i< 3; i++){
            System.out.println( (i+1) + ". " + empType[i]  );
        }
    }

    public void printMaritalStatus(){
        for (int i=0; i< 3; i++){
            System.out.println( (i+1) + ". " + empMaritalStatus[i]  );
        }
    }

    public void printEmpStatus(){
        for (int i=0; i< 3; i++){
            System.out.println( (i+1) + ". " + empStatus[i]  );
        }
    }
}
