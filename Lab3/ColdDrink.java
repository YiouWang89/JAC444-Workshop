import java.util.Scanner;

public class ColdDrink extends Item{
    Bottle packing = new Bottle();
    Scanner input = new Scanner(System.in);
    int option;
    String temperature = "Room Temperature";

    public ColdDrink(){
    }

    public ColdDrink(String name){
        super(name);
        super.setPackingType(packing.getPackingType());
    }

    public void chooseTemp(){
        System.out.println("The Drink is Room Temperature, Do You Want Cold or Not: (Y/N)");
        String temp = input.next();
        if (temp.equals("Y") || temp.equals("y")){
            temperature = "Cold";
        }
        input.nextLine();
    }

    public ColdDrink chooseDrink(){
        ColdDrink drink = new ColdDrink();
        System.out.println("Please select a Drink: ");
        System.out.println("1. Coke");
        System.out.println("2. Pepsi");
        option = input.nextInt();
        if(option == 1){
            drink = new Coke();
        }else if (option ==2){
            drink = new Pepsi();
        }
        return drink;
    }

    @Override
    public void setItemPrice( ){
        double price = 2.99;
        if (temperature.equals("Cold")){
            itemPrice = price + 0.25;
        }else if(temperature.equals("Room Temperature")){
            itemPrice = price;
        }
    }


}
