import java.util.Scanner;

public class ChickenBurger extends Burger{

    Scanner input = new Scanner(System.in);
    int option = 0;

    public ChickenBurger(){
        super("Chicken Burger", 2.69);
    }

    @Override
    public void chooseIngredients(){
        ingredient.add("Chicken Patty");
        do{
            super.chooseIngredients();
            System.out.println("5. Add Chicken Patty");
            System.out.println("6. Finish");
            option = input.nextInt();
            super.addIngredient(option);
            noIngredient++;
            if (option ==5){
                ingredient.add("Chicken Patty");
                numberOfPatty++;
                noIngredient--;
            }
        }while(option != 6);
        noIngredient--;
        input.nextLine();
    }



}
