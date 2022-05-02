import java.util.Scanner;

public class Fries extends Item {
    BoxContainer packing = new BoxContainer();
    Scanner input = new Scanner(System.in);
    double basicPrice = 5.79;
    double addPrice;
    int option;

    public Fries(){}

    public Fries(String name, double price){
        super(name);
        super.setPackingType(packing.getPackingType());
        addPrice = price;
    }

    public Fries chooseFries(){
        Fries fries = new Fries();
        System.out.println("Please select a Fries: ");
        System.out.println("1. Curly Fries");
        System.out.println("2. Straight Fries");
        option = input.nextInt();
        if(option == 1){
            fries = new CurlyFries();
        }else if (option ==2){
            fries = new StraightFries();
        }
        return fries;
    }

    public void setItemPrice( ){
        itemPrice = basicPrice + addPrice;
    }
}
