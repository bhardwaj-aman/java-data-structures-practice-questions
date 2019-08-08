package mettl;
import java.util.*;
public class practice {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int l = s.nextInt();
        int h = s.nextInt();
        int size = s.nextInt();
        ArrayList<String> arr = new ArrayList<>();
        neckLace(l,h,size,"",arr);
        System.out.println(arr.size()+size-1);
    }
    public static void neckLace(int l,int h,int size,String ans,ArrayList<String>arr){
       // System.out.println(" l: "+l+" h: "+h+" size: "+size);
     if(l>h){
         return;
     }
        if(size==0){
         if(!arr.contains(ans)){
             arr.add(ans);
             System.out.println(ans);
         }

            return;
        }
        ans+=l;
        for(int i=0;i<=(h-l);i++){
            neckLace(l+i,h,size-1,ans,arr);
        }
        neckLace(l+1,h,size,"",arr);
    }
}
