package stackandqueue;
public class queuefromarrayclient {
    public static void main(String[] args) throws Exception{
        queuefromarray q = new queuefromarray(5);
        q.enqueue(69);
        q.enqueue(70);
        q.print();
    }
}
