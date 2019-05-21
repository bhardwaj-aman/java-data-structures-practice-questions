import java.util.*;

public class pattern18 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        for(int i=a/2;i>=0;i--){
            for(int j=0;j<i;j++){
                System.out.print("  ");
            }

        }
    }
}
