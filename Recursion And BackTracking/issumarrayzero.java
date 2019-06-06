package RECURSION;
import java.util.*;
public class issumarrayzero {
    public static void main(String args[]) {
        Scanner  s = new Scanner(System.in);
        int x = s.nextInt();
        int [] a = new int[x];
        for(int i=0;i<x;i++){
            a[i]= s.nextInt();
        }
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list1 = issumzero(a,0,0,list);
        Boolean b = false;
       Iterator i = list1.iterator();
       int count =0;
       while (i.hasNext()){
           if(i.next().equals(0)){
               count++;
           }
       }
       if(count>1){
           b=true;
       }
        System.out.println(b);

    }
    public static ArrayList<Integer> issumzero(int[] arr,int index,int sum,ArrayList<Integer> list ) {
        if (index > arr.length - 1) {
            //   System.out.println("sum is :"+sum+" i is: "+i);
            list.add(sum);
ArrayList<Integer> emp = new ArrayList<>();
return emp;
           // System.out.println(sum);
        }
        int a = arr[index];
        issumzero(arr,index+1,sum,list);
        // System.out.println("loop 1 - a is: "+a+ "  & index is: "+index + " & sum is: "+sum);
            //  System.out.println("loop 2 - index is: " + index + " & sum is: " + sum);
        issumzero(arr, index + 1, sum + a,list);
            // return false;
        return list;
    }

           }
