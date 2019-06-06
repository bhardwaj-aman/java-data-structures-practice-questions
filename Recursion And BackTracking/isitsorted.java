package RECURSIONPRACTICE;
import java.util.*;
public class isitsorted {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int[] b = new int[a];
        for(int i=0;i<a;i++){
            b[i]=s.nextInt();
        }
        System.out.println(isitsorted(b,0));
    }
    public static boolean isitsorted(int[] a,int s){
        if(s==a.length-1){
            return true;
        }
        if(a[s+1]<a[s]){
            return false;
        }
        return isitsorted(a,s+1);
    }

}