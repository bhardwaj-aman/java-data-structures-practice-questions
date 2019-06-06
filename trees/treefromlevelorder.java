package trees;

import java.util.*;

class Max_level {

    int max_level;
}
public class treefromlevelorder {
    private class node {
        int data;
        node leftchild;
        node rightchild;

        node(node l, node r, int d) {
            this.data = d;
            this.leftchild = l;
            this.rightchild = r;
        }
    }
    private class nodeplusHdistance{
        node n;
        int distance;
        nodeplusHdistance(node n){
            this.n = n;
        }
    }
    private node root;

    treefromlevelorder(int r) {
        node n = new node(null, null, r);
        this.root = n;

    }

    public void treefromlevelorder(node root, Queue<node> q1, Queue<node> q2, String[] a) {
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
    }
        public void rightview(node parent, int level, Max_level maxlevel) {
        if (parent==null){
            return;
        }
        if((parent.leftchild==null)||(parent.rightchild==null)){
            System.out.print(parent.data+" ");
        }
        if (maxlevel.max_level<level ) {
      //      System.out.println("level is: "+level+" & maxlevel is: " +maxlevel);
          //  System.out.print(parent.data + " ");
            maxlevel.max_level=level;
        }
            rightview(parent.leftchild, level + 1, maxlevel);
            rightview(parent.rightchild, level + 1, maxlevel);

    }
    public void verticalTraversal(node root, HashMap<Integer,node> h,Queue<nodeplusHdistance> q){
        nodeplusHdistance x = new nodeplusHdistance(root);
        q.add(x);
        while (!q.isEmpty()){
            nodeplusHdistance nd = q.remove();
            h.put(nd.distance,nd.n);
            if (nd.n.leftchild!=null){
                nodeplusHdistance left = new nodeplusHdistance(nd.n.leftchild);
                left.distance = nd.distance-1;
                q.add(left);
            }
            if (nd.n.rightchild!=null){
                nodeplusHdistance right = new nodeplusHdistance(nd.n.rightchild);
                right.distance = nd.distance+1;
                q.add(right);
            }
        }
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

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        String[] a = str.split(" ");
        Queue<node> q1 = new LinkedList<node>();
        Queue<node> q2 = new LinkedList<node>();
        treefromlevelorder t = new treefromlevelorder(Integer.parseInt(a[0]));
        t.treefromlevelorder(t.root,q1,q2,a);
        t.display(t.root);
      /*  HashMap<Integer,node> h = new HashMap<Integer,node>();
        Queue<nodeplusHdistance> q3 = new LinkedList<nodeplusHdistance>();
        t.verticalTraversal(t.root,h,q3);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i:h.keySet()){
           // System.out.println("i is: "+i+" and set is: "+h.get(i).data);
            arr.add(i);
        }
        Collections.sort(arr);
        for (int i: arr){
            System.out.print(h.get(i).data+" ");
        }*/

    }
}
//1 2 3 4 5 6 -1 -1 -1 -1 -1 -1 -1
//1 2 -1 4 5 -1 6 -1 -1 -1 -1
