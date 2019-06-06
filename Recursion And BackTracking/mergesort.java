package RECURSIONPRACTICE;

public class mergesort{
    public static void main(String[] args) {
        int[] a = new int[5];
        for (int i = 0; i < a.length; i++) {
            a[i] = 50-(10*i);
        }
        bubblesort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+ " -> ");
        }
    }
    public static void bubblesort(int[] a){
        for(int i=0;i<a.length-1;i++){
            for(int j=0;j<a.length-1;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j+1];
                    a[j+1]=a[j];
                    a[j]=temp;
                }
                for (int k = 0; k < a.length; k++) {
            //        System.out.print( a[k]+ " -> ");
                }
              //  System.out.println("");
            }
        }
    }
}
