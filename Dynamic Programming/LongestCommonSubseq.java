package DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class LongestCommonSubseq {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String a = s.nextLine();
     String[] fin = makeStringArray(a);
     System.out.println(infixtoPostfix(fin));
    }
public static String[] makeStringArray(String a){
    char[] ans = a.toCharArray();
    ArrayList<String> b = new ArrayList<>();
    int i=0;
    while (i<a.length()){
        if(ans[i]>='0'&& ans[i]<='9'){
            StringBuffer sb = new StringBuffer();
            while (i<a.length()&&ans[i]>='0'&&ans[i]<='9'){
                sb.append(ans[i]);
                i++;
            }
         //   System.out.println("added "+sb.toString());
            b.add(sb.toString());
        }else if(ans[i]== ' ') {
            i++;
        }else
        {
         //   System.out.println(" added: "+ans[i]);
            b.add(ans[i]+"");
            i++;
        }
    }
    String[] fin = new String[b.size()];
    int y=0;
    for(String x: b){
        fin[y]=x;
        y++;
    }
    return fin;
}
    public static int lcs(String s1, String s2, int i, int j) {
        if (i >= s1.length() || j >= s2.length()) {
            return 0;
        }
        if ((s1.charAt(i) + "").equals(s2.charAt(j) + "")) {
            return lcs(s1, s2, i + 1, j + 1) + 1;
        }
        return Math.max(lcs(s1, s2, i + 1, j), lcs(s1, s2, i, j + 1));

    }

    public static int[][] lcsBottomUp(String s1, String s2) {
        int[][] ans = new int[s1.length() + 1][s2.length() + 1];
        int x = s1.length();
        int y = s2.length();
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if ((s1.charAt(i - 1) + "").equals(s2.charAt(j - 1) + "")) {
                    ans[i][j] = ans[i - 1][j - 1] + 1;
                } else {
                    ans[i][j] = Math.max(ans[i - 1][j], ans[i][j - 1]);
                }
            }
        }
        return ans;
    }

    public static int[] LongestIncreasingSubSeq(int[] a) {
        int[] ans = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            ans[i] = 1;
        }
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    ans[i] = Math.max(ans[i], ans[j] + 1);
                }
            }
        }
        return ans;
    }

    public static int longestPalindromic(String s, int calls) {
        if (s.length() == 2 && (s.charAt(0) + "").equals(s.charAt(1) + "")) {
            System.out.println(s.charAt(0) + " & " + s.charAt(s.length() - 1) + " matched");
            return 2;
        }
        if (s.length() == 1) {
            return 1;
        }
        //  System.out.println(" calls is: "+calls);
        if ((s.charAt(0) + "").equals(s.charAt(s.length() - 1) + "")) {
            System.out.println(s.charAt(0) + " & " + s.charAt(s.length() - 1) + " matched");
            return longestPalindromic(s.substring(1, s.length() - 1), calls + 1) + 2;
        } else {
            System.out.println(s.charAt(0) + " & " + s.charAt(s.length() - 1) + " didnt match");
            return Math.max(longestPalindromic(s.substring(0, s.length() - 1), calls + 1), longestPalindromic(s.substring(1, s.length()), calls + 1));
        }
    }

    public static boolean sunsetSum(int[] a, int m, int sum, int index, String s) {
        if (index == a.length) {
            return false;
        }
        if (sum == m) {
            System.out.println(s);
            return true;
        }
        System.out.println(" including : " + a[index]);
        boolean include = sunsetSum(a, m, sum + a[index], index + 1, s + " " + a[index]);
        System.out.println(" excluding: " + a[index]);
        boolean exclude = sunsetSum(a, m, sum, index + 1, s);
        return include || exclude;
    }

    public static int[] minCoinsToMakeChange(int[] coins, int m) {
        int[] ans = new int[m + 1];
        for (int i = 1; i < ans.length; i++) {
            ans[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    ans[i] = Math.min(ans[i], ans[i - coins[j]] + 1);
                }
            }
        }
        return ans;
    }

    public static int minCoinsToMakeChangeTopDown(int[] coins, int difference, int i,int[] ans) {
        if (difference - coins[i] < 0) {
            return 0;
        }
        if(ans[difference-coins[i]]!=0){
            System.out.println(" table match!! for difference: "+difference);
            return ans[difference-coins[i]];
        }
        System.out.println(" difference is: "+difference);
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < coins.length; j++) {
            int x=minCoinsToMakeChangeTopDown(coins, difference - coins[i], j, ans) + 1;
            System.out.println(" x for "+coins[i]+ " is: "+ x);
            if (min > x) {
                min = x;
            }

        }
        ans[difference-coins[i]]=min;
        return min;
    }
    public static int[][] SumMatrix(int[][] a){
        int x = a[0].length;
        int y = a.length;
        int[][] ans = new int [x+1][y+1];
        for(int i=0;i<=x;i++){
            ans[0][i]=0;
        }
        for(int j=0;j<=y;j++){
            ans[j][0]=0;
        }
        for(int i=1;i<=x;i++){
            ans[1][i]=ans[1][i-1]+a[0][i-1];
        }
        for(int j=1;j<=y;j++){
            ans[j][1]=ans[j-1][1]+a[j-1][0];
        }
        for(int i=2;i<=x;i++){
            for(int j=2;j<=y;j++){
                ans[i][j]=a[i-1][j-1]+ans[i][j-1]+ans[i-1][j]-ans[i-1][j-1];
            }
        }
        return  ans;
    }
    public static String maxSumIncreasingSubseq(int[] a){
      int[] b = new int[a.length];
      for(int i=0;i<a.length;i++){
          b[i]=a[i];
      }
      int[] c = new int[a.length];
      for(int i=1;i<a.length;i++){
          for(int j=0;j<i;j++){
              if(a[i]>a[j]){
                  if(b[i]<b[j]+a[i]){
                      b[i]=b[j]+a[i];

                      c[i]=j;
                  }
              }
          }
      }
      int max=0;
      int ind = 0;
      for(int i=0;i<b.length;i++){
          if(max<a[i]){
              max=a[i];
              ind=i;
          }
      }
      String ans = makeString("",a,b,ind);
      return ans;

    }
    public static String makeString(String ans,int[] a,int[] b,int start){
                      if(start==-1){
                          return ans;
                      }
                      ans+=a[start];
                      int x = b[start]-a[start];
                      int n=-1;
                      for(int i=0;i<b.length;i++){
                          if(b[i]==x){
                              n=i;
                          }
                      }
                      ans+=makeString(ans,a,b,n);

                      return ans;
    }
    private static class kadanesPair{
        int data;
        int start;
        int end;
        kadanesPair(int d){
            this.data=d;
        }
public String toString(){
            return " data: "+data+" start: "+start+" end: "+ end;
}

    }

    public static kadanesPair kadanes(int[] a){
        kadanesPair[] ans = new kadanesPair[a.length];
        for(int i=0;i<a.length;i++){
            ans[i] = new kadanesPair(a[i]);
            ans[i].start=ans[i].end=i;
        }
        for(int i=1;i<a.length;i++){
            if(ans[i].data<ans[i-1].data+a[i]){
                ans[i].data= ans[i-1].data+a[i];
                ans[i].start=ans[i-1].start;
            }
        }
        kadanesPair max=new kadanesPair(0);
        for(kadanesPair i:ans){
          //  System.out.println("data - "+i.data+" start - "+i.start+" end- "+i.end);
            if(i.data>max.data){
                max=i;
            }
        }

        return max;
    }
   public static int solve(String s){
        int i=0;
       HashMap<String,Integer> map = new HashMap<>();
       map.put("+",2);
       map.put("-",1);
       map.put("*",3);
       map.put("/",4);
       Stack<Integer> s1 = new Stack<>();
       Stack<String> s2 = new Stack<>();
       while (i<s.length()){
           String x = s.charAt(i)+"";
           System.out.println(" x is: "+x);
           if(x.equals("+")||x.equals("-")||x.equals("*")||x.equals("/")){
              if(s2.isEmpty()){
                  s2.push(x);
                  System.out.println("initially pushed: "+x);
              }else {
                  int j=i;
                  while (!s2.isEmpty()&&map.get(x) <= map.get(s2.peek())&&j<s.length()) {
                          System.out.println(" in loop 1- j is: " + j);
                          String y = s2.pop();
                          int a = s1.pop();
                          System.out.println(" a is: " + a);
                          int b = s1.pop();
                          System.out.println(" b is: " + b);
                          int c = 0;
                          if (y.equals("+")) {
                              c = b + a;
                          } else if (y.equals("-")) {
                              c = b - a;
                          } else if (y.equals("*")) {
                              c = b * a;
                          }
                          s1.push(c);
                          System.out.println("pushed : " + c);
                          j++;

                  }
                  s2.push(x);
                 System.out.println(" pushed: "+x);
              }
           }else{
               System.out.println(" pushed  "+x);
               s1.push(Integer.parseInt(x));
           }
           i++;
       }
       while (!s2.isEmpty()){
           String z = s2.pop();
           System.out.println(" z is : "+z);
           int a = s1.pop();
           System.out.println("a is: " +a);
           int b = s1.pop();
           System.out.println(" b is: "+b);
           int c=0;
           if(z.equals("+")){
               c=b+a;
           }else if(z.equals("-")){
               c=b-a;
           }else if(z.equals("*")){
               c=b*a;
           }else {
               c=b/a;
           }
           System.out.println(" c is: "+c);
           s1.push(c);
       }
       return s1.peek();
   }
   public static String infixtoPostfix(String[] infix){
       String ans = "";
       String[] n = new String[infix.length+1];
       int i=0;
       for(String s: infix){
           n[i]=s;
           i++;
       }
       n[i]=")";
       HashMap<String,Integer> map = new HashMap<>();
       map.put("+",2);
       map.put("-",1);
       map.put("*",3);
       map.put("/",4);
        int j=0;
       Stack<String> s = new Stack<>();
       s.push("(");
       while (!s.isEmpty()){
           String x=n[j];
           System.out.println(" x is :"+x);
           if(x.equals("+")||x.equals("*")||x.equals("-")||x.equals("/")){
               System.out.println(" map get x is: "+map.get(x));
               System.out.println(" peek is: "+s.peek());
               while (map.get(s.peek())!=null&&!s.isEmpty()&&map.get(x)<=map.get(s.peek())){
                   String y = s.pop();
                   ans+=y;
               }
               s.push(x);
           }else if(x.equals(")")){
               while (!s.peek().equals("(")){
                   ans+=s.pop();
               }
               s.pop();
           }else if(x.equals("(")){
               s.push(x);
           }
           else {
               ans+=x;
           }
           j++;
       }
       return ans;
   }
   public static int solvePostFix(String[] a){
        int i=0;
        Stack<String> s = new Stack<>();
        while (i<a.length){
            if(a[i].equals("+")||a[i].equals("-")||a[i].equals("*")||a[i].equals("/")){
         //       System.out.println(" popping: "+s.peek());
                int x = Integer.parseInt(s.pop());
           //     System.out.println(" popping: "+s.peek());
                int y = Integer.parseInt(s.pop());
                int z=0;
                if(a[i].equals("+")){
                    z=x+y;
                } if(a[i].equals("-")){
                    z=y-x;
                } if(a[i].equals("*")){
                    z=y*x;
                } if(a[i].equals("/")){
                    z=y/x;
                }
                s.push(z+"");
            }else{
                s.push(a[i]);
            }
            i++;
        }
       return Integer.parseInt(s.pop());
   }

}


/*
abcdaf
acbcf
*/
        /*7
        4 6 1 3 8 4 6*/
//25 * 44 - 78 + 1
