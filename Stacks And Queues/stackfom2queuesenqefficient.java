package stackandqueue;

public class stackfom2queuesenqefficient {
    queuefromarray q1;
    queuefromarray q2;
    stackfom2queuesenqefficient(queuefromarray q, queuefromarray r){
        this.q1=q;
        this.q2=r;

    }
    public void push(int a) throws Exception {
        q1.enqueue(a);
    }
    public int pop() throws Exception {
        while (q1.size!=1){
            q2.enqueue(q1.deque());
        }
        int n = q1.deque();
        while (!q2.isempty()){
            q1.enqueue(q2.deque());
        }
        return n;
    }
    public int top() throws Exception {
        while (q1.size!=1){
            q2.enqueue(q1.deque());
        }
        int n = q1.getFront();
        while (!q2.isempty()){
            q1.enqueue(q2.deque());
        }
        return n;
    }

}
