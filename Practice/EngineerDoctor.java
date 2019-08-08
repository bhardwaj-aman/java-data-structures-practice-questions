package RandomPractice;

import java.util.*;
public class EngineerDoctor {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int c = s.nextInt();
        int d = s.nextInt();
        Queue<String> q = new LinkedList<>();
        q.add("e");
        int max = (int)Math.pow(2,c)-1+d;
      //  System.out.println("max is: "+max);
        int number=0;
        while (!q.isEmpty()){
            String str = q.remove();
            number++;
            if(number==max){
              //  System.out.println(number+"******");
                System.out.println(str);
                break;
            }
            if(str.equals("e")){
                q.add("e");
                q.add("d");
            }else{
                q.add("d");
                q.add("e");
            }
        }
    }
}
