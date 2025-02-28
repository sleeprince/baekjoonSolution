package P_Stack_Queue_Deck;
// 정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

// 명령은 총 다섯 가지이다.

// 1 X: 정수 X를 스택에 넣는다. (1 ≤ X ≤ 100,000)
// 2: 스택에 정수가 있다면 맨 위의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
// 3: 스택에 들어있는 정수의 개수를 출력한다.
// 4: 스택이 비어있으면 1, 아니면 0을 출력한다.
// 5: 스택에 정수가 있다면 맨 위의 정수를 출력한다. 없다면 -1을 대신 출력한다.

// 첫째 줄에 명령의 수 N이 주어진다. (1 ≤ N ≤ 1,000,000)
// 둘째 줄부터 N개 줄에 명령이 하나씩 주어진다.
// 출력을 요구하는 명령은 하나 이상 주어진다.

// 출력을 요구하는 명령이 주어질 때마다 명령의 결과를 한 줄에 하나씩 출력한다.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
// LinkedList로 구현
class MyLinkedStack{
    private int lenth;
    private node lastNode;
    private class node{
        int content;
        node prev;
    }
    public MyLinkedStack(){
        this.lenth = 0;
        this.lastNode = null;
    }
    public void push(int _content){
        node newNode= new node();
        newNode.content = _content;
        newNode.prev = this.lastNode;
        this.lastNode = newNode;
        this.lenth++;
    }
    public int pop(){
        if(this.lastNode == null){
            return -1;
        }else{
            int _content = this.lastNode.content;
            this.lastNode = this.lastNode.prev;
            this.lenth--;
            return _content;
        }
    }
    public int size(){
        return lenth;
    }
    public int isEmpty(){
        return (lastNode == null)? 1 : 0;
    }
    public int peek(){
        return (this.lastNode == null)? -1 : this.lastNode.content; 
    }
}
public class Main_28278 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int order;
        MyLinkedStack stack = new MyLinkedStack();
        for(int i = 0; i < cnt; i++){
            st = new StringTokenizer(br.readLine());
            order = Integer.parseInt(st.nextToken());
            switch (order) {
                case 1:
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    bw.write(stack.pop() + "\n");
                    break;
                case 3:
                    bw.write(stack.size() + "\n");
                    break;
                case 4:
                    bw.write(stack.isEmpty() + "\n");
                    break;
                case 5:
                    bw.write(stack.peek() + "\n");
                    break;
                default:
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}
