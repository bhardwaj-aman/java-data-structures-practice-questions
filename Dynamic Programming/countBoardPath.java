package DynamicPrograming;

import java.util.Scanner;

public class countBoardPath{
    public static int numBoardPathsItr(int[] count,int a){
        count[a]=1;
        count[a-1]=1;
        for(int i=a-2;i>=0;i--){
            for(int j=1;j<=6;j++){
                 if(i+j<=a){
                     count[i]+=count[i+j];
                 }
            }
        }
        return count[0];
    }
    public static int numboardpathsRec(int[] count,int a,int end){
        if(a==end){
            return 1;
        }
        if(a>end){
            return 0;
        }
        if(count[a]!=0){
            return count[a];
        }
        int c=0;
        for(int i=1;i<=6;i++){
          c+=numboardpathsRec(count,a+i,end);
        }
        count[a]=c;
        return c;
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int[] count = new int[a+1];
        System.out.println(numboardpathsRec(count,0,a));
    }
}
