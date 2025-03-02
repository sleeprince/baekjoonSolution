package AI_factor_multiple;
// 4 × 3 = 12이다.
// 이 식을 통해 다음과 같은 사실을 알 수 있다.
// 3은 12의 약수이고, 12는 3의 배수이다.
// 4도 12의 약수이고, 12는 4의 배수이다.
// 두 수가 주어졌을 때, 다음 3가지 중 어떤 관계인지 구하는 프로그램을 작성하시오.
// 1. 첫 번째 숫자가 두 번째 숫자의 약수이다.
// 2. 첫 번째 숫자가 두 번째 숫자의 배수이다.
// 3. 첫 번째 숫자가 두 번째 숫자의 약수와 배수 모두 아니다.

// 입력은 여러 테스트 케이스로 이루어져 있다. 각 테스트 케이스는 10,000이 넘지않는 두 자연수로 이루어져 있다. 마지막 줄에는 0이 2개 주어진다. 두 수가 같은 경우는 없다.
// 각 테스트 케이스마다 첫 번째 숫자가 두 번째 숫자의 약수라면 factor를, 배수라면 multiple을, 둘 다 아니라면 neither를 출력한다.
public class Main_5086 {
    private static int inputInt() throws Exception{
        int result = 0;
        int tmp;
        while(true){
            tmp = System.in.read();
            //if(tmp == 10) continue;
            if(tmp < '0' || tmp > '9') return result;
            result *= 10;
            result += tmp - '0';
        }
    }
    public static void main(String[] args) throws Exception{
        int a, b;
        while(true){
            a = inputInt();
            b = inputInt();
            if(a == 0 && b == 0) break;
            if(a > b){
                if(a%b == 0){
                    System.out.println("multiple");
                }else{
                    System.out.println("neither");
                }
            }else{
                if(b%a == 0){
                    System.out.println("factor");
                }else{
                    System.out.println("neither");
                }
            }
        }
    }
}
