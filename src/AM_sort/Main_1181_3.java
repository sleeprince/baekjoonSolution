package AM_sort;
// 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
// 1. 길이가 짧은 것부터
// 2. 길이가 같으면 사전 순으로
// 단, 중복된 단어는 하나만 남기고 제거해야 한다.

// 첫째 줄에 단어의 개수 N이 주어진다. (1 ≤ N ≤ 20,000) 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다. 주어지는 문자열의 길이는 50을 넘지 않는다.
// 조건에 따라 정렬하여 단어들을 출력한다.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main_1181_3 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   
        int cnt = Integer.parseInt(br.readLine());
        
        SortedSet<String> set = new TreeSet<>();
        for(int i = 0; i < cnt; i++)
            set.add(br.readLine());
        List<String> list = new ArrayList<>();
        list.addAll(set);
        list.sort(new Comparator<String>() {
              @Override
              public int compare(String str1, String str2){
                if(str1.length() < str2.length())
                    return -1;
                else if(str1.length() == str2.length())
                    return 0;
                else
                    return 1;
              }
        });
        for(String str : list){
            bw.write(str);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
