import java.util.*;

public class pattern15 {
    public static void main(String[] args){
 Scanner s = new Scanner(System.in);
int a = s.nextInt();
for(int i=a;i>0;i--){
    for(int j=0;j<(a-i)*4;j++ ){
    System.out.print(" ");
}
    for(int j=0;j<i;j++){
        System.out.print("*" + " ");

    }

    System.out.println("");

}
        for(int i=2;i<=a;i++){
            for(int j=0;j<(a-i)*4;j++ ){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*" + " ");

            }

            System.out.println("");

        }
    }
}
