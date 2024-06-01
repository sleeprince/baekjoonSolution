package F_2dim_array;
import java.util.Scanner;
// N*M크기의 두 행렬 A와 B가 주어졌을 때, 두 행렬을 더하는 프로그램을 작성하시오.

// 첫째 줄에 행렬의 크기 N 과 M이 주어진다. 둘째 줄부터 N개의 줄에 행렬 A의 원소 M개가 차례대로 주어진다. 이어서 N개의 줄에 행렬 B의 원소 M개가 차례대로 주어진다. N과 M은 100보다 작거나 같고, 행렬의 원소는 절댓값이 100보다 작거나 같은 정수이다.
public class Main_2738{
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] matrixA = new int[row][col];
        int[][] matrixB = new int[row][col];
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                matrixA[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                matrixB[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                System.out.print(matrixA[i][j] + matrixB[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
