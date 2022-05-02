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

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    public void save(GeometricObject GO) {
        try( ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("GO_object.ser", true))){
            oos.writeObject(GO);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<GeometricObject> load() throws Exception {
        FileInputStream fs = new FileInputStream("Go_object.ser");
        ObjectInputStream input = new ObjectInputStream(fs);
        ArrayList<GeometricObject> objectsList = new ArrayList<>();
        GeometricObject obj;
        boolean cont = true;
        while (cont) {
            try {
                 obj = (GeometricObject) input.readObject();
                 fs.skip(4);
                if (obj != null) {
                    objectsList.add(obj);
                } else {
                    cont = false;
                }
            } catch (Exception e) {
                cont = false;
            }
        }
        input.close();
        return objectsList;
    }


    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        GetData ask = new GetData();
        Triangle triangle = new Triangle();
        Circle  circle = new Circle();
        Test test = new Test();
        GeometricObject GO;
        int option;

       do{
           System.out.println("Please choose which Geometric Area you would like to calculate: ");
           System.out.println("1. Triangle");
           System.out.println("2. Circle");
           System.out.println("3. Load the previous Geometric Objects");
           System.out.println("4.Exit");
           option = input.nextInt();
           while (option !=1 && option!=2 && option!=3 && option!=4){
               System.out.println("Invalid select, Please select again (1-4)");
               option = input.nextInt();
           }

           switch (option){
               case 1:
               {
                   double[] sides = {};
                   String color = ask.askColor(triangle);
                   Boolean isFilled =  ask.askFilled(triangle);
                   sides = ask.askData(triangle);
                   do{
                       try {
                           triangle = new Triangle(color, isFilled, sides[0], sides[1], sides[2]);
                       } catch (Exception e) {
                           e.printStackTrace();
                           triangle.setSide1(sides[0]);
                           triangle.setSide2(sides[1]);
                           triangle.setSide3(sides[2]);
                           triangle.isIllegal = true;
                           System.out.println("Please input the change percentage");
                           int percentage = input.nextInt();
                           if (triangle.getArea() < triangle.defaultSize) {
                               triangle.incSize(percentage);
                           } else {
                              triangle.decSize(percentage);
                           }
                           sides[0] = triangle.getSide1();
                           sides[1] = triangle.getSide2();
                           sides[2] = triangle.getSide3();
                       }
                   }while (triangle.isIllegal);
                   ask.displayDetail(triangle);

                   //call a function to write the object to the file
                   if(ask.wantSave()){
                       GO = triangle;
                       test.save(GO);
                   }
               }
               break;
               case 2:
               {
                   {
                       double[] radius = {};
                       String color = ask.askColor(circle);
                       Boolean isFilled =  ask.askFilled(circle);
                       radius = ask.askData(circle);
                       do{
                           try {
                               circle = new Circle(color, isFilled, radius[0]);
                           } catch (Exception e) {
                               e.printStackTrace();
                               circle.setRadius(radius[0]);
                               circle.isIllegal = true;
                               System.out.println("Please input the change percentage");
                               int percentage = input.nextInt();
                               if (circle.getArea() < circle.defaultSize) {
                                   circle.incSize(percentage);
                               } else {
                                   circle.decSize(percentage);
                               }
                               radius[0] = circle.getRadius();
                           }
                       }while (circle.isIllegal);
                       ask.displayDetail(circle);
                       if(ask.wantSave()){
                           GO = circle;
                           test.save(GO);
                       }
                   }
               }
               break;
               case 3:
               {
                   ArrayList<GeometricObject> loaded = test.load();
                   for(GeometricObject go : loaded){
                       ask.displayDetail(go);
                   }
               }
               break;
               default:
                   break;
           }
       }while(option != 4);

    }
}
