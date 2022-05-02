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

import java.io.*;
import java.util.stream.Collectors;

public class HandleFile {
    String fileName = "LAB5/Hangman-Text.txt";

    public String[] readFile(){
        String content = new String();
        String[] words = null;
        try{
            BufferedReader bufferReader = new BufferedReader(new FileReader(fileName));
            content = bufferReader.lines().collect(Collectors.joining(System.lineSeparator()));
            words = content.split(" ");
        }catch (Exception e){
            e.printStackTrace();
        }
        return words;
    }

    public void writeFile(String word) {
        try{
            Writer fw = new FileWriter(fileName, true);
            fw.write(word);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void isFileExit(String fileName){
        try{
            FileReader newFile = new FileReader(fileName);
            this.fileName = fileName;
        }catch (Exception e){
            System.out.println("Can not find the file, will still use default file.");
        }
    }

}
