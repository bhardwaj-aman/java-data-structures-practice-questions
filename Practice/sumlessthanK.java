package AmazonPractice;
import java.util.*;
public class sumlessthanK {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int[] b = new int[a];
        for(int i=0;i<a;i++){
            b[i]=s.nextInt();
        }
        int k = s.nextInt();
        int i=0;
        int j=a-1;
        int counter=0;
        while(i<j){
            System.out.println("i is: "+i+" & j is: "+j );
            while(b[i]+b[j]>=k){
                j--;
            }
            counter+=(j-i);
            System.out.println("counter is: "+counter);
            i++;
        }
        System.out.println(counter);
    }
}
/*

7
1
3
5
8
12
20
30
15

*/