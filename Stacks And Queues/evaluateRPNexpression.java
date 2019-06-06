package stackandqueue;

import java.util.Scanner;
import java.util.Stack;

public class evaluateRPNexpression {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        String[] str1 = str.split(",");
     /*   for(int i=0;i<str1.length;i++){
            System.out.println(str1[i]);
        }*/
        Stack<String> stack =  new Stack<String>();
        for(int i=str1.length-1;i>=0;i--){
            stack.push(str1[i]);
        }
        while ((!stack.isEmpty())&&(stack.size()>1)){
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                String c = stack.pop();
                System.out.println("a is: " + a + " & bis : " + b + " c is: " + c);
                if (c.equals("+")) {
                    stack.push(a + b + "");

                }
                if (c.equals("x")) {
                    stack.push((a * b )+ "");

                }
                if (c.equals("/")) {
                    stack.push((a / b) + "");

                }
                if (c.equals("-")) {
                    stack.push((a - b) + "");
                }

            }
        System.out.println(stack.peek());
    }

}
