package H_factor_multiple;
// 정수 N이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오.
public class Main_11653 {
    private static int inputInt() throws Exception{
        int tmp;
        int result = 0;
        while(true){
            tmp = System.in.read();
            if(tmp < '0' || tmp > '9') return result;
            result *= 10;
            result += tmp - '0';
        }
    }
    public static void main(String[] args) throws Exception{
        int a = inputInt();
        while(a%2 == 0){
            a /= 2;
            System.out.println(2);
        }
        for(int i = 3; a != 1; i += 2){
            while(a%i == 0){
                a /= i;
                System.out.println(i);
            }
        }
    }
}
