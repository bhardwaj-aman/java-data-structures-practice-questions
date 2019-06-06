package treepractice;
import java.util.*;
public class buildBST {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);

            int b = s.nextInt();
            int[] c = new int[b];
            for(int j=0;j<b;j++){
                c[j] = s.nextInt();
            }
            BST t1 = new BST(c);
        System.out.println(t1.lowestcommonanc(1,3,t1.root).data);
           // BST t2 = new BST(c);
          //  t1.replacesum(t1.root,t2.root);
          //  t1.preorder(t1.root);
    }
}
 class BST{
    public class node{
        int data;
        node left;
        node right;
        node(int n){
            this.data =n;
        }

    }
    public node root;
    BST(int[] arr){
        this.root =buildtree(0,arr.length-1,arr) ;
    }
    public node buildtree(int start,int end,int[] arr){
        if(start>end){
            return null;
        }
        int mid = (start+end)/2;
        node parent = new node(arr[mid]);
        parent.left = buildtree(start,mid-1,arr);
        parent.right = buildtree(mid+1,end,arr);
        return parent;
    }
    public void preorder(node parent){
        if(parent==null){
            return;
        }
        System.out.print(parent.data+ " ");
        preorder(parent.left);

        preorder(parent.right);
    }
     public node lowestcommonanc(int a,int b,node parent){
        if(parent==null){
            return null;
        }
        if((parent.data==a)||(parent.data==b)){
            System.out.println(parent.data+ " : loop 0");
            return parent;
        }
        node l = lowestcommonanc(a,b,parent.left);
        node r = lowestcommonanc(a,b,parent.right);
        if((l==null)){
            System.out.println(parent.data+ " : loop 1");
            return r;
        }
        if((r==null)){
            System.out.println(parent.data+ " : loop 2");
            return  l;
        }
            return parent;


     }
    public void replacesum(node parent,node root){
        if (parent==null){
            return;
        }
        replacesum(parent.left,root);
        parent.data= addsum(parent.data,root);
        replacesum(parent.right,root);
    }
    public int addsum(int n,node parent){
        if (parent==null){
            return 0;
        }
        if (parent.data>=n) {
            return parent.data+ addsum(n, parent.left) + addsum(n, parent.right);
        }
        else {
            return addsum(n,parent.right)+addsum(n,parent.left);
        }
    }
}