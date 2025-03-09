package AS_recursive;
// 재귀적인 패턴으로 별을 찍어 보자. N이 3의 거듭제곱(3, 9, 27, ...)이라고 할 때, 크기 N의 패턴은 N×N 정사각형 모양이다.
// 크기 3의 패턴은 가운데에 공백이 있고, 가운데를 제외한 모든 칸에 별이 하나씩 있는 패턴이다.
// ***
// * *
// ***
// N이 3보다 클 경우, 크기 N의 패턴은 공백으로 채워진 가운데의 (N/3)×(N/3) 정사각형을 크기 N/3의 패턴으로 둘러싼 형태이다. 예를 들어 크기 27의 패턴은 예제 출력 1과 같다.

// 첫째 줄에 N이 주어진다. N은 3의 거듭제곱이다. 즉 어떤 정수 k에 대해 N=3k이며, 이때 1 ≤ k < 8이다.
// 첫째 줄부터 N번째 줄까지 별을 출력한다.
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_2447 {
    private static char[][] makeStars(int size){
        if(size == 1) return new char[][]{{'*'}};
        char[][] stars = new char[size][size];
        char[][] unit = makeStars(size/3);
        for(int i = 0; i < unit.length; i++)
            for(int j = 0; j < unit[i].length; j++)
                for(int k = 0; k < size; k += size/3)
                    for(int l = 0; l < size; l += size/3)
                        stars[k + i][ l + j] = (k != size/3 || l != size/3)? unit[i][j] : ' ';
        return stars;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(char[] row : makeStars(Integer.parseInt(br.readLine()))){
            for(char col : row) bw.write(col);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
