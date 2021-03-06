package stackandqueue;

import java.util.Scanner;
import java.util.Stack;

public class BuildingsWithSunsetView {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        Stack<Integer> stack = new Stack<Integer>();
        int a = s.nextInt();
        int[] b = new int[a];
        for(int i=0;i<a;i++){
            b[i]= s.nextInt();
        }
        /*for(int i=a-1;i>=0;i--){
            System.out.println(b[i]);
        }*/

        for(int i=a-1;i>=0;i--){
            while ((stack.isEmpty()==false)&&(b[i]>=stack.peek())){
                stack.pop();
            }
            stack.push(b[i]);
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
