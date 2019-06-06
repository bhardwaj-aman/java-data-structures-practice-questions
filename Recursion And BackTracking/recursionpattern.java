package RECURSION;

public class recursionpattern {

    public static void main(String[] args) {
        pattern(1,1 , 5);
    }

    public static void pattern(int r, int c, int n) {
        if (r > n) {
           return;
        }
        if (c > r) {
            System.out.println("");
            pattern(r + 1, 1, n);
            return;
        }

        System.out.print("*");
        pattern(r, c + 1, n);


    }
}