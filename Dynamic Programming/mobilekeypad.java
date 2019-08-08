package DP;
import java.util.*;
public class mobilekeypad {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
  HashMap<String,String>map = new HashMap<>();
  map.put("0"," ");
  map.put("1",".+@$");
    map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");
        ArrayList<String> arr =new ArrayList<>();
        printString(str,0,"",str.length());

    }
    public static ArrayList<String> keyPad(HashMap<String,String> map,String ans,String s,ArrayList<String> arr,int i){
       if(i==s.length()){
           arr.add(ans);
           return arr;
       }
       ArrayList<String> b = new ArrayList<>();
        for(int j=0;j<map.get(s.charAt(i)+"").length();j++){
        b = keyPad(map,ans+map.get(s.charAt(i)+"").charAt(j),s,arr,i+1);
    for(String x:b){
        if(!arr.contains(x)){
            arr.add(x);
        }
    }
       }
       return arr;
    }
    public static ArrayList<String> keypad2(HashMap<String,String> map,String s,int i,ArrayList<String> arr,String curr){
        if(i==s.length()){
            arr.add(curr);
            return arr;
        }

       // System.out.println(" i is: "+i);
ArrayList<String> ans = new ArrayList<>();
        for(int j=0;j<map.get(s.charAt(i)+"").length();j++){
           // System.out.println(" j is: "+j);
           ans=  keypad2(map,s,i+1,arr,curr+map.get(s.charAt(i)+"").charAt(j));
        }
        return ans;
    }
  public static void printString(String s,int i,String curr,int k){

        if(curr.length()==k){
           System.out.println(curr);
            return;
        }
     // System.out.println("i is: " +i);
            for (int j=0;j<s.length();j++){

                    printString(s.substring(0,j)+s.substring(j+1),i+1,curr,k);
                printString(s,i+1,curr+s.charAt(j),k);
            }

            }

  }
