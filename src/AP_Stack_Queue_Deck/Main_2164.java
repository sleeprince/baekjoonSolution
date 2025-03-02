package AP_Stack_Queue_Deck;

import java.util.Scanner;

public class Main_2164 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int[] card = new int[2*cnt];
        for(int i = 0; i < cnt; i++) card[i] = i + 1;
        int front = 0;
        int back = cnt;
        while(front < back - 1){
            front++;
            card[back++] = card[front++];
        }
        System.out.println(card[front]);
        sc.close();
    }
}
