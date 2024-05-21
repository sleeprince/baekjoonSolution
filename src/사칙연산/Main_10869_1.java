package 사칙연산;

public class Main_10869_1 {
    private static int a;
    private static int b;
	//input을 System.in.read() 메소드로 받음
    private static int input() throws Exception {
		int result = 0;
		int dgt = 0;
		while((dgt = System.in.read()) != -1){
            			
			if(dgt > '9' || dgt <'0') {				
				return result;
            }
            result *= 10;
			dgt = dgt - '0';
			result += dgt;            
		}
		
		return result;
	}
	//메모리 14176KB 120ms
	//세 가지 입력 메소드 가운데 가장 빠르다.
	public static void main(String[] args) throws Exception {
		a = input();
        b = input();
		System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b);
        System.out.println(a % b);
	}
}
