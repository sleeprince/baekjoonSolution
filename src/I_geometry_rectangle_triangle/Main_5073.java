package I_geometry_rectangle_triangle;
// 삼각형의 세 변의 길이가 주어질 때 변의 길이에 따라 다음과 같이 정의한다.
// Equilateral :  세 변의 길이가 모두 같은 경우
// Isosceles : 두 변의 길이만 같은 경우
// Scalene : 세 변의 길이가 모두 다른 경우
// 단 주어진 세 변의 길이가 삼각형의 조건을 만족하지 못하는 경우에는 "Invalid" 를 출력한다. 예를 들어 6, 3, 2가 이 경우에 해당한다. 가장 긴 변의 길이보다 나머지 두 변의 길이의 합이 길지 않으면 삼각형의 조건을 만족하지 못한다.
// 세 변의 길이가 주어질 때 위 정의에 따른 결과를 출력하시오.

// 각 줄에는 1,000을 넘지 않는 양의 정수 3개가 입력된다. 마지막 줄은 0 0 0이며 이 줄은 계산하지 않는다.
public class Main_5073 {
    private static int inputInt() throws Exception{
        int tmp;
        int result = 0;
        while(true){
            tmp = System.in.read();
            //if(tmp == 10) continue;
            if(tmp > '9' || tmp < '0') return result;
            result *= 10;
            result += tmp - '0';
        }
    }
    
    public static void main(String[] args) throws Exception{
        int a, b, c, max;
        
        while(true){            
            a = inputInt();
            max = a;
            b = inputInt();
            if(max < b) max = b;
            c = inputInt();
            if(max < c) max = c;
            
            if(a == 0 && b == 0 && c == 0){
                break;
            }else if(a + b + c <= 2*max){
                System.out.println("Invalid");
            }else if(a == b && a == c){
                System.out.println("Equilateral");
            }else if(a == b){
                System.out.println("Isosceles");
            }else if(b == c){
                System.out.println("Isosceles");
            }else if(c == a){
                System.out.println("Isosceles");
            }else{
                System.out.println("Scalene");
            }
        }
    }
}
