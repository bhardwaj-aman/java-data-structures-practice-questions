package stackandqueue;

import java.util.Scanner;
public class Main {
    public static void main(String args[]) throws Exception {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        queuefromarray1 q = new queuefromarray1(a);
        for(int i=0;i<a;i++){
            q.enqueue(s.nextInt());
        }
        int k = s.nextInt();
        int arr = -9999;
        int counter=0;
        while(!q.isempty()){
            if(counter==k){
                System.out.println(arr);
                counter=0;
            }
            int i = q.deque();
            if(i>arr){
                arr=i;
            }
            counter++;
        }
    }
}
 class queuefromarray1 {
    int[] arr = new int[10];
    int front=0;
    int size=0;
    public queuefromarray1(int capacity){
        arr = new int[capacity];
    }
    public void enqueue(int data)throws Exception{
        if (size==arr.length){
            throw new Exception("queue full");
        }
        this.arr[(front+size)%arr.length]=data;
        this.size++;
    }
    public int deque () throws Exception{
        if(this.size==0){
            System.out.println("queue empty");
        }
        int a = this.arr[front];
        this.arr[front]=0;
        this.front=(this.front+1)%this.arr.length;
        size--;
        return a;
    }
    public int getFront(){
        return this.arr[front];
    }
    public boolean isempty(){
        return this.size==0;
    }
    public void print(){
        for(int i=0;i<this.size;i++){
            System.out.print(arr[(front+i)%this.arr.length]+" => ");
        }
    }


}