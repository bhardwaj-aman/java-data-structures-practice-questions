package codechef;


import java.util.*;

public class Tree {
    Scanner s = new Scanner(System.in);

    private class node {
        int data;
        node leftchild;
        node rightchild;

        node(int d) {
            this.data = d;
        }

        node(int d, node l, node r) {
            this.data = d;
            this.leftchild = l;
            this.rightchild = r;
        }
    }

    private node root;

    Tree() {
        this.root = generateTree(null, false);
    }

    public node generateTree(node parent, boolean isleft) {
        if (parent == null) {
            System.out.println(" enter root");
        } else if (isleft) {
            System.out.println(" enter left child of: " + parent.data);
        } else {
            System.out.println("Enter right child of: " + parent.data);
        }
        int d = s.nextInt();
        node n = new node(d, null, null);
        System.out.println(" does " + d + " have a left child: ");
        boolean b = s.nextBoolean();
        isleft = true;
        if (b) {
            n.leftchild = generateTree(n, isleft);
        }
        isleft = false;
        System.out.println("does : " + d + " have a right child");
        boolean b1 = s.nextBoolean();
        if (b1) {
            n.rightchild = generateTree(n, isleft);
        }
        return n;

    }

    public void display(node parent) {
        if (parent == null) {
            return;
        }

        System.out.print(parent.data + " -> ");
        if (parent.leftchild != null)
            System.out.print(parent.leftchild.data + " -> ");

        if (parent.rightchild != null)
            System.out.print(parent.rightchild.data + " -> ");
        System.out.println(" end");
        display(parent.leftchild);
        display(parent.rightchild);
    }

    public int height(node parent) {
        if (parent == null) {
            return 0;
        }
        return Math.max(height(parent.leftchild), height(parent.rightchild)) + 1;
    }

    public int diameter(node parent) {
        if (parent == null) {
            return 0;
        }
        int lHeight = height(parent.leftchild);
        int rHeight = height(parent.rightchild);
        return Math.max(lHeight + rHeight + 1, Math.max(diameter(parent.leftchild), diameter(parent.rightchild)));
    }

    public boolean isIsomorphic(node parent1, node parent2) {
        if (parent1 == null && parent2 == null) {
            return true;
        }
        if (parent1 == null || parent2 == null) {
            return false;
        }
        if (parent1.data != parent2.data) {
            return false;
        }
        if (isIsomorphic(parent1.leftchild, parent2.rightchild) && isIsomorphic(parent1.rightchild, parent2.leftchild)) {
            return true;
        }
        if (isIsomorphic(parent1.rightchild, parent2.rightchild) && isIsomorphic(parent1.leftchild, parent2.leftchild)) {
            return true;
        }

        return false;
    }

    public boolean rootToLeafWithGivenSum(int k, int sum, node parent, String s) {
        if (parent == null) {
            if (sum == k) {
                System.out.println(s);
                return true;
            } else {
                //        System.out.println(" sum is: " + sum);
                return false;
            }
        }
        boolean b2 = false;
        boolean b1 = rootToLeafWithGivenSum(k, sum + parent.data, parent.leftchild, s + parent.data);
        if (!b1) {
            b2 = rootToLeafWithGivenSum(k, sum + parent.data, parent.rightchild, s + parent.data);
        }
        return b1 || b2;
    }

    public void roottoLeafWithSumUsingStack(node parent, Stack<node> s, int k, int sum) {
        if (parent == null) {
            return;
        }
        sum += parent.data;
        s.push(parent);
        //   System.out.println(" sum is: "+sum+" and top is: "+s.peek().data);
        if (sum == k) {
            while (s.size() > 1) {
                System.out.print(s.pop().data + " ");
            }
            System.out.println(s.peek().data);
        }

        roottoLeafWithSumUsingStack(parent.leftchild, s, k, sum);
        roottoLeafWithSumUsingStack(parent.rightchild, s, k, sum);
        // sum-=parent.data;
        if (!s.isEmpty())
            s.pop();
    }

    public int nodeswithKleaves(node parent, int k) {
        if (parent.leftchild == null && parent.rightchild == null) {
            return 1;
        }
        int l = 0;
        int r = 0;
        if (parent.leftchild != null) {
            l = nodeswithKleaves(parent.leftchild, k);
        }
        if (parent.rightchild != null) {
            r = nodeswithKleaves(parent.rightchild, k);
        }
        // System.out.println(" checking for: "+parent.data+" l+r  is: "+(l+r));

        if (l + r == k) {
            System.out.println(parent.data);
        }
        return l + r;
    }

