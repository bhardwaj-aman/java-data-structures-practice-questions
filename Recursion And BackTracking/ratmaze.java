package RECURSIONPRACTICE;
import java.util.*;
public class ratmaze {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        s.nextLine();
        // System.out.println(b);
        String[] str = new String [a+1];
        // System.out.println("a is: "+a + " b is :"+b);

        for(int i=0;i<a;i++){
            str[i]=s.nextLine();

        }
        // System.out.println(str[0]);

        String[][] str2 = new String [a][b];
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                str2[i][j]=str[i].substring(j,j+1);
            }
        }
        int[][] abc= new int[a][b];
        ratpath(str2,0,0,a-1,b-1,abc,0);

    }
    public static void ratpath(String[][] str, int a , int b,int r,int c,int[][] str2,int i){
        //System.out.println(" *************** str["+a+"]"+"["+b+"]");
        if(isitsafe(str,a,b,r,c)==false){
          //  System.out.println(" *************** str["+a+"]"+"["+b+"] fail" );
            return;
        }
        if((a==r)&&(b==c)){
            str2[r][c]=1;
            printit(str2,r,c);
            return;
        }

        str2[a][b]=1;
        str[a][b]="X";
        ratpath(str,a+1,b,r,c,str2,i+1);
        ratpath(str,a-1,b,r,c,str2,i+1);
        ratpath(str,a,b+1,r,c,str2,i+1);


        ratpath(str,a,b-1,r,c,str2,i+1);
        str2[a][b]=0;
        str[a][b]="O";
    }
    public static boolean isitsafe(String[][]str , int a , int b,int r,int c){
 //      System.out.println(" *************** str["+a+"]"+"["+b+"]");
        if((a>r)||(a<0)||(b>c)||(b<0)||(str[a][b].equals("X"))){
       //     System.out.println(" *************** str[a][b] fail---------------");
            return false;
        }
        return true;
    }

    public static void printit(int[][] a,int r,int c){
        for(int i=0;i<=r;i++){
            for(int j=0;j<=c;j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("*********");
    }
}
