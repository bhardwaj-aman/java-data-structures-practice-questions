package trees;

import java.util.ArrayList;
import java.util.Scanner;

public class generictree {
    private class node{
         int data;
         ArrayList<node> children;
         node(int data){
       this.data = data;
       this.children = new ArrayList<node>();
        }
    }
    private node root;
    private int size;
    generictree(){
        Scanner s = new Scanner(System.in);
        this.root = generatetree(s,null,0);
    }
    public node generatetree(Scanner s, node parent,int ithchild){
        if(parent==null){
            System.out.println("Enter 1st node");
        }else{
            System.out.println("Enter data for "+ ithchild+"th child of: "+parent.data);
        }
        int x = s.nextInt();
            node n = new node(x);
            this.size++;
        System.out.println("enter no. of children for : "+n.data);
        int children = s.nextInt();
        for(int i=0;i<children;i++){
              node child = this.generatetree(s,n,i);
              n.children.add(child);
        }
        return n;
    }
    public void displaytree(node parent){
        if(parent==null){
            return;
        }
        System.out.print(parent.data+"-->");
          for (node n: parent.children){
              System.out.print(n.data+"-->");
          }
        System.out.println("End");
       for (node n: parent.children){
           displaytree(n);
       }
    }
    public static void main(String[] args){
        generictree tree = new generictree();
tree.displaytree(tree.root);

    }
}
