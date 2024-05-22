package E_Letter;

public class Main_27866 {

    private static char[] inputString() throws Exception{
        char[] result = new char[1000];
        for(int i = 0; i < 1000; i++){
            result[i] = (char)System.in.read();
            if(result[i] < 'a' || result[i] > 'Z'){
                result[i] = 0;
                return result;
            }
        }
        return result;
    }

    private static int inputInt() throws Exception{
        int tmp;
        int result = 0;
        while(true){
            tmp = System.in.read();
            if(tmp > '9' || tmp < '0')
        }
    }

    public static void main(String[] args){

    } 
}
