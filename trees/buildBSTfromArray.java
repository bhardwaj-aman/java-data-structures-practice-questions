package treepractice;

        import java.util.ArrayList;
        import java.util.Collections;
        import java.util.Scanner;

public class buildBSTfromArray {
    private class node{
        int data;
        node left;
        node right;
        node(int d){
            this.data=d;
        }
    }
    private node root;
    buildBSTfromArray(int[] a){
        //quicksort(a);
        this.root =binarytreefromNormalArray(a);
    }
    public node binarytreefromNormalArray(int[] a){
        node root = new node(a[0]);
        for(int i=1;i<a.length;i++){
            node p=root;
            node q = new node(a[i]);
            while (true){
                if(q.data<=p.data){
                    if(p.left==null){
                        p.left=q;
                        break;
                    }else {
                        p = p.left;
                    }
                }else {
                    if(p.right==null){
                        p.right=q;
                        break;
                    }else {
                        p = p.right;
                    }
                }
            }

        }
        return root;
    }
    public void quicksort(int[] a){
        for (int i=0;i<a.length;i++){
            for (int j=0;j<a.length-1;j++){
                if(a[j+1]<=a[j]){
                    int t = a[j];
                    a[j] = a[j+1];
                    a[j+1]=t;
                }
            }
        }
    }
    public node BSTfromSortedArray(int[] a,int min,int max){
        if (min>max){
            return null;
        }
        int mid = (max+min)/2;
        node parent = new node(a[mid]);
        parent.right = BSTfromSortedArray(a,mid+1,max);
        parent.left = BSTfromSortedArray(a,min,mid-1);
        return parent;
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

    public void preorder(node parent,int r1,int r2,ArrayList<Integer> arr){
        if(parent==null){
            return;
        }
        if((parent.data>=r1)&&(parent.data<=r2)){
            arr.add(parent.data);
        }
        System.out.print(parent.data+ " ");
        preorder(parent.left,r1,r2,arr);
        preorder(parent.right,r1,r2,arr);
    }
    public void preordernormal(node p){
        if (p==null){
            return;
        }
        System.out.print(p.data+" ");
        preordernormal(p.left);
        preordernormal(p.right);
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        for(int i=0;i<a;i++){
            String b = s.next();
            String[] c = new String[Integer.parseInt(b)];
            for (int j=0;j<c.length;j++){
                c[j]=s.next();
            }
            String r1 = s.next();
            String r2 = s.next();
            int[] d = new int[c.length];
            for (int j=0;j<d.length;j++){
                d[j] = Integer.parseInt(c[j]);
            }
            ArrayList<Integer> arr = new ArrayList<>();
            int[] c2 = new int[]{12,18,11,1,3,20,17,19};
            buildBSTfromArray t = new buildBSTfromArray(d);
            //    t.display(t.root);
            //t.preordernormal(t.root);
            System.out.print("# Preorder : ");
            t.preorder(t.root,Integer.parseInt(r1),Integer.parseInt(r2),arr);
            System.out.println("");
            Collections.sort(arr);
            System.out.print("# Nodes within range are : ");
            for (int k:arr){
                System.out.print(k+" ");
            }
            //t.display(t.root);
        }
    }
}
