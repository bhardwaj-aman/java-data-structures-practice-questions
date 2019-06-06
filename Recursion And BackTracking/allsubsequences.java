package RECURSIONPRACTICE;

import java.util.Scanner;

public class allsubsequences {
    public static  void main(String[] args){
        Scanner s = new Scanner(System.in);
        String a = s.next();
      /////  StringBuilder sb = new StringBuilder(a);
      //  sb= sb.reverse();

        sub(a,"",0);
    }
    public static void  sub(String  s, String ros,int iteration){
     //   System.out.println("iteration no- "+iteration);
        if (s.length()==0){
            System.out.println("exiting loop  coz s is: "+s);
            System.out.println(ros);
            return;
        }
        char a = s.charAt(0);
        String b = s.substring(1);
    //    StringBuilder x = new StringBuilder(b);
        System.out.println("a is: "+a);
        System.out.println("entering loop 1 -----s is: " + b+ " and ros is: "+ros);

        sub(b,ros,iteration+1);
        System.out.println("entering loop 2- a is: "+a);
        System.out.println(" loop 2 --- s is: " + b+ " and ros is: "+ros+a);
        sub(b,ros+a,iteration);
    }
}
