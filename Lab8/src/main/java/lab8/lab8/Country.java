/**********************************************
 *  Workshop 8
 *  Course:<JAC444> - Semester
 *  Last Name:<Wang>
 *  First Name:<Yiou(Anna)>
 *  ID:<151558194>
 *  Section:<NBB>
 *  This assignment represents my own work in accordance with Seneca Academic Policy. Signature
 *  Date:<2022-04-03>
 * **********************************************/
package lab8.lab8;

import java.util.ArrayList;

public class Country {
    private String countryName;
    private ArrayList<City> cityList = new ArrayList<>();

    public Country(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void addCity(City city){
        cityList.add(city);
    }

    public ArrayList<City> getCity (){
        return cityList;
    }

}
