package stackandqueue;

public class stackfromtwoqueuesenqefficientclient {
    public static void main(String[] args) throws Exception {
        queuefromarray q1 = new queuefromarray(5);
        queuefromarray q2 = new queuefromarray(5);
        stackfom2queuesenqefficient s = new stackfom2queuesenqefficient(q1,q2);
        s.push(4);
        s.push(5);
        String z = "lodu";
        System.out.println(z.charAt(0)+0);
    }
}
