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
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Restaurant restaurant = new Restaurant();
        Meal meal = new Meal();
        Order order = new Order();
        int option, orderChoose;

        restaurant.printWelcome();
        do{
            restaurant.printMainMenu();
            option = input.nextInt();
            input.nextLine();
            if(option == 1){
                order.displayOrderMenu();
                orderChoose = input.nextInt();
                input.nextLine();
                switch(orderChoose){
                    case 1:
                        meal.addBurger();
                        break;
                    case 2:
                        meal.addDrink();
                        break;
                    case 3:
                       meal.addFries();
                        break;
                }

            }else if(option ==2){
                meal.printDetail();

            }
        } while(option != 3);
}
}
