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

public class VegBurger extends Burger{
    Scanner input = new Scanner(System.in);
    int option = 0;

    public VegBurger(){
        super("VegBurger", 1.99);
    }

    @Override
    public void chooseIngredients(){
        ingredient.add("Soya Patty");
        do{
            super.chooseIngredients();
            System.out.println("5. Add Soya Patty");
            System.out.println("6. Finish");
            option = input.nextInt();
            super.addIngredient(option);
            noIngredient++;
            if (option ==5){
                ingredient.add("Soya Patty");
                numberOfPatty++;
                noIngredient--;
            }
        }while(option != 6);
        noIngredient--;
        input.nextLine();

    }
}
