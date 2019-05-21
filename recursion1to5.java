package RECURSION;

public class recursion1to5 {
    public static void main(String[] args){
        recforward(7);
    }
    public static void recforward(int n){
        if(n==0){
            return;
        }
        recforward(n-1);
        System.out.println(n);

    }
}
