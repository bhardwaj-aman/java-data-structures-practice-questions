package trees;
//we create the BST class
public class BST {
    //We create nodes, which is a private class
    private class node{
         node leftchild;
         node rightchild;
         int data;
    }
    private node root;
    private int size;
    BST(int[] a){
        //this creates a BST from an array that is already sorted.
        this.root = create(a,0,a.length-1);
    }
    //we write a recursive function named create, which is used to make the BST node by node, and return the node each time.
    //we create the min and max pointers, which indicate the starting and end index of our array, and pass these values recursively.
    public node create(int[]a,int min, int max){
        //base case
        if(min>max){
            return null;
        }
        int mid = (min+max)/2;
        //we create a new node which has the value in a[mid] as its value .
        node n = new node();
        n.data=a[mid];
        // we recursively call this function for both halves.
        n.leftchild =create(a,min,mid-1);
        n.rightchild = create(a,mid+1,max);
        return n;
    }
    public void display(node parent){
        if(parent==null){
            return;
        }
       String s = "";
       if(parent.leftchild==null){
      s+=".";
       }else{
           s+=parent.leftchild.data;
       }
        s+="->"+parent.data+"<-";
        if(parent.rightchild==null){
            s+=".";
        }else{
            s+=parent.rightchild.data;
        }
        System.out.println(s);
        display(parent.leftchild);
        display(parent.rightchild);
    }
    public boolean find(node parent,int d){
  if(parent==null){
      System.out.println("backtracking");
      return false;
  }
  if(parent.data==d){
      System.out.println("match");
      return true;
  }
 else if(parent.data>d){
      System.out.println("parent is: "+parent.data+ " going left");
      return find(parent.leftchild,d);
  }
      else {
      System.out.println("parent is: " + parent.data + " going right");
      return find(parent.rightchild, d);
  }
    }
    public int max(node parent){
      if(parent.rightchild!=null){
          return max(parent.rightchild);
      }else {
          return parent.data;
      }
    }
    public void add(node parent,int a){

        if(a>parent.data){
            if(parent.rightchild!=null){
                add(parent.rightchild,a);
            }else{
                node n = new node();
                n.data=a;
                parent.rightchild=n;
            }

        }else{
            if(parent.leftchild!=null) {
                add(parent.leftchild, a);
            }else{
                node n = new node();
                n.data=a;
                parent.leftchild= n;
            }
        }
    }
    public void displayleft(node parent){
        if((parent.leftchild==null)&&(parent.rightchild==null)){
            return;
        }
        if(parent.leftchild!=null){
            System.out.println(parent.leftchild.data+" ");
            displayleft(parent.leftchild);
        }
        if(parent.rightchild!=null){
            displayleft(parent.rightchild);
        }
    }
    public void remove(node parent,node node,boolean isleft,int d){
        if (node==null){
            return;
        }
        if(d<parent.data){
            remove(parent.leftchild,node,true,d);
        }else if(d>parent.data){
            remove(parent.rightchild,node,false,d);
        }else {
            if((node.leftchild==null)&&(node.rightchild==null)){
                parent.leftchild=null;
                parent.rightchild=null;
            }
            else if((node.leftchild!=null)&&(node.rightchild==null)){
                 if(isleft){
                    parent.leftchild = node.leftchild;
                }else{
                    parent.rightchild = node.leftchild;
                }
            }else if((node.leftchild==null)&&(node.rightchild!=null)){
                if(isleft){
                    parent.leftchild = node.rightchild;
                }else {
                    parent.rightchild = node.rightchild;
                }

            }
            else {
                int n  = max(node.leftchild);
                node.data = n;
                remove(node,node.leftchild,true,n);
            }
        }
    }
    public static void main(String[] args){
    int[] a = {10,20,30,40,50,60,70};
    BST b = new BST(a);
   b.add(b.root,55);
   b.display(b.root);
        System.out.println("************");
        b.displayleft(b.root);
  //      System.out.println(b.max(b.root));
    }
}
