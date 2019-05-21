package RECURSIONPRACTICE;
import java.util.*;
public class allxatback {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        movex(s.next(),0,"");
    }
    public static void movex(String s,int c,String res){
        if(s.length()==1){
            System.out.print(res+s.charAt(0));
            for(int i=0;i<c;i++){
                System.out.print("x");
            }
            System.out.println("");
            return;
        }
        char a = s.charAt(0);
        System.out.println("a is: " + a);
        String b = s.substring(1);
        System.out.println("b is: " + b);
        if((a+"").equals("x")){
            System.out.println("loop 1");
            movex(b,c+1,res);
        }else{
            System.out.println("loop 2");
            movex(b,c,res+a);
        }
    }
}
