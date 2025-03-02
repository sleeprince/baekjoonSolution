package AJ_geometry_rectangle_triangle;
// 정수 A, B 가 주어진다. 세로 길이가 A cm, 가로 길이가 B cm 인 아래와 같은 직사각형의 넓이를 cm2 단위로 구하시오.

public class Main_27323 {
    private static int a;
    private static int b;
    private static int input() throws Exception {
		int result = 0;
		int dgt = 0;
		while(true){
            dgt = System.in.read();
			if(dgt > '9' || dgt <'0') return result;
            result *= 10;
			result += dgt - '0';
		}	
	}
	public static void main(String[] args) throws Exception {
		a = input();
        b = input();
        System.out.println(a * b);
	}
}
