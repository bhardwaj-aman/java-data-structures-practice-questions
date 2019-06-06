package RECURSION;

public class recursionpower {
    public static void main(String[] args){
        System.out.println(power(7,3));
    }
    public static int power(int n,int k){
        if(k==1){
            return n;
        }
        return (n*power(n,k-1));
}
}
