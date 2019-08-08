package DP;
import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        for(int k=0;k<x;k++) {
            int a = s.nextInt();
            int b = s.nextInt();
            int[][] c = new int[a][b];
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < b; j++) {
                    c[i][j] = s.nextInt();
                }
            }
            System.out.println(stones(c));
        }
    }
    public static int stones(int[][] a){
        int max=0;
        for(int j=0;j<a[0].length;j++){
            int[][] ans = new int[a.length][a[0].length];
            int x = maxVal(a,0,j,ans)+a[0][j];
            if(x>max){
                max=x;
            }
        }
        return max;
    }
    public static int maxVal(int[][] a,int i,int j,int[][] ans){
        if(i<0||i>=a.length||j<0||j>=a[0].length){
            return 0;
        }
        if(ans[i][j]!=0){
          //  System.out.println("match for: "+i+","+j);
            return ans[i][j];
        }
        //  System.out.println("i: "+i+" j: "+j);
        int x=0;
        int y=0;
        int z=0;
        if(i+1<a.length)
            x = a[i+1][j]+maxVal(a,i+1,j,ans);
        if(i+1<a.length&&j+1<a[0].length)
            y = a[i+1][j+1]+maxVal(a,i+1,j+1,ans);
        if(i+1<a.length&&j-1>=0)
            z = a[i+1][j-1]+maxVal(a,i+1,j-1,ans);
        int p=Math.max(Math.max(x,y),z);
        ans[i][j]=p;
        return p;
    }
    public static int maxval2(int[][] a){
        int[][] ans = new int[a.length][a[0].length];
        for(int j=0;j<a[0].length;j++){
            ans[0][j] = a[0][j];
        }
        for(int i=1;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                int x=0;
                int y=0;
                int z=0;
                 x = ans[i-1][j];
                 if(j+1<a[0].length){
                     y  = ans[i-1][j+1];
                 }
                 if(j-1>0){
                     z = ans[i-1][j-1];
                 }
                 ans[i][j] = a[i][j]+Math.max(Math.max(x,y),z);
            }
        }
        int max=0;
        for(int j=0;j<a[0].length;j++){
            if(ans[a.length-1][j]>max){
                max = ans[a.length-1][j];
            }
        }
        return max;
    }
}
