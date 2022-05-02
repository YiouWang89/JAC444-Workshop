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

import java.util.Random;

public class Matrix {
    private int row = 2000;
    private int col = 2000;
    private double[][] matrix = new double[row][col];

    public double[][] getMatrix() {
        Random random = new Random();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                matrix[i][j] = random.nextDouble();
            }
        }
        return matrix;
    }
}