    public void iterativeInorder() {
        Stack<node> stack = new Stack<>();
        ArrayList<node> visited = new ArrayList<>();
        stack.push(this.root);
        while (!stack.isEmpty()) {
            node n = stack.peek();

            //   System.out.println("n is: "+n.data);
            if (n.leftchild == null || visited.contains(n.leftchild)) {
                System.out.print(n.data + " ");
                visited.add(stack.pop());
                if (n.rightchild != null) {
                    stack.push(n.rightchild);
                }
            } else {
                stack.push(n.leftchild);
            }
        }
    }

    public void inorder(node parent) {
        if (parent == null) {
            return;
        }
        inorder(parent.leftchild);
        System.out.print(parent.data + " ");
        inorder(parent.rightchild);
    }

    public node lowestCommonAncestor(int a, int b, node parent) {
        if (parent == null) {
            return null;
        }
        if (parent.data == a || parent.data == b) {
            return parent;
        }
        node l = lowestCommonAncestor(a, b, parent.leftchild);
        node r = lowestCommonAncestor(a, b, parent.rightchild);
        if (l != null && r != null) {
            //   System.out.println(" l is: "+l.data+" and r is: "+r.data);
            return parent;
        } else if (l != null && r == null) {
            return l;
        } else if (l == null && r == null) {
            return null;
        }
        return r;
    }

    private class verticalPair {
        node n;
        int distance;

        verticalPair(node a, int d) {
            this.distance = d;
            this.n = a;
        }

        verticalPair() {
            this.distance = 0;
            this.n = null;
        }
    }

