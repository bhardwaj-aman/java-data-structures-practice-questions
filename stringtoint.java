package RECURSIONPRACTICE;

import java.util.Scanner;

public class stringtoint {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        convert(s.next(),0);
    }
    public static void convert(String i,int a){
        if(i.length()==0){
            System.out.println(a);
            return;
        }
        char c = i.charAt(0);
        String b = i.substring(1);
       // System.out.println("Integer.parseInt(c+\"\")*10) is: "+Integer.parseInt(c+"")*10);
        convert(b,(a*10)+Integer.parseInt(c+""));
    }
}