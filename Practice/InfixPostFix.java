package AmazonPractice;
import java.util.*;
public class InfixPostFix {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String a = s.next();
        Stack<String> stack = new Stack<>();
        a+=")";
        int i=0;
        stack.push("(");
        HashMap<String,Integer> priorities = new HashMap<>();
        priorities.put("-",1);
        priorities.put("+",2);
        priorities.put("*",3);
        priorities.put("/",4);
        String ans = "";
        while (!stack.isEmpty()){
            String c = a.charAt(i)+"";
           // System.out.println("checking for: "+c);
            if(c.equals("(")){
                stack.push(c);
            }else if(c.equals("+")||c.equals("-")||c.equals("*")||c.equals("/")){
                if(stack.peek().equals("+")||stack.peek().equals("-")||stack.peek().equals("*")||stack.peek().equals("/")){
                    while (priorities.get(stack.peek())>=priorities.get(c)){
                        ans+=stack.pop();
                    }
                    stack.push(c);
                } else{
                    stack.push(c);
                }
            }else if(c.equals(")")){
                while (!stack.peek().equals("(")){
                    ans+=stack.pop();
                }
                stack.pop();
            }else {
                ans+=c;
            }
            i++;
           // System.out.println(" ans is now: "+ans);
        }
        System.out.println(ans);
    }
}
//a+((b+c)+(d+e)*f)/g