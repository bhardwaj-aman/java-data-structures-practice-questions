package AmazonPractice;

import java.util.Scanner;

public class LongestPalindromicSubStr {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int flag=0;
        int[] b = new int[a];
        for(int i=0;i<a;i++){
            b[i]=s.nextInt();
        }
        for(int i=a-1;i>=0;i--){
            for(int j=0;j<i;j++){
                if(isPalindrome(b,j,i)){
                  //  System.out.println("lol");
                    System.out.println((i-j)+1);
                    flag=1;
                    break;
                }
                if(flag>0){
                    break;
                }
            }
        }
    }
    public static boolean isPalindrome(int[]a,int l,int h){
        while (l<h){
            if(a[l]!=a[h]){
                return false;
            }
            l++;
            h--;
        }
        return true;
    }
}
