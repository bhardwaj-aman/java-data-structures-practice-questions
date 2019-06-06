package RECURSION;

public class pdiskip {
    public static void main(String[] args){
        recforward(777);
    }
    public static void recforward(int n){
        if(n==0){
            return;
        }
        if(n%2==1){
            System.out.println(n);
        }
        recforward(n-1);
      //  System.out.println(n);
        if(n%2==0){
            System.out.println(n);
        }
    }
}
