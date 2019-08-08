package AmazonPractice;

import java.util.Scanner;

public class TwoDkadane {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b=s.nextInt();
        int[][] c = new int[a][b];
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                c[i][j]=s.nextInt();
            }
        }
        System.out.println(TwodKadane(c));
    }
    private static class kadanePair{
        int start;int end;int data;
        kadanePair(){
            this.data=0;
            this.start=0;
            this.end=0;
        }
        kadanePair(int data){
            this.data=data;
            this.end=this.start=this.data;
            this.start=0;
        }
        public String toString(){
            return " data : "+data+" start: "+start+" end: "+end;
        }
    }
    public static kadanePair kadane(kadanePair[] a){
        kadanePair[] ans = new kadanePair[a.length];
        for(int i=0;i<a.length;i++){
            ans[i]=new kadanePair(a[i].data);
        }
        kadanePair max = new kadanePair();
        for(int i=1;i<a.length;i++){
            if(ans[i].data<ans[i-1].data+a[i].data){
                ans[i].data=ans[i-1].data+a[i].data;
                ans[i].start=ans[i-1].end;
            }
            if(ans[i].data>max.data){
                max=ans[i];
            }
        }
        return max;
    }
    public static int kadane(int[] a){
        int[] ans = new int[a.length];
        for(int i=0;i<a.length;i++){
            ans[i]=a[i];
        }
        int max=0;
        for(int i=1;i<a.length;i++){
            if(ans[i]<ans[i-1]+a[i]){
                ans[i]=ans[i-1]+a[i];

            }
            if(ans[i]>max){
                max=ans[i];
            }
        }
        return max;
    }
    public static int TwodKadane(int[][] a){

         int maxSum=0;
         for (int j=0;j<a[0].length;j++){
             int[] temp = new int[a.length];
             for (int k=j;k<a[0].length;k++) {
                 for (int i = 0; i < a.length; i++) {
                     temp[i] += a[i][k];
                     }
                     int x = kadane(temp);
                     if (x > maxSum) {
                         maxSum = x;
                 }
             }
         }
         return maxSum;
    }
}
