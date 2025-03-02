package AJ_geometry_rectangle_triangle;
// 세 점이 주어졌을 때, 축에 평행한 직사각형을 만들기 위해서 필요한 네 번째 점을 찾는 프로그램을 작성하시오.
// 세 점의 좌표가 한 줄에 하나씩 주어진다. 좌표는 1보다 크거나 같고, 1000보다 작거나 같은 정수이다.
// 직사각형의 네 번째 점의 좌표를 출력한다.

import java.util.Scanner;

public class Main_3009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] cod = new int[3][2];
        for(int i = 0; i < cod.length; i++){
            for(int j = 0; j < cod[i].length; j++){
                cod[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < 2; i++){
            if(cod[0][i] == cod[1][i]){
                System.out.print(cod[2][i] + " ");
            }else if(cod[0][i] == cod[2][i]){
                System.out.print(cod[1][i] + " ");
            }else{
                System.out.print(cod[0][i] + " ");
            }
        }
        sc.close();
    }
}
