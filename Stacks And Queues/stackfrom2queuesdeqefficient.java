package stackandqueue;

public class stackfrom2queuesdeqefficient {
    queuefromarray q1;
    queuefromarray q2;
    stackfrom2queuesdeqefficient(queuefromarray q, queuefromarray r){
        this.q1=q;
        this.q2=r;

    }
    public void push(int a) throws Exception {
        while (!q1.isempty()){
            q2.enqueue(q1.deque());
        }
        q1.enqueue(q2.deque());
        while (!q2.isempty()){
            q1.enqueue(q2.deque());
        }
    }
    public int pop() throws Exception {
return q1.deque();
    }
    public int top() throws Exception {
       return q1.getFront();
    }
}
