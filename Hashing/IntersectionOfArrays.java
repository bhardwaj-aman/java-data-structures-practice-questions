package HashingPractice;
import java.util.*;
public class IntersectionOfArrays {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int[] b = new int[a];
        int[] c = new int[a];
        for(int i=0;i<a;i++){
            b[i]=s.nextInt();
        }
        for(int i=0;i<a;i++){
            c[i]=s.nextInt();
        }
        HashMap<Integer,Integer> h1 = new HashMap<Integer,Integer>();
        for(int i=0;i<b.length;i++){
            if(h1.get(b[i])!=null){
                int x = h1.get(b[i]);
                h1.remove(b[i]);
                h1.put(b[i],x+1);
            }else{
                h1.put(b[i],1);
            }
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<a;i++){
            if(h1.get(c[i])!=null) {
                if (h1.get(c[i]) > 0) {
                    int x = h1.get(c[i]);
                    h1.remove(c[i]);
                    h1.put(c[i], x - 1);
                         arr.add(c[i]);
                }
            }
        }
        Collections.sort(arr);
        System.out.println(arr);
    }
}

//IntersectionOfArrays