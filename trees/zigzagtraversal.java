package treepractice;
import java.util.*;
public class zigzagtraversal {

    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        zigzagtraversal m = new zigzagtraversal();
        BinaryTree bt = m.new BinaryTree();
        Stack<BinaryTree.Node> s1 = new Stack<BinaryTree.Node>();
        Stack<BinaryTree.Node> s2 = new Stack<BinaryTree.Node>();
        bt.levelOrderZZ(bt.root,s1,s2);
    }

    private class BinaryTree {
        private class Node {
            int data;
            Node left;
            Node right;
        }

        private Node root;
        private int size;

        public BinaryTree() {
            this.root = this.takeInput(null, false);
        }

        public Node takeInput(Node parent, boolean ilc) {

            int cdata = scn.nextInt();
            Node child = new Node();
            child.data = cdata;
            this.size++;

            // left
            boolean hlc = scn.nextBoolean();

            if (hlc) {
                child.left = this.takeInput(child, true);
            }

            // right
            boolean hrc = scn.nextBoolean();

            if (hrc) {
                child.right = this.takeInput(child, false);
            }

            // return
            return child;
        }

        public void levelOrderZZ(Node parent,Stack<Node> s1, Stack<Node>s2) {
           s1.push(parent);
           while (true){
               while (!s1.isEmpty()){
                   Node n = s1.pop();
                   System.out.print(n.data+" ");
                   if(n.left!=null)
                   s2.push(n.left);
                   if (n.right!=null)
                   s2.push(n.right);
               }
               while (!s2.isEmpty()){
                   Node n = s2.pop();
                   System.out.print(n.data+" ");
                   if(n.right!=null)
                       s1.push(n.right);
                   if(n.left!=null)
                       s1.push(n.left);
               }
               if((s1.isEmpty())&&(s2.isEmpty())){
                   break;
               }
           }
        }

    }

}
