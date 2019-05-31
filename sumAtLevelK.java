package treepractice;

import java.util.*;
public class sumAtLevelK {
    public static void main(String args[]) {
        tree t = new tree();
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        System.out.println(t.sumK(k,t.root,0,0));
    }

}
class tree{
    public class node {
        int data;
        ArrayList<node> children;

        node(int d) {
            this.data = d;
            this.children = new ArrayList<node>();
        }
    }
        public node root;
        tree(){
            Scanner s = new Scanner(System.in);
            this.root = buildtree(s,null,0);
         //   s.close();
        }


        public node buildtree(Scanner s, node parent, int index){
            if(parent==null){
                System.out.println("Enter root node");
            }else{
                System.out.println("Enter "+ index+" node of: "+parent.data);
            }

            int c = s.nextInt();
            node n = new node(c);
            System.out.println("Enter no. of nodes of "+n.data);
            int number = s.nextInt();
            for(int i=0;i<number;i++){
                node x = buildtree(s,n,i);
                n.children.add(x);
            }
            return n;
        }
    public int sumK(int k,node parent, int level,int sum){
        System.out.println("level is: "+level);
        if(level==k-1){
            System.out.println( "level==k : "+level);
            int sumtemp =0;
            for(node n:parent.children){

                sumtemp+=n.data;
            }
            return sumtemp;
        }

        for(node n: parent.children){
            System.out.println("sum is: "+sum);
            sum+=sumK(k,n,level+1,sum);
        }
        return sum;
    }
}
//20 2 10 0 30 0
//1 2 2 2 3 0 4 0 5 2 6 0 7 0