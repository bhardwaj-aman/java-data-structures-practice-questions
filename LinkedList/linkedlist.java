package linkedlist;

public class linkedlist {
    private class node{
        private int data;
        private node next;

        }
        private node head;
    private node tail;
    private int size;
    public void display(){
        node temp = this.head;
        while (temp.next!=null){
            System.out.println(temp.next.data);
        }
    }
    public void addlast(int i){
        node n = new node();
        n.data=i;
        n.next=null;

        if(this.size>0)
            this.tail.next=n;
        if(this.size==0){

            this.head=n;
            this.tail=n;
            this.size++;
        }else {
            this.tail = n;
            this.size++;
        }
    }
    public void addfirst(int i){
        node n = new node();
        n.data=i;
        if(this.size>0){
            n.next=head;
        }
        if (this.size==0){
            this.head=n;
            this.tail=n;
            this.size++;
        }else {
            this.head=n;
            this.size++;
        }
    }
    public node getnodeat(int n){
        node temp = this.head;
        for(int i=0;i<n;i++){
            temp= temp.next;
        }
        return temp;

    }
    public void addat(int n,int data1) throws Exception {
        if(n<0||(n>this.size)){
            throw new Exception("invalid index");
        }
        if(n==0){
            addfirst(data1);
        }
        else if(n==this.size){
            addlast(data1);
        }else {
            node nn = new node();
            nn.data = data1;
            node temp = this.getnodeat(n-1);
            node temp1 = temp.next;
            temp.next=nn;
            nn.next = temp1;
            this.size++;
        }
    }
    public int removefirst() throws Exception {
        if(this.size==0){
            throw new Exception("ll empty");
        }
        int d = this.head.data;
        if (this.size == 1) {
            this.head = null;
            this.tail = null;
            this.size = 0;
        } else {
            node temp = this.head;
            node temp1 = temp.next;
             this.head=temp1;
             this.size--;
        }
        return d;
    }
    public int removelast() throws Exception {
        if(this.size==0){
            throw new Exception("ll empty");
        }
        int d = this.tail.data;
        if (this.size == 1) {
            this.head = null;
            this.tail = null;
            this.size = 0;
        } else {
            node temp = this.getnodeat(this.size-2);
            temp.next=null;
            this.tail=temp;
           this.size--;
        }
        return d;
    }
    public int removeaat(int n) throws Exception {
        if (n<0||n>=this.size){
            throw new Exception("invalid index");
        }
        if(this.size==0){
            throw new Exception("ll empty");
        }
        int d = this.getnodeat(n).data;
        if(n == this.size-1){
            return this.removelast();
        }else if(n==0){
            return this.removefirst();
        }
        else {

                node temp = this.getnodeat(n- 1);
                node temp1 = temp.next;
                node temp2 = temp1.next;
                temp.next = temp2;
                this.size--;

        }
        return d;
    }
    public void reversebydata(){
        int left =0;
        int right=this.size-1;
        while (left<right){
            node l = this.getnodeat(left);
            node r = this.getnodeat(right);
            int temp = l.data;
            l.data = r.data;
            r.data=temp;
            left++;
            right--;

        }
    }
    public void reversepointers(){
        node n1= this.head;
        node n2 = n1.next;
        node n3 = n2.next;
        while (n2!=null){
            n2.next = n1;
            n2 = n3;
            n1 = n2;
            n3 = n3.next;
        }
        node temp = this.head;
        this.head = this.tail;
        this.tail = temp;
        this.tail.next= null;
    }
    public int midnode(){
        //slow pointer
        node n1 = this.head;
        //fast moving pointer
        node n2 = this.head;
        while ((n2.next!=null)&&(n2.next.next!=null)){
            n2 = n2.next.next;
            n1 = n1.next;

        }
        return  n1.data;
    }
}
