package HashingPractice;
import java.util.Scanner;
import java.util.*;
public class HighestFrequency{
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        HashMap<Integer,Integer> h = new HashMap<Integer, Integer>();
        for(int i=0;i<a;i++){
            int b = s.nextInt();
            if(h.get(b)!=null){
                int x = h.get(b);
                h.remove(b);
                h.put(b,x+1);
            }else {
                h.put(b,1);
            }
        }
        int max=0;
        int num=0;
        for (int x: h.keySet()){
            if(h.get(x)>max){
                max = h.get(x);
                num=x;
            }
        }
        System.out.println(num);
    }
}