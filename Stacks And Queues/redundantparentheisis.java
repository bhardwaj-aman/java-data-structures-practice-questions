package stackandqueue;
import java.util.*;
public class redundantparentheisis {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);

        String str = s.nextLine();
        Stack<Integer> stack = new Stack<Integer>();
        int flag=0;
        for(int i=0;i<str.length();i++){
            int counter=0;
            System.out.println("lngth is : "+str.length());
            System.out.println((int)str.charAt(i));
            if((int)str.charAt(i)==41){
                //   stack.pop();
                while(stack.peek()!=40){
                    counter = counter+1;
                    System.out.println("popping: "+ stack.peek() );
                    stack.pop();
                }
                stack.pop();
                if(counter==0){
                    //	System.out.println("counter 0");
                    flag++;
                }
            }else{
                int x = (int)str.charAt(i);
                //	System.out.println(x);
                stack.push(x);
            }

        }
        if(flag>0){
            System.out.println("Duplicate");
        }else{
            System.out.println("Not Duplicates");
        }




    }
}