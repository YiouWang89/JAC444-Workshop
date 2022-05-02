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
public class Parallel implements Runnable{
    Matrix ma = new Matrix();
    private final double[][] matrix1;
    private final double[][] matrix2;
    private final static int[][] dividedMatrix = new int[][]{{0, 500}, {501, 1000},
            {1001, 1500}, {1501, 2000}};
    private static int threadNo = 0;

    public Parallel(){
        matrix1 = ma.getMatrix();
        matrix2 = ma.getMatrix();
    }

    public static double[][] parallelAddMatrix(double[][] a, double[][] b){
        double[][] solution = new double[a.length][a[0].length];
        int rowCount = dividedMatrix[threadNo][0];
        int colCount = dividedMatrix[threadNo][1];

        if(threadNo < dividedMatrix.length){

            for(int i=0; i <= rowCount; i ++){
                for(int j=0; j <colCount; j++){
                    solution[i][j] = a[i][j] + b[i][j];
                }
            }
        }
        threadNo++;
        return solution;
    }


    @Override
    public void run() {
        parallelAddMatrix(matrix1, matrix2);
    }
}
