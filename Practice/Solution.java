package amex;
import java.util.*;

class Solution {
    public static int ships(int i,int m){
        Queue<Integer> q  = new LinkedList<>();
        q.add(2);
        q.add(-1);
        int count=0;
        int level=0;
        while (level<=i){
            int x = q.remove();
            //System.out.println("x: "+x);
            if(x==-1){
                level++;
                q.add(-1);
            }else {
                count++;
                for (int j = 0; j < ((x * x) + 1) % m; j++) {
                    q.add(j);
                }
            }
        }
        return count%m;
    }
    public static int[] chocolates(int n,int k){
        int[] ans = new int[k];
        int i=1;
        while(n>0){
            if(n>=i) {
                ans[(i - 1) % k] += (i);
            }else{
                ans[(i - 1) % k] +=n;
            }
          //  System.out.println(" ans["+(i-1)%k+"] = "+ans[(i-1)%k]);
            n=n-(i);
           // System.out.println("i: "+i+" n: "+n);
            i++;
        }
        return ans;
    }
    public static boolean isSafe(String s,String p,int j,int k){
        if(j>k){
            return false;
        }
        System.out.println(" s: "+s+" p: "+p);
        if(s.equals(p)){
            return true;
        }
        boolean x=false;
        for(int i=0;i<s.length()-2;i++){
            for(int m=i+2;m<s.length();m+=2) {
          //        System.out.println(" i: "+i+" & m: "+m+" for s: "+s);
                if (isSafe(swap(s, i,m), p, j + 1, k)) {
                    x = true;
                }
            }
        }
        return x;
    }
    public static String swap(String s,int i,int j){
        String rev = "";
        int x=j;
        while (x>=i){
            rev+=s.charAt(x);
            x--;
        }
        return s.substring(0,i)+rev+s.substring(j+1);
    }
    public static boolean isPalindrome(String s){
        int i=0;
        int j=s.length()-1;
        while (i<j){
            if(!(s.charAt(i)+"").equals(s.charAt(j)+"")){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public  static int min(String s,int j,int k ,int count){
        System.out.println(" s : "+s+" count: "+count);
        if(j==k){
   return Integer.MAX_VALUE;
        }
        if(isPalindrome(s)){
            System.out.println(s);
            return count;
        }
        int d=Integer.MAX_VALUE;
        for(int i=0;i<k;i++){
     int x = min(swap(s,i,i+1),j+1,k,count+1);
     if(x<d){
         d=x;
     }
        }
        return d;
    }
    public static int distinct(String[] a){
        int counter=0;
        ArrayList<String> arr = new ArrayList<>();
        for(String x: a){
            arr.add(x);
            }
            for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                if(isSafe(a[i],a[j],0,a[i].length()-2)){
                    if(arr.contains(a[j]))
                    arr.remove(a[j]);
                }
            }
            }
        return arr.size();
    }
    public static long largestK(String s,long max,int k,int j){
      //  System.out.println("s: "+s+" max: "+max+" k: "+k+" j: "+j);
        if(j>k){
            return max;
        }
        if(Long.parseLong(s)>max){
            max = Long.parseLong(s);
        }
        long ans =0;
       // System.out.println("max is now: "+max);
        for(int i=0;i<s.length()-1;i++){
            for(int z=i+1;z<s.length();z++) {
                 if((Integer.parseInt(s.charAt(z)+""))>(Integer.parseInt(s.charAt(i)+""))){
                long x = largestK(swap(s, i, z), max, k, j + 1);
                if (x > ans) {
                    ans = x;
                }
                //  s=swap(s,i,z);
            }
            }
        }
        return Math.max(max,ans);
    }
public static int[][] solve(int[][] a) {
    ArrayList<Integer> arr = new ArrayList<>();
    HashMap<Integer, int[]> map = new HashMap<>();
    for (int i = 0; i < a.length; i++) {
        arr.add(a[i][1]);
        map.put(a[i][1], a[i]);
    }
    Collections.sort(arr);
    for (int i = 0; i < a.length; i++) {
        a[i] = map.get(arr.get(i));
    }
    return a;
}
public static void isInterleaving(HashMap<String,Boolean> map,String s,String curr){
        if(s.length()==0){
            if(map.containsKey(curr)){
                map.put(curr,true);
            }
         //   System.out.println(curr);
            return;
        }
        String x = s.charAt(0)+"";
           String ros = s.substring(1);
           isInterleaving(map,ros,curr+x);
           isInterleaving(map,ros,curr);
}
public static boolean isRotation(String a,String b){
        HashMap<String,String> map1  = new HashMap<>();
        HashMap<String,String> map2 = new HashMap<>();
        for(int i=0;i<a.length()-1;i++){
            map1.put(a.charAt(i)+"",a.charAt(i+1)+"");
        }
        map1.put(a.charAt(a.length()-1)+"",a.charAt(0)+"");
    for(int i=0;i<b.length()-1;i++){
        map2.put(b.charAt(i)+"",b.charAt(i+1)+"");
    }
    map2.put(b.charAt(b.length()-1)+"",b.charAt(0)+"");
    for(String x: map1.keySet()){
        if(!map2.containsKey(x)){
            return false;
        }
        if(!(map2.get(x).equals(map1.get(x)))){
            return false;
        }
    }
    return true;
}
public static int invcount(int[] a){
        int count=0;
        for (int i=0;i<a.length-1;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[j]<a[i]){
                    count++;
                }
            }
        }
        return count;
}
public static int rcmax(int[][] a){
        int r=0;
        int c=0;
        for(int i=0;i<a.length;i++){
            int temp=0;
            for(int j=0;j<a[0].length;j++){
                temp+=a[i][j];
            }
            if(temp>r){
                r=temp;
            }
        }
    for(int i=0;i<a[0].length;i++){
        int temp=0;
        for(int j=0;j<a.length;j++){
            temp+=a[j][i];
        }
        if(temp>c){
            c=temp;
        }
    }
    return r+c;
}
    public static void main(String[] args){
   int[][] a = new int[][]{{1,2},
           {5,6}};
        System.out.println(rcmax(a));
        }
    }
