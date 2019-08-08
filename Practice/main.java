package RandomPractice;

import java.util.Scanner;

class main{
    public static void main(String[] args){
        Scanner  s = new Scanner(System.in);
        int c = s.nextInt();
        int[] a = new int[c];
        for(int i=0;i<a.length;i++){
            a[i]=s.nextInt();
        }
        int xx=0;
        for (int x:a){
            if(x>xx){
                xx=x;
            }
        }
        int[] b = new int[xx+1];
        for (int x:a){
            b[x]++;
        }
        for (int i=0;i<b.length;i++){
            int mI=0;
            for (int j=0;j<b.length;j++){
                if (b[j]>b[mI]){
                    mI=j;
                }
            }
            for (int k=0;k<b[mI];k++){
                System.out.print(mI+" ");
            }
            b[mI]=0;
        }
    }
}
/* 8 2 5 2 8 5 6 8 8
 */