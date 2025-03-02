package AE_Letter;

public class Main_5622 {
    private static int convertInput() throws Exception{
        char ch = (char)System.in.read();
        switch(ch){
            case 'A':
            case 'B':
            case 'C':
                return 3;
            case 'D':
            case 'E':
            case 'F':
                return 4;
            case 'G':
            case 'H':
            case 'I':
                return 5;
            case 'J':
            case 'K':
            case 'L':
                return 6;
            case 'M':
            case 'N':
            case 'O':
                return 7;
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
                return 8;
            case 'T':
            case 'U':
            case 'V':
                return 9;
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
                return 10;
            default:
                return 0;
        }
    }
    public static void main(String[] args) throws Exception{
        int sum = 0;
        for(int i = 0; i < 16; i++){
            sum += convertInput();
        }
        System.out.print(sum);
    }
}
