package RECURSIONPRACTICE;

import java.util.ArrayList;
import java.util.Scanner;
/* Idea is - we either select an element , or we dont select it
   so for every element, we first add it to power set, then explore the function,
   and then we remove the element, and explore without that element.
   We have a full powerset, which stores all found subsets.
  we increase the counter till it reaches end of input array, and hence we backtrack, coz even if we
   backtrack at a step, the counter is still at the same value, which allows us to add other,new  values.
 */
public class generatepowerset {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int[] b = new int[a];
        for(int i=0;i<a;i++){
            b[i] = s.nextInt();
        }
        ArrayList<ArrayList<Integer>>powersetx = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> curr = new ArrayList<Integer>();
        powerset(powersetx,curr,0,b);
        System.out.println(powersetx);
    }
    public static void   powerset(ArrayList<ArrayList<Integer>>powerset,ArrayList<Integer>current,int i,int[]a){
       //if i reaches end of array, we add the entire current array to the powerset.
        if(i==a.length){

            powerset.add(new ArrayList<>(current));
            return ;
        }
        // here we select an element
        current.add(a[i]);
         powerset(powerset,current,i+1,a);
         //here we deselect it
         current.remove(current.size()-1);
         powerset(powerset,current,i+1,a);
    }
}
