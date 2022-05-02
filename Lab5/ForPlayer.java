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
package LAB5;
import java.util.Scanner;

public class ForPlayer {
    Scanner input = new Scanner(System.in);
    HandleFile file = new HandleFile();

    public void welMessage(){
        System.out.println("Please Enter Your Name: ");
        String name = input.nextLine();
        System.out.println("Hi " + name.toUpperCase() + ",  Welcome to the HangMan Game");
        System.out.print("Press Enter to Begin: ");
        input.nextLine();
    }


    public char getUserLetter(String word){
        System.out.print("Please Enter a letter in word " + word + "------->");
        char userInput = input.next().charAt(0);
        input.nextLine();
        return userInput;
    }

    public void askNewWord(){
        System.out.println("Please Enter a New Word , we will add it to the source file: ");
        String word = input.nextLine();
        file.writeFile(word);
    }

    public boolean askContinue(){
        System.out.println("Do you want to continue this game? (Y/N)");
        String temp = input.next();
        while(temp.isEmpty() && !temp.equals("Y") && !temp.equals("y") && !temp.equals("N") && !temp.equals("n") ){
            System.out.println("Invalid input, Please select Yes or No (Y/N)");
            temp = input.next();
            input.nextLine();
        }
        if(temp.equals("Y") || temp.equals("y")){
            return true;
        }else{
            return false;
        }
    }

    public void askChangeFile(){
        System.out.println("The default file is Hangman-Text, would you like to change a file? (Y/N)");
        String temp = input.next();
        while(temp.isEmpty() && !temp.equals("Y") && !temp.equals("y") && !temp.equals("N") && !temp.equals("n") ){
            System.out.println("Invalid input, Please select Yes or No (Y/N)");
            temp = input.next();
            input.nextLine();
        }
        if(temp.equals("Y") || temp.equals("y")){
            input.nextLine();
            System.out.println("Please Enter the File's Name: ");
            String fileName = input.nextLine();
            file.isFileExit(fileName);
        }
    }
}
