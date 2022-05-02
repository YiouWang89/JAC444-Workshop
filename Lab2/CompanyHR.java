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

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.HashSet;
import java.util.Random;

public class CompanyHR {
    Scanner input = new Scanner(System.in);
    static  int size = 0;
    Employee[] employees = {};
    Employee employee = new Employee();
    ArrayList<Integer> id = new ArrayList<>();

    public void printMenu(){
        System.out.println("-----------------------------------");
        System.out.println("1. Add New Employee");
        System.out.println("2. Update Employee Information/Status");
        System.out.println("3. Search an Employee");
        System.out.println("4. Compute Salary");
        System.out.println("5. List all Employees");
        System.out.println("6. Filter By Status");
        System.out.println("7. Exit");
        System.out.println("-----------------------------------");
        System.out.println("Please select an option:");
    }

    public void addEmployee(){
        System.out.println("Please input Employee Name: ");
        String name = input.nextLine();
        System.out.println("Please input the Address:");
        String address = input.nextLine();
        System.out.println("Please input DOB(yyyy-MM-dd), Joining Date(yyyy-MM-dd), Basic Salary （Split using Space）");
        String info =input.nextLine();
        String[] strArr=info.split(" ");
        String DOB = strArr[0];
        String joinDate = strArr[1];
        double bSalary = Double.parseDouble(strArr[2]);
        System.out.println("Please select Employee Type: ");
        employee.printEmpType();
        String emType=employee.empType[input.nextInt() - 1];

        System.out.println("Please select Employee Marital Status: ");
       employee.printMaritalStatus();
        String empMS=employee.empMaritalStatus[input.nextInt() - 1];

        System.out.println("Please select Employee Status: ");
        employee.printEmpStatus();
        String empSt=employee.empStatus[input.nextInt() - 1];
        input.nextLine();
        employee = new Employee(name, address, DOB, empMS, joinDate, bSalary, emType, empSt );
        employee.setID(setEmployeeID());
        employees = Arrays.copyOf(employees, size+1);
        employees[employees.length-1] = employee;
        size++;
    }

    public int  setEmployeeID(){
        Random number = new Random();
        HashSet<Integer> set = new HashSet<>(id);
        int newId = number.nextInt(100) + 1;
        id.add(newId);
        Boolean isRepeat = set.size() == id.size() ? true : false;
        while(isRepeat){
            newId = number.nextInt(100) + 1;
            id.set(id.size()-1, newId);
            isRepeat = set.size() == id.size() ;
        }
        return newId;
    }
    public void displayEmployee(Employee empObject){
            System.out.println("******************************************************************");
            System.out.println("Employee ID: " + empObject.getEmployeeId());
            System.out.println("Name: " +empObject.employeeName);
            System.out.println("Address: " + empObject.getAddress());
            System.out.println("Date of Birth: " + empObject.getDOB());
            System.out.println("Martial Status: " + empObject.getMaritalStatus());
            System.out.println("Joining Date: " + empObject.getJoinDate());
            System.out.println("Employee Type: " + empObject.getEmployeeType());
            System.out.println("Employee Status: " + empObject.getEmpStatus());
            System.out.println("******************************************************************\n\n");

    }

    public void updateEmployee(){
        Employee eChanged = searchEmployee();
        int option;
        int type;
        String temp;
        do{
            System.out.println("Please select  the option needs to be changed:");
            System.out.println("1.Name                2.Address                3.DOB                        4.Marital Status");
            System.out.println("5.Joining Date      6.Basic Salary           7.Employee Type       8.Employment Status");
            System.out.println("9. Exit");
            option = input.nextInt();
            input.nextLine();
            switch (option){
                case 1:
                    System.out.println("The current Name is " + eChanged.employeeName);
                    System.out.println("New Name: ");
                    eChanged.employeeName = input.nextLine();
                    break;
                case 2:
                    System.out.println("The current Address is " + eChanged.getAddress());
                    System.out.println("New Address: ");
                    eChanged.setAddress(input.nextLine());
                    break;
                case 3:
                    System.out.println("The current DOB is " + eChanged.getDOB());
                    System.out.println("New DOB(yyyy-MM-dd): ");
                    eChanged.setDOB(input.nextLine());
                    break;
                case 4:
                    System.out.println("The current Marital Status is " + eChanged.getMaritalStatus());
                    eChanged.printMaritalStatus();
                    type = input.nextInt();
                    input.nextLine();
                    temp = eChanged.empMaritalStatus[type - 1];
                    eChanged.setMaritalStatus(temp);
                    break;
                case 5:
                    System.out.println("The current Joining Date is " + eChanged.getJoinDate());
                    System.out.println("New Joining Date(yyyy-MM-dd): ");
                    eChanged.setJoiningDate(input.nextLine());
                    break;
                case 6:
                    System.out.println("The current Basic Salary is " + eChanged.getBasicSalary());
                    System.out.println("New Basic Salary: ");
                    eChanged.setSalary(input.nextDouble());
                    input.nextLine();
                    break;
                case 7:
                    System.out.println("The current Employee Type is " + eChanged.getEmployeeType());
                    eChanged.printEmpType();
                    type = input.nextInt();
                    input.nextLine();
                    temp = eChanged.empType[type - 1];
                    eChanged.setEmployeeType(temp);
                    break;
                case 8:
                    System.out.println("The current Employee Status is " + eChanged.getEmpStatus());
                    eChanged.printEmpStatus();
                    type = input.nextInt();
                    input.nextLine();
                    temp = eChanged.empStatus[type - 1];
                    eChanged.setEmpStatus(temp);
                    break;
                default:
                    break;
            }
        }while (option != 9);

    }


