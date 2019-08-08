package AmazonPractice;
import java.util.*;
public class DPpractice2 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
       int a = s.nextInt();
       int[] b = new int[a];
       for(int i=0;i<a;i++){
           b[i]=s.nextInt();
       }
        System.out.println(towerHopper(b));
    }

    public static void display(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static int RodCutting(int[] lengths, int[] values, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < lengths.length; i++) {
            map.put(lengths[i], values[i]);
        }
        System.out.println(" map is: ");
        int[][] ans = new int[values.length + 1][k + 1];
        for (int i = 1; i <= values.length; i++) {
            for (int j = 1; j <= k; j++) {
                if (i > j) {
                    ans[i][j] = ans[i - 1][j];
                } else {
                    ans[i][j] = Math.max(ans[i - 1][j], ans[i][j - i] + map.get(i));
                    System.out.println(" ans for " + i + " and" + j + " is " + ans[i][j]);
                }
            }
        }
        return ans[values.length][k];
    }
public static int noOfWays(int[][] a,int i,int j,int[][] memo){
        if(i>=a.length||j>=a[0].length){
            return 0;
        }
        if((i==a.length-1)&&(j==a[0].length-1)){
            return 1;
        }
        if(memo[i][j]!=0){
            return memo[i][j];
        }
        int r = noOfWays(a,i,j+1,memo);
        int b= noOfWays(a,i+1,j,memo);
        memo[i][j]=r+b;
        return r+b;
}
public static int noOfwaysBottomUp(int[][] a){
        int[][] b = new int[a.length][a[0].length];
        for (int i=0;i<a.length;i++){
            b[i][0]=1;
        }
        for (int j=0;j<a[0].length;j++){
            b[0][j]=1;
        }
        for (int i=1;i<a.length;i++){
            for (int j=1;j<a[0].length;j++){
                b[i][j]=b[i-1][j]+b[i][j-1];
            }
        }
        return b[a.length-1][a[0].length-1];
}
    public static int stonks(int[] a, int k) {
        int[][] ans = new int[k + 1][a.length];
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < a.length; j++) {
                int max = 0;
                for (int z = 0; z < j; z++) {
                    if ((a[j] - a[z]) + ans[i - 1][z] > max) {
                        max = a[j] - a[z] + ans[i - 1][z];
                    }
                }
                if (j > 0)
                    ans[i][j] = Math.max(ans[i][j - 1], max);

                System.out.println(" ans " + i + " " + j + " is: " + ans[i][j]);

            }
        }
        return ans[k][a.length - 1];
    }

    public static int knapsack(int[] weights, int[] prices, int k) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < weights.length; i++) {
            map1.put(i, weights[i]);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < weights.length; i++) {
            map.put(weights[i], prices[i]);
        }

        int[][] ans = new int[weights.length + 1][k + 1];
        for (int i = 1; i <= weights.length; i++) {
            for (int j = 1; j <= k; j++) {
                if (map1.get(i - 1) <= j) {
                    ans[i][j] = Math.max(ans[i - 1][j], ans[i][j - map1.get(i - 1)] + map.get(map1.get(i - 1)));

                } else {
                    ans[i][j] = ans[i - 1][j];
                }
                System.out.println(" ans " + i + " " + j + " is: " + ans[i][j]);
            }
        }
        return ans[weights.length][k];
    }

    public static String minCostPath(int[][] a) {
        String ans = "" + a[0][0];
        int i = 0;
        int j = 0;
        while (true) {
            if (i == a.length - 1 && j == a[0].length - 1) {
                //       System.out.println(" ans is: * "+ans);
                break;
            } else if (i + 1 >= a.length) {
                ans += a[i][j + 1];
                //    System.out.println(" ans is: "+ans);
                j++;
            } else if (j + 1 >= a[0].length) {
                ans += a[i + 1][j];
                //  System.out.println(" ans is: "+ans);
                i++;
            } else {
                if (a[i + 1][j] < a[i][j + 1]) {
                    ans += a[i + 1][j];
                    //   System.out.println(" ans is: "+ans);
                    i++;
                } else {
                    ans += a[i][j + 1];
                    //   System.out.println(" ans is "+ans);
                    j++;
                }
            }
        }
        return ans;
    }

    public static int palindromicDecomposition(String s, int i, int j) {
        // System.out.println(" i is: "+i+" and j: "+j);
        if (i == j) {
            return 0;
        }
        if (isPalindrome(s, i, j)) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int a = i; a < j; a++) {
            int l = palindromicDecomposition(s, i, a);
            //   System.out.println(" l is: "+l);
            int r = palindromicDecomposition(s, a + 1, j);
            //   System.out.println(" r is: "+r);
            if (min > l + r + 1) {
                min = l + r + 1;
            }
        }
        //  System.out.println(" returning: "+min);
        return min;
    }

    public static boolean WordBreakProblem(String s, ArrayList<String> dictionary, HashMap<Integer, Boolean> map, int i) {
        System.out.println(" s is: " + s + " and i is: " + i);
        if (dictionary.contains(s)) {
            return true;
        }
        if (s.length() == 1) {
            if (dictionary.contains(s)) {
                return true;
            } else {
                return false;
            }
        }
        if (map.containsKey(i)) {
            System.out.println(" match for " + i);
            return map.get(i);
        }
        for (int a = 0; a < s.length() - 1; a++) {
            boolean x = WordBreakProblem(s.substring(0, a + 1), dictionary, map, a) && WordBreakProblem(s.substring(a + 1), dictionary, map, a);
            map.put(a, x);
            if (x) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPalindrome(String s, int a, int b) {
        while (a != b) {
            if (!((s.charAt(a) + "").equals(s.charAt(b) + ""))) {
                return false;
            }
            a++;
            b--;
        }
        return true;
    }

    public static int DictionaryDist(String s1, String s2, ArrayList<String> arr, int ans) {
        System.out.println(" s1 is: " + s1 + " and s2 is: " + s2);
        if (s1.equals(s2)) {
            return ans;
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (String x : arr) {
            if (!x.equals(s1)) {
                map.put(x, distbW(s1, x));
                System.out.println(" put " + distbW(s1, x) + " at " + x);
            }
        }
        int min = Integer.MAX_VALUE;
        String a = "";
        for (String x : map.keySet()) {
            if (map.get(x) < min) {
                min = map.get(x);
                a = x;
            }
        }
        System.out.println(" min is: " + min);
        System.out.println(" a is: " + a);
        ans += min;
        arr.remove(arr.indexOf(s1));
        return DictionaryDist(a, s2, arr, ans);

    }

    private static class pair {
        int l;
        int r;

        pair() {
            this.l = 0;
            this.r = 0;
        }

        public String toString() {
            return "l: " + l + " r: " + r;
        }
    }

    public static int maxSquareSubMatrix(int[][] a) {
        int max = 0;
        pair[][] ans = new pair[a.length][a[0].length];
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                ans[i][j] = new pair();
            }
        }
        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < a[0].length; j++) {
                //    System.out.println(" i is: "+i+" and j: "+j);
                if (a[i - 1][j] == 1) {
                    //  System.out.println(" a["+(i-1)+"] ["+j+"] is: "+a[i-1][j] );
                    ans[i][j].r = ans[i - 1][j].r + 1;
                }
                if (a[i][j - 1] == 1) {
                    //   System.out.println("a["+i+"] ["+(j-1)+"] is: "+a[i][j-1]);
                    ans[i][j].l = ans[i][j - 1].l + 1;
                }
                //  System.out.println(" ans["+i+"]["+j+"] is: "+ans[i][j]);
                if (Math.min(ans[i][j].l, ans[i][j].r) + 1 > max) {
                    //    System.out.println(" match for: " +i+" " + j+" : value is: "+ans[i][j]);
                    max = Math.max(ans[i][j].l, ans[i][j].r) + 1;
                }
            }
        }
        return max;
    }

    public static int noOfPalindromePartitions(String s) {
        if (s.length() == 2) {
            if ((s.charAt(0) + "").equals(s.charAt(1) + "")) {
                return 2;
            } else {
                return 1;
            }
        }
        int x = noOfPalindromePartitions(s.substring(1)) * noOfPalindromePartitions(s.substring(0, s.length() - 1));
        if ((s.charAt(0) + "").equals(s.charAt(s.length() - 1) + "")) {
            return 1 + x;
        } else {
            return x;
        }
    }

    public static int EditDistance(String s1, String s2) {
        int[][] ans = new int[s2.length() + 1][s1.length() + 1];
        for (int i = 1; i <= s2.length(); i++) {
            for (int j = 1; j <= s1.length(); j++) {
                if ((s1.charAt(j - 1) + "").equals(s2.charAt(i - 1) + "")) {
                    ans[i][j] = ans[i - 1][j - 1];
                } else {
                    ans[i][j] = Math.min(Math.min(ans[i - 1][j], ans[i][j - 1]), ans[i - 1][j - 1]) + 1;
                }
            }
        }
        return ans[s2.length()][s1.length()];
    }

    public static int distbW(String s1, String s2) {
        //  System.out.println(" s1 is: "+s1+ " and s2: "+s2);
        if (s1.length() == 0 && s2.length() == 0) {
            return 0;
        } else if (s1.equals("") && s2.length() > 0) {
            return s2.length();
        } else if (s1.length() > 0 && s2.length() == 0) {
            return s1.length();
        } else {
            int x = distbW(s1.substring(1), s2.substring(1));
            if ((s1.charAt(0) + "").equals(s2.charAt(0) + "")) {
                return x;
            } else {
                return 1 + x;
            }
        }
    }

    public static int[][] WordWrap(String[] s, int k) {
        int[][] ans = new int[s.length][s.length];
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s.length; j++) {
                int x=totalSpace(s, i, j);
             //   System.out.println(" x is: "+x);
                if ( x!=-1 &&x<= k) {
                    ans[i][j] = ((k - x) * (k - x));
                }else if(x==-1) {
                    ans[i][j]=-1;
                }
                else
                 {
                    ans[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        return ans;
    }
public static String longestSumIncreasingSubseq(int[] a) {
    int[] ans = new int[a.length];
    for(int i=0;i<a.length;i++){
        ans[i]=a[i];
    }
    int[] ans1 = new int[a.length];
    for(int i=0;i<a.length;i++){
        ans1[i]=i;
    }

    ans[0] = a[0];
    for (int i = 1; i < ans.length; i++) {
      //  System.out.println("checking for: " + i);
        int max = 0;
        for (int j = 0; j < i; j++) {
          //  System.out.println(" a[" + i + "] is: " + a[i] + " a[" + j + "] is: " + a[j]);
          //  System.out.println("ans[j]+a[i] is: " + (ans[j] + a[i]) + " and max is: " + max);
            if ((a[i] > a[j])&& ans[j] + a[i] > max) {
                    max = ans[j] + a[i];
                    ans1[i] = j;
                ans[i] = max;
            }
        }

      //  System.out.println(" ans for " + i + " is: " + ans[i]);
       // System.out.println(" ans 1 for " + i + "is: " + ans1[i]);
    }
        int m = 0;
    int index=0;
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] > m) {
                m = ans[i];
                index=i;
            }
        }
        String fin = "";
        int i = index;
        while (i >= 0) {
          //  System.out.println(" i is: " + i);
            if (i == 0) {
                fin+=a[0];
                break;
            }
            fin =fin+ a[i];
            i = ans1[i];
        }
        return fin;
    }

    public static int totalSpace(String[] s, int a, int b) {
        int ans = 0;
        for (int i = a; i <= b; i++) {
            ans += s[i].length() + 1;
        }
        ans--;
        return ans;
    }
    public static String towerHopper(int[] a){
        int[] ans = new int[a.length+1];
        int i=a.length;
        while (i>=0){
            if(i==0){
                ans[i]=i;
                break;
            }
            int value=0;
            for (int j=0;j<i;j++){
                if(a[j]+j>=i){
                value=j;
                break;
                }
            }
            ans[i]=value;
            i=value;
        }
        String fin="";
        int j=a.length;
        while (j>=0){
            if(j==0){
                break;
            }
            fin+=a[ans[j]];
            j=ans[j];
        }
        String fin2 = "";
        for (int k=fin.length()-1;k>=0;k--){
            fin2+=fin.charAt(k)+" ";
        }
        return fin2;
    }

}
