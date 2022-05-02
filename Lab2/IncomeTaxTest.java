/**********************************************
 *  Workshop 2
 *  Course:<JAC444> - Semester
 *  Last Name:<Wang>
 *  First Name:<Yiou(Anna)>
 *  ID:<151558194>
 *  Section:<NBB>
 *  This assignment represents my own work in accordance with Seneca Academic Policy. Signature
 *  Date:<2022-02-10>
 * **********************************************/

import java.util.Scanner;

public class IncomeTaxTest {

    public static void printHeader() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("Taxable     Single     Married Joint   Married Filing       Head of House Hold");
        System.out.println("Income                    or Qualifying        Separately");
        System.out.println("                                  Widow(er)");
        System.out.println("--------------------------------------------------------------");
    }

    public static void printFilingStatus(IncomeTax tax){
        System.out.println(tax.SINGLE_FILER + " - single filer");
        System.out.println(tax.MARRIED_JOINTLY_OR_QUALIFYING_WIDOWER + " - married filing jointly or qualifying widow(er)");
        System.out.println(tax.MARRIED_SEPARATELY + " -married filing separately");
        System.out.println(tax.HEAD_OF_HOUSEHOLD + " -head of household.");
    }

    public static int[][] interval2009 = {
            {8350, 33950, 82250, 171550, 372950},//single
            {16700, 67900, 137050, 208850, 372950},//Married filing jointly or qualifying widow
            {8350, 33950, 68525, 104425, 186475},//Married filing separately
            {11950, 45500, 117450, 190200, 372950}//Head of House
    };

    public static int[][] interval2020 = {
            {9875, 40125, 85525, 163300, 207350, 518400},
            {19750, 80250, 171050, 326600, 414700, 622050},
            {9875, 40125, 85525, 163300, 207350, 311025},
            {14100, 53700, 85500, 163300, 207350, 518400}
    };

    public static double[] rates2009 = {0.1, 0.15, 0.25, 0.28, 0.33, 0.35};

    public static double[] rates2020 = {0.1, 0.12, 0.22, 0.24, 0.32, 0.37};

    public static void  printTaxTable(IncomeTax tax, int fAmount, int tAmount){
        for(int row = 0; row < (tAmount - fAmount)/1000 + 1; row++){
            System.out.print(fAmount + row * 1000);

            for(int col = 0; col < tax.getIntervals().length; col ++){
                tax = new IncomeTax(col, tax.getIntervals(), tax.getRate(), fAmount + row * 1000);
                System.out.printf("%14.2f",tax.getTax());
            }
            System.out.println("\n");
        }
    }


    public static void main(String[] args) {
        IncomeTaxTest test = new IncomeTaxTest();
        IncomeTax tax = new IncomeTax();
        int filingStatus, year, option;
        double taxIncome;
        System.out.println("Welcome to the Income Tax Calculate System: ");
        Scanner input = new Scanner(System.in);
        do{
            System.out.println("---------------------------------------");
            System.out.println("1. Compute personal income Tax");
            System.out.println("2. Print the tax table incomes(with range)");
            System.out.println("3. Exit");
            System.out.println("---------------------------------------");
            System.out.println("Please select an option:");
            option = input.nextInt();
            if(option == 1){
                test.printFilingStatus(tax);
                System.out.println("Please select the filing status:");
                filingStatus = input.nextInt();
                while(filingStatus >3 || filingStatus < 0) {
                    System.out.print("The option should between 0-3, please select again:  ");
                    filingStatus = input.nextInt();
                }
                tax.setFilingStatus(filingStatus);
                System.out.println("Which year 2009 or 2020: ");
                year = input.nextInt();
                //check input
                if(year == 2009){
                    tax.setIntervals(interval2009);
                    tax.setRates(rates2009);
                }else{
                    tax.setIntervals(interval2020);
                    tax.setRates(rates2020);
                }
                System.out.println("Please input the Taxable Income: ");
                taxIncome = input.nextDouble();
                tax.setTaxableIncome(taxIncome);
                System.out.println("The tax is " + tax.getTax());
            }else if (option == 2){
                System.out.println("Please input the from amount(intervals 1000, e.g 1000 or 9000): ");
                int fromAmount = input.nextInt();
                System.out.println("Please input the to amount(intervals 1000, e.g 1000 or 9000):");
                int toAmount = input.nextInt();
                System.out.println("Which year tax table would you like to print ( 2009 or 2020):");
                year = input.nextInt();
                test.printHeader();
                if(year == 2009){
                    tax.setIntervals(interval2009);
                    tax.setRates(rates2009);
                }else{
                    tax.setIntervals(interval2020);
                    tax.setRates(rates2020);
                }

                test.printTaxTable(tax, fromAmount, toAmount);

            }
        }while(option != 3);

    }
}
