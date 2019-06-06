package treepractice;
import java.util.*;
public class largestBST{

    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        largestBST m = new largestBST();
        int[] pre = takeInput();
        int[] in = takeInput1(pre.length);
        BinaryTree bt = m.new BinaryTree(pre, in);
     //   bt.display();
       // System.out.println(bt.sizeoftree(bt.root.left,0));
       System.out.println(bt.largestBST(bt.root));
        //
    }

    public static int[] takeInput() {
        int n = scn.nextInt();

        int[] rv = new int[n];
        for (int i = 0; i < rv.length; i++) {
            rv[i] = scn.nextInt();
        }

        return rv;
    }
    public static int[] takeInput1(int n) {


        int[] rv = new int[n];
        for (int i = 0; i < rv.length; i++) {
            rv[i] = scn.nextInt();
        }

        return rv;
    }

    private class BinaryTree {
        private class Node {
            int data;
            Node left;
            Node right;
        }

        private Node root;
        private int size;

        public BinaryTree(int[] pre, int[] in) {
            this.root = this.construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
        }

        private Node construct(int[] pre, int plo, int phi, int[] in, int ilo, int ihi) {
            if((plo>phi)||(ilo>ihi)){
                return null;
            }
            Node parent = new Node();
            // System.out.println("plo is: "+plo+" & phi is: "+phi+" ** ilo is: "+ilo+" & ihi is: "+ihi);

            parent.data = pre[plo];
            int z=0;
            for(int i=ilo;i<=ihi;i++){
                if(in[i]==parent.data){
                    z=i;
                }
            }
            // System.out.println("z is: "+z);
            parent.left = construct(pre,plo+1,plo+(z-ilo),in,ilo,z-1);
            parent.right = construct(pre,plo+(z-ilo)+1,phi,in,z+1,ihi);
            return parent;
        }
          public int largestBST(Node parent){
            if (parent==null){
                return 1;
            }
              if(isBST(parent,Integer.MIN_VALUE,Integer.MAX_VALUE)){
                return sizeoftree(parent,0);
              }
              return Math.max(largestBST(parent.right),largestBST(parent.left));
          }
      public int sizeoftree(Node parent,int size){
            if(parent==null){
                return 0;
            }
            return sizeoftree(parent.right,size)+sizeoftree(parent.left,size)+1;
      }
        public boolean isBST(Node parent,int min,int max){
            if(parent==null){
                return true;
            }
            if((parent.data<min)||(parent.data>max)){
                return false;
            }else if (isBST(parent.left,min,parent.data)==false){
                return false;
            }else if (isBST(parent.right,parent.data,max)==false){
                return false;
            }
            return true;
        }
        public void display() {
            this.display(this.root);
        }

        private void display(Node node) {
            if (node == null) {
                return;
            }

            String str = "";

            if (node.left != null) {
                str += node.left.data;
            } else {
                str += "END";
            }

            str += " => " + node.data + " <= ";

            if (node.right != null) {
                str += node.right.data;
            } else {
                str += "END";
            }

            System.out.println(str);

            this.display(node.left);
            this.display(node.right);
        }

    }

}
/*6
1 2 4 5 3 6
4 2 5 1 6 3
*/