/**********************************************
 *  Workshop 9
 *  Course:<JAC444> - Semester
 *  Last Name:<Wang>
 *  First Name:<Yiou(Anna)>
 *  ID:<151558194>
 *  Section:<NBB>
 *  This assignment represents my own work in accordance with Seneca Academic Policy. Signature
 *  Date:<2022-04-10>
 * **********************************************/
public class Sequential{
    private double[][] matrix1;
    private double[][] matrix2;

    StopWatch stopWatch = new StopWatch();
    Matrix ma = new Matrix();


    public Sequential(){
        matrix1 = ma.getMatrix();
        matrix2 = ma.getMatrix();
    }

    public static double[][] sequentialAddMatrix(double[][] a, double[][] b){
        double[][] solution = new double[a.length][a[0].length];
        for(int i=0; i< a.length; i++){
            for(int j=0; j<a[i].length; j++){
                solution[i][j] = a[i][j] + b[i][j];
            }
        }
        return solution;
    }

    public void show(long time){
        System.out.println("Sequential Method used ----" + time + "msec");
    }

    public void run() {
        stopWatch.start();
        sequentialAddMatrix(matrix1, matrix2);
        stopWatch.stop();
        show(stopWatch.getTime());
    }
}