package RECURSIONPRACTICE;

import java.util.*;
public class dictorder {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        dict(s.next(),"");
    }
    public static void dict(String s, String res){
        if(s.length()==2){
            System.out.println(res);
            return;
        }
        char a = s.charAt(s.length()-1);
        String b = s.substring(0,s.length()-1);
        System.out.println("b length is : "+b.length());
        char d = b.charAt(b.length()-1);
        if(((int)a)<((int)d)){
            dict(b,res+d+a);
        }else{
            dict(b,res+a+d);
        }

    }
}
