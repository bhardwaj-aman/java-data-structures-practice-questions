package trees;

import java.util.Queue;
import java.util.Scanner;

public class Binarytree {
    private class node{
        node leftchild;
        node rightchild;
        int data;
        node(node l,node r,int d){
            this.leftchild=l;
            this.rightchild=r;
            this.data=d;
        }
    }
    private node root;
    private int size;
    Binarytree(){
        Scanner s = new Scanner(System.in);
        this.root= gettree(s,null,false);
    }
    public node gettree(Scanner s ,node parent,boolean isleft){
       if(parent==null){
           System.out.println("Enter root");
       }else{
           if (isleft){
               System.out.println("Enter left child of: "+ parent.data);
       }
       else {
               System.out.println("Enter right child of: "+ parent.data);
       }
       }
           int data1 = s.nextInt();
           node n = new node(null,null,data1);
           isleft = false;
           System.out.println("Does "+n.data+" have a left child?");
           boolean b = s.nextBoolean();
           if(b){
               isleft=true;
             n.leftchild= gettree(s,n,isleft);
           }
           isleft = false;
           System.out.println("Does "+n.data+" have a right child?");
           boolean c = s.nextBoolean();
          if(c) {
               n.rightchild = gettree(s,n,isleft);
           }
   return n;
       }
  public void display(node parent){
      System.out.print(parent.data+" ==> ");
        if(parent.leftchild!=null){
            System.out.print(parent.leftchild.data+" ==> ");
      }
      if(parent.rightchild!=null){
          System.out.print(parent.rightchild.data+ " ==> ");
      }
      System.out.println("End");
      if(parent.leftchild!=null){
          display(parent.leftchild);
      }
      if(parent.rightchild!=null){
          display(parent.rightchild);
      }

  }
  public int height(node parent){
        if (parent==null){
            return -1;
        }
       int leftheight = height(parent.leftchild);
       int rightheight = height(parent.rightchild);
       return Math.max(leftheight,rightheight)+1;
  }
  public void preorder(node n){
      System.out.print(n.data+" ");
      if (n.leftchild!=null){
          preorder(n.leftchild);
      }
      if (n.rightchild!=null){
          preorder(n.rightchild);
      }
  }
    public void inorder(node n){

        if (n.leftchild!=null){
            inorder(n.leftchild);
        }
        System.out.print(n.data+" ");
        if (n.rightchild!=null){
            inorder(n.rightchild);
        }
    }
    public void postorder(node n){

        if (n.leftchild!=null){
            postorder(n.leftchild);
        }

        if (n.rightchild!=null){
            postorder(n.rightchild);
        }
        System.out.print(n.data+" ");
    }
    public void levelorder(node parent, Queue<node> q){
   q.add(parent);
        while (!q.isEmpty()){
            node n = q.remove();
            System.out.print(n.data+" ");
            if(n.leftchild!=null){
                q.add(n.leftchild);
            }
            if(n.rightchild!=null){
                q.add(n.rightchild);
            }

        }
    }
    public boolean isitBST(node n,int min,int max){
        if(n==null){
            return true;
        }
       if((n.data<min)||(n.data>max)){
           return false;
       }else if(!isitBST(n.leftchild,min,n.data)){
           return false;
       }else if(!isitBST(n.rightchild,n.data,max)){
           return false;
       }
       return true;
    }
public static void main(String[] args){
        Binarytree b = new Binarytree();
      // b.display(b.root);
    System.out.println("height is: "+b.height(b.root));
 /*   b.preorder(b.root);
    System.out.println("");
    b.postorder(b.root);
    System.out.println("");
    b.inorder(b.root);*/
 //Queue<node> q = new LinkedList<>();
 //b.levelorder(b.root,q);
    System.out.println(b.isitBST(b.root,Integer.MIN_VALUE,Integer.MIN_VALUE));
}
    }
//2 true 3 false false true 1 false false
//50 true 25 true 12 false false true 48 true 18 false false false true 55 true 53 false false true 60 false false