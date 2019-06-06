package RECURSIONPRACTICE;

import java.util.ArrayList;
import java.util.Scanner;

public class number_of_binary_strings_without_consecutive_1s {
    public static void main(String[] ars){
        Scanner s = new Scanner(System.in);
     //   int a = s.nextInt();
        String str = "";
       /* while (str.length()<a){
            str= str+"1";
       //     System.out.println("len is: "+str.length());
            if(str.length()<a) {
                str = str + "0";
            }
        }*/
        ArrayList<String> l = new  ArrayList<String>();
   //     permwithoutalternate(str,"",l);
       // int[] arr = new int[a-1];
      //  stringgenerator(a,"",arr);
    }
    public static void stringgenerator(int n,String s,int[] arr){
        if((s.length()==n)){
            if((numones(s)<n-1)&&(arr[numones(s)]==0)) {
                arr[numones(s)]++;
                System.out.println(s);
                return;
            }
            return;
        }
        stringgenerator(n,s+"0",arr);
        stringgenerator(n,s+"1",arr);

    }
    public static int numones(String s){
        int counter=0;
        for(int i=0;i<s.length();i++){
            if(s.substring(i,i+1).equals("1")){
                counter++;
            }
        }
     //   System.out.println(counter);
        return counter;
    }
    public static void permwithoutalternate(String s, String res,ArrayList<String> l){
        if(s.length()==0){
           if(issafe(res,l)){
               l.add(res);
               System.out.println(res);
               return;
           }
           return;
        }
        for(int i=0;i<s.length();i++){
            String c = s.substring(i,i+1);
            String a = s.substring(0,i)+s.substring(i+1);
            permwithoutalternate(a,res+c,l);
        }
    }
    public static boolean issafe(String s,ArrayList<String> l){
        int flag=0;
        for(int i=0;i<s.length()-1;i++){
            if((s.substring(i,i+1).equals("1"))&&(s.substring(i+1,i+2).equals("1"))){
                flag=1;
            }
        }
        if((flag >0)||(l.contains(s))){
            return false;
        }
        return true;
    }
}
