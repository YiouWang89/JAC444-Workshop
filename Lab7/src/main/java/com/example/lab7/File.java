/**********************************************
 *  Workshop 7
 *  Course:<JAC444> - Semester
 *  Last Name:<Wang>
 *  First Name:<Yiou(Anna)>
 *  ID:<151558194>
 *  Section:<NBB>
 *  This assignment represents my own work in accordance with Seneca Academic Policy. Signature
 *  Date:<2022-03-27>
 * **********************************************/
package com.example.lab7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class File {
    private String path;

    public String[] readFile(int year){
        String path = "src/main/java/com/example/lab7/babynames-w07/babynamesranking" + year +".txt";
        String str = new String();
        String[] names = null;
        try{
            BufferedReader bufferReader = new BufferedReader(new FileReader(path));
            str = bufferReader.lines().collect(Collectors.joining(System.lineSeparator()));
            names = str.split("\n");
        }catch (Exception e){
            e.printStackTrace();
        }
        return names;
    }

    public ArrayList<BabyName> getName(int year){
        ArrayList<BabyName> babyNames = new ArrayList<>();
        String[] names = readFile(year);
        for(int i = 0; i< names.length; i++){
            BabyName name = new BabyName();
            String[] temp;
            String temp1 =  names[i].replace("\t", " ");
            temp1 = temp1.replaceAll(" +"," ");
            temp1 = temp1.replaceAll(",", "");
            temp = temp1.split(" ");
            name.setId(Integer.parseInt(temp[0]));
            name.setBoyName(temp[1]);
            name.setBoyNo(Integer.parseInt(temp[2]));
            name.setGirlName(temp[3]);
            name.setGirlNo(Integer.parseInt(temp[4]));
            babyNames.add(name);
        }
        return babyNames;
    }

    public void print(int year){
        System.out.println("User input " + year);
    }
}
