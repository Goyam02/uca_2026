import java.util.*;

public class setZeroes{

    public void setZeroes(int[][] matrix){
        int m = matrix.length;

        int n = matrix[0].length;

        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        for(int i = 0 ; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n ; j++){
                if(row[i] || col[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}


class Main{
    public static void main(String[] args){
        int[][] matrix1 = {
            {0, 1, 2, 0},
            {3, 4, 5, 2},
            {1, 3, 1, 5}
        };

        int[][] matrix2 = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };



        setZeroes test = new setZeroes();

        test.setZeroes(matrix1);

        test.setZeroes(matrix2);
        System.out.println("Matrix 1:");


        for(int i = 0; i < matrix1.length; i++){

            for(int j = 0; j < matrix1[0].length; j++){
                System.out.print(matrix1[i][j] + " ");
            }
            System.out.println();
        }


        System.out.println("Matrix 2:");

        for(int i = 0; i < matrix2.length; i++){

            for(int j = 0; j < matrix2[0].length; j++){
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println();
        }



    }
}