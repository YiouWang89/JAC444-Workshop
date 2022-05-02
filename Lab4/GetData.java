/**********************************************
 *  Workshop 5
 *  Course:<JAC444> - Semester
 *  Last Name:<Wang>
 *  First Name:<Yiou(Anna)>
 *  ID:<151558194>
 *  Section:<NBB>
 *  This assignment represents my own work in accordance with Seneca Academic Policy. Signature
 *  Date:<2022-03-13>
 * **********************************************/
import java.util.Scanner;

public class GetData {
    Scanner input = new Scanner(System.in);
    public double[] askData(GeometricObject go){
        System.out.print("Please input ");
        for(String data: go.dataNeeded()){
            System.out.print(data + " ");
        }
        System.out.println();
        System.out.println("If there are multi input, split with space ");
        String str = input.nextLine();
        String [] temp = str.split("\\s+");
        double [] data = new double[temp.length];
        for (int i = 0; i< temp.length; i++){
            data[i] = Double.parseDouble(temp[i]);
        }
        return data;
    }

    public String askColor(GeometricObject go){
        System.out.println("The Color for  " + go.getGeometricType() + " is now " + go.getColor());
        System.out.println("Would you like to change it? (Y/N) ? ");
        String color = go.getColor();
        String temp = input.next();
        input.nextLine();
        while(temp.isEmpty() && !temp.equals("Y") && !temp.equals("y") && !temp.equals("N") && !temp.equals("n") ){
            System.out.println("Invalid input, Please select Yes or No (Y/N)");
            temp = input.next();
            input.nextLine();
        }
        if(temp.equals("Y") || temp.equals("y")){
            System.out.println("Please set the color for " + go.getGeometricType());
            color = input.nextLine();
        }
        return color;
    }

    public Boolean askFilled(GeometricObject go){
        System.out.println("Do you want " + go.getGeometricType() + " to be filled? (Y/N)" );
        String temp = input.next();
        input.nextLine();
        Boolean isFilled = false;
        while(temp.isEmpty() && !temp.equals("Y") && !temp.equals("y") && !temp.equals("N") && !temp.equals("n") ){
            System.out.println("Invalid input, Please select Yes or No (Y/N)");
            temp = input.next();
            input.nextLine();
        }
        if(temp.equals("Y") || temp.equals("y")){
            isFilled = true;
        }
        return isFilled;
    }

    public void displayDetail(GeometricObject go){
        System.out.println("Please the below detail: ");
        System.out.println("Type: " + go.getGeometricType());
        System.out.printf("Area: %.2f", go.getArea());
        System.out.println( );
        System.out.printf("Perimeter: %.2f", go.getPerimeter());
        System.out.println( );
        System.out.println("Color: " + go.getColor());
        System.out.println("Is Filled: " + go.getFilled());
        System.out.println();
    }

    public boolean wantSave(){
        boolean wantSave=false;
        System.out.println("Would you like to save it in the file?  (Y/N)");
        String temp = input.next();
        while(temp.isEmpty() && !temp.equals("Y") && !temp.equals("y") && !temp.equals("N") && !temp.equals("n") ){
            System.out.println("Invalid input, Please select Yes or No (Y/N)");
            temp = input.next();
            input.nextLine();
        }
        if(temp.equals("Y") || temp.equals("y")){
            wantSave = true;
        }
        return wantSave;
    }

}
