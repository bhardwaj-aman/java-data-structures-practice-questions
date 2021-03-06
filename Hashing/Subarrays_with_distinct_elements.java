package HashingPractice;
import java.util.*;
public class Subarrays_with_distinct_elements  {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int[] b = new int[a];
        for(int i=0;i<a;i++){
            b[i] = s.nextInt();
        }
        HashMap<Integer,ArrayList<Integer>> h = new HashMap<Integer,ArrayList<Integer>>();
       for(int i=0;i<b.length;i++){
           for(int j=i;j<b.length;j++){
               int[] arr = new int[j-i+1];
               for(int k=i;k<=j;k++){
                  arr[k-i]= b[k];
               }
               if(h.get(b[i])==null){
                   h.put(b[i],new ArrayList<Integer>());
               }
            //   System.out.println("arr is: "+arr+" & hasDuplicate is: "+hasDuplicate(arr));
               if(!hasDuplicate(arr)){
                   for (int x:arr){
                       h.get(b[i]).add(x);
                   }
               }
           }
       }
int m=0;
        for(ArrayList<Integer> x:h.values()){
            m+=x.size();
        }
        System.out.println(m);
    }

    public static boolean hasDuplicate(int[] a){

        for (int x=0;x<a.length;x++){
            for (int y=0;y<a.length;y++){
                if(x!=y&&(a[x]==a[y])){
                    return true;
                }
            }
        }
        return false;
    }
}
//Subarrays_with_distinct_elements