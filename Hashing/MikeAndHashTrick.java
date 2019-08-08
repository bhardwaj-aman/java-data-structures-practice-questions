    package HashingPractice;
    import java.util.*;
    public class MikeAndHashTrick {
        public static void main(String args[]) {
            Scanner s = new Scanner(System.in);
            int a = s.nextInt();
            int[] b = new int[a];
            for (int i = 0; i < a; i++) {
                b[i] = s.nextInt();
            }
            int[] c = new int[a];
            int j=0;
            ArrayList<Integer> arr = new ArrayList<Integer>();
            for (int i=a-1;i>=0;i--){
                if(!arr.contains(b[i])){
                    c[j]=b[i];
                    j++;
                   arr.add(b[i]);
                }
            }

            for(int i=a-1;i>=0;i--){
                if(c[i]!=0)
                System.out.println(c[i]);
            }

        }
    }
    //MikeAndHashTrick