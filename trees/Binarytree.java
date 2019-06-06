package trees;

import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Binarytree {
    private class node {
        node leftchild;
        node rightchild;
        int data;

        node(node l, node r, int d) {
            this.leftchild = l;
            this.rightchild = r;
            this.data = d;
        }
    }

    private node root;
    private int size;

    Binarytree() {
        Scanner s = new Scanner(System.in);
        this.root = gettree(s, null, false);
    }

    public node gettree(Scanner s, node parent, boolean isleft) {
        if (parent == null) {
            System.out.println("Enter root");
        } else {
            if (isleft) {
                System.out.println("Enter left child of: " + parent.data);
            } else {
                System.out.println("Enter right child of: " + parent.data);
            }
        }
        int data1 = s.nextInt();
        node n = new node(null, null, data1);
        isleft = false;
        System.out.println("Does " + n.data + " have a left child?");
        boolean b = s.nextBoolean();
        if (b) {
            isleft = true;
            n.leftchild = gettree(s, n, isleft);
        }
        isleft = false;
        System.out.println("Does " + n.data + " have a right child?");
        boolean c = s.nextBoolean();
        if (c) {
            n.rightchild = gettree(s, n, isleft);
        }
        return n;
    }

    public void display(node parent) {
        System.out.print(parent.data + " ==> ");
        if (parent.leftchild != null) {
            System.out.print(parent.leftchild.data + " ==> ");
        }
        if (parent.rightchild != null) {
            System.out.print(parent.rightchild.data + " ==> ");
        }
        System.out.println("End");
        if (parent.leftchild != null) {
            display(parent.leftchild);
        }
        if (parent.rightchild != null) {
            display(parent.rightchild);
        }

    }

    public int height(node parent) {
        if (parent == null) {
            return -1;
        }
        int leftheight = height(parent.leftchild);
        int rightheight = height(parent.rightchild);
        return Math.max(leftheight, rightheight) + 1;
    }

    public void preorder(node n) {
        System.out.print(n.data + " ");
        if (n.leftchild != null) {
            preorder(n.leftchild);
        }
        if (n.rightchild != null) {
            preorder(n.rightchild);
        }
    }

    public void inorder(node n) {

        if (n.leftchild != null) {
            inorder(n.leftchild);
        }
        System.out.print(n.data + " ");
        if (n.rightchild != null) {
            inorder(n.rightchild);
        }
    }

    public void postorder(node n) {

        if (n.leftchild != null) {
            postorder(n.leftchild);
        }

        if (n.rightchild != null) {
            postorder(n.rightchild);
        }
        System.out.print(n.data + " ");
    }

    public void levelorder(node parent, Queue<node> q) {
        q.add(parent);
        while (!q.isEmpty()) {
            node n = q.remove();
            System.out.print(n.data + " ");
            if (n.leftchild != null) {
                q.add(n.leftchild);
            }
            if (n.rightchild != null) {
                q.add(n.rightchild);
            }

        }
    }

  /*  public boolean isitBST(node n, int min, int max) {
        if (n == null) {
            return true;
        }
        if ((n.data < min) || (n.data > max)) {
            return false;
        } else if (!isitBST(n.leftchild, min, n.data)) {
            return false;
        } else if (!isitBST(n.rightchild, n.data, max)) {
            return false;
        }
        return true;
    }*/
  public int largestBST(node parent){
      if (parent==null){
          return 1;
      }
      if(isBST(parent,parent.data,parent.data)){
          return sizeoftree(parent,0)+1;
      }
      return Math.max(largestBST(parent.rightchild),largestBST(parent.leftchild));
  }
    public int sizeoftree(node parent,int size){
        if(parent==null){
            return 0;
        }
        return sizeoftree(parent.rightchild,size)+sizeoftree(parent.leftchild,size)+1;
    }
    public boolean issymetricDriver(){
      return issymmetric(root.leftchild,root.rightchild);
    }
    public boolean issymmetric(node left,node right){
     if( (left==null)&&(right==null)){
         return true;
     }
     if ((left!=null)&&(right!=null)){
         return ((left.data==right.data)&&(issymmetric(left.leftchild,right.rightchild))&&(issymmetric(left.rightchild,right.leftchild)));
     }
    return false;

    }
    public boolean isBST(node parent,int min,int max){
        if(parent==null){
            return true;
        }
        if((parent.data<min)||(parent.data>max)){
            return false;
        }else if (isBST(parent.leftchild,min,parent.data)==false){
            return false;
        }else if (isBST(parent.rightchild,parent.data,max)==false){
            return false;
        }
        return true;
    }
    public int roottoleafpaths(node parent, String str, Stack<node> s,int sum){
      if (parent==null){
          return 0;
      }
        s.push(parent);
        System.out.println("str is now: "+str);
        str+=parent.data;
        if(parent.leftchild==null&&parent.rightchild==null){
            System.out.println("str is: "+str);
            sum+=(Integer.parseInt(str));
            s.pop();
            str = str.substring(0,str.length()-2);
            return sum;
        }
      //  System.out.println("sum is: "+roottoleafpaths(parent.leftchild,str,s,sum)+roottoleafpaths(parent.rightchild,str,s,sum));
        return roottoleafpaths(parent.leftchild,str,s,sum)+roottoleafpaths(parent.rightchild,str,s,sum);

    }
  public int sumofroottoleafpaths(node parent,int sum,Stack<node> s ){
      if(parent==null){
          return 0;
      }
      System.out.println("pushing: "+parent.data);
      s.push(parent);
      if(parent.leftchild==null&&parent.rightchild==null){
          int x =sumofstack(s,0);
          System.out.println(" sos is: "+x);
          s.pop();
          return x;
      }
      if(parent.leftchild!=null)
      sum+= sumofroottoleafpaths(parent.leftchild, sum,s);
      if(parent.rightchild!=null)
      sum+=sumofroottoleafpaths(parent.rightchild,sum,s);
      return sum;
  }
  public int sumofstack(Stack<node> s,int sum){
      node x = null;
      if(!s.isEmpty()){
          sum+=s.peek().data;
           x = s.pop();
          return sumofstack(s,sum);
      }
      s.push(x);
      return sum;
  }
   /* public void treefromlevelorder(node root, Queue<node> q1, Queue<node> q2, String[] a) {
        for (int i = 1; i < a.length; i++) {
            node n = new node(null, null, Integer.parseInt(a[i]));
            q2.add(n);
        }
        q1.add(root);
        while (true) {
            if (q2.isEmpty()) {
                break;
            }
            while (q1.size() > 0) {
                node n = q1.remove();
                node p = q2.remove();
                node q = q2.remove();
                if (p.data != -1) {
                    n.leftchild = p;
                    q1.add(p);
                }
                if (q.data != -1) {
                    n.rightchild = q;
                    q1.add(q);
                }
            }
        }
    }*/

    public void rightview(node parent, int level, int maxlevel) {
        if (parent == null) {
            return;
        }
        if (maxlevel<level ) {
            System.out.println("level is: "+level+" & maxlevel is: " +maxlevel);
            System.out.println(parent.data + " ");
            maxlevel =level;
        }
        rightview(parent.rightchild, level + 1, maxlevel);
        rightview(parent.leftchild, level + 1, maxlevel);

    }

    public static void main(String[] args) {
        Binarytree b = new Binarytree();
        Stack<node> s = new Stack<>();
     //   b.roottoleafpaths(b.root,str,s);
        System.out.println(b.roottoleafpaths(b.root,"",s,0));
        //  b.rightview(b.root, 1, 0);
     //   System.out.println(b.largestBST(b.root));
    }
}
//2 true 3 false false true 1 false false
//50 true 25 true 12 false false true 48 true 18 false false false true 55 true 53 false false true 60 false false
//1 true 2 true 4 false false true 5 false false true 3 true 6 false false true 7 true 8 false false false