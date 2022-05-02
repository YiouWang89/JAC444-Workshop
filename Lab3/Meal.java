/**********************************************
 *  Workshop 3
 *  Course:<JAC444> - Semester
 *  Last Name:<Wang>
 *  First Name:<Yiou(Anna)>
 *  ID:<151558194>
 *  Section:<NBB>
 *  This assignment represents my own work in accordance with Seneca Academic Policy. Signature
 *  Date:<2022-02-19>
 * **********************************************/
import java.util.Date;

public class Meal{
    Customer customer = new Customer();
    Order order = new Order();
    Burger burger = new Burger();
    ColdDrink drink = new ColdDrink();
    Fries fries = new Fries();


    public void printDetail(){
        customer.askCustomerInfo();
        Date date = new Date();
        System.out.println("**********************************************************");
        System.out.println("Hi, " + customer.getCustomerName() + ". Please check your Order Detail");
        System.out.println("  Order Date: " + date);
        System.out.println("  Contact Number: " + customer.getPhone());
        System.out.println("**********************************************************");
        order.displayOrderDetail();
        }

    public void addBurger(){
        burger = burger.chooseBurger();
        burger.chooseIngredients();
        burger.setItemPrice();
        order.burgers.add(burger);
    }

    public void addDrink(){
        drink = drink.chooseDrink();
        drink.chooseTemp();
        drink.setItemPrice();
        order.drinks.add(drink);
    }

    public void addFries(){
        fries = fries.chooseFries();
        fries.setItemPrice();
        order.fries.add(fries);
    }

    }

