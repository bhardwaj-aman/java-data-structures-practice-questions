import java.util.*;

public class pattern17 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        for(int i=a/2;i>=0;i--){
            for(int j=0;j<i;j++){
                System.out.print("*" + " ");
            }
            for(int j=0;j<(((a/2)-i)*4+1);j++){
              //  System.out.print("i is "+i);
                System.out.print(" ");
            }
            for(int j=0;j<i;j++){
                System.out.print(" *");
            }
            System.out.println("");
    }
        for(int i=1;i<=a/2;i++){
            for(int j=0;j<i;j++){
                System.out.print("*" + " ");
            }
            for(int j=0;j<(((a/2)-i)*4+1);j++){
                //  System.out.print("i is "+i);
                System.out.print(" ");
            }
            for(int j=0;j<i;j++){
                System.out.print(" *");
            }
            System.out.println("");
        }
    }
}
