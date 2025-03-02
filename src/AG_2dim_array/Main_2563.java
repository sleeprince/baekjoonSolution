package AG_2dim_array;
// 가로, 세로의 크기가 각각 100인 정사각형 모양의 흰색 도화지가 있다. 이 도화지 위에 가로, 세로의 크기가 각각 10인 정사각형 모양의 검은색 색종이를 색종이의 변과 도화지의 변이 평행하도록 붙인다. 이러한 방식으로 색종이를 한 장 또는 여러 장 붙인 후 색종이가 붙은 검은 영역의 넓이를 구하는 프로그램을 작성하시오.
// 첫째 줄에 색종이의 수가 주어진다. 이어 둘째 줄부터 한 줄에 하나씩 색종이를 붙인 위치가 주어진다. 색종이를 붙인 위치는 두 개의 자연수로 주어지는데 첫 번째 자연수는 색종이의 왼쪽 변과 도화지의 왼쪽 변 사이의 거리이고, 두 번째 자연수는 색종이의 아래쪽 변과 도화지의 아래쪽 변 사이의 거리이다. 색종이의 수는 100 이하이며, 색종이가 도화지 밖으로 나가는 경우는 없다
import java.util.Scanner;

public class Main_2563 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        boolean[][] paper = new boolean[101][101];
        int cnt = sc.nextInt();
        int x, y;
        int result = 0;
        for(int i = 0; i < cnt; i++){
            x = sc.nextInt();
            y = sc.nextInt();
            for(int j = x; j < x + 10; j++){
                for(int k = y; k < y + 10; k++){
                    paper[j][k] = true;
                }
            }
        }
        sc.close();
        for(int i = 0; i < paper.length; i++){
            for(int j = 0; j < paper[i].length; j++){
                if(paper[i][j] == true) result++;
            }
        }
        System.out.print(result);        
    }
}
