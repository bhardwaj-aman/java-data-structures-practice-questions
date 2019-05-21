package stackandqueue;

public class queuefromtwostacksclient {
    public static void main(String[] args) throws Exception {
        queuefromtwostacks q = new queuefromtwostacks(5);
        for(int i=0;i<5;i++){
            q.enqueue(i+69);
        }
        q.printit();
        q.deque();
        q.printit();
    }
}
