package AT_back_tracking;
// 스도쿠는 18세기 스위스 수학자가 만든 '라틴 사각형'이랑 퍼즐에서 유래한 것으로 현재 많은 인기를 누리고 있다. 이 게임은 아래 그림과 같이 가로, 세로 각각 9개씩 총 81개의 작은 칸으로 이루어진 정사각형 판 위에서 이뤄지는데, 게임 시작 전 일부 칸에는 1부터 9까지의 숫자 중 하나가 쓰여 있다.
// 나머지 빈 칸을 채우는 방식은 다음과 같다.
// 1. 각각의 가로줄과 세로줄에는 1부터 9까지의 숫자가 한 번씩만 나타나야 한다.
// 2. 굵은 선으로 구분되어 있는 3x3 정사각형 안에도 1부터 9까지의 숫자가 한 번씩만 나타나야 한다.
// 게임 시작 전 스도쿠 판에 쓰여 있는 숫자들의 정보가 주어질 때 모든 빈 칸이 채워진 최종 모습을 출력하는 프로그램을 작성하시오.
// 아홉 줄에 걸쳐 한 줄에 9개씩 게임 시작 전 스도쿠판 각 줄에 쓰여 있는 숫자가 한 칸씩 띄워서 차례로 주어진다. 스도쿠 판의 빈 칸의 경우에는 0이 주어진다. 스도쿠 판을 규칙대로 채울 수 없는 경우의 입력은 주어지지 않는다.
// 모든 빈 칸이 채워진 스도쿠 판의 최종 모습을 아홉 줄에 걸쳐 한 줄에 9개씩 한 칸씩 띄워서 출력한다.
// 스도쿠 판을 채우는 방법이 여럿인 경우는 그 중 하나만을 출력한다.
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class Main_2580 {
    private static int[][] sudoku = new int[9][9];
    private static int[][] answer = new int[9][9];
    private static boolean[][][] squares = new boolean[3][3][9];
    private static boolean[][] rows = new boolean[9][9];
    private static boolean[][] cols = new boolean[9][9];
    private static void fillSudoku(int pos){
        if(pos < 81){
            int row = pos/9;
            int col = pos%9;
            if(sudoku[row][col] == 0){
                for(int i = 1; i < 10; i++){
                    if(isNumUsed(row, col, i)) continue;
                    fillOutNum(row, col, i);
                    fillSudoku(pos + 1);
                    pickOutNum(row, col, i);
                }
            }else{
                fillSudoku(pos + 1);
            }
        }else{
            for(int i = 0; i < 9; i++)
                for(int j = 0; j < 9; j++)
                    answer[i][j] = sudoku[i][j];
        }
    }
    private static boolean isNumUsed(int row, int col, int num){
        return squares[row/3][col/3][num - 1] || rows[row][num - 1] || cols[col][num - 1];
    }
    private static void fillOutNum(int row, int col, int num){
        sudoku[row][col] = num;
        if(num > 0){
            squares[row/3][col/3][num - 1] = true;
            rows[row][num - 1] = true;
            cols[col][num - 1] = true;
        }
    }
    private static void pickOutNum(int row, int col, int num){
        sudoku[row][col] = 0;
        if(num > 0){
            squares[row/3][col/3][num - 1] = false;
            rows[row][num - 1] = false;
            cols[col][num - 1] = false;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < 9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++)
                fillOutNum(i, j, Integer.parseInt(st.nextToken()));
        }
        fillSudoku(0);
        for(int[] row : answer){
            for(int col : row)
                bw.write(col + " ");
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
