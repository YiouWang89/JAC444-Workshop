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
import java.util.ArrayList;

public class Order {
    ArrayList<Burger> burgers = new ArrayList<>();
    ArrayList<ColdDrink> drinks = new ArrayList<>();
    ArrayList<Fries> fries = new ArrayList<>();

    public void displayOrderMenu() {
        System.out.println("            Order Menu");
        System.out.println("------------------------");
        System.out.println("1. Add Burger");
        System.out.println("2. Add Cold Drink");
        System.out.println("3. Add Fries");
        System.out.println("4. Finish");
        System.out.println("5. Cancel");
        System.out.println("------------------------");
    }

    public void displayOrderDetail() {
        double totalPrice = 0;
        if(burgers.size() != 0) {
            System.out.println("Burger----- " + burgers.size() + " " + burgers.get(0).getPackingType());
            for (Burger burger : burgers) {
                int[] noEach;
                noEach = burger.calEachIngredient();
                System.out.println("    " + burger.getItemName() + "---------" + burger.itemPrice);
                totalPrice += burger.itemPrice;
                for (int i = 0; i < noEach.length; i++) {
                    if (noEach[i] != 0) {
                        System.out.println("    " + burger.ingredients[i] + " * " + noEach[i]);
                    }
                }
                System.out.println("    " + burger.ingredient.get(0) + " * " + burger.numberOfPatty);
            }
            System.out.println();
        }
        if (drinks.size() !=0){
                System.out.println("Drink----- " + drinks.size() + " " + drinks.get(0).getPackingType());
                for (ColdDrink drink : drinks){
                    System.out.println("    " + drink.getItemName() + " ( "+ drink.temperature + " ) " + "---------" + drink.itemPrice);
                    totalPrice += drink.itemPrice;
                }
            System.out.println();
            }
        if(fries.size() !=0){
            System.out.println("Fries----- " + fries.size() + " " + fries.get(0).getPackingType());
            for (Fries fries : fries){
                System.out.println("    " + fries.getItemName()  + "---------" + fries.itemPrice);
                totalPrice += fries.itemPrice;
            }
            System.out.println();
        }
        System.out.print("Total-------------------------------------- ");
        System.out.printf("%.2f\n\n", totalPrice);
        }
    }

