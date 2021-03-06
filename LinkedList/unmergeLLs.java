package linkedlist;

import java.util.Scanner;

public class unmergeLLs {
    private class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public unmergeLLs() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public unmergeLLs(Node head, Node tail, int size) {
        this.head = head;
        this.tail = tail;
        this.size = size;
    }

    // O(1)
    public int size() {
        return this.size;
    }

    // O(1)
    public boolean isEmpty() {
        return this.size() == 0;
    }

    // O(1)
    public int getFirst() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("List is empty.");
        }

        return this.head.data;
    }

    // O(1)
    public int getLast() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("List is empty.");
        }

        return this.tail.data;
    }

    // O(N)
    public int getAt(int idx) throws Exception {
        Node temp = this.getNodeAt(idx);
        return temp.data;
    }

    // O(N)
    private Node getNodeAt(int idx) throws Exception {
        if (this.isEmpty()) {
            throw new Exception("List is empty");
        }
        if(idx==0){
            return this.head;
        }
        if (idx < 0 || idx >= this.size()) {
            throw new Exception("Invalid arguments");
        }

        Node retVal = this.head;

        for (int i = 0; i < idx; i++) {
            retVal = retVal.next;
        }

        return retVal;
    }

    // O(1)
    public void addFirst(int data) {
        Node node = new Node(data, this.head);

        if (this.size() == 0) {
            this.head = node;
            this.tail = node;
        } else {
            this.head = node;
        }

        this.size++;
    }

    // O(1)
    public void addLast(int data) {
        Node node = new Node(data, null);

        if (this.size() == 0) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            this.tail = node;
        }

        this.size++;
    }

    // O(n)
    public void addAt(int idx, int data) throws Exception {
        if (idx < 0 || idx > this.size()) {
            throw new Exception("Invalid arguments");
        }

        if (idx == 0) {
            this.addFirst(data);
        } else if (idx == this.size()) {
            this.addLast(data);
        } else {
            Node nm1 = this.getNodeAt(idx - 1);
            Node n = nm1.next;

            Node node = new Node(data, n);
            nm1.next = node;

            this.size++;
        }
    }

    // O(1)
    public int removeFirst() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("List is empty");
        }

        int retVal = this.head.data;

        if (this.size() == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
        }

        this.size--;
        return retVal;
    }

    // O(n)
    public int removeLast() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("List is empty");
        }

        int retVal = this.tail.data;

        if (this.size() == 1) {
            this.head = null;
            this.tail = null;
        } else {
            Node sm2 = this.getNodeAt(this.size() - 2);
            sm2.next = null;
            this.tail = sm2;
        }

        this.size--;
        return retVal;
    }

    // O(n)
    public int removeAt(int idx) throws Exception {
        if (this.isEmpty()) {
            throw new Exception("List is empty");
        }

        if (idx < 0 || idx >= this.size()) {
            throw new Exception("Invalid arguments");
        }

        if (idx == 0) {
            return this.removeFirst();
        } else if (idx == this.size() - 1) {
            return this.removeLast();
        } else {
            Node nm1 = this.getNodeAt(idx - 1);
            Node n = nm1.next;
            Node np1 = n.next;

            nm1.next = np1;
            this.size--;

            return n.data;
        }
    }

    // O(n)
    public void display() {
        Node node = this.head;

        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }

        //System.out.println("END");
    }

    public void reverse(int k) throws Exception{

        int l = 0;
        int r = k-1;
        while((l<this.size)&&(r<this.size)){
            int x = r;
            if(x>this.size){
                break;
            }
            while(l<r){
                //       System.out.println("l is: " + l+ " & r is: "+r);
                int t = this.getNodeAt(l).data;
                this.getNodeAt(l).data = this.getNodeAt(r).data;
                this.getNodeAt(r).data =t;
                l++;
                r--;
            }
            l = x+1;
            r= x+k;
        }

    }

    public static void main(String[] args) throws Exception {

        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int[] b = new int[a];
        for(int i=0;i<a;i++){
            b[i]=s.nextInt();
        }
        int c = s.nextInt();
        int[] d = new int[c];
        for(int i=0;i<c;i++){
            d[i]=s.nextInt();
        }
        int x=0;
        int y=0;
        for(int i=a-1;i>=0;i--){
            for(int j=c-1;j>=0;j--){
                if(b[i]==d[j]){
                    x= i;
                    y =j;
                    //	System.out.print(x);
                    break;
                }
            }
        }
        unmergeLLs l1 = new unmergeLLs();
        unmergeLLs l2 = new unmergeLLs();
        int z = 0;
        for(int i=0;i<a;i++){
            if(i==x+1){
                z = l1.size-1;
//	   System.out.println("z is: "+z);
            }
            l1.addLast(b[i]);
        }
        for(int i=0;i<=y;i++){
            l2.addLast(d[i]);
        }
        Node n2 = l2.getNodeAt(l2.size-1);
        //	  System.out.println("n2 is: "+n2.data+ " & z+1 node is: "+l1.getNodeAt(z+1).data);
       while(z<l1.size-1){
        //   System.out.println("haha");
            l2.tail.next=(l1.getNodeAt(z+1));
            z++;
            l2.size++;
        }
        System.out.print(l2.size);
        while(l2.size>0){
            System.out.println(l2.removeFirst());
        }

    }
}

