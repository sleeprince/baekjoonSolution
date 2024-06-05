package G_2dim_array;
// 9×9 격자판에 쓰여진 81개의 자연수 또는 0이 주어질 때, 이들 중 최댓값을 찾고 그 최댓값이 몇 행 몇 열에 위치한 수인지 구하는 프로그램을 작성하시오.

// 첫째 줄에 최댓값을 출력하고, 둘째 줄에 최댓값이 위치한 행 번호와 열 번호를 빈칸을 사이에 두고 차례로 출력한다. 최댓값이 두 개 이상인 경우 그 중 한 곳의 위치를 출력한다.

import java.util.Scanner;

public class Main_2566 {
    public static void main(String[] args) throws Exception{
        int max = -1;
        int row = 0;
        int col = 0;
        int tmp;
        Scanner sc = new Scanner(System.in);
        for(int i = 0;i < 9; i++){
            for(int j = 0; j < 9; j++){
                tmp = sc.nextInt();
                if(max < tmp){
                    max = tmp;
                    row = i + 1;
                    col = j + 1;
                }
            }
        }
        sc.close();
        System.out.println(max);
        System.out.print(row + " " + col);
    }
}
