
package treepractice;
import java.util.*;

    public class treefromPostorderInorder{

        static Scanner scn = new Scanner(System.in);

        public static void main(String[] args) {
            treefromPostorderInorder m = new treefromPostorderInorder();
            int[] pre = takeInput();
            int[] in = takeInput();
            BinaryTree bt = m.new BinaryTree(pre, in);
            bt.display();
        }

        public static int[] takeInput() {
            int n = scn.nextInt();

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

            private Node construct(int[] post, int plo, int phi, int[] in, int ilo, int ihi) {
                if((ilo>ihi)||(plo>phi)){
                    return null;
                }
                Node parent = new Node();
                parent.data = post[phi];
                int z=0;
                for (int i=ilo;i<=ihi;i++){
                    if(in[i]==parent.data){
                        z = i;
                    }
                }

                parent.left = construct(post,plo,plo+(z-ilo)-1,in,ilo,z-1);
                parent.right = construct(post,plo+(z-ilo),phi-1,in,z+1,ihi);
                return parent;
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
