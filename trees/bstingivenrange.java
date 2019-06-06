package treepractice;
import java.util.*;
public class bstingivenrange {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        for(int i=0;i<a;i++){
            int b = s.nextInt();
            int[] c = new int[b];
            for(int j=0;j<b;j++){
                c[j] = s.nextInt();
            }
            int r1= s.nextInt();
            int r2 = s.nextInt();
            ArrayList<Integer> arr = new ArrayList<Integer>();
            BST2 t = new BST2(c);
            t.display(t.root);
            t.preordernormal(t.root);
        /*    System.out.print("# Preorder : ");
            t.preorder(t.root,r1,r2,arr);
            System.out.println("");
            Collections.sort(arr);
            System.out.print("# Nodes within range are : ");
            for(int x: arr){
                System.out.print(i+" ");
            }
            System.out.println("");*/
        }
    }
}
class BST2{
    private class node{
        int data;
        node left;
        node right;
        node(int n){
            this.data =n;
        }
    }
    public node root;
    BST2(int[] arr){
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
    public void preorder(node parent,int r1,int r2,ArrayList<Integer> arr){
        if(parent==null){
            return;
        }
        if((parent.data>=r1)||(parent.data<=r2)){
            arr.add(parent.data);
        }
        System.out.print(parent.data+ " ");
        preorder(parent.left,r1,r2,arr);
        preorder(parent.right,r1,r2,arr);
    }
    public void preordernormal(node parent){
        if (parent==null){
            return;
        }
        System.out.print(parent.data+" ");
        preordernormal(parent.left);
        preordernormal(parent.right);
    }
    public void display(node parent) {

        if (parent.left != null) {
            System.out.print(parent.left.data + " ==> ");
        }
        System.out.print(parent.data );
        if (parent.right!= null) {
            System.out.print( " <== " +parent.right.data);
        }
        System.out.println(" <== End");
        if (parent.left != null) {
            display(parent.left);
        }
        if (parent.right!= null) {
            display(parent.right);
        }

    }

}