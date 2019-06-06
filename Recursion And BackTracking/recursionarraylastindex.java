package RECURSION;

public class recursionarraylastindex {
    public static void main(String[] args) {
        int[] a = new int[]{3, 7, 6, 7, 8};
        System.out.println(lastindex(a, 3, 0));
    }

    public static int lastindex(int[] n, int a, int b) {

        if(b==n.length){
            return -1;
        }
        int index = lastindex(n,a,b+1);
        if(index==-1)/*has not been found yet*/
        {
            if(n[b]==a){
                return b;
            }
            else {
                return -1;
            }
        }
        else {
            return index;
        }
    }
}