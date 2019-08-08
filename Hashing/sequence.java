package HashingPractice;

import java.util.*;
class sequence{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        if(a==1){
            System.out.println(1);
        }else{
            if(a%2==1){
                System.out.println((int)Math.pow(2,(a/2)));
            }else{
                System.out.println((int)Math.pow(3,(a/2)-1));
            }
        }}
}