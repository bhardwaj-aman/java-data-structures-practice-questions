package RECURSIONPRACTICE;

import java.util.ArrayList;
import java.util.Scanner;

public class permutationfinder {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
     //   int a = s.nextInt();
        String x = s.nextLine();
     /*   String str = "";
        for(int i=1;i<=a;i++){
            str+=i;
        }*/
        ArrayList<String> l = new ArrayList<String>();
     //   allsubsequences(a,str,"");
        permutations(x,"",l);
    }
    public static void allsubsequences(int n,String s, String res){
       // System.out.println(s);
        if(s.length()==0){
            System.out.println(res);
            return;
        }
        if(res.length()==n){
            System.out.println(res);
            return;
        }
        String c = s.substring(0,1);
        String a = s.substring(1);
        allsubsequences(n,a,res);
        allsubsequences(n,a,res+c);
    }
    public static void permutations(String s,String res,ArrayList<String> l){
        if((s.length()==0)){
            if(!l.contains(res)){
                l.add(res);
                System.out.println(res);
                return;
            }
            return;
        }
        for(int i=0;i<s.length();i++){
            String c = s.substring(i,i+1);
            String a = s.substring(0,i)+s.substring(i+1,s.length());
            permutations(a,res+c,l);
        }
    }
}
