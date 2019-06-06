package Sorting;

public class MergeSort {
    public static void main(String[] args){
  int[] a = new int[]{8,6,7,6,65};
  MergeSort m = new MergeSort();
       m.mergeSort(a,0,a.length-1);
       for (int i=0;i<a.length;i++){
           System.out.print(a[i]+ " ");
       }
    }
    public  void mergeSort(int[] a,int min, int max){

        if(min>=max){
            return ;
        }

     int mid = (max+min)/2;
        mergeSort(a,min,mid);
        mergeSort(a,mid+1,max);
merge2halves(a,min,max);
    }
    public void merge2halves(int[]a,int min,int max){
        int mid = (min+max)/2;
        int[] temp = new int[a.length];
        int i=0;
        int j=mid+1;
        int k=0;
        while (i<=mid&&j<=max){
            if (a[i]<a[j]){
                temp[k++]=a[i++];
            }else {
                temp[k++] = a[j++];
            }
        }
        while (i<=mid){
            temp[k++]=a[i++];
        }
        while (j<=max){
            temp[k++]=a[j++];
        }
        for (int z=min;z<=max;z++){
            a[z]=temp[z];
        }
    }

}
