package P_Stack_Queue_Deck;

// 정수를 저장하는 덱을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
// 명령은 총 여덟 가지이다.

// 1 X: 정수 X를 덱의 앞에 넣는다. (1 ≤ X ≤ 100,000)
// 2 X: 정수 X를 덱의 뒤에 넣는다. (1 ≤ X ≤ 100,000)
// 3: 덱에 정수가 있다면 맨 앞의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
// 4: 덱에 정수가 있다면 맨 뒤의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
// 5: 덱에 들어있는 정수의 개수를 출력한다.
// 6: 덱이 비어있으면 1, 아니면 0을 출력한다.
// 7: 덱에 정수가 있다면 맨 앞의 정수를 출력한다. 없다면 -1을 대신 출력한다.
// 8: 덱에 정수가 있다면 맨 뒤의 정수를 출력한다. 없다면 -1을 대신 출력한다.

// 첫째 줄에 명령의 수 N이 주어진다. (1 ≤ N ≤ 1,000,000)
// 둘째 줄부터 N개 줄에 명령이 하나씩 주어진다.
// 출력을 요구하는 명령은 하나 이상 주어진다.
// 출력을 요구하는 명령이 주어질 때마다 명령의 결과를 한 줄에 하나씩 출력한다.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class MyLinkedDeck{
    private int size;
    private Node head;
    private Node tail;
    private class Node{
        int content;
        Node prev;
        Node next;
        Node(int _content){
            this.content = _content;
            this.prev = null;
            this.next = null;
        }
    }
    public MyLinkedDeck(){
        this.size = 0;
        this.head = null;
        this.tail = null;
    }
    public void addFirst(int _content){
        Node node = new Node(_content);
        if(this.size == 0){
            this.head = node;
            this.tail = node;
        }else{
            this.head.prev = node;
            node.next = this.head;
            this.head = node;
        }
        size++;
    }
    public void addLast(int _content){
        Node node = new Node(_content);
        if(this.size == 0){
            this.head = node;
            this.tail = node;
        }else{
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
        }
        size++;
    }
    public int pollFirst(){
        if(this.size == 0){
            return -1;
        }else{
            Node tmp = this.head;
            this.head = this.head.next;
            if(this.head != null) this.head.prev = null;
            tmp.prev = null;
            tmp.next = null;
            size--;
            return tmp.content;
        }
    }
    public int pollLast(){
        if(this.size == 0){
            return -1;
        }else{
            Node tmp = this.tail;
            this.tail = this.tail.prev;
            if(this.tail != null) this.tail.next = null;
            tmp.prev = null;
            tmp.next = null;
            size--;
            return tmp.content;
        }
    }
    public int size(){
        return this.size;
    }
    public int isEmpty(){
        return (this.size == 0)? 1 : 0;
    }
    public int peekFirst(){
        return (this.size == 0)? -1 : this.head.content;
    }
    public int peekLast(){
        return (this.size == 0)? -1 : this.tail.content;
    }
    public int[] toArray(){
        int[] arr = new int[this.size];
        Node tmp = this.head;
        for(int i = 0; i < arr.length; i++){
            arr[i] = tmp.content;
            tmp = this.head.next;
        } 
        return arr;
    }
}
public class Main_28279 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());
        MyLinkedDeck myDeck = new MyLinkedDeck();
        for(int i = 0; i < cnt; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (Integer.parseInt(st.nextToken())) {
                case 1:
                    myDeck.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    myDeck.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case 3:
                    bw.write(myDeck.pollFirst() + "\n");
                    break;
                case 4:
                    bw.write(myDeck.pollLast() + "\n");
                    break;
                case 5:
                    bw.write(myDeck.size() + "\n");
                    break;
                case 6:
                    bw.write(myDeck.isEmpty() + "\n");
                    break;
                case 7:
                    bw.write(myDeck.peekFirst() + "\n");
                    break;
                case 8:
                    bw.write(myDeck.peekLast() + "\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}
