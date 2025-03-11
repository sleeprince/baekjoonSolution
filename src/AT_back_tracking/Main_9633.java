package AT_back_tracking;
// N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.
// N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.
// 첫째 줄에 N이 주어진다. (1 ≤ N < 15)
// 첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.

import java.util.Scanner;

public class Main_9633 {
    private static int[][] board;
    private static int cnt = 0;
    private static void countNQueen(int row){
        if(row < board.length){
            for(int col = 0; col < board.length; col++){
                if(board[row][col] > 0) continue;
                checkCells(row, col);
                countNQueen(row + 1);
                uncheckCells(row, col);
            }
        }else{            
            cnt++;
        }
    }
    private static void checkCells(int row, int col){
        for(int i = 1; i < board.length; i++){
            if(row + i < board.length) board[row + i][col]++;
            if(row + i < board.length && col + i < board.length) board[row + i][col + i]++;
            if(row + i < board.length && col - i > -1) board[row + i][col - i]++;
        }
    }
    private static void uncheckCells(int row, int col){
        for(int i = 1; i < board.length; i++){
            if(row + i < board.length) board[row + i][col]--;
            if(row + i < board.length && col + i < board.length) board[row + i][col + i]--;
            if(row + i < board.length && col - i > -1) board[row + i][col - i]--;
        }
    }
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        board = new int[n][n];
        countNQueen(0);
        System.out.println(cnt);
        sc.close();
    }
}
