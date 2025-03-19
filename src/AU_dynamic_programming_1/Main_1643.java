package AU_dynamic_programming_1;
// 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지이다.
// - X가 3으로 나누어 떨어지면, 3으로 나눈다.
// - X가 2로 나누어 떨어지면, 2로 나눈다.
// - 1을 뺀다.
// 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
// 첫째 줄에 1보다 크거나 같고, 10^6보다 작거나 같은 정수 N이 주어진다.
// 첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.

import java.util.Scanner;
public class Main_1643 {
    private static int[] series;
    private static int findMin(int num){
        if(series[num] != 0) return series[num];
        if(num == 1) return series[num] = 0;
        int option1 = (num%2 == 0)? findMin(num/2) + 1 : findMin(num-1) + 1;
        int option2 = (num%3 == 0)? findMin(num/3) + 1 : findMin(num-1) + 1;
        return series[num] = (option1 < option2)? option1 : option2;
    }
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        series = new int[num + 1];
        System.out.println(findMin(num));
        sc.close();
    }
}
