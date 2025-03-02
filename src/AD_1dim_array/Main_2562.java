package AD_1dim_array;
// 9개의 서로 다른 자연수가 주어질 때, 이들 중 최댓값을 찾고 그 최댓값이 몇 번째 수인지를 구하는 프로그램을 작성하시오.
// 예를 들어, 서로 다른 9개의 자연수 3, 29, 38, 12, 57, 74, 40, 85, 61 이 주어지면, 이들 중 최댓값은 85이고, 이 값은 8번째 수이다.
public class Main_2562{
    private static int input() throws Exception{
        int a = 0;
        int result = 0;
        while(true){
            a = System.in.read();
            //if(a == 10) continue;
            if(a < '0' || a > '9') return result;
            result *= 10;
            result += a - '0';
        }
    }
    public static void main(String[] args) throws Exception{
        int max = 0;
        int ord = 0;
        int tmp;
        for(int i = 1; i < 10; i++){
            tmp = input();
            if(tmp > max){
                max = tmp;
                ord = i;
            }
        }
        System.out.print(max + "\n" + ord);
    }
}