    public HashMap<Integer, ArrayList<node>> verticalTraversal(HashMap<Integer, ArrayList<node>> map, node parent, int distance) {
        if (parent == null) {
            return map;
        }
        if(map.get(distance)==null) {
            map.put(distance, new ArrayList<>());
        }
        map.get(distance).add(parent);
        verticalTraversal(map, parent.leftchild, distance - 1);
        verticalTraversal(map, parent.rightchild, distance + 1);
        return map;
    }
    public HashMap<Integer, ArrayList<node>> verticalOrderTraversal(HashMap<Integer, ArrayList<node>> map, node parent, int distance) {
        Queue<verticalPair> q = new java.util.LinkedList<>();
        verticalPair v = new verticalPair(parent,distance);
        q.add(v);

        while (!q.isEmpty()){
            verticalPair pair = q.remove();
            if(map.get(pair.distance)==null)
                map.put(pair.distance,new ArrayList<>());
            map.get(pair.distance).add(pair.n);
            if(pair.n.leftchild!=null){
                verticalPair v1 = new verticalPair(pair.n.leftchild,(pair.distance)-1);
                q.add(v1);
            }
            if(pair.n.rightchild!=null){
                verticalPair v1 = new verticalPair(pair.n.rightchild,(pair.distance)+1);
                q.add(v1);
            }
        }
        return map;
    }
   public int maxSum(node parent,int res){
        if(parent==null){
            return 0;
        }
        if(parent.leftchild==null&&parent.rightchild==null){
            return parent.data;
        }
     int lsum=maxSum(parent.leftchild,res);
        int rsum = maxSum(parent.rightchild,res);
        if(parent.leftchild!=null&&parent.rightchild!=null){
            res=Math.max(res,lsum+rsum+parent.data);
            return Math.max(lsum,rsum)+parent.data;
        }
        return (parent.leftchild==null)? rsum+parent.data:lsum+ parent.data;
   }
   public int maxsumfinal(node root){
        int res=Integer.MIN_VALUE;
        maxSum(root,res);
        return res;
   }
    public void bottomview(){
        HashMap<Integer,ArrayList<node>> h = new  HashMap<Integer,ArrayList<node>>();
        h= verticalOrderTraversal(h,this.root,0);
        for(int x:h.keySet()){
            ArrayList<node > n = h.get(x);
            System.out.print(h.get(x).get(n.size()-1).data+" ");
        }
    }
    public void topview(){
        HashMap<Integer,ArrayList<node>> h = new HashMap<>();
        h=verticalOrderTraversal(h,this.root,0);
        for(int x:h.keySet()){
            ArrayList<node> arr = h.get(x);
            System.out.print(arr.get(0).data+" ");
        }
    }
    public void leftView(node parent,ArrayList<Integer> visited,int level){
        if(parent==null){
            return;
        }
        if(!visited.contains(level)) {
            System.out.print(parent.data + " ");
            visited.add(level);
        }

        leftView(parent.leftchild,visited,level+1);
        leftView(parent.rightchild,visited,level+1);
    }
    public void rightview(node parent,ArrayList<Integer> visited,int level){
        if(parent==null){
            return;
        }
        if(!visited.contains(level)) {
            System.out.print(parent.data + " ");
            visited.add(level);
        }

        rightview(parent.rightchild,visited,level+1);
        rightview(parent.leftchild,visited,level+1);
    }
    public void nodeswithSumK(node root,ArrayList<Integer> arr,int k){
        if(root==null){
            return;
        }
        arr.add(k-root.data);
        nodeswithSumK(root.leftchild,arr,k);
        nodeswithSumK(root.rightchild,arr,k);
    }
    public boolean checkIfSumK(ArrayList<Integer> arr,node root){
        if(root==null){
            return false;
        }
        if(arr.contains(root.data)){
            return true;
        }
        boolean b1 = checkIfSumK(arr,root.rightchild);
        boolean b2 = checkIfSumK(arr,root.leftchild);
        return b1||b2;
    }
    public boolean findNodesWitthSumk(int k){
        ArrayList<Integer> arr = new ArrayList<>();
        nodeswithSumK(this.root,arr,k);
        if(checkIfSumK(arr,this.root)){
            return true;
        }
        return false;
    }
    public void maxRootDistance(node parent,ArrayList<String> ans,String str){
         if(parent.leftchild==null&&parent.rightchild==null){
             ans.add(str+parent.data);
             return;
         }
         str+=parent.data+" ";
         if(parent.leftchild!=null){
             maxRootDistance(parent.leftchild,ans,str);
         }
         if(parent.rightchild!=null){
             maxRootDistance(parent.rightchild,ans,str);
         }
    }
    private class intpair{
        int data;
        boolean isFull;
        intpair(int d){
            this.data=d;
            this.isFull=false;
        }
    }
    public int maxfinal(){
        ArrayList<String> arr = new ArrayList<>();
        this.maxRootDistance(this.root,arr,"");
        System.out.println(" arr is: "+arr);
        HashMap<String,String> map = new HashMap<>();
        for(String X:arr){
            String[] a = X.split(" ");
            int sum=0;
            String ans = "";
            int check=0;
            for(int i=a.length-1;i>=0;i--){
                check+=Integer.parseInt(a[i]);
                System.out.println("check has become: "+check);
                String y="";
                if(check>sum) {
                    System.out.println("entered");
                    sum = check;
                    for (int j = i; j < a.length-1; j++) {
                        y += a[j]+" ";
                    }
                    y+=a[a.length-1];
                    System.out.println(" y is now: "+y);
                    ans=y;
                }
            }
            map.put(X,ans);
            System.out.println(" added "+ans+" to "+X);
        }
        intpair max1=new intpair(0);
        intpair max2=new intpair(0);
         for(String str: map.keySet()){
             System.out.println(" ***** str is: "+str);
             String str1=map.get(str);
            int s=0;
             System.out.println(" str1 is: "+str1);
            String[] c = str1.split(" ");
            for(String z:c){
                System.out.println(" c ka elelent//// "+z);
                s+=Integer.parseInt(z);
            }
            if(s>max1.data){
                max1.data=s;
                if(str1.equals(str)){
                    System.out.println(" true");
                    max1.isFull=true;
                }else{
                    max1.isFull=false;
                }
            }
         }
        for(String str: map.keySet()){
            String str1=map.get(str);
            int s=0;
            String[] c = str1.split(" ");
            for(String z:c){
                s+=Integer.parseInt(z);
            }
            if(s>max2.data&&s!=max1.data){
                max2.data=s;
                if(str1.equals(str)){
                    max2.isFull=true;
                }else{
                    max2.isFull=false;
                }
            }
        }
        if(!max1.isFull||!max2.isFull){
             return Math.max(max1.data,max2.data);
        }
        return max1.data+max2.data-this.root.data;
    }
    public static void main(String[] args) {
        Tree t = new Tree();
        System.out.println(t.findNodesWitthSumk(4));
    }
}
/*1 true 2 false false true 3 false false*/
/*1 true -2 true 4 false false true 5 false false true 3 true -6 true 7 false false false false*/
/*1 true 2 true 4 false false true 5 false false true 3 true 6 false true 7 false false false*/
/*1 true 2 true -4 true 8 false false true 9 false false true 5 false false true 3 true -6 true 10 false false true 11 false false true 7 false false*/