    public long daysBetween(Employee e){
        String[] date = e.getJoinDate().split("-");
        int year = Integer.valueOf(date[0]);
        int month =  Integer.valueOf(date[1]);
        int day =  Integer.valueOf(date[2]);

        LocalDate today = LocalDate.now();
        LocalDate joinDay=LocalDate.of(year, month, day );
        long noOfDays = ChronoUnit.DAYS.between(joinDay, today);
        return noOfDays;
    }

    public void computerSalary(){
        Employee e = searchEmployee();
        if(e.getEmpStatus().equals("Active")){
            double salary;
            long noOfDay = daysBetween(e);
            String type = e.getEmployeeType();
            System.out.println("The Employee Type for " + e.employeeName + " is " +type);
            if(type.equals("Daily Wages")){
                salary = e.calculateSalary(e.getBasicSalary(), noOfDay);
            }else if(type.equals("Permanent")){
                System.out.println("Please input the allowance for " + e.employeeName + ":");
                double allowance = input.nextDouble();
                input.nextLine();
                salary = e.calculateSalary(e.getBasicSalary(), allowance);
            }else{
                int yearForService = (int) noOfDay/365;
                salary = e.calculateSalary(e.getBasicSalary(), yearForService);
            }
            System.out.println(e.employeeName + "'s Salary is " + salary);
        }else{
            System.out.println("The system can only calculate salary for active employee, "
                    + e.employeeName + "'s status is " + e.getEmpStatus());
        }

    }

    public void listAllEmployees(){
        for (Employee e : employees){
            displayEmployee(e);
        }
    }

    public Employee searchEmployee(){
        int index = -1;
        Employee e = new Employee();
        do{
            System.out.println("Please input Employee's Name:");
            String name = input.nextLine();
//            input.nextLine();
            for (int i=0; i<employees.length; i++){
                if(name.equals(employees[i].employeeName)) {
                    index = i;
                    e = employees[index];
                    i = employees.length;
                }
            }
            if(index == -1){
                System.out.println("There is no data for " + name);
            }
        }while(index == -1);
        return e;
    }

    public Employee[] filterByStatus(){
        int newSize = 0;
        Employee[] e = {};
        String searchType;
        System.out.println("Search By:");
        System.out.println("1.Marital Status        2. Employee Status");
        int option = input.nextInt();
        switch (option){
            case 1:
                employee.printMaritalStatus();
                searchType = employee.empMaritalStatus[input.nextInt() - 1];
                for(int i=0; i<employees.length; i++){
                    if(employees[i].getMaritalStatus().equals(searchType)){
                        employee = employees[i];
                        e=Arrays.copyOf(e, newSize + 1);
                        e[e.length - 1] = employee;
                        newSize++;
                    }
                }
                break;
            case 2:
                employee.printEmpStatus();
                searchType = employee.empStatus[input.nextInt() - 1];
                for(int i=0; i<employees.length; i++){
                    if(employees[i].getEmpStatus().equals(searchType)){
                        employee = employees[i];
                        e=Arrays.copyOf(e, newSize + 1);
                        e[e.length - 1] = employee;
                    }
                }
                break;
            default:
                break;
        }
        return e;
    }


    public void handleOption(int option){
        switch (option){
            case 1:
                addEmployee();
                break;
            case 2:
                updateEmployee();
                break;
            case 3:
                Employee e = searchEmployee();
                displayEmployee(e);
                break;
            case 4:
                computerSalary();
                break;
            case 5:
                listAllEmployees();
                break;
            case 6:
                Employee[] afterFilter = filterByStatus();
                if (afterFilter.length == 0){
                    System.out.println("There is no data");
                }else{
                for (Employee emp: afterFilter){
                    displayEmployee(emp);
                }
                }
                break;
        }
    }
}
