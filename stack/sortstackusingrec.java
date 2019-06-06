package stackandqueue;
public class sortstackusingrec {

    public static void main(String[] args) throws Exception {
        stackfromarray s = new stackfromarray(5);
        for (int i = 0; i < 5; i++) {
            s.push(69 - i);
        }
        sortit(s, 0);
        s.print();
    }

    public static void sortit(stackfromarray s, int i) throws Exception {

        if (s.isempty()) {
            return;
        }
        int n = s.pop();
        System.out.println("n is: " + n + " and i is: " + i);
        if (!s.isempty()) {
            if (n < s.top()) {
                System.out.println("entered loop ");
                int m = s.pop();
                System.out.println("m is: " + m + " and i is: " + i);
                s.push(n);
                System.out.println("pushed n");
                if (!s.isempty()) {
                    s.push(m);

                    System.out.println("pushed m");
                }
            }
            sortit(s, i + 1);
            s.push(n);
        }
    }
}

