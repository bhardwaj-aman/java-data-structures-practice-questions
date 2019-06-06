package stackandqueue;

public class queuefromtwostacks {
    stackfromarray s1;
    stackfromarray s2;

    queuefromtwostacks(stackfromarray x, stackfromarray y) {
        this.s1 = x;
        this.s2 = y;

    }

    public queuefromtwostacks(int capacity) {
        s1= new stackfromarray(capacity);
        s2 = new stackfromarray(capacity);
    }

    public void enqueue(int x) throws Exception {
        this.s1.push(x);
      //  System.out.println("pushed- top is: "+s1.top());

    }

    public int deque() throws Exception {
        while (s1.size() >= 1) {
            if(s1.size()==1){
                break;
            }
            System.out.println("pushing to s2: "+s1.top());
            this.s2.push(s1.pop());
        }
        int z = s1.pop();
        while(s2.size()>=0){
            if(s2.size()==0){
                break;
            }
            this.s1.push(s2.pop());
        }
        return z;
    }
    public int front() throws Exception{
        while (s1.size() != 1) {
            this.s2.push(s1.pop());
        }
        int z = s1.top();
        while(s2.size()>=0){
            this.s1.push(s2.pop());
        }
        return z;
    }
    public void printit() throws Exception {
    s1.reverseit(s1,s2,s1.top()+1,0);
        s1.print();
        s1.reverseit(s1,s2,s1.top()+1,0);
    }


}