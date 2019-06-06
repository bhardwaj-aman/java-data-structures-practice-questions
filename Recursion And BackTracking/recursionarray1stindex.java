package RECURSION;

public class recursionarray1stindex {
    public static void main(String[] args){
        int[] a = new int[]{3,7,6,7,8};
        System.out.println(firstindex(a,9,0));
    }
    public static int firstindex(int[] n,int a,int b){
        if (b==n.length){
            return -1;

        }
        if(n[b]==a){
            return b;
        }else {
            return firstindex(n,a,b+1);
        }
    }
}
