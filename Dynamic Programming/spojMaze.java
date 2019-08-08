package DP;
import java.util.*;
public class spojMaze {
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
            int x = maxVal(a,0,j)+a[0][j];
            if(x>max){
                max=x;
            }
        }
        return max;
    }
    public static int maxVal(int[][] a,int i,int j){
        if(i<0||i>=a.length||j<0||j>=a[0].length){
            return 0;
        }
      //  System.out.println("i: "+i+" j: "+j);
        int x=0;
        int y=0;
        int z=0;
        if(i+1<a.length)
         x = a[i+1][j]+maxVal(a,i+1,j);
        if(i+1<a.length&&j+1<a[0].length)
         y = a[i+1][j+1]+maxVal(a,i+1,j+1);
        if(i+1<a.length&&j-1>=0)
             z = a[i+1][j-1]+maxVal(a,i+1,j-1);
        return Math.max(Math.max(x,y),z);
    }
}
