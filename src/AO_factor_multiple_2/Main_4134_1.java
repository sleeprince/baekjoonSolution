package AO_factor_multiple_2;
// 정수 n(0 ≤ n ≤ 4*10^9)가 주어졌을 때, n보다 크거나 같은 소수 중 가장 작은 소수 찾는 프로그램을 작성하시오.

// 첫째 줄에 테스트 케이스의 개수가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다.
// 각각의 테스트 케이스에 대해서 n보다 크거나 같은 소수 중 가장 작은 소수를 한 줄에 하나씩 출력한다.
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;
// ✘ 시간 초과
public class Main_4134_1 {
    private static List<Integer> primeNums = new LinkedList<>(List.of(2, 3));
    private static int findNextPrimeNumberOf(int num){
        if(num == primeNums.getLast()){
            return primeNums.getLast();
        }else if(num < primeNums.getLast()){
            for(int primeNum : primeNums){
                if(num <= primeNum)
                    return primeNum;
            }
        }else{
            int nextNum = primeNums.getLast();
            while(num > primeNums.getLast()){
                nextNum += 2;
                if(isPrimeNumber(nextNum))
                    primeNums.add(nextNum);
            }
        }
        return primeNums.getLast();
    }
    private static boolean isPrimeNumber(int num){
        for(int primeNum : primeNums){
            if(primeNum*primeNum > num)
                break;
            if(num % primeNum == 0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        for(int i = 0; i < cnt; i++){
            System.out.println(findNextPrimeNumberOf(sc.nextInt()));
        }
        sc.close();
    }
}
