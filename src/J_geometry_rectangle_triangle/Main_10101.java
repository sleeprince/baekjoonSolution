package J_geometry_rectangle_triangle;
// 삼각형의 세 각을 입력받은 다음, 
// 세 각의 크기가 모두 60이면, Equilateral
// 세 각의 합이 180이고, 두 각이 같은 경우에는 Isosceles
// 세 각의 합이 180이고, 같은 각이 없는 경우에는 Scalene
// 세 각의 합이 180이 아닌 경우에는 Error
// 를 출력하는 프로그램을 작성하시오.

public class Main_10101 {
    private static int inputInt() throws Exception{
        int tmp;
        int result = 0;
        while(true){
            tmp = System.in.read();
            if(tmp > '9' || tmp < '0') return result;
            result *= 10;
            result += tmp - '0';
        }
    }
    
    public static void main(String[] args) throws Exception{
        int a = inputInt();
        int b = inputInt();
        int c = inputInt();
        
        if((a + b + c) != 180){
            System.out.print("Error");
        }else if(a == b && a == c){
            System.out.print("Equilateral");
        }else if(a == b){
            System.out.print("Isosceles");
        }else if(b == c){
            System.out.print("Isosceles");
        }else if(c == a){
            System.out.print("Isosceles");
        }else{
            System.out.print("Scalene");
        }
    }
}
