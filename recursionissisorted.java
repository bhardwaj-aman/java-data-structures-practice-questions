package RECURSION;

public class recursionissisorted {
    public static void main(String[] args){
        int[] a = new int[]{3,4,6,7,8};
        System.out.println(issorted(a,0));
    }
    public static boolean issorted(int[] n,int a){
        if(a+1==n.length-1){
            return true;
        }
        if(n[a+1]<n[a]){
            return false;
        }
        else {
            return issorted(n,a+1);
        }
    }
    }

