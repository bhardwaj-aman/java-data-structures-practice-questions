package RECURSION;

public class recursion5to1 {
    public static void main(String[] args){
        recforward(7);
    }
    public static void recforward(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        recforward(n-1);
    }
}
