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

public class IncomeTax {
    public final static int SINGLE_FILER = 0;
    public final static int MARRIED_JOINTLY_OR_QUALIFYING_WIDOWER = 1;
    public final static int MARRIED_SEPARATELY = 2;
    public final static int HEAD_OF_HOUSEHOLD = 3;

    private int filingStatus;
    private int [] [] intervals;
    private double [] rates;
    private double  taxableIncome;

    public int getFilingStatus() {
        return this.filingStatus;
    }

    public int[][] getIntervals(){
        return this.intervals;
    }

    public double[] getRate() {
        return this.rates;
    }

    public double getTaxableIncome() {
        return this.taxableIncome;
    }

    public void setFilingStatus(int status) {
        this.filingStatus = status;
    }

    public void setTaxableIncome(double income) {
        this.taxableIncome = income;
    }

    public void setIntervals(int[][] inter) {
        this.intervals = new int[inter.length][inter[0].length];
        for(int row = 0; row < inter.length; row++) {
            for(int col = 0; col < inter[0].length; col++)
            {
                this.intervals[row][col]= inter[row][col];
            }
        }
    }

    public void setRates(double[] rate) {
        this.rates = new double[rate.length];
        for(int i = 0; i < rate.length; i++)
        {
            this.rates[i] = rate[i];
        }
    }


    public IncomeTax() {
    }

    public IncomeTax(int fStatus, int[][] inter, double[] rate, double taxIncome) {
        this.filingStatus = fStatus;
        this.intervals = inter;
        this.rates = rate;
        this.taxableIncome = taxIncome;
    }

    public double getTax(){
        int count = 1;
        double tax;

        if(taxableIncome > intervals[filingStatus][0] ){
            tax = intervals[filingStatus][0] * rates[0];
            for( int i = 1; i <intervals.length; i++ ){
                if (taxableIncome > intervals[filingStatus][i]){
                    tax += (intervals[filingStatus][i] -intervals[filingStatus][i - 1] ) * rates[i];
                    count ++;
                }else{
                    tax += (taxableIncome - intervals[filingStatus][i - 1]) * rates[i];
                    i = intervals.length;
                }
                if (count ==intervals.length){
                    tax += (taxableIncome - intervals[filingStatus][count - 1]) * rates[i + 1];
                }
            }
        }else{
            tax = taxableIncome * rates[0];
        }
            return tax;
    }

}


