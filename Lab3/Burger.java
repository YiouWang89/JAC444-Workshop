import java.util.ArrayList;
import java.util.Scanner;

public class Burger extends Item {
    int numberOfPatty = 1;
    private  double ingredientPrice = 1.5;
    private  double pattyPrice;
    int noIngredient = 0;
    int option;

    ArrayList<String>  ingredient = new ArrayList<>();

    Scanner input = new Scanner(System.in);
    Wrapper packing = new Wrapper();

    public String[] ingredients = {"Mayo", "Salad", "Tomatoes", "Onions"};

    public Burger(){}

    public double getIngredientPrice() {
        return ingredientPrice;
    }

    public void setIngredientPrice(double ingredientPrice) {
        this.ingredientPrice = ingredientPrice;
    }

    public Burger(String name, double pattyPrice){
        super(name);
        super.setPackingType(packing.getPackingType());
        this.pattyPrice = pattyPrice;
    }

    public void chooseIngredients() {
        System.out.println("Please select the Ingredients: ");
        for (int i = 0; i < ingredients.length; i++) {
            System.out.println((i + 1) + ". Add " + ingredients[i]);
        }
    }

    public void addIngredient(int option){
        switch (option){
            case 1:
                ingredient.add(ingredients[0]);
                break;
            case 2:
                ingredient.add(ingredients[1]);
                break;
            case 3:
                ingredient.add(ingredients[2]);
                break;
            case 4:
                ingredient.add(ingredients[3]);
                break;
            default:
               break;
        }
    }

    public Burger chooseBurger(){
        Burger burger = new Burger();
        System.out.println("Please select a Burger: ");
        System.out.println("1. Chicken Burger");
        System.out.println("2. Veg Burger");
        option = input.nextInt();
        if(option == 1){
            burger = new ChickenBurger();
        }else if (option ==2){
            burger = new VegBurger();
        }
        return burger;
    }

    @Override
    public void setItemPrice( ){
        double basicBurgerPrice = 10;
        itemPrice = basicBurgerPrice + ingredientPrice * noIngredient + pattyPrice * numberOfPatty;
    }

    public int[] calEachIngredient( ){
        int[] noEach = new int[ingredients.length];
        for(int i=0; i< ingredients.length; i++){
            int count = 0;
            for(int j=0; j< ingredient.size(); j++){
                if(ingredient.get(j) == ingredients[i]){
                    count++;
                }
            }
            noEach[i] = count;
        }
        return noEach;
    }


}
