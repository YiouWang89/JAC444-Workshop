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

import java.util.ArrayList;

public class CheckInfo {
    BabyName babyName;
    public BabyName checkName(String name, String gender, ArrayList<BabyName> nameList){
        if(gender.equals("F") | gender.equals("f")){
            for (int i = 0; i< nameList.size(); i++){
                if(name.equals(nameList.get(i).getGirlName().toLowerCase())){
                    babyName = nameList.get(i);
                }
            }
        }else if (gender.equals("M") | gender.equals("m")){
            for (int i = 0; i< nameList.size(); i++){
                if(name.equals(nameList.get(i).getBoyName().toLowerCase())){
                    babyName = nameList.get(i);
                }
            }
        }
        return babyName;
    }

}
