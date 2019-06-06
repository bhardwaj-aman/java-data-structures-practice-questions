package stackandqueue;

import java.util.Scanner;

public class timescheduling {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        Queue q1 = new Queue(a);
        for(int i=0;i<a;i++){
            q1.enqueue(s.nextInt());
        }
        Queue q2 = new Queue(a);
        for(int i=0;i<a;i++){
            q2.enqueue(s.nextInt());
        }
        int counter=0;
        while (!q1.isEmpty()){
            if(q1.getFront()==q2.getFront()){
                q1.dequeue();
                q2.dequeue();
                counter++;
            }else{
                q1.enqueue(q1.dequeue());
                counter++;
            }
        }
        System.out.println(counter);
    }

}
class Queue {

    protected int size;

    protected int front;
    protected int[] data;

    public Queue() {
        this.size = 0;
        this.front = 0;
        this.data = new int[5];
    }

    public Queue(int cap) {
        this.size = 0;
        this.front = 0;
        this.data = new int[cap];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void enqueue(int item) throws Exception {
        if (this.size() == this.data.length) {
            int[] oa = this.data;
            int[] na = new int[oa.length * 2];
            for (int i = 0; i < this.size(); i++) {
                int idx = (i + front) % oa.length;
                na[i] = oa[idx];
            }

            this.data = na;
            this.front = 0;
        }

        // if (this.size == this.data.length) {
        // throw new Exception("queue is full");
        // }

        this.data[(front + size) % this.data.length] = item;
        size++;

    }

    public int dequeue() throws Exception {
        if (this.size == 0) {
            throw new Exception("queue is empty");

        }

        int rv = this.data[front];
        front = (front + 1) % this.data.length;
        size--;

        return rv;

    }

    public int getFront() throws Exception {
        if (this.size == 0) {
            throw new Exception("queue is empty");
        }

        int rv = this.data[front];

        return rv;
    }

    public void display() {
        System.out.println();
        for (int i = 0; i < size; i++) {
            int idx = (i + front) % this.data.length;
            System.out.print(this.data[idx] + " ");
        }
        System.out.print("END");
    }

}


