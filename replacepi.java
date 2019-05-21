package RECURSIONPRACTICE;
import java.util.*;
public class replacepi {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        for(int i=0;i<a;i++){
            String str = s.next();
            replacepi(str,"");
        }
    }
    public static void replacepi(String s,String rem){
        if(s.equals("")){
            System.out.println(rem);
            return;
        }
        String x = s.substring(0,1);
        if((x.equals("p"))&&(s.substring(1,2).equals("i"))){
            replacepi(s.substring(2),rem+"3.14");
        }

        else{
            replacepi(s.substring(1),rem+x);
        }

    }
}