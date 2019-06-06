package stackandqueue;

import java.util.Scanner;
import java.util.Stack;

public class histogramarea {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int[] b = new int[a];
        for (int i = 0; i < a; i++) {
            b[i] = s.nextInt();
        }
        int maxarea = 0;
        Stack<Integer> stack = new Stack<Integer>();
     //   stack.push(0);
        int i=0;
        while ( i < a) {
          //  System.out.println("stack.peek() is: " + b[stack.peek()] + " b[i] is:  " + b[i]);
            if ((!stack.isEmpty())&& (b[stack.peek()] > b[i]) ){
                System.out.println("loop 0");
                int d = stack.pop();
                int c = b[d];
                if (!stack.isEmpty()) {
                    System.out.println("loop 1");
                    if (c * (i - stack.peek() - 1) > maxarea) {
                        System.out.println("loop 2");
                        maxarea = c * (i - stack.peek() - 1);

                    }
                } else {
                    System.out.println("loop 3");
                    if ((c * i) > maxarea) {
                        System.out.println("loop 4");
                        maxarea = c * i;
                    }
                }
            }
            else {

                stack.push(i++);
                System.out.println("stack top is now: " + stack.peek());

            }

        }
        while (!stack.isEmpty()) {
            int d = stack.pop();
            System.out.println("d is: "+d+ " & z is : "+i);
            int c = b[d];
            System.out.println("c is : "+c);
            if (!stack.isEmpty()) {
                System.out.println("loop 1");
                System.out.println("stack peek is: "+stack.peek());
                if (c * (i - stack.peek()-1) > maxarea) {
                    System.out.println("loop 2");
                    maxarea = c * (i - stack.peek() - 1);

                }
            } else {
                System.out.println("loop 3");
                if ((c * i) > maxarea) {
                    System.out.println("loop 4");
                    maxarea = c * i;
                }
            }

        }

        System.out.println(maxarea);
    }
}
