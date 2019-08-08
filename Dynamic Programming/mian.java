package DP;
import java.util.*;
public class mian {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
       int c = s.nextInt();
       int[] a = new int[c];
       for(int i=0;i<c;i++){
           a[i]=s.nextInt();
       }
        System.out.println(GameStrategy(a));
    }

    public static int matrixChainMultiplication(int[] a,int i,int j,int[][] cache){
           if(i==j){
               return 0;
           }
           if(cache[i][j]!=0){
               return cache[i][j];
           }
           int ans = Integer.MAX_VALUE;
           for(int k=i;k<j;k++){
               int temp = matrixChainMultiplication(a,i,k,cache)+matrixChainMultiplication(a,k+1,j,cache)+a[i-1]*a[k]*a[j];
               ans = Math.min(temp,ans);
           }
           cache[i][j]=ans;
           return ans;
    }
    public static int mixtures(int[] a,int i,int j,int[][] cache){
        if(i==j){
            return 0;
        }
        if(cache[i][j]!=0){
            return cache[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int temp = mixtures(a,i,k,cache)+mixtures(a,k+1,j,cache)+((sum(a,i,k)%100)*(sum(a,k+1,j)%100));
        ans = Math.min(ans,temp);
        }

        cache[i][j]=ans;
        return ans;
    }
    public static int sum(int[] a,int i,int j){
        int ans = 0;
        for(int k=i;k<=j;k++){
            ans+=a[k];
        }
        return ans;
    }
  public static int minJumps(int[] a){
        int i = a.length-1;
        int count = 0;
        while (i>=0){
            if(i==0){
                break;
            }
            for(int j=0;j<i;j++){
                if(j+a[j]>=i){
                    i=j;
                    count++;
                    break;
                }
            }
        }
        return count;
  }
public static int nthUglyNumber(int n){
        int i=2;
        int counter=n-1;
    boolean[] b = new boolean[100000];
        while (true){
            if(isUglyNumber(i,b)){
                b[i]=true;
                counter--;
            }
            if(counter==0){
                return i;
            }
            i++;
        }
}
  public static boolean isUglyNumber(int i,boolean[] cache){
    //  System.out.println(" i is: "+i);
      if(cache[i]){
          return true;
      }
        if(i%2==0){
            if(i==2){
                return true;
            }else {
             boolean b = isUglyNumber(i/2,cache);
             if(b){
                 cache[i]=true;
             }
             return b;
            }
        }
      if(i%3==0){
          if(i==3){
              return true;
          }else {
              boolean b = isUglyNumber(i/3,cache);
              if(b){
                  cache[i]=true;
              }
              return b;
          }
      }
      if(i%5==0){
          if(i==5){
              return true;
          }else {
              boolean b = isUglyNumber(i/5,cache);
              if(b){
                  cache[i]=true;
              }
              return b;
          }
      }
      return false;
  }
    public static long nthFibb(int n){
        if(n==0){
            return 1;
        }
        if(n==1){
            return 2;
        }
        long[] a = new long[n+1];
        a[0]=1;
        a[1]=2;
        for(int i=2;i<=n;i++){
            a[i]=a[i-1]+a[i-2];
            System.out.println("a["+i+"] is: "+a[i]);
        }
        return a[n];
    }
    public static boolean doesSumExist(int[] a,int i,int sum,int k,boolean[] cache){

        if(i>=a.length){
            return false;
        }
        if(sum==k){
            return true;
        }
      //
        System.out.println(" removing: "+i);
        int p=i;
        boolean b1  = doesSumExist(a,i+1,sum-a[p],k,cache);
        boolean b2 = doesSumExist(a,i+1,sum,k,cache);

        return b1||b2;
    }
    public static boolean doesSumExistBottomUp(int[] a,int k){
        boolean[][] table = new boolean[a.length][k+1];
        for(int i=0;i<a.length;i++){
            table[i][0]=true;
        }
        for(int j=0;j<=k;j++){
            if(j==a[0]){
                table[0][j]=true;
            }
        }
        for(int i=1;i<a.length;i++){
            for(int j=1;j<=k;j++){
                if(j<a[i]){
                    table[i][j]=table[i-1][j];
                }else {
                    table[i][j]=(table[i-1][j]||table[i-1][j-a[i]]);
                }

            }

        }
        return table[a.length-1][k];
    }
    public static int minMoneyNeeded(int [] a,int k){
        int[][] ans = new int[a.length][k+1];
        for(int i=1;i<=k;i++){
            ans[0][i]=a[0]*(i);
        }
        for(int i=1;i<a.length;i++){
            ans[i][1]=ans[i-1][1];
        }

        for(int i=1;i<a.length;i++){
            for(int j=2;j<=k;j++){
            //    System.out.println(" i , j is: "+i+","+j);
                if(i+1>j){
                    ans[i][j]=ans[i-1][j];
                }else {
                    ans[i][j]=Math.min(ans[i-1][j],ans[i][j-(i+1)]+a[i]);
                }
            }
        }
        return ans[a.length-1][k];
    }
    public static int KnapSack(int [] a,int[] b,int k){
        int[][] ans = new int[a.length][k+1];
        for(int i=1;i<=k;i++){
            if(i<a[0]){
                ans[0][i]=0;
            }else {
                ans[0][i]=b[0];
            }
        }
        for(int i=1;i<a.length;i++){
            for(int j=1;j<=k;j++){
                //    System.out.println(" i , j is: "+i+","+j);
                if(a[i]>j){
                    ans[i][j]=ans[i-1][j];
                }else {
                    ans[i][j]=Math.max(ans[i-1][j],ans[i-1][j-a[i]]+b[i]);
                }
            }
        }
        return ans[a.length-1][k];
    }
    public static String lcs(String s1,String s2,String ans,int i,int j,String[][] cache){
       // System.out.println("s1 is: "+s1+" and s2: "+s2+" and ans: "+ans );
        if(s1.length()==0||s2.length()==0){
            return ans;
        }
       if(cache[i][j]!=null){
        //    System.out.println(" match");
            return cache[i][j];
        }
        if((s1.charAt(0)+"").equals(s2.charAt(0)+"")){
            String x = lcs(s1.substring(1),s2.substring(1),ans+s1.charAt(0),i+1,j+1,cache);
          cache[i+1][j+1]=x;
          return x;
        }
        String a = lcs(s1.substring(1),s2,ans,i+1,j,cache);
        String b = lcs(s1,s2.substring(1),ans,i,j+1,cache);
        if(a.length()>b.length()){
            cache[i+1][j]=a;
            return a;
        }else{
            cache[i][j+1]=b;
            return b;
        }
    }
    public static String lcsBottomUp(String s1,String s2){
        String[][] ans = new String[s1.length()+1][s2.length()+1];
         for(int i=0;i<ans.length;i++){
             ans[i][0]="";
         }
         for(int i=0;i<ans[0].length;i++){
             ans[0][i]="";
         }
         for(int i=1;i<ans.length;i++){
             for(int j=1;j<ans[0].length;j++){
                String x = ans[i-1][j];
                String y = ans[i][j-1];
                String z = "";
                if(x.length()>y.length()){
                    z=x;
                }
                else{
                    z=y;
                }
                if((s1.charAt(i-1)+"").equals(s2.charAt(j-1)+"")){
                   ans[i][j]=ans[i-1][j-1]+s1.charAt(i-1);
                 }else{
                    ans[i][j]=z;
                 }
             }
         }
         return ans[s1.length()][s2.length()];
    }
    private static class pair{
        int a;
        int b;
        pair(){
            this.a=this.b=0;
        }
        public String toString(){
            return "("+a+","+b+")";
        }
    }
  public static int GameStrategy(int[] a){
        pair[][] ans = new pair[a.length][a.length];
       for(int i=0;i<ans.length;i++){
           for(int j=0;j<ans.length;j++){
               ans[i][j] = new pair();
           }
       }
       for(int i=0;i<a.length;i++){
           ans[i][i].a=a[i];

       }
       for(int i=0;i<a.length-1;i++){
           ans[i][i+1].a=Math.max(a[i],a[i+1]);
           ans[i][i+1].b=Math.min(a[i],a[i+1]);
       }
       for(int k=2;k<a.length;k++){
           for(int i=0;i<a.length-k;i++){
               int x = a[i]+ans[i+1][k].b;
               int y = a[i+k]+ans[i][k-1].b;
               if(x>y){
                   ans[i][i+k].a=x;
                   ans[i][i+k].b=ans[i+1][k].a;
               }else{
                   ans[i][i+k].a=y;
                   ans[i][i+k].b=ans[i][k-1].a;
               }
           }
       }
return ans[0][ans.length-1].a;
  }
